package com.tetrisGame2V10;

//�ع�J�࣬�̳�Tetromino
public class TetrominoJ extends Tetromino{
	public TetrominoJ(int row,int col){
		super();
		//��˳ʱ�뷽���ʼ��
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+2);
	}
	
	@Override
	public void print() {
		System.out.println("���� J");
		super.print();
	}
}
