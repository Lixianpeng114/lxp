package lxp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.tools.internal.ws.processor.model.Model;

/**
 * @author lxp
 * @date 2018年2月6日 上午11:16:42
 * @param
 * @return
 */
@Controller
public class EmailController {
	
	@RequestMapping("/")
	public String ma(ModelMap model) {
		
		model.addAttribute("name","lxp");
		//model.setProperty("name","lxp");
		return "index";
	} 
	
	
}

