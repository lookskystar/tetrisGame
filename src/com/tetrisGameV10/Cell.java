package com.tetrisGameV10;

public class Cell {
	public int row;
	public int col;
	
	//无参的构造方法（默认的），在引用这个类对象的时候（new），会自动创建
	public Cell() {
		//super();
		this(0,0);//无参调用有参的构造方法Cell(int row, int col)
	}
	//有参的构造方法，在new时候，赋初始值
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	//下落一行
	public void drop(){
		row++;
	}
	
	//左移
	public void moveLeft(int d){
		col-=d;
	}
	
	//重载drop方法,类里面的方法，方法名相同，方法的参数列表不同
	public void drop(int d){
		row+=d;
	}
	//重载方法moveLeft，左移个单元
	public void moveLeft(){
		col--;
	}
	
	//右移
	public void moveRight(int d){
		col+=d;
	}
	public void moveRight(){
		col++;
	}
	
	
	//重写父类Object的toString
	@Override
	public String toString() {
		return row+","+col;
	}
}
