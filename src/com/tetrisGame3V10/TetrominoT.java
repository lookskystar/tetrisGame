package com.tetrisGame3V10;

//�ع�T�࣬�̳�Tetromino
public class TetrominoT extends Tetromino{
	public TetrominoT(int row,int col){
		super();
		//��˳ʱ�뷽���ʼ��
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+1);
	}

	@Override
	public void print() {
		System.out.println("���� T");
		super.print();
	}
	
	
}