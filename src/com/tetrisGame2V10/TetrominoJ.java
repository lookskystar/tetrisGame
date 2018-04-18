package com.tetrisGame2V10;

//重构J类，继承Tetromino
public class TetrominoJ extends Tetromino{
	public TetrominoJ(int row,int col){
		super();
		//按顺时针方向初始化
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+2);
	}
	
	@Override
	public void print() {
		System.out.println("我是 J");
		super.print();
	}
}
