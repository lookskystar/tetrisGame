package com.tetrisGame3V10;

import java.util.Scanner;

public class TetrominoGame {
	public static void main(String[] args) {
		//测试TetrominoT
		System.out.println("-------打印T型-------");
		Tetromino t=new TetrominoT(0,4);
		t.print();
		printTetromino(t);
		
		System.out.println("1-下落，2-向左，3-向右，0-退出");
		//状态，判断是否继续从控制台得到值
		boolean flag=true; 
		
		while(flag){
			//每一次都要输入一个数字
			Scanner sc=new Scanner(System.in);
			int key=sc.nextInt();
			switch (key) {
			case 1:
				//下落
				t.drop();
				printTetromino(t);
				break;
			case 2:
				//向左
				t.moveLeft();
				printTetromino(t);
				break;
			case 3:
				//向右
				t.moveRight();
				printTetromino(t);
				break;
			case 0:
				//退出
				flag=false;
				break;
			default:
				break;
			}
		}
		
		
		
		
		
//		//测试TetrominoJ
//		System.out.println("-------打印T型-------");
//		Tetromino j=new TetrominoJ(0,4);
//		j.print();
//		printTetromino(j);
//		
//		//测试TetrominoO
//		System.out.println("-------打印O型-------");
//		Tetromino o=new TetrominoO(0,4);
//		o.print();
//		printTetromino(o);
	}
	
	
	
	
	
	
	//打印出游戏所在的平面（宽10格，高20格）。
	//用“-”号表示平面上的每个单元，
	//用“*”号打印显示方块中的每个格子
	/*
	 * @param tetromino 需要显示爱游戏平面中的方块
	 * 
	 */
	                                  //方法的参数列表
	public static void printTetromino(Tetromino tetromino){
		int totalRow=20;
		int totalCol=10;
		
		//获取方块中存储的四个各自的数组
		Cell[] cells=tetromino.cells; 
		//打印20*10的面板
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				//用于判断该位置是否包含在cells数组中
				boolean isInCells=false;
				for (int i = 0; i < cells.length; i++) {
					if(cells[i].row==row&&cells[i].col==col){
						System.out.print("* ");
						isInCells=true;
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
