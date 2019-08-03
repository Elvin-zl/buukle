package top.buukle.util;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
public class IoUtil {

    /**
     * IO 读取模板代码
     * @param reader
     * @return
     * @throws IOException
     */
    public static String read(BufferedReader reader) throws IOException {
        String tempStr;
        String bodyIncrement = "";
        while((tempStr = reader.readLine()) != null){
            bodyIncrement += tempStr;
        }
        return StringUtil.isEmpty(bodyIncrement) ? StringUtil.EMPTY : bodyIncrement;
    }
}
