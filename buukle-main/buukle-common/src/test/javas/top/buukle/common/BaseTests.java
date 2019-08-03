/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: BaseTests
 * Author:   zhanglei1102
 * Date:     2019/7/26 17:14
 * Description: 测试类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package javas.top.buukle.common;

import org.junit.Test;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.code.BaseReturnEnum;
import top.buukle.common.call.head.ResponseHead;

/**
 * @description 〈测试类〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
public class BaseTests {

    @Test
    public void test1() {
        CommonResponse commonResponse = new CommonResponse(new ResponseHead(),BaseReturnEnum.SUCCESS);
    }
}