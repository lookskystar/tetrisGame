package com.tetrisGame2;

public class T {
	public Cell[] cells; //用来存储一个方块4个格子的坐标
	
	//构造方法，为属性cells，进行初始化
	//row 顺时针方法，第一个坐标行
	//col 顺时针方向，第一个坐标列
	public T(int row,int col){
		this.cells=new Cell[4];
		//按顺时针方向初始化
		this.cells[0]=new Cell(row,col);
		this.cells[1]=new Cell(row,col+1);
		this.cells[2]=new Cell(row,col+2);
		this.cells[3]=new Cell(row+1,col+1);
	}
	
	//无参构造方法，为属性cells进行初始化
	public T(){
		this(0,0);
	}
	
	//按顺时针方法，打印方块中四个格子所在的坐标
	public void print(){
		String str="";
		for (int i = 0; i < cells.length-1; i++) {
			str+="("+cells[i].toString()+"),";
		}
		str+="("+cells[cells.length-1].toString()+")";
		System.out.println(str);
	}
	
	//使方块下落一个格子
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].row++;
		}
	}
	
	//使方块左移动一个格子
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	
	//使方块右移一个格子
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}
}
