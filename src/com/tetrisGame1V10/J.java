package com.tetrisGame1V10;

public class J {
	public Cell[] cells;
	public J(){
		this(0,0);
	}
	
	/*
	 * ���췽����Ϊ����cells���г�ʼ��
	 * 
	 * @param row ˳ʱ�뷽��
	 * 				,��һ���������
	 * @param col ˳ʱ�뷽��
	 * 				,��һ���������
	 */
	public J(int row,int col){
		cells=new Cell[4];
		//��˳ʱ�뷽���ʼ��cell
		cells[0]=new Cell(row,col);
		cells[1]=new Cell(row,col+1);
		cells[2]=new Cell(row,col+2);
		cells[3]=new Cell(row+1,col+2);
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
	public void movLeft(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col--;
		}
	}
	/*
	 * ʹ��������һ������
	 */
	public void movRight(){
		for (int i = 0; i < cells.length; i++) {
			cells[i].col++;
		}
	}

}
