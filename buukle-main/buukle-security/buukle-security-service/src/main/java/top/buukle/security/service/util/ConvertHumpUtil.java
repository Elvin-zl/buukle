package top.buukle.security.service.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConvertHumpUtil {
  private static Pattern linePattern = Pattern.compile("_(\\w)");
 
    /**
     * @description 下划线转驼峰
     * @param str
     * @return java.lang.String
     * @Author zhanglei1102
     * @Date 2019/8/6
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
 
  private static Pattern humpPattern = Pattern.compile("[A-Z]");
 

    /**
    * @description 驼峰转下划线,效率比上面高
    * @param str
    * @return java.lang.String
    * @Author zhanglei1102
    * @Date 2019/8/6
    */
    public static String  humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        String line = sb.toString();
        line = line.startsWith("_") ? line.substring(1,line.length()) : line;
        return line;
    }
}