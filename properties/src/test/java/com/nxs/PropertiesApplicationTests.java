package com.nxs;

import com.nxs.properties.BlogProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesApplicationTests {

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void getHello() throws Exception {
		Assert.assertEquals(blogProperties.getName(), "程序猿DD");
		Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
		Assert.assertEquals(blogProperties.getDesc(), "程序猿DD正在努力写《Spring Boot教程》");
		System.out.println(blogProperties.getValue());//0d2a9b13f987fef784584cbedcd4f758

	}

}
