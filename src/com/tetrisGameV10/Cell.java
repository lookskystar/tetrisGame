package com.tetrisGameV10;

public class Cell {
	public int row;
	public int col;
	
	//�޲εĹ��췽����Ĭ�ϵģ������������������ʱ��new�������Զ�����
	public Cell() {
		//super();
		this(0,0);//�޲ε����вεĹ��췽��Cell(int row, int col)
	}
	//�вεĹ��췽������newʱ�򣬸���ʼֵ
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	//����һ��
	public void drop(){
		row++;
	}
	
	//����
	public void moveLeft(int d){
		col-=d;
	}
	
	//����drop����,������ķ�������������ͬ�������Ĳ����б�ͬ
	public void drop(int d){
		row+=d;
	}
	//���ط���moveLeft�����Ƹ���Ԫ
	public void moveLeft(){
		col--;
	}
	
	//����
	public void moveRight(int d){
		col+=d;
	}
	public void moveRight(){
		col++;
	}
	
	
	//��д����Object��toString
	@Override
	public String toString() {
		return row+","+col;
	}
}
