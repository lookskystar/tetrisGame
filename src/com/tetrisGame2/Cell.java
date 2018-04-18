package com.tetrisGame2;
public class Cell {
	public int row;
	public int col;

	// 默认的构造函数
	public Cell() {
		this(0, 0); // 无参的构造函数调用有参的构造函数
	}

	// 初始化，带参的构造函数
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	//构造方法重载
	public Cell(Cell cell){
		this(cell.row,cell.col);
	}
	

	// 下落一行
	public void drop() {
		row++;
	}

	// 左移
	public void moveLeft(int d) {
		col -= d;
	}
	//右移
	public void moveRight(int d) {
		col+=d;
	}

	// 下落多行，重载drop方法
	public void drop(int d) {
		row += d;
	}

	// 左移一列，重载moveLeft方法
	public void moveLeft() {
		col--;
	}
	// 右移一列，重载moveRight方法
	public void moveRight() {
		col++;
	}

	// 调用该方法，即可打印格子位置信息
	public String toString() {
		return row + "," + col;
	}

}
