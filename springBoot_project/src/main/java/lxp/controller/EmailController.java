package lxp.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.sun.tools.internal.ws.processor.model.Model;


import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import lxp.util.Result;
import lxp.util.TempUtils;

/**
 * @author lxp
 * @date 2018年2月6日 上午11:16:42
 * @param
 * @return
 */
@Controller
public class EmailController {
	
	
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/")
	public String ma(ModelMap model) {
		model.addAttribute("name","lxp");
		//model.setProperty("name","lxp");
		return "index";
	} 
	
	
	
	/**
	 * 发送email 邮箱信息
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws MalformedTemplateNameException 
	 * @throws TemplateNotFoundException 
	 * @throws TemplateException 
	 */
	@RequestMapping("/fasongEmail")
	@ResponseBody
	public Result fasongEmail(String email) throws FileNotFoundException {
		
		Map model =new HashMap();
		model.put("name","lxp");
		
		//获取邮箱模版 
		Template template;String html =null;
		try {
			template = freeMarkerConfigurer.getConfiguration().getTemplate("EmailModel.ftl");
			html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		} catch (IOException | TemplateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		
		MimeMessage message = javaMailSender.createMimeMessage(); 
		
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setFrom("420059604@qq.com");  
	        helper.setTo("1139901095@qq.com");  
	        helper.setSubject("图片");  
	        helper.setText(html, true);	        
//	        URL path2 = Thread.currentThread().getContextClassLoader ().getResource("");
//	        String ph =path2+"/"+"static/forbidden.jpg";
	        
	        File photo =TempUtils.getphoto();
	        FileSystemResource res = new FileSystemResource(new File("src/main/resources/static/forbidden.jpg"));  
            helper.addInline("forbidden.jpg", res); 
	        
	        javaMailSender.send(message);  
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
      
		
		return new Result();
	}
}

