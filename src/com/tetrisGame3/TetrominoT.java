package com.tetrisGame3;

//重构T
public class TetrominoT extends Tetromino {
	public TetrominoT(int row,int col){
		//使用super关键字调用父类的无参数构造方法，可以省略不写
		//默认情况下，系统在子类构造方法的第一句代码就是super();
		super();
		//按顺时针方向初始化Cell
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+1);
	}

	@Override
	public void print() {
		System.out.println("我 是一个 T");
		super.print();
	}
	
	
}
