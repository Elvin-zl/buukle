package top.buukle.plugin.security.vo.response;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/24.
 * @Description :  下拉框返回值包装类
 */
public class SelectSearchItemVo {

    /** 内容*/
    private String text;
    /** id标识 string*/
    private String idStr;
    /** id标识 integer*/
    private Integer idInteger;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    public Integer getIdInteger() {
        return idInteger;
    }

    public void setIdInteger(Integer idInteger) {
        this.idInteger = idInteger;
    }
}
