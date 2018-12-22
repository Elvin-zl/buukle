package top.buukle.consumer.cms.invoker;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.consumer.cms.constants.CacheConstants;
import top.buukle.consumer.cms.util.redis.RedisString;
import top.buukle.consumer.cms.vo.ArticleCatTreeNodeVo;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/14.
 * @Description : redis 缓存invoker
 */
public class RedisInvoker {

    /**获取文章分类列表*/
    public static List<ArticleCatTreeNodeVo> getArticleCatList() {
        String s = RedisString.get(CacheConstants.ARTICLE_CAT_LIST_KEY);
        if(StringUtil.isNotEmpty(s)){
           return JsonUtil.parseArray(s, ArticleCatTreeNodeVo.class);
        }
        return null;
    }

    /**缓存文章分类列表*/
    public static void saveArticleCatList(List<ArticleCatTreeNodeVo> articleCatTreeNodeVoList) {
        RedisString.setex(CacheConstants.ARTICLE_CAT_LIST_KEY,CacheConstants.ARTICLE_CAT_LIST_CACHE_TIME_EXPIRE,JsonUtil.toJSONString(articleCatTreeNodeVoList));
    }

}
