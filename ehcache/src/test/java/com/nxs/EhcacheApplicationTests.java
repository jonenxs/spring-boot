package com.nxs;

import com.nxs.domain.User;
import com.nxs.domain.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EhcacheApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp(){
		userRepository.save(new User("AAA", 10));
	}

	@Test
	public void contextLoads() {
		User u1 = userRepository.findByName("AAA");
		System.out.println("第一次查询：" + u1.getAge());

		User u2 = userRepository.findByName("AAA");
		System.out.println("第二次查询：" + u2.getAge());
	}

}
