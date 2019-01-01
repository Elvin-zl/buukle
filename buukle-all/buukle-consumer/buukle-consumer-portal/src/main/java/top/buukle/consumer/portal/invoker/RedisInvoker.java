package top.buukle.consumer.portal.invoker;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.consumer.portal.constants.CacheConstants;
import top.buukle.consumer.portal.entity.vo.UserArticlePraiseRelationQuery;
import top.buukle.consumer.portal.util.redis.commonFrameWork.RedisHash;
import top.buukle.consumer.portal.util.redis.commonFrameWork.RedisSet;
import top.buukle.consumer.portal.util.redis.commonFrameWork.RedisString;
import top.buukle.consumer.portal.vo.ArticleCatTreeNodeVo;

import javax.servlet.http.HttpServletRequest;
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
        RedisString.setex(CacheConstants.ARTICLE_CAT_LIST_KEY, CacheConstants.ARTICLE_CAT_LIST_CACHE_TIME_EXPIRE,JsonUtil.toJSONString(articleCatTreeNodeVoList));
    }

    /**缓存用户点赞操作*/
    public static void saveUserOperation(UserArticlePraiseRelationQuery query) {
        if(!query.getPraiseFlag()){
            // 缓存用户的点赞行为
            RedisHash.hset(CacheConstants.USER_ARTICLE_PRAISE_RELATION_HASH_KEY,query.getArticleId()+"",query.getUserId());
            // 缓存文章的最新被点赞数据
            RedisSet.sadd(query.getArticleId()+"",query.getUserId());
        }else{
            // 缓存用户的点赞行为
            RedisHash.hdel(CacheConstants.USER_ARTICLE_PRAISE_RELATION_HASH_KEY,query.getArticleId()+"");
            // 缓存文章的最新被点赞数据
            RedisSet.srem(query.getArticleId()+"",query.getUserId());
        }
    }
    /**查询用户点赞操作*/
    public static UserArticlePraiseRelationQuery getUserArticlePraiseRelation(Integer articleId) {
        String userId = RedisHash.hget(CacheConstants.USER_ARTICLE_PRAISE_RELATION_HASH_KEY, articleId + "");
        UserArticlePraiseRelationQuery relationQuery = new UserArticlePraiseRelationQuery();
        if(StringUtil.isNotEmpty(userId)){
            relationQuery.setArticleId(articleId);
            relationQuery.setUserId(userId);
        }
        return relationQuery;
    }

    public static Long getUserArticlePraiseCount(Integer articleId) {
       return RedisSet.scard(articleId+"");
    }
}
