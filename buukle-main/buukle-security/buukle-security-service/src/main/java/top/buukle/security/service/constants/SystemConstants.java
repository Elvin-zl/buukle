/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: SystemConstants
 * Author:   elvin
 * Date:     2019/8/5 1:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.service.constants;

import java.util.Random;

/**
 * @description 〈〉
 * @author elvin
 * @create 2019/8/5
 * @since 1.0.0
 */
public class SystemConstants {

    public static final String USERID_PREFIX ="BK_";

    public static String getRandomSuffix(int length) {
        char[] chr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(chr[random.nextInt(36)]);
        }
        return buffer.toString();
    }

    public static String genUserId() {
        StringBuilder sb = new StringBuilder();
        sb.append(SystemConstants.USERID_PREFIX).append(SystemConstants.getRandomSuffix(9));
        return sb.toString();
    }
}