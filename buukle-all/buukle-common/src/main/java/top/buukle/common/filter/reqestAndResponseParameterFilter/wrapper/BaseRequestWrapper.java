package top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper;

import top.buukle.common.util.common.HttpHelper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Enumeration;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
 * 请求参数处理装饰类
 */
public class BaseRequestWrapper extends HttpServletRequestWrapper {

    private byte[] bodyBytes;
    private final String bodyString;

    public BaseRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
//         Enumeration e = request.getHeaderNames()   ;
//         while(e.hasMoreElements()){
//             String name = (String) e.nextElement();
//             String value = request.getHeader(name);
//             System.out.println(name+" = "+value);
//
//         }
        bodyString = HttpHelper.getBodyString(request);
        bodyBytes = bodyString.getBytes(Charset.forName("UTF-8"));
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bais = new ByteArrayInputStream(bodyBytes);

        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {

            }

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    @Override
    public String getHeader(String name) {
        return super.getHeader(name);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        return super.getHeaderNames();
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        return super.getHeaders(name);
    }

    /**
     * 获取请求参数
     * @return
     */
    public String getRequestBody() {
        return bodyString;
    }

    /**
     * 重写请求参数
     * @param bodyString
     */
    public void setRequestBody(String bodyString) {
        bodyBytes = bodyString.getBytes();
    }
}
