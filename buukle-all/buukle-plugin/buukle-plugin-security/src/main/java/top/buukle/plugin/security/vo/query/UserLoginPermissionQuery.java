package top.buukle.plugin.security.vo.query;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.plugin.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public class UserLoginPermissionQuery<T> {
    private String userCookie;
    private String url;
    private T user;

    public UserLoginPermissionQuery() {
    }

    public String getUserCookie() {
        return this.userCookie;
    }

    public void setUserCookie(String userCookie) {
        this.userCookie = userCookie;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getUser() {
        return (T) JsonUtil.parseFromObject(user, User.class);
    }

    public void setUser(T user) {
        this.user = user;
    }
}
