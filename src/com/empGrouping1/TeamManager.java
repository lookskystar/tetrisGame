package com.empGrouping1;

import java.util.Scanner;

public class TeamManager {
	public static void main(String[] args) {
		//员工分为3个小组
		Emp[][] emps=new Emp[3][];
		//第1小组有2人
		emps[0]=new Emp[2];
		//第2小组有3人
		emps[1]=new Emp[3];
		//第3小组有2人
		emps[2]=new Emp[2];
		
		inputTeam(emps);
		findEmp(emps, "andy");
	}
	
	//输入员工的信息，
	//emps 存储员工信息的数组
	public static void inputTeam(Emp[][] emps){
		Scanner sc=new Scanner(System.in);
		//循环员工有几个小组
		for (int i = 0; i < emps.length; i++) {
			System.out.println("***输入第"+(i+1)+"组员工信息***");
			//每个小组有多个位员工
			for (int j = 0; j < emps[i].length; j++) {
				System.out.println("---输入第"+(i+1)+"组，第"+(j+1)+"个员工信息：姓名、年龄、性别（f/m）、工资（用空格分开）---");
				String name=sc.next();
				int age=sc.nextInt();
				String gender=sc.next();
				double salary=sc.nextDouble();
				
				//j表示员工组，i表示每个员工组有多个员工
				emps[i][j]=new Emp(name,age,gender,salary);
			}
		}
	}
	
	//查询指定姓名的员工信息
	//emps 存储员工信息的数组
	//name 指定员工名称
	public static void findEmp(Emp[][] emps,String name){
		for (int i = 0; i < emps.length; i++) {
			System.out.println("***输入第"+(i+1)+"组员工信息***");
			for (int j = 0; j < emps[i].length; j++) {
				if(name.equals(emps[i][j].name)){
					System.out.println("第"+(i+1)+"组，第"+(j+1)+"个员工信息如下：");
					emps[i][j].printlnInfo();
					return;
				}
			}
		}
	}
	
}
