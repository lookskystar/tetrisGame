package com.tetrisGame1V10;

public class J {
	public Cell[] cells;
	public J(){
		this(0,0);
	}
	
	/*
	 * 构造方法，为属性cells进行初始化
	 * 
	 * @param row 顺时针方法
	 * 				,第一个坐标的行
	 * @param col 顺时针方法
	 * 				,第一个坐标的列
	 */
	public J(int row,int col){
		cells=new Cell[4];
		//按顺时针方向初始化cell
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+2);
	}
	
	/*
	 * 按照顺时针方向，打印方块中四个格子所在的坐标
	 */
	public void print(){
		String str="";
		for (int i = 0; i < cells.length-1; i++) {
			str+="("+cells[i].toString()+"),";
		}
		str+="("+cells[cells.length-1].toString()+")";
		System.out.println(str);
	}
	
	/*
	 * 使方块下落一个格子
	 */
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].row++;
		}
	}
	
	/*
	 * 使方块左移一个格子
	 */
	public void movLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	/*
	 * 使方块右移一个格子
	 */
	public void movRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}

}
