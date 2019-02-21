package top.buukle.plugin.upload.Util;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/29.
 * @Description :
 */
public class FileUtil {

    /**
     * 读写文件
     * @param fileInputStream
     * @param bufferedOutputStream
     * @throws Exception
     */
    public static void readWrite(FileInputStream fileInputStream, BufferedOutputStream bufferedOutputStream) throws Exception {
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bufferedOutputStream.write(bs, 0, len);
        }
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }
}
