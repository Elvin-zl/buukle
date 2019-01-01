package top.buukle.consumer.portal.util.redis.commonFrameWork;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : redis String类
 */
public class RedisString {

    /**
     * set k,v
     * @param k
     * @param v
     * @return
     */
    public static String set(String k,String v){
        return RedisCommond.set(k,v);
    }

    /**
     * set k,v,if not exist
     * @param k
     * @param v
     * @return
     */
    public static Long setnx(String k,String v){
        return RedisCommond.setnx(k,v);
    }

    /**
     * set k,v with expire time ,the unit is second
     * @param k
     * @param expire
     * @param v
     * @return
     */
    public static String setex(String k,int expire,String v){
        return RedisCommond.setex(k,expire,v);
    }


    /**
     * get the value of the key k
     * @param k
     * @return
     */
    public static String get(String k){
        return RedisCommond.get(k);
    }

    /**
     * set k,v ,also return the old v
     * @param k
     * @param v
     * @return
     */
    public static String getSet(String k, String v) {
        return RedisCommond.getSet(k,v);
    }


    /**
     * 删除某key
     * @param k
     */
    public static Long delete(String k) {
        return RedisCommond.delete(k);
    }
}
