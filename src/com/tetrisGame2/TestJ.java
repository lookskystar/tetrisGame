package com.tetrisGame2;

public class TestJ {

	public static void main(String[] args) {
		J j=new J(17,3);
		System.out.println("ԭʼ����Ϊ��");
		j.print();
		
		//����drop����
//		j.drop();
//		System.out.println("����drop����������꣺");
//		j.print();
		
		//����moveLeft����
//		j.moveLeft();
//		System.out.println("����moveLeft����������꣺");
//		j.print();
		
		//����moveRight����
		j.moveRight();
		System.out.println("����moveRight����������꣺");
		j.print();
		
	}
	
}
