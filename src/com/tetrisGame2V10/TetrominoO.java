package com.tetrisGame2V10;

//�ع�O�࣬�̳�Tetromino
public class TetrominoO extends Tetromino{
	public TetrominoO(int row,int col){
		super();
		//��˳ʱ�뷽���ʼ��
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row+1,col+1);
		cells[3]=new Cell(row+1,col);
	}

	@Override
	public void print() {
		System.out.println("���� O");
		super.print();
	}
	
	
}
