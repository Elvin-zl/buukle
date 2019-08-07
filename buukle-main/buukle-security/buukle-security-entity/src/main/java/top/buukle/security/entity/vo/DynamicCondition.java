/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: DynimicCondition
 * Author:   zhanglei1102
 * Date:     2019/8/7 15:37
 * Description: 动态查询条件包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.entity.vo;

/**
 * @description 〈动态查询条件包装类〉
 * @author zhanglei1102
 * @create 2019/8/7
 * @since 1.0.0
 */
public class DynamicCondition {
    private String attrName;
    private String begin;
    private String end;

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}