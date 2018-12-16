package top.buukle.provider.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.dataIsolation.IsolationConstants;
import top.buukle.common.exception.BaseException;
import top.buukle.provider.security.constants.CommonControllerConstants;
import top.buukle.plugin.security.entity.User;
import top.buukle.provider.security.service.ApplicationService;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.util.SessionUtil;
import top.buukle.plugin.security.vo.response.SelectSearchItemVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/6.
 * @Description : 页面通用controller
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    UserService userService;
    @Autowired
    ApplicationService applicationService;
    /**
     * 获取下拉列表
     * @return
     * @throws Exception
     */
    @RequestMapping("/getSelectItemByType")
    @ResponseBody
    public List<SelectSearchItemVo> getSelectItemByType(HttpServletRequest request, Integer selectType,String superCode) throws Exception {
        if(null == selectType){
            throw new BaseException(BaseResponseCode.COMMON_SELECT_TYPE_NULL);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_LEVEL)){
            return this.getUserSubLevel(request);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_PLATFORM)){
            return userService.getSelectItemByType(request,selectType,superCode);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_AGENT)){
            return userService.getSelectItemByType(request,selectType,superCode);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_GROUP)){
            return userService.getSelectItemByType(request,selectType,superCode);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_SALESMAN)){
            return userService.getSelectItemByType(request,selectType,superCode);
        }
        if(selectType.equals(CommonControllerConstants.SELECT_TYPE_APPLICATION)){
            return applicationService.getApplicationListWithoutPage();
        }
        return null;
    }


    /**
     * 获取用户所包含级别
     * @param request
     * @return
     */
    private List<SelectSearchItemVo> getUserSubLevel(HttpServletRequest request) {
        User operator = SessionUtil.getOperator(request);
        List<SelectSearchItemVo> list = new ArrayList<>();
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_CREATOR)){
            return list;
        }
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_SALESMAN)){
            list.add(this.assCreatorLevelItem());
        }
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_GROUP)){
            list.add(this.assCreatorLevelItem());
            list.add(this.assSalesmanLevelItem());
        }
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_AGENT)){
            list.add(this.assCreatorLevelItem());
            list.add(this.assSalesmanLevelItem());
            list.add(this.assGroupLevelItem());
        }
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_PLATFORM)){
            list.add(this.assCreatorLevelItem());
            list.add(this.assSalesmanLevelItem());
            list.add(this.assGroupLevelItem());
            list.add(this.assAgentLevelItem());
        }
        if(operator.getUserLevel().equals(IsolationConstants.USER_LEVEL_BOSS)){
            list.add(this.assCreatorLevelItem());
            list.add(this.assSalesmanLevelItem());
            list.add(this.assGroupLevelItem());
            list.add(this.assAgentLevelItem());
            list.add(this.assPlatformLevelItem());
        }
        return list;
    }

    private SelectSearchItemVo assPlatformLevelItem() {
        SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
        selectSearchItemVo.setText(IsolationConstants.USER_LEVEL_PLATFORM_NAME_CN);
        selectSearchItemVo.setIdInteger(IsolationConstants.USER_LEVEL_PLATFORM);
        return selectSearchItemVo;
    }

    private SelectSearchItemVo assAgentLevelItem() {
        SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
        selectSearchItemVo.setText(IsolationConstants.USER_LEVEL_AGENT_NAME_CN);
        selectSearchItemVo.setIdInteger(IsolationConstants.USER_LEVEL_AGENT);
        return selectSearchItemVo;
    }

    private SelectSearchItemVo assGroupLevelItem() {
        SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
        selectSearchItemVo.setText(IsolationConstants.USER_LEVEL_GROUP_NAME_CN);
        selectSearchItemVo.setIdInteger(IsolationConstants.USER_LEVEL_GROUP);
        return selectSearchItemVo;
    }

    private SelectSearchItemVo assSalesmanLevelItem() {
        SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
        selectSearchItemVo.setText(IsolationConstants.USER_LEVEL_SALESMAN_NAME_CN);
        selectSearchItemVo.setIdInteger(IsolationConstants.USER_LEVEL_SALESMAN);
        return selectSearchItemVo;
    }

    private SelectSearchItemVo assCreatorLevelItem() {
        SelectSearchItemVo selectSearchItemVo = new SelectSearchItemVo();
        selectSearchItemVo.setText(IsolationConstants.USER_LEVEL_CREATOR_NAME_CN);
        selectSearchItemVo.setIdInteger(IsolationConstants.USER_LEVEL_CREATOR);
        return selectSearchItemVo;
    }

}
