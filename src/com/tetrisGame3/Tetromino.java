package com.tetrisGame3;

//T和J父类 抽取其共有的属性和方法构建
public class Tetromino {
	public Cell[] cells; //属性，用来存储一个方块的四个格子的坐标
	
	
	//构造方法，初始化cells数组
	public Tetromino() {
		cells=new Cell[4];
	}
	//顺时针，打印方块中四个格子所在的坐标
	public void print(){
		String str="";
		for (int i = 0; i < cells.length-1; i++) {
			str+="("+cells[i].toString()+"),";
		}
		str+="("+cells[cells.length-1].toString()+")";
		System.out.println(str);
	}
	//使方块落一个格子
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].row++;
		}
	}
	//使方块左移一个格子
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
