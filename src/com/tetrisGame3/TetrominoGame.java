package com.tetrisGame3;

public class TetrominoGame {
	public static void main(String[] args) {
		//测试TetrominoT
		System.out.println("打印T型");
		Tetromino t=new TetrominoT(0,4);
		t.print();
		printTetromino(t);
		
		//测试TetrominoJ
		System.out.println("打印J型");
		Tetromino j=new TetrominoJ(0,4);
		j.print();
		printTetromino(j);
		
	}
	//打印出游戏所在平面（宽10格，高10格）。用“-”号表示平面上的每个单元
	//用“*”号打印显示方块中的每个格子
	//tetromino 需要显示在游戏中的方块
	public static void printTetromino(Tetromino tetromino){
		int totalRow=20;
		int totalCol=10;
		//获取方块中存储的四个各自的数组
		Cell[] cells=tetromino.cells;
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				//用于判断该位置是否包含在cells数组中
				boolean isInCells=false;
				for (int i = 0; i < cells.length; i++) {
					if(cells[i].row==row&&cells[i].col==col){
						System.out.print("* ");
						isInCells=true;
						break;
					}
				}
				if(!isInCells){
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
