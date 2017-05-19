package cn.aki.demo.dubbo.service.impl;

import com.alibaba.dubbo.rpc.RpcContext;

import cn.aki.demo.dubbo.service.IDemoService;

public class DemoServiceImpl implements IDemoService{

	@Override
	public String hello(String name) {
		String attachment = RpcContext.getContext().getAttachment("key");
		StringBuilder result = new StringBuilder();
		result.append("<").append(attachment).append(">hello ").append(name);
		return result.toString();
	}

	@Override
	public String async(String message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}

}
