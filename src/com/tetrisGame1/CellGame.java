package com.tetrisGame1;
import java.util.Scanner;


public class CellGame {
	
	public static void main(String[] args) {
		System.out.println("-------����Cell-------");
		//����Cell���󣬲���ӡ
		Cell cell=new Cell(0,4);
//		cell.row=15; //16 //�ı�˱���ֵ��* ����
//		cell.col=6;//�ı�˱���ֵ��* ����
		printCell(cell);
		
		//��������һ�У�����drop����
//		System.out.println("-------Cell����һ��-------");
//		cell.drop();
//		printCell(cell);
		
		//�������Ʒ���
//		System.out.println("-------Cell�ƶ�����-------");
//		System.out.println("���������Ƶ�������");
//		Scanner sc=new Scanner(System.in);
//		int cols=sc.nextInt();
//		sc.close();
//		//����moveLeft�������ƶ���Ӧ������
//		cell.moveLeft(cols);
//		printCell(cell);
		
		//��������һ��
//		System.out.println("-------Cell����һ��-------");
//		cell.moveLeft();
//		printCell(cell);
		
		//���Դ�ӡ����λ����Ϣ
//		System.out.println("Cellλ��Ϊ��("+cell.toString()+")");
		
		System.out.println("1-���䣬2-����3-���ң�0-�˳�");
		boolean flag=true;
		while(flag){
			Scanner sc=new Scanner(System.in);
			int cols=sc.nextInt();
			switch (cols) {
			case 1:
				cell.drop();
				break;
			case 2:
				cell.moveLeft();
				break;
			case 3:
				cell.moveRight();
				break;
			case 0:
				flag=false;
				System.out.println("��Ϸ����");
				break;
			default:
				System.out.println("�������");
				break;
			}
			System.out.println("Cellλ��Ϊ��("+cell.toString()+")");
			printCell(cell);
			
		}
	}
	
	
	
	
	// ��ӡ����
	public static void printCell(Cell cell){
		int totalRow=20;
		int totalCol=10;
		
		//��ӡ����
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if(cell.row==row&&cell.col==col){
					//��ӡָ������
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
