package com.nxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 57014
 */
@RestController
@SpringBootApplication
public class SecurityCasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityCasApplication.class, args);
	}

	@RequestMapping("/")
	public String index() {
		return "访问了首页哦";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "不验证哦";
	}

	/**
	 * 有TEST权限的才能访问
	 * @return
	 */
	@PreAuthorize("hasAuthority('TEST')")
	@RequestMapping("/security")
	public String security() {
		return "hello world security";
	}

	/**
	 * 必须要有ADMIN权限的才能访问
	 */
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/authorize")
	public String authorize() {
		return "有权限访问";
	}

	/**这里注意的是，TEST与ADMIN只是权限编码，可以自己定义一套规则，根据实际情况即可*/
}
