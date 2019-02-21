package top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import java.io.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;


/**
 * 返回值输出装饰类
 */
public class BaseResponseWrapper extends HttpServletResponseWrapper{

    // 缓冲区，用来存放后台数据
    private ByteArrayOutputStream cacheStream = new ByteArrayOutputStream();
    private PrintWriter pw =new PrintWriter(cacheStream);
    private ServletOutputStream outputStream ;


    public BaseResponseWrapper(HttpServletResponse response) throws IOException {
        super(response);
        outputStream = response.getOutputStream();
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new ServletOutputStream(){
            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }
            @Override
            public void write(int b) throws IOException {
                cacheStream.write(b);
                outputStream.write(b);
            }
            @Override
            public void flush(){
                try {
                    pw.flush();
                    pw.close();
                    cacheStream.flush();
                    cacheStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }
    public String getResponseBody() {
        return cacheStream.toString();
    }
}

