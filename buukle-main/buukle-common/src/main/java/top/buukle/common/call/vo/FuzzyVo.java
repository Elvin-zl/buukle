package top.buukle.common.call.vo;

/**
 * @Author: elvin
 * @Date: 2019/7/28/028 3:22
 */
public class FuzzyVo {

    /** 这个字段是搜索返回来的值 , string类型的*/
    private String id;
    /** 字段名*/
    private String fieldName;
    /** 字段名*/
    private String tableName;
    /** 模糊搜索入参*/
    private String text;
    /** 搜索记录中单条记录的id*/
    private Integer identity;

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
