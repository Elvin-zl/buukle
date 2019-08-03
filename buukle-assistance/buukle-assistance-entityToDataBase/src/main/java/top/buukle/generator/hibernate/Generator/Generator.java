package top.buukle.generator.hibernate.Generator;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.junit.Test;
import top.buukle.generator.hibernate.utils.XmlGeneratorUtil;
import top.buukle.generator.hibernate.utils.HibernateUtil;

/**
 * @author elvin
 */
public class Generator {
	/**
	 * 生成配置文件
	 */
	@Test
	public void generateHbmXml(){
	    try {
            XmlGeneratorUtil.generateXml();
        } catch (Exception e) {
			System.out.println("配置文件生成出现异常");
			e.printStackTrace();
		}
        System.out.println("配置文件生成完毕,请执行@Test  autoGenerateTable() 方法生成表.");
	}

    @Test
    public  void autoGenerateTable(){
		boolean isSuccess = true;
		try {
			Session session = HibernateUtil.openSession();
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			session.close();
		} catch (Exception e) {
			System.out.println("出现异常!");
			isSuccess = false;
			e.printStackTrace();
		}
		if(isSuccess){
			System.out.println("生成数据表成功!");
		}
	}
}
