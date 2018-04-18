package com.tetrisGame1;
import java.util.Scanner;


public class CellGame {
	
	public static void main(String[] args) {
		System.out.println("-------绘制Cell-------");
		//创建Cell对象，并打印
		Cell cell=new Cell(0,4);
//		cell.row=15; //16 //改变此变量值，* 下落
//		cell.col=6;//改变此变量值，* 左右
		printCell(cell);
		
		//测试下落一行，调用drop方法
//		System.out.println("-------Cell下落一行-------");
//		cell.drop();
//		printCell(cell);
		
		//测试左移方法
//		System.out.println("-------Cell移动程序-------");
//		System.out.println("请输入左移的列数：");
//		Scanner sc=new Scanner(System.in);
//		int cols=sc.nextInt();
//		sc.close();
//		//调用moveLeft方法，移动相应的列数
//		cell.moveLeft(cols);
//		printCell(cell);
		
		//测试左移一列
//		System.out.println("-------Cell左移一列-------");
//		cell.moveLeft();
//		printCell(cell);
		
		//测试打印格子位置信息
//		System.out.println("Cell位置为：("+cell.toString()+")");
		
		System.out.println("1-下落，2-向左，3-向右，0-退出");
		boolean flag=true;
		while(flag){
			Scanner sc=new Scanner(System.in);
			int cols=sc.nextInt();
			switch (cols) {
			case 1:
				cell.drop();
				break;
			case 2:
				cell.moveLeft();
				break;
			case 3:
				cell.moveRight();
				break;
			case 0:
				flag=false;
				System.out.println("游戏结束");
				break;
			default:
				System.out.println("输入错误");
				break;
			}
			System.out.println("Cell位置为：("+cell.toString()+")");
			printCell(cell);
			
		}
	}
	
	
	
	
	// 打印场地
	public static void printCell(Cell cell){
		int totalRow=20;
		int totalCol=10;
		
		//打印场地
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				if(cell.row==row&&cell.col==col){
					//打印指定格子
					System.out.print("* ");
				}else{
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
