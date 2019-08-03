package top.buukle.security.plugin.enums;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/3.
 * @Description :
 */
public enum SecurityExceptionEnumType {

    // 页面
    VIEW("VIEW"),
    // json
    JSON("JSON")
    ;
    private String value;
    SecurityExceptionEnumType(String value) {
        this.value = value;
    }

    public String type() {
        return value;
    }
}
