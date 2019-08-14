package top.buukle.security.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.common.call.AppResourceResponse;
import top.buukle.common.call.CommonRequest;
import top.buukle.common.exception.CommonException;
import top.buukle.common.status.StatusConstants;
import top.buukle.security.api.ApiAppService;
import top.buukle.security.dao.*;
import top.buukle.security.entity.*;
import top.buukle.security.service.constants.SystemReturnEnum;
import top.buukle.security.service.exception.SystemException;

import java.util.ArrayList;
import java.util.List;

/**
* @author elvin
* @description UserService实现类
*/
@Service
public class ApiAppServiceImpl implements ApiAppService {


    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private ButtonMapper buttonMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private InterfaceRegisterMapper interfaceRegisterMapper;


    /**
     * @description 查询app资源目录
     * @param request
     * @return top.buukle.common.call.AppResourceResponse
     * @Author elvin
     * @Date 2019/8/2
     */
    @Override
    public AppResourceResponse getAppResource(CommonRequest request) {

        AppResourceResponse appResourceResponse = new AppResourceResponse();

        // 查询应用
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria appCriteria = applicationExample.createCriteria();
        appCriteria.andNameEqualTo(request.getHead().getApplicationName());
        appCriteria.andStatusEqualTo(StatusConstants.OPEN);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        if(CollectionUtils.isEmpty(applications) || applications.size()!=1){
            throw SystemException.convert(new SystemException(SystemReturnEnum.APP_RESOURCE_EXCEPTION),new CommonException());
        }
        // 查询应用已注册接口资源
        InterfaceRegisterExample interfaceRegisterExample = new InterfaceRegisterExample();
        InterfaceRegisterExample.Criteria criteria = interfaceRegisterExample.createCriteria();
        criteria.andStatusEqualTo(StatusConstants.OPEN);
        criteria.andApplicationIdEqualTo(applications.get(0).getId());
        List<InterfaceRegister> interfaceRegisters = interfaceRegisterMapper.selectByExample(interfaceRegisterExample);
        List<String> registeredResourceList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(interfaceRegisters)){
            for (InterfaceRegister interfaceRegister: interfaceRegisters) {
                registeredResourceList.add(interfaceRegister.getUrl());
            }
        }
        appResourceResponse.setRegisteredResourceList(registeredResourceList);
        return appResourceResponse;
    }
}