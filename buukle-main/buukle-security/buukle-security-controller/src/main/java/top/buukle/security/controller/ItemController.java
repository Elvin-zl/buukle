package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security .entity.vo.ItemQuery;
import top.buukle.security .service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
* @author elvin
* @description  Item controller
*/
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, ItemQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", itemService.getPage(query));
        modelAndView.setViewName("item/" + pageName);
        return modelAndView;
    }

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/itemList")
    @ResponseBody
    public PageResponse itemList() throws Exception {
        Map<String,String> map = new HashMap();
        map.put("pageNo", "1");
        map.put("pageSize", "10");
        map.put("isBook", "0");
        map.put("productStyle", "2");
        map.put("rangeParams", "[{\"attrName\":\"fundCloseBeginDate\",\"end\":\"2019-06-10\"}," +
                "{\"attrName\":\"fundCloseEndDate\",\"begin\":\"2019-06-10\"}]");
        return itemService.itemList(map);
    }

    /**
    * @description 新增或者修改
    * @param query
    * @param request
    * @return top.buukle.common.call.CommonResponse
    * @Author elvin
    * @Date 2019/8/5
    */
    @RequestMapping("/saveOrEdit")
    @ResponseBody
    public CommonResponse saveOrEdit(ItemQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return itemService.saveOrEdit(query,request,response);
    }
}