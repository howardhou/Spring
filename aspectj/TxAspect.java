package com.example;

public aspect TxAspect{
	void around(): call(void Hello.sayHello()){
		System.out.println("开始自定义事务...");
		proceed();
		System.out.println("结束自定义事务...");
	}
}