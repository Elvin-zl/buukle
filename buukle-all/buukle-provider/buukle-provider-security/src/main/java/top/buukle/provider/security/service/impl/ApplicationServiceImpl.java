package top.buukle.provider.security.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.plugin.security.entity.Application;
import top.buukle.plugin.security.entity.ApplicationExample;
import top.buukle.plugin.security.vo.response.SelectSearchItemVo;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.ApplicationMapper;
import top.buukle.provider.security.service.ApplicationService;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/16.
 * @Description : 应用service
 */
@Service
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    ApplicationMapper applicationMapper;
    /**
     * 获取应用列表
     * @return
     */
    @Override
    public List<SelectSearchItemVo> getApplicationListWithoutPage() {
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andStatusEqualTo(SecurityStatusConstants.STATUS_OPEN);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        List<SelectSearchItemVo> selectSearchItemVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(applications)){
            for (Application application: applications) {
                SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
                selectSearchItemVo.setIdInteger(application.getId());
                selectSearchItemVo.setText(application.getName());
                selectSearchItemVos.add(selectSearchItemVo);
            }
        }
        return selectSearchItemVos;
    }
}
