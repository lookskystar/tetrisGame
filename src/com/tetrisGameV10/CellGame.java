package com.tetrisGameV10;

import java.util.Scanner;

public class CellGame {
	public static void main(String[] args) {
		System.out.println("-------����Cell-------");
		//����Cell���󣬲���ӡ
		Cell cell=new Cell(0,4);
//		cell.row=15;
//		cell.col=6;  //������ӵ�λ��
		printCell(cell);
		
		//���÷���������һ��
//		System.out.println("-------Cell ����һ��-------");
//		cell.drop();
//		printCell(cell);
		
		//������Ҫ�ƶ�������
//		System.out.println("-------Cell �ƶ�����-------");
//		System.out.print("���������Ƶ�������");
//		Scanner sc=new Scanner(System.in);
//		int cols=sc.nextInt();
//		sc.close();
//		cell.moveLeft(cols);
//		printCell(cell);
		
		//���ƶ�һ��
//		System.out.println("-------Cell ���ƶ�һ��-------");
//		cell.moveLeft();
//		printCell(cell);
		
		System.out.println("1-���䣬2-����3-���ң�0-�˳�");
		//״̬���ж��Ƿ�����ӿ���̨�õ�ֵ
		boolean flag=true; 
		
		while(flag){
			//ÿһ�ζ�Ҫ����һ������
			Scanner sc=new Scanner(System.in);
			int key=sc.nextInt();
			switch (key) {
			case 1:
				//����
				cell.drop();
				printCell(cell);
				break;
			case 2:
				//����
				cell.moveLeft();
				printCell(cell);
				break;
			case 3:
				//����
				cell.moveRight();
				printCell(cell);
				break;
			case 0:
				//�˳�
				flag=false;
				break;
			default:
				break;
			}
		}
		
		
		
		
	}
	
	//��ӡ����
	public static void printCell(Cell cell){
		int totalRow=20; //������
		int totalCol=10; //������
		
		//��Ӧ���ӵ�λ����Ϣ
		System.out.println("Cell��λ��Ϊ����"+cell.toString()+")");
		
		//��ӡ����
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if(cell.row==row&&cell.col==col){
					//��ӡָ���ĸ���
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
