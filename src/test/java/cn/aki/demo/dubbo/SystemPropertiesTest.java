package cn.aki.demo.dubbo;

import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class SystemPropertiesTest {
	
	@Test
	public void test(){
		Properties props = System.getProperties();
		Set<Object> keys = props.keySet();
		for(Object key : keys){
			System.err.println(key + "<" + props.get(key) + ">");
		}
	}
}
