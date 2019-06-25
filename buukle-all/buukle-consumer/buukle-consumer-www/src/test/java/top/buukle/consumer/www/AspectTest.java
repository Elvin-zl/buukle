/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: AspectTest
 * Author:   elvin
 * Date:     2019/6/25 22:20
 * Description: 切面测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.consumer.www;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.consumer.www.entity.ArticleInfo;
import top.buukle.consumer.www.service.ArticleInfoService;

/**
 * @description 〈切面测试〉
 * @author elvin
 * @create 2019/6/25
 * @since 1.0.0
 */
public class AspectTest extends AbstractApplicationTests {


    @Autowired
    ArticleInfoService articleInfoService;

    @Test
    public void updateArticleTitleTest() {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(93);
        articleInfo.setTitle("压力测试001");
        articleInfoService.updateArticleInfo(articleInfo);
    }
}