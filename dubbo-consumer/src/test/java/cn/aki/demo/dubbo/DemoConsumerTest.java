package cn.aki.demo.dubbo;

import java.util.concurrent.Future;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;

import cn.aki.demo.dubbo.service.IDemoService;

public class DemoConsumerTest {
	
	@Test
	public void simpleTest(){
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("/spring-consumer.xml");
		context.start();
		
		// 隐式传参
		RpcContext.getContext().setAttachment("key", "keyValue");// 线程变量
		
		// 远程调用
		IDemoService service = context.getBean(IDemoService.class);
		String word = service.hello("world");
		System.out.println(word);
		context.close();
	}
	
	@Test
	public void asyncTest(){
		new TestTempalte(){
			@Override
			protected void doExecute(ClassPathXmlApplicationContext context) throws Exception {
				IDemoService service = context.getBean(IDemoService.class);
				String result = service.async("hello");
				System.out.println(result);
				Future<String> future = RpcContext.getContext().getFuture();
				result = future.get();
				System.out.println(result);
			}
		}.execute();
	}
	
	private static abstract class TestTempalte{
		public void execute(){
			ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("/spring-consumer.xml");
			context.start();
			try {
				doExecute(context);
			} catch (Exception e) {
				e.printStackTrace();
			}
			context.close();
		}
		protected abstract void doExecute(ClassPathXmlApplicationContext context) throws Exception;
	}
}
