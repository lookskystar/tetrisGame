package com.empGrouping1;

import java.util.Scanner;

public class TeamManager {
	public static void main(String[] args) {
		//Ա����Ϊ3��С��
		Emp[][] emps=new Emp[3][];
		//��1С����2��
		emps[0]=new Emp[2];
		//��2С����3��
		emps[1]=new Emp[3];
		//��3С����2��
		emps[2]=new Emp[2];
		
		inputTeam(emps);
		findEmp(emps, "andy");
	}
	
	//����Ա������Ϣ��
	//emps �洢Ա����Ϣ������
	public static void inputTeam(Emp[][] emps){
		Scanner sc=new Scanner(System.in);
		//ѭ��Ա���м���С��
		for (int i = 0; i < emps.length; i++) {
			System.out.println("***�����"+(i+1)+"��Ա����Ϣ***");
			//ÿ��С���ж��λԱ��
			for (int j = 0; j < emps[i].length; j++) {
				System.out.println("---�����"+(i+1)+"�飬��"+(j+1)+"��Ա����Ϣ�����������䡢�Ա�f/m�������ʣ��ÿո�ֿ���---");
				String name=sc.next();
				int age=sc.nextInt();
				String gender=sc.next();
				double salary=sc.nextDouble();
				
				//j��ʾԱ���飬i��ʾÿ��Ա�����ж��Ա��
				emps[i][j]=new Emp(name,age,gender,salary);
			}
		}
	}
	
	//��ѯָ��������Ա����Ϣ
	//emps �洢Ա����Ϣ������
	//name ָ��Ա������
	public static void findEmp(Emp[][] emps,String name){
		for (int i = 0; i < emps.length; i++) {
			System.out.println("***�����"+(i+1)+"��Ա����Ϣ***");
			for (int j = 0; j < emps[i].length; j++) {
				if(name.equals(emps[i][j].name)){
					System.out.println("��"+(i+1)+"�飬��"+(j+1)+"��Ա����Ϣ���£�");
					emps[i][j].printlnInfo();
					return;
				}
			}
		}
	}
	
}
