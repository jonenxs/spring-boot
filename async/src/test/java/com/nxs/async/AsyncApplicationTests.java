package com.nxs.async;

import com.nxs.async.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyncApplicationTests {

	@Autowired
	private Task task;

	/**
	 * Future 方法
	 * 	1.判断任务是否完成；
	 *  2.能够中断任务；
	 *  3.能够获取任务执行结果。
	 * cancel方法用来取消任务，如果取消任务成功则返回true，如果取消任务失败则返回false。参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，则表示可以取消正在执行过程中的任务。如果任务已经完成，则无论mayInterruptIfRunning为true还是false，此方法肯定返回false，即如果取消已经完成的任务会返回false；如果任务正在执行，若mayInterruptIfRunning设置为true，则返回true，若mayInterruptIfRunning设置为false，则返回false；如果任务还没有执行，则无论mayInterruptIfRunning为true还是false，肯定返回true。
	 * isCancelled方法表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true。
	 * isDone方法表示任务是否已经完成，若任务完成，则返回true；
	 * get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
	 * get(long timeout, TimeUnit unit)用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。
	 * @throws Exception
	 */
	@Test
	public void contextLoads() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> task1 = task.doTaskOne();
		Future<String> task2 = task.doTaskTwo();
		Future<String> task3 = task.doTaskThree();

		while (true) {
			if (task1.isDone() && task2.isDone() && task3.isDone()) {
				//三个任务都都调用完成，退出循环等待
				break;
			}
		}
		long end = System.currentTimeMillis();
		log.info("任务全部完成，总耗时：" + (end - start) + "毫秒");
	}

}
