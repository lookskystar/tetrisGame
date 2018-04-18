package com.tetrisGame3V10;

import java.util.Scanner;

public class TetrominoGame {
	public static void main(String[] args) {
		//����TetrominoT
		System.out.println("-------��ӡT��-------");
		Tetromino t=new TetrominoT(0,4);
		t.print();
		printTetromino(t);
		
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
				t.drop();
				printTetromino(t);
				break;
			case 2:
				//����
				t.moveLeft();
				printTetromino(t);
				break;
			case 3:
				//����
				t.moveRight();
				printTetromino(t);
				break;
			case 0:
				//�˳�
				flag=false;
				break;
			default:
				break;
			}
		}
		
		
		
		
		
//		//����TetrominoJ
//		System.out.println("-------��ӡT��-------");
//		Tetromino j=new TetrominoJ(0,4);
//		j.print();
//		printTetromino(j);
//		
//		//����TetrominoO
//		System.out.println("-------��ӡO��-------");
//		Tetromino o=new TetrominoO(0,4);
//		o.print();
//		printTetromino(o);
	}
	
	
	
	
	
	
	//��ӡ����Ϸ���ڵ�ƽ�棨��10�񣬸�20�񣩡�
	//�á�-���ű�ʾƽ���ϵ�ÿ����Ԫ��
	//�á�*���Ŵ�ӡ��ʾ�����е�ÿ������
	/*
	 * @param tetromino ��Ҫ��ʾ����Ϸƽ���еķ���
	 * 
	 */
	                                  //�����Ĳ����б�
	public static void printTetromino(Tetromino tetromino){
		int totalRow=20;
		int totalCol=10;
		
		//��ȡ�����д洢���ĸ����Ե�����
		Cell[] cells=tetromino.cells; 
		//��ӡ20*10�����
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				//�����жϸ�λ���Ƿ������cells������
				boolean isInCells=false;
				for (int i = 0; i < cells.length; i++) {
					if(cells[i].row==row&&cells[i].col==col){
						System.out.print("* ");
						isInCells=true;
					}
				}
				if(!isInCells){
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		
	}
}
