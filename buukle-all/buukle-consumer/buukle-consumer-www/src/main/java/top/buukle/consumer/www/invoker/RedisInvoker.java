package top.buukle.consumer.www.invoker;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.consumer.www.constants.CacheConstants;
import top.buukle.consumer.www.vo.ArticleCatTreeNodeVo;

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
        RedisString.setWithExpire(CacheConstants.ARTICLE_CAT_LIST_KEY, JsonUtil.toJSONString(articleCatTreeNodeVoList),CacheConstants.ARTICLE_CAT_LIST_CACHE_TIME_EXPIRE);
    }

}
