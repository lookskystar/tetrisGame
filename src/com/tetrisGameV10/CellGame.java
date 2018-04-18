package com.tetrisGameV10;

import java.util.Scanner;

public class CellGame {
	public static void main(String[] args) {
		System.out.println("-------绘制Cell-------");
		//创建Cell对象，并打印
		Cell cell=new Cell(0,4);
//		cell.row=15;
//		cell.col=6;  //定义格子的位子
		printCell(cell);
		
		//调用方法，下落一行
//		System.out.println("-------Cell 下落一行-------");
//		cell.drop();
//		printCell(cell);
		
		//输入需要移动的列数
//		System.out.println("-------Cell 移动程序-------");
//		System.out.print("请输入左移的列数：");
//		Scanner sc=new Scanner(System.in);
//		int cols=sc.nextInt();
//		sc.close();
//		cell.moveLeft(cols);
//		printCell(cell);
		
		//左移动一列
//		System.out.println("-------Cell 左移动一列-------");
//		cell.moveLeft();
//		printCell(cell);
		
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
				cell.drop();
				printCell(cell);
				break;
			case 2:
				//向左
				cell.moveLeft();
				printCell(cell);
				break;
			case 3:
				//向右
				cell.moveRight();
				printCell(cell);
				break;
			case 0:
				//退出
				flag=false;
				break;
			default:
				break;
			}
		}
		
		
		
		
	}
	
	//打印格子
	public static void printCell(Cell cell){
		int totalRow=20; //定义行
		int totalCol=10; //定义列
		
		//答应格子的位置信息
		System.out.println("Cell的位置为：（"+cell.toString()+")");
		
		//打印场地
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if(cell.row==row&&cell.col==col){
					//打印指定的格子
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
