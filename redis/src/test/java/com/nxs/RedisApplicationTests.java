package com.nxs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nxs.pojo.Student;
import com.nxs.util.ByteUtil;
import com.nxs.util.RedisUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ByteUtil byteUtil;

	@Test
	public void contextLoads() {
		stringRedisTemplate.opsForValue().set("aaa", "111");
		Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
	}

	@Test
	public void test(){
		Student student = new Student();
		student.setId(1L);
		student.setName("张三");
		student.setAge(18);
		student.setBirth(new Date());
		student.setAddress("北京市朝阳区");

		List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        redisUtil.putListCacheWithExpireTime("1", studentList, 1000L);
	}

    @Test
    public void test2(){
        List<Student> listCache = redisUtil.getListCache("1", Student.class);
        listCache.forEach(System.out::println);
    }

    @Test
    public void test3(){
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(18);
        student.setBirth(new Date());
        student.setAddress("北京市朝阳区");

        Student student1 = new Student();
        student1.setId(2L);
        student1.setName("李四");
        student1.setAge(20);
        student1.setBirth(new Date());
        student1.setAddress("北京市海淀区");

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);

        Gson gson = new Gson();
        gson.toJson(studentList);

        stringRedisTemplate.opsForValue().set("bbb", gson.toJson(studentList));
        List<Student> list = gson.fromJson(stringRedisTemplate.opsForValue().get("bbb"), new TypeToken<List<Student>>(){}.getType());
        list.forEach(System.out::println);
//        byteUtil.toByteArray(student);

//        stringRedisTemplate.opsForValue().set("bbb", new String(byteUtil.toByteArray(student)));

//        Assert.assertEquals(student.getName(), ((Student)byteUtil.toObject(stringRedisTemplate.opsForValue().get("bbb").getBytes()) ).getName());
    }

    @Test
    public void test4(){
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(18);
        student.setBirth(new Date());
        student.setAddress("北京市朝阳区");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        redisUtil.set("ddd",studentList);
        ;
        List<Student> ddd = redisUtil.getList("ddd");
        System.out.println(ddd);
    }

}
