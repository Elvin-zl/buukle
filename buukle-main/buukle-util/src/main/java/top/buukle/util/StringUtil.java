package top.buukle.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description :
 */
public class StringUtil extends StringUtils{

    /**逗号*/
    public final static String COMMA = ",";

    /**null*/
    public final static String NULL = "null";

    /** 中杠线*/
    public final static String MIDDLE = "-";

    /**空串*/
    public final static String EMPTY = "";

    /**回车*/
    public final static String NEW_LINE = "\n";

    /**制表*/
    public final static String TABULACTOR = "\t";

    /**单引号*/
    public final static String SINGLE_QUOTE = "'";

    /**横线*/
    public final static String LINE = "-";

    /**下划线*/
    public final static String UNDERLINE = "_";

    /**反斜杠*/
    public final static String BACKSLASH = "/";

    /**点*/
    public final static String DOT = ".";

    public final static String REGEX_DOT = "\\.";

    /**分号*/
    public final static String SEMICOLON = ";";

    /**空格*/
    public final static String BLANK = " ";

    /**竖线*/
    public final static String VERTICAL = "|";

    /**冒号*/
    public final static String COLON = ":";

    /**
     * 检测字符串是否不为空(null,"","null")
     * @param s
     * @return 不为空则返回true，否则返回false
     */
    public static boolean notEmpty(String s){
        return s!=null && !"".equals(s) && !"null".equals(s);
    }

    /**
     * 检测字符串是否为空(null,"","null")
     * @param s
     * @return 为空则返回true，不否则返回false
     */
    public static boolean isEmpty(String s){
        return s==null || "".equals(s) || "null".equals(s);
    }

    /**
     * 字符串转换为字符串数组
     * @param str 字符串
     * @param splitRegex 分隔符
     * @return
     */
    public static String[] str2StrArray(String str,String splitRegex){
        if(isEmpty(str)){
            return null;
        }
        return str.split(splitRegex);
    }

    /**
     * 用默认的分隔符(,)将字符串转换为字符串数组
     * @param str	字符串
     * @return
     */
    public static String[] str2StrArray(String str){
        return str2StrArray(str,",\\s*");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，日期转字符串
     * @param date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String date2Str(Date date){
        return date2Str(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 按照yyyy-MM-dd HH:mm:ss的格式，字符串转日期
     * @param date
     * @return
     */
    public static Date str2Date(String date){
        if(notEmpty(date)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Date();
        }else{
            return null;
        }
    }

    /**
     * 按照参数format的格式，日期转字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date, String format){
        if(date!=null){
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }else{
            return "";
        }
    }
    /**
     * 截取第n个特定字符(code)以后的所有字符串
     * @param str
     * @param n
     * @return
     */
    public static String getStr(String str, int n, String code) {
        int i = 0;
        int s = 0;
        while (i++ < n) {
            s = str.indexOf(code, s + 1);
            if (s == -1) {
                return str;
            }
        }
        return str.substring(s);
    }

    /**
     * @Description 将字符串数组拼接成字符串
     * @throws
     * @param strings
     * @return String
     * @Author 王琳
     * @Date 2016-3-21
     */
    public static String buildStringArray(String... strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String string : strings) {
            sb.append(string).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * @Description 将long型数据转化为相应格式的字符串
     * @throws
     * @param format
     * @return String
     * @Author 王琳
     * @Date 2016-3-24
     */
    public static String getFormatString(String format, long num) {
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(num);
    }

    /**
     * @Description 获取controller请求串
     * @throws
     * @return String
     * @Author 王琳
     * @Date 2016-4-11
     */
    public static String getControllerPath(String str) {
        String[] strings = StringUtils.split(str, "/");
        if(strings.length != 0) {
            for(String string : strings) {
                return "/" + string;
            }
        }
        return null;
    }

    /**
     * @Description 将list转化为逗号分隔的字符串并加上单引号
     * @throws
     * @param strings
     * @return String
     * @Author 王琳
     * @Date 2016-5-20
     */
    public static String ListToString(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        if(CollectionUtils.isEmpty(strings)) {
            return null;
        }
        for(String string : strings) {
            sb.append("'").append(string).append("'").append(",");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * @Description 将list转化为符号分隔的字符串
     * @throws
     * @return String
     * @Author 王琳
     * @Date 2017-6-13
     */
    public static String ListToString(List<String> strings, String separator) {
        StringBuilder sb = new StringBuilder();
        if(CollectionUtils.isEmpty(strings)) {
            return null;
        }
        for(String string : strings) {
            if(StringUtils.isNotBlank(string)) {
                sb.append(string).append(separator);
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    /**
     * @Description 将字符串用,组装
     * @param sb
     * @param strings
     * @return void
     * @Author 王琳
     * @Date 2016-5-23
     */
    public static void assString(StringBuilder sb, String... strings) {
        if(sb == null || strings == null) {
            return;
        }
        for(String string : strings) {
            if(StringUtils.isBlank(string)) {
                continue;
            }
            if(sb.length() != NumberUtils.INTEGER_ZERO && StringUtils.isNotBlank(string)) {
                sb.append(COMMA + string);
            }
            if(sb.length() == NumberUtils.INTEGER_ZERO && StringUtils.isNotBlank(string)) {
                sb.append(string);
            }
        }
    }

    /**
     * @Description 将字符串用,组装
     * @param strings
     * @return String
     * @Author 王琳
     * @Date 2016-6-16
     */
    public static String assString(String... strings) {
        StringBuilder sb = new StringBuilder();
        assString(sb, strings);
        return sb.toString();
    }

    /**
     * 将分隔符隔开的字符串解析到list中
     *
     * @param str
     * @param separator
     * 		分隔符，正则表达式，例如根据英文逗号和中文逗号分隔，则写成：",|，"
     * @return
     */
    public static List<String> parseString(String str, String separator) {
        List<String> list = new ArrayList<String>();
        parseString(str, separator, list);
        return list;
    }

    /**
     * @Description 将逗号隔开的字符串解析到list中
     * @throws
     * @param str
     * @return List<String>
     * @Author 王琳
     * @Date 2016-9-20
     */
    public static List<String> parseStringToListComma(String str) {
        return parseStringToList(str, ",");
    }

    /**
     * @Description 将:隔开的字符串解析到list中
     * @throws
     * @param str
     * @return List<String>
     * @Author 王琳
     * @Date 2016-9-20
     */
    public static List<String> parseStringToListColon(String str) {
        return parseStringToList(str, ":");
    }

    /**
     * @Description 将分隔符隔开的字符串解析到list中
     * @throws
     * @param str
     * @param separator
     * @return List<String>
     * @Author 王琳
     * @Date 2016-9-20
     */
    public static List<String> parseStringToList(String str, String separator) {
        List<String> list = new ArrayList<String>();
        parseString(str, separator, list);
        return list;
    }

    /**
     * @Description 将分隔符隔开的字符串解析到集合中
     * @throws
     * @param str
     * @param separator
     * @param result
     * @return void
     * @Author 王琳
     * @Date 2016-9-20
     */
    public static void parseString(String str, String separator, Collection<String> result) {
        if (StringUtils.isBlank(str)) {
            return;
        }
        for (String subStr : str.trim().split(separator)) {
            if (StringUtils.isBlank(subStr)) {
                continue;
            }
            result.add(subStr.trim());
        }
    }
}
