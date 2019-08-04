/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: StatusConstants
 * Author:   zhanglei1102
 * Date:     2019/7/26 16:49
 * Description: 状态常量
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.common.status;

/**
 * @description 〈状态常量〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
public final class StatusConstants {

    /*----返回状态-----*/
    /** 成功*/
    public static final String SUCCESS = "S";
    /** 失败*/
    public static final String FAILED = "F";

    /*---数据记录状态--*/
    /** 启用*/
    public static final Integer OPEN = 1;
    /** 禁用*/
    public static final Integer BAN  = 0;
    /** 删除*/
    public static final Integer DELETED  = -1;

}