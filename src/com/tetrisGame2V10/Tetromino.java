package com.tetrisGame2V10;

//����ĸ���
public class Tetromino {
	//���ԣ������洢һ��������ĸ��ӵ�����
	public Cell[] cells;
	//���췽������ʼ��cells����
	public Tetromino(){
		cells=new Cell[4];
	}
	/*
	 * ����˳ʱ�뷽�򣬴�ӡ�������ĸ��������ڵ�����
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
	 * ʹ��������һ������
	 */
	public void drop(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].row++;
		}
	}
	
	/*
	 * ʹ��������һ������
	 */
	public void moveLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	/*
	 * ʹ��������һ������
	 */
	public void moveRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}
}
