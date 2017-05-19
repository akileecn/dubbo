package cn.aki.demo.dubbo;

import java.io.IOException;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoProviderTest {

	@Test
	public void test(){
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("/spring-provider.xml");
		context.start();
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
