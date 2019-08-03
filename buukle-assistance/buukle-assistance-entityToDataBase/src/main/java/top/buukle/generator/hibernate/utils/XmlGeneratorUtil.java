package top.buukle.generator.hibernate.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


import top.buukle.generator.hibernate.config.DataSourceConfig;

/**
 * @author elvin
 */
public class XmlGeneratorUtil extends DataSourceConfig {

    /** 当前工作路径目录*/
    private static final String USER_DIR_PROPERTY_KEY = "user.dir";
    /** 实体类文件相对路径*/
    private static final String ENTITY_RELATIVE_PATH = "/src/main/java/top/buukle/generator/hibernate/targetEntity";
    /** 实体类包路径名*/
    private static final String ENTITY_PACKAGE_PATH_NAME = "top.buukle.generator.hibernate.targetEntity.";
    /** hibernate.cfg.xml位置*/
    private static final String HIBERNATE_CFG_XML = "/src/main/resources/hibernate.cfg.xml";
    /** hbm.xml位置*/
    private static final String HBM_XML_CFG_XML = "/src/main/resources";

    /**
     * 生成实体和表映射文件
     */
    public static File generateXml() throws Exception {
        String mapping = XmlGeneratorUtil.generateHbmXml();
        return XmlGeneratorUtil.generateHibernateCfgXml(mapping);
    }

    /**
     * 生成映射文件
     * @return
     * @throws Exception
     */
    private static String generateHbmXml() throws Exception {
        System.out.println("=============================================开始生成映射文件===================================================");
        // 初始化一些变量,配置信息
        System.out.println(">>>>>>>>>>>>>>初始化一些变量,配置信息... ...");
        boolean isSuccess = true;
        // 实体数目
        int entityCount = 0;
        // 生成映射文件数目
        int mappingCount = 0;
        // 生成核心配置文件中的mapping resource 注册标签
        AtomicReference<StringBuilder> mappingResource = new AtomicReference<StringBuilder>(new StringBuilder());
        String entityPath = System.getProperty(USER_DIR_PROPERTY_KEY) + ENTITY_RELATIVE_PATH;
        DataSourceConfig config = new DataSourceConfig();
        File file = new File(entityPath);
        File[] tempList = file.listFiles();
        if(tempList == null || tempList.length == 0){
            throw new Exception("指定包下无实体类! 路径: " + entityPath);
        }
        for (File aTempList : tempList) {
            if (aTempList.isFile() && aTempList.getName().endsWith(".java")) {
                entityCount++;
            }
        }
        System.out.println(">>>>>>>>>>>>>>该目录下实体个数：" + entityCount);
        if (entityCount > 0) {
            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].isFile() && tempList[i].getName().endsWith(".java")) {
                    String className = tempList[i].getName();
                    className = className.substring(0, className.length() - 5);
                    try {
                        String hbmXmlPath = System.getProperty(USER_DIR_PROPERTY_KEY) + HBM_XML_CFG_XML + "/" + className + ".hbm.xml";
                        System.out.println("开始为类:" + className + " 生成.hbm.xml映射文件");
                        System.out.println("生成文件路径为: " + hbmXmlPath);
                        File hbmXmlFile = new File(hbmXmlPath);
                        boolean newFileSuccess = false ;
                        if (!hbmXmlFile.exists()) {
                            boolean mkdirsSuccess = hbmXmlFile.getParentFile().mkdirs();
                            if(mkdirsSuccess){
                                newFileSuccess = hbmXmlFile.createNewFile();
                            }
                        }
                        if(newFileSuccess){
                            System.out.println("");
                            throw new Exception("创建"+hbmXmlPath+"文件失败!");
                        }
                        FileWriter fw = new FileWriter(hbmXmlFile, false);
                        BufferedWriter bw = new BufferedWriter(fw);
                        String classDescriptions = ENTITY_PACKAGE_PATH_NAME + className;
                        String classTableName = converseToTableName(className);

                        bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
                        bw.write("<!DOCTYPE hibernate-mapping PUBLIC \"-// Hibernate/Hibernate Mapping DTD 3.0// EN\" \"http:// www.hibernate.org/dtd/hibernate-mapping-3.0.dtd\">\r\n");
                        bw.write("<hibernate-mapping>\r\n");
                        bw.write("<class name=\"" + classDescriptions + "\" table=\"" + classTableName + "\" lazy=\"false\">\r\n");

                        Class<?> entityClass = Class.forName(classDescriptions);
                        Object entity = entityClass.newInstance();
                        Field[] fields = entity.getClass().getDeclaredFields();
                        for (int j = 0; j < fields.length; j++) {
                            String fieldName = fields[j].getName();
                            if (j == 0) {
                                bw.write("<id name=\"" + fieldName + "\" column=\"" + converseToTableName(fieldName) + "\">\r\n");
                                bw.write("<generator class=\"" + config.getPrimareyStrategy() + "\"></generator>\r\n");
                                bw.write("</id>\r\n");
                                bw.write("\r\n");
                            } else {
                                bw.write("<property name=\"" + fieldName + "\" column=\"" + converseToTableName(fieldName) + "\"></property>\r\n");
                            }
                        }
                        bw.write("\r\n");
                        bw.write("</class>\r\n");
                        bw.write("\r\n");
                        bw.write("</hibernate-mapping>\r\n");
                        bw.flush();
                        bw.close();
                        fw.close();
                        System.out.println("-------------------生成" + className + ".hbm.xml映射文件结束-------------------------");
                        mappingResource.get().append("<mapping resource=\"").append(className).append(".hbm.xml\"/>\r\n");
                        mappingCount++;
                    } catch (Exception e) {
                        System.out.println("生成映射文件失败,请检查该类--->" + className + ",或以管理员身份运行IDE后尝试;");
                        isSuccess =false;
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println(">>>>>>>>>>>>>>该目录下没有实体!请确认创建实体!");
        }

        if (entityCount >= 0 && isSuccess) {
            System.out.println(">>>>>>>>>>>>>>共生成mapping文件" + mappingCount + "个," + (mappingCount == entityCount ? "个数与实体类相符" : "个数与实体类不符,有失败案例,请查看日志修改相应java bean"));
        }
        System.out.println("=============================================生成映射文件结束===================================================");
        return mappingResource.toString();
    }

    /**
     * 生成hibernate核心配置文件
     * @param mappingResource
     */
    private static File generateHibernateCfgXml(String mappingResource) throws Exception {
        System.out.println("=============================================开始生成hibernate核心配置文件===================================================");
        System.out.println(">>>>>>>>>>>>>>初始化一些常量 ,配置类等... ...");
        DataSourceConfig dataConfig = new DataSourceConfig();
        String hibernateCfgXmlFilePathName = System.getProperty(USER_DIR_PROPERTY_KEY) + HIBERNATE_CFG_XML;
        System.out.println(">>>>>>>>>>>>>>生成核心配置文件路径为: " + hibernateCfgXmlFilePathName);
        // 输出数据库连接类型信息
        if (dataConfig.getDriver().contains("mysql")) {
            System.out.println(">>>>>>>>>>>>>>数据库连接类型:MYSQL(mysql)");
        }
        if (dataConfig.getDriver().contains("postgresql")) {
            System.out.println(">>>>>>>>>>>>>>数据库连接类型:POSTGRESQL(postgresql)");
        }

        File hibernateCfgXmlFile = new File(hibernateCfgXmlFilePathName);
        if (!hibernateCfgXmlFile.exists()) {
            hibernateCfgXmlFile.getParentFile().mkdirs();
        }
         hibernateCfgXmlFile.createNewFile();
        try {
            FileWriter fw = new FileWriter(hibernateCfgXmlFile, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
            bw.write("<!DOCTYPE hibernate-configuration PUBLIC \"-// Hibernate/Hibernate Configuration DTD 3.0// EN\" \"http:// www.hibernate.org/dtd/hibernate-configuration-3.0.dtd\">");
            bw.write("\r\n");
            bw.write("<hibernate-configuration>");
            bw.write("<session-factory>");
            bw.write("\r\n");
            bw.write("<property name=\"hibernate.connection.driver_class\">" + dataConfig.getDriver() + "</property>\r\n");
            bw.write("<property name=\"hibernate.connection.url\">" + dataConfig.getJdbcUrl() + "</property>\r\n");
            bw.write("<property name=\"hibernate.connection.username\">" + dataConfig.getUsername() + "</property>\r\n");
            bw.write("<property name=\"hibernate.connection.password\">" + dataConfig.getPassword() + "</property>\r\n");
            bw.write("<property name=\"hibernate.dialect\">" + dataConfig.getDialect() + "</property>\r\n");
            bw.write("<property name=\"hibernate.hbm2ddl.auto\">" + dataConfig.getGenerateStrategy() + "</property>\r\n");
            System.out.println("数据表的生成策略为:" + dataConfig.getGenerateStrategy());
            bw.write("<property name=\"hibernate.show_sql\">true</property>\r\n");
            bw.write("<property name=\"hibernate.format_sql\">true</property>\r\n");
            bw.write("<property name=\"hibernate.connection.provider_class\">org.hibernate.connection.C3P0ConnectionProvider</property>\r\n");
            bw.write("<property name=\"javax.persistence.validation.mode\">none</property>\r\n");
            bw.write("\r\n");
            bw.write(mappingResource);
            bw.write("\r\n");
            bw.write("</session-factory>\r\n");
            bw.write("\r\n");
            bw.write("</hibernate-configuration>\r\n");
            bw.flush();
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println("=============================================生成hibernate.cfg.xml 出错===================================================");
            e.printStackTrace();
            hibernateCfgXmlFile = null;
        }finally {
            System.out.println("=============================================生成hibernate核心配置文件结束===================================================");
        }
        return hibernateCfgXmlFile;
    }

    /**
     * 将类名转换成数据表名称
     * @param name
     * @return
     */
    private static String converseToTableName(String name) {
        StringBuffer buffer = new StringBuffer();
        char[] array = name.toCharArray();
        List<Integer> insertIndexes = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            Character c = array[i];
            if (i != 0 && Character.isUpperCase(c)) {
                insertIndexes.add(i);
            }
        }
        if (insertIndexes.size() > 0) {
            int flag = 0;
            for (int j = 0; j < insertIndexes.size(); j++) {
                String word = toLowerCase4FirstLetter(name.substring(flag, insertIndexes.get(j)));
                buffer.append(word).append("_");
                flag = insertIndexes.get(j);
            }
            String last = toLowerCase4FirstLetter(name.substring(flag));
            buffer.append(last);
            return buffer.toString();
        } else {
            String last = toLowerCase4FirstLetter(name);
            buffer.append(last);
            return buffer.toString();
        }
    }

    /**
     *
     * 首字母大写转小写
     * @param word
     * @return
     */
    private static String toLowerCase4FirstLetter(String word) {
        StringBuffer buffer = new StringBuffer();
        String firstLetter = word.substring(0, 1);
        String others = word.substring(1);
        String upperLetter;
        upperLetter = firstLetter.toLowerCase();
        buffer.append(upperLetter).append(others);
        return buffer.toString();
    }
}
