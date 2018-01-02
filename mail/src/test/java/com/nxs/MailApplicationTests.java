package com.nxs;

import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;


	@Test
	public void senderSimpleMail(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("570141370@qq.com");
		message.setTo("878169592@qq.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		mailSender.send(message);
	}

	@Test
	public void sendAttachmentsMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("570141370@qq.com");
		helper.setTo("878169592@qq.com");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("headimage.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendInlineMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("570141370@qq.com");
		helper.setTo("878169592@qq.com");
		helper.setSubject("主题：嵌入静态资源");
		//这里需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
		helper.setText("<html><body><img src=\"cid:headimage\" ></body></html>", true);
		FileSystemResource file = new FileSystemResource(new File("headimage.jpg"));
		helper.addInline("headimage", file);
		mailSender.send(mimeMessage);
	}

	@Test
	public void sendTemplateMail() throws Exception {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("570141370@qq.com");
		helper.setTo("878169592@qq.com");
		helper.setSubject("主题：模板邮件");

		//通过指定模板名获取FreeMarker模板实例
		Template tpl=freeMarkerConfigurer.getConfiguration().getTemplate("template.ftl");
		//FreeMarker通过Map传递动态数据
		Map<String, Object> model = new HashMap<>();
		model.put("username", "jonenxs"); //注意动态数据的key和模板标签中指定的属性相匹配
		//解析模板并替换动态数据，最终username将替换模板文件中的${username}标签。
		String htmlText= FreeMarkerTemplateUtils.processTemplateIntoString(tpl,model);
		helper.setText(htmlText, true);
		mailSender.send(mimeMessage);
	}


}
