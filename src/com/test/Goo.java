package com.test;

public class Goo extends Foo {
	
	int num;
	int num1;
	
	
	
	public Goo(int num, int num1) {
		super.f();
		this.num = num;
		this.num1 = num1;
	}

	public void f(){
		System.out.println("Goo g() 子类");
	}
	
	public void g(){
		System.out.println("Goo g() 子类");
	}
}
