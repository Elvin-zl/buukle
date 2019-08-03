package top.buukle.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static Properties getProperties(String confFile) {
		Properties props = new Properties();
		InputStream is = null;
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream (confFile);
			props.load(is);
		} catch (Exception e) {
            System.out.println("top.buukle.common.util.common.PropertiesUtil(java.13) IoException : 读取文件失败 ! 文件路径 : " + confFile);
		}finally {
			try {
				assert is != null;
				is.close();
			} catch (IOException e) {
                System.out.println("top.buukle.common.util.common.PropertiesUtil(java.13) IoException : 读取文件失败 ! 文件路径 : " + confFile);
            }
		}
		return props;
	}
}


