package com.empGrouping1;

public class Emp {
	public String name;
	public int age;
	public String gender;
	public double salary;
	public Emp(String name, int age, String gender, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
	}
	
	public void printlnInfo(){
		System.out.println("------------------");
		System.out.println("������"+name);
		System.out.println("���䣺"+age);
		System.out.println("�Ա�"+gender);
		System.out.println("нˮ��"+salary);
	}

}
