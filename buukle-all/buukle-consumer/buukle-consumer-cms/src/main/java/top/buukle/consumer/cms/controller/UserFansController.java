package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.UserFansService;
import top.buukle.consumer.cms .entity.UserFans;
import top.buukle.consumer.cms .entity.vo.UserFansQuery;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import java.util.List;

@Controller
@RequestMapping("/userFans")
public class UserFansController{

    @Autowired
    UserFansService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getUserFansList")
    @ResponseBody
    public PageResponse<UserFans> getUserList(UserFansQuery query,PageBounds pageBounds) throws Exception {
        return service.getUserFansList(query,pageBounds);
    }

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    * @throws Exception
    */
    @RequestMapping("/fuzzySearchByText")
    @ResponseBody
    public List<FuzzySearchListVo>  fuzzySearchByText(String fuzzyText) throws Exception {
        return service.fuzzySearchByText(fuzzyText);
    }

}