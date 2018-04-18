package com.test1;

public class Sub extends Base{
	String color;

	public Sub(double size, String name, String color) {
		super(size, name);
		this.color = color;
	}
	
	public static void main(String[] args) {
		Sub s=new Sub(5.6,"≤‚ ‘∂‘œÛ","∫Ï…´");
		System.out.println(s.size+":"+s.name+":"+s.color);
	}

}
