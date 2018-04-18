package com.tetrisGame2;
public class Cell {
	public int row;
	public int col;

	// Ĭ�ϵĹ��캯��
	public Cell() {
		this(0, 0); // �޲εĹ��캯�������вεĹ��캯��
	}

	// ��ʼ�������εĹ��캯��
	public Cell(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
	
	//���췽������
	public Cell(Cell cell){
		this(cell.row,cell.col);
	}
	

	// ����һ��
	public void drop() {
		row++;
	}

	// ����
	public void moveLeft(int d) {
		col -= d;
	}
	//����
	public void moveRight(int d) {
		col+=d;
	}

	// ������У�����drop����
	public void drop(int d) {
		row += d;
	}

	// ����һ�У�����moveLeft����
	public void moveLeft() {
		col--;
	}
	// ����һ�У�����moveRight����
	public void moveRight() {
		col++;
	}

	// ���ø÷��������ɴ�ӡ����λ����Ϣ
	public String toString() {
		return row + "," + col;
	}

}
