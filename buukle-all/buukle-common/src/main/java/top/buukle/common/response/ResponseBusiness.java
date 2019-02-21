package top.buukle.common.response;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.buukle.common.constants.BaseResponseCode;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/22.
 * @Description :
 */
public  class ResponseBusiness <T>  {

    /** 第三方业务响应状态码*/
    private String status;

    /** 第三方业务响应错误码*/
    private String code;

    /** 第三方业务响应信息*/
    private String msg;

    /** 第三方业务响应数据(list)*/
    private List<T> dataList;

    public ResponseBusiness(T t) {

        // 返回第三方业务错误信息
        if(t instanceof BaseResponseCode){
            BaseResponseCode baseResponseCode = (BaseResponseCode) t;
            this.status = baseResponseCode.getStatus();
            this.msg = baseResponseCode.getMsg();
        }
        // 返回第三方业务 list 数据
        else if(t instanceof List){
            this.status = BaseResponse.SUCCESS;
            this.dataList = (List<T>) t;
        }
        // 返回第三方业务 object 数据
        else {
            this.status = BaseResponse.SUCCESS;
            List<T> list = new ArrayList<>();
            list.add(t);
            this.dataList =  list;
        }
    }

    public ResponseBusiness()  {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getListData(Class<T> clazz) {
        List<T> list = new ArrayList<>();
        JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(dataList));
        if (jsonArray==null || jsonArray.isEmpty()) {
            return list;
        }
        // 处理String类型
        if(clazz.getName().equals("java.lang.String")){
            List<String> listStr = new ArrayList<>();
            for (Object object : jsonArray) {
                listStr.add((String) object);
            }
            return (List<T>) listStr;
        }
        for (Object object : jsonArray) {
            JSONObject jsonObject = (JSONObject) object;
            T t = JSONObject.toJavaObject(jsonObject, clazz);
            list.add(t);
        }
        return list;
    }

    public T getDataWithIndex(Class<T> clazz,Integer index) {
        List<T> listData = this.getListData(clazz);
        if(CollectionUtils.isEmpty(listData)){
            return null;
        }
        T t = listData.get(index);
        return t;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
