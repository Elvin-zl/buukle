package top.buukle.consumer.www.task;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.consumer.www.entity.vo.UserArticlePraiseRelationQuery;
import top.buukle.consumer.www.service.UserArticlePraiseRelationService;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/1.
 * @Description :
 */
public class PraiseTask {

    private UserArticlePraiseRelationService userArticlePraiseRelationService = SpringContextUtil.getBean(UserArticlePraiseRelationService.class);

    public void execute(String parameter) throws InterruptedException {
        UserArticlePraiseRelationQuery relationQuery = JsonUtil.parseObject(parameter, UserArticlePraiseRelationQuery.class);
        userArticlePraiseRelationService.updateArticlePraise(relationQuery,null);
    }
}
