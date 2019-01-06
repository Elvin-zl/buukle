package top.buukle.consumer.portal.vo;

import java.util.Comparator;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/1/7.
 * @Description :
 */
public class MapKeyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2)  {

        return i2.compareTo(i1);
    }
}
