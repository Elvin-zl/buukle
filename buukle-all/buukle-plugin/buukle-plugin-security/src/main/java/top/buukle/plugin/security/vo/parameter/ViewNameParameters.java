package top.buukle.plugin.security.vo.parameter;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/3.
 * @Description :
 */
public class ViewNameParameters {

    private String loginViewName;
    private String indexViewName;
    private String outOfTimeViewName;
    private String noPermissionViewName;
    private String errorViewName;
    private String logoutViewName;

    public String getLoginViewName() {
        return loginViewName;
    }

    public void setLoginViewName(String loginViewName) {
        this.loginViewName = loginViewName;
    }

    public String getIndexViewName() {
        return indexViewName;
    }

    public void setIndexViewName(String indexViewName) {
        this.indexViewName = indexViewName;
    }

    public String getOutOfTimeViewName() {
        return outOfTimeViewName;
    }

    public void setOutOfTimeViewName(String outOfTimeViewName) {
        this.outOfTimeViewName = outOfTimeViewName;
    }

    public String getNoPermissionViewName() {
        return noPermissionViewName;
    }

    public void setNoPermissionViewName(String noPermissionViewName) {
        this.noPermissionViewName = noPermissionViewName;
    }

    public String getErrorViewName() {
        return errorViewName;
    }

    public void setErrorViewName(String errorViewName) {
        this.errorViewName = errorViewName;
    }

    public String getLogoutViewName() {
        return logoutViewName;
    }

    public void setLogoutViewName(String logoutViewName) {
        this.logoutViewName = logoutViewName;
    }
}
