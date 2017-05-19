package cn.aki.demo.dubbo.service;

public interface IDemoService {
	String hello(String name);
	
	String async(String message);
}
