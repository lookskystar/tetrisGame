package com.tetrisGame3;

//�ع�T
public class TetrominoT extends Tetromino {
	public TetrominoT(int row,int col){
		//ʹ��super�ؼ��ֵ��ø�����޲������췽��������ʡ�Բ�д
		//Ĭ������£�ϵͳ�����๹�췽���ĵ�һ��������super();
		super();
		//��˳ʱ�뷽���ʼ��Cell
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+1);
	}

	@Override
	public void print() {
		System.out.println("�� ��һ�� T");
		super.print();
	}
	
	
}
