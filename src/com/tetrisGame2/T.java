package com.tetrisGame2;

public class T {
	public Cell[] cells; //�����洢һ������4�����ӵ�����
	
	//���췽����Ϊ����cells�����г�ʼ��
	//row ˳ʱ�뷽������һ��������
	//col ˳ʱ�뷽�򣬵�һ��������
	public T(int row,int col){
		this.cells=new Cell[4];
		//��˳ʱ�뷽���ʼ��
		this.cells[0]=new Cell(row,col);
		this.cells[1]=new Cell(row,col+1);
		this.cells[2]=new Cell(row,col+2);
		this.cells[3]=new Cell(row+1,col+1);
	}
	
	//�޲ι��췽����Ϊ����cells���г�ʼ��
	public T(){
		this(0,0);
	}
	
	//��˳ʱ�뷽������ӡ�������ĸ��������ڵ�����
	public void print(){
		String str="";
		for (int i = 0; i < cells.length-1; i++) {
			str+="("+cells[i].toString()+"),";
		}
		str+="("+cells[cells.length-1].toString()+")";
		System.out.println(str);
	}
	
	//ʹ��������һ������
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].row++;
		}
	}
	
	//ʹ�������ƶ�һ������
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	
	//ʹ��������һ������
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}
}
