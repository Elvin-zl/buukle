/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: DnsCallBackController
 * Author:   elvin
 * Date:     2019/6/21 4:20
 * Description: DNS报警自动停服
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.consumer.www.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 〈DNS报警自动停服〉
 * @author elvin
 * @create 2019/6/21
 * @since 1.0.0
 */

@Controller
@RequestMapping("/api/dnsCallBack")
public class DnsCallBackController {
    @RequestMapping("exit0")
    public void exit0() {
        System.out.print("DNS报警,应用自动退出!");
        System.exit(0);
    }
}