package com.tetrisGame3;

public class TetrominoGame {
	public static void main(String[] args) {
		//����TetrominoT
		System.out.println("��ӡT��");
		Tetromino t=new TetrominoT(0,4);
		t.print();
		printTetromino(t);
		
		//����TetrominoJ
		System.out.println("��ӡJ��");
		Tetromino j=new TetrominoJ(0,4);
		j.print();
		printTetromino(j);
		
	}
	//��ӡ����Ϸ����ƽ�棨��10�񣬸�10�񣩡��á�-���ű�ʾƽ���ϵ�ÿ����Ԫ
	//�á�*���Ŵ�ӡ��ʾ�����е�ÿ������
	//tetromino ��Ҫ��ʾ����Ϸ�еķ���
	public static void printTetromino(Tetromino tetromino){
		int totalRow=20;
		int totalCol=10;
		//��ȡ�����д洢���ĸ����Ե�����
		Cell[] cells=tetromino.cells;
		for (int row = 0; row < totalRow; row++) {
			for (int col = 0; col < totalCol; col++) {
				//�����жϸ�λ���Ƿ������cells������
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
