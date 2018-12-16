package top.buukle.provider.security.service;


import top.buukle.plugin.security.vo.response.SelectSearchItemVo;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/16.
 * @Description :
 */
public interface ApplicationService {
    /**
     * 获取应用列表
     * @return
     */
    List<SelectSearchItemVo> getApplicationListWithoutPage();
}
