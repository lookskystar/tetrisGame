package com.tarena.tetris;

import java.awt.image.BufferedImage;

//����
public class Cell {
	private int row;//���ӵ���
	private int col;//���ӵ���
	private  BufferedImage image;//���ӵ���ͼ
	
	public Cell(int row, int col, BufferedImage image) {
		super();
		this.row = row;
		this.col = col;
		this.image = image;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void drop(){
		row++;
	}
	public void moveRight(){
		col++;
	}
	public void moveLeft(){
		col--;
	}

	@Override//��д
	public String toString() {
		// TODO Auto-generated method stub
		//System.out.println(row+","+col);
		return row+","+col;
	}
	
	
}
