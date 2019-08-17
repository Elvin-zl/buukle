package top.buukle.security.plugin.thymleafDialect;
 
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.context.WebEngineContext;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.util.StringUtil;

import java.util.List;

/**
 * _处理器
 * @author sly
 * @time 2019年1月24日
 */
public class HpProcessor extends AbstractElementTagProcessor {
	private static final int PRECEDENCE = 10000;
	private static final String TAG_NAME = "hp";
	
	public HpProcessor(String dialectPrefix) {
		super(
				// 此处理器将仅应用于HTML模式
				TemplateMode.HTML,
				// 要应用于名称的匹配前缀
				dialectPrefix,
				// 标签名称：匹配此名称的特定标签
				TAG_NAME,
				// 没有要应用于标签名称的前缀
				false,
				// 无属性名称：将通过标签名称匹配
				null,
				// 没有要应用于属性名称的前缀
				false,
				// 优先(内部方言自己的优先)
				PRECEDENCE);
	}
	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
		WebEngineContext webEngineContext = (WebEngineContext)context;
		HttpServletRequest request = webEngineContext.getRequest();
		List<String> usrUrls = (List<String>)SessionUtil.get(request, SessionUtil.USER_URL_LIST_KEY);
		// 有or无权限处理
		if (!CollectionUtils.isEmpty(usrUrls) && (usrUrls.contains(tag.getAttributeValue("url")) || usrUrls.contains(tag.getAttributeValue("data-url"))) ) {
			structureHandler.removeTags();
		} else {
			structureHandler.removeElement();
		}
		// 修改or新增处理
		if(!StringUtil.isEmpty(tag.getAttributeValue("hpType"))){
			// 只在新增时候展示
			if(tag.getAttributeValue("hpType").equals("displayForAdd")){
				if(StringUtil.isEmpty(tag.getAttributeValue("recordId"))){
					structureHandler.removeTags();
				}else{
					structureHandler.removeElement();
				}
			}
			// 只在修改的时候展示
			else if(tag.getAttributeValue("hpType").equals("displayForEdit")){
				if(StringUtil.isEmpty(tag.getAttributeValue("recordId"))){
					structureHandler.removeElement();
				}else{
					structureHandler.removeTags();
				}
			}
		}
	}
}