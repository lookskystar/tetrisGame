package com.tarena.tetris;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;

//����˹����
public class Tetris extends JPanel {
	private int score=0;// ����
	private int lines=0;// ��������(������)
	
	private int sumScore=0;// �ܷ���
	private int sumLines=0;// ����������(������)
	
	private Cell[][] wall;// ����ǽ
	private Tetromino tetromino;// ����������ĸ񷽿�
	private Tetromino nextOne;// ��һ���ĸ񷽿�
	
	private String pass="��һ��";
	private int num;  //����
	private boolean gamePass;//�Ƿ���Ϸ����

	// ����ͼƬ
	private static BufferedImage background;
	private static BufferedImage overImage;
	private static BufferedImage nextImage;
	public static BufferedImage T;
	public static BufferedImage S;
	public static BufferedImage I;
	public static BufferedImage L;
	public static BufferedImage J;
	public static BufferedImage O;
	public static BufferedImage Z;
	
	public static File actionMusicWavFile;
	public static File rotateRightWavFile;
	public static File deleteRowWavFile;
	public static File destoryLinesWavFile;
	public static File backgroundWavFile;

	private static final int ROWS = 20;// ����ǽ������
	private static final int COLS = 10;// ����ǽ������
	private static final int CELL_SIZE = 26;

	private static int[] scoreTable = { 0, 1, 10, 50, 100 };
	// 0 1 2 3 4

	public static final int FONT_COLOR = 0x667799;
	public static final int FONT_SIZE = 30;

	private Timer timer;// ��ʱ��
	private boolean pause;// �Ƿ�Ϊ��ͣ״̬
	private boolean gameOver;// �Ƿ���Ϸ����״̬
	private long interval = 600;// ���ʱ��
	
	// ��ͼƬ�زģ����Ƶ�com.tarena.tetris����
	// ʹ�þ�̬�������ؾ�̬��ͼƬ
	static {
		try {
			// Tetris.class��ͬʱһ�������ҵ�"tetris.png"
			background = ImageIO.read(Tetris.class.getResource("tetris.png"));
			overImage = ImageIO.read(Tetris.class.getResource("GAMEOVER.png"));
			nextImage=ImageIO.read(Tetris.class.getResource("next.png"));
			T = ImageIO.read(Tetris.class.getResource("T.png"));
			I = ImageIO.read(Tetris.class.getResource("I.png"));
			S = ImageIO.read(Tetris.class.getResource("S.png"));
			Z = ImageIO.read(Tetris.class.getResource("Z.png"));
			J = ImageIO.read(Tetris.class.getResource("J.png"));
			L = ImageIO.read(Tetris.class.getResource("L.png"));
			O = ImageIO.read(Tetris.class.getResource("O.png"));

			
//			String proPath=Tetris.class.getClassLoader().getResource("").toString();
//			proPath=proPath.replaceAll("bin/", "");
//			proPath=proPath.
//			System.out.println(proPath);
			
			//actionMusicWavFile = new File(proPath+"sound/ZR882.WAV");
			actionMusicWavFile = new File(Tetris.class.getResource("ZR882.WAV").getPath());
			//actionMusicWavFile = new File("E:\\new\\tetrisGame\\src\\com\\tarena\\tetris\\ZR882.WAV");//���£�������������
			rotateRightWavFile = new File(Tetris.class.getResource("ZR2014.WAV").getPath());//��ת����
			deleteRowWavFile = new File(Tetris.class.getResource("ZR927.WAV").getPath());// ɾ������
			destoryLinesWavFile = new File(Tetris.class.getResource("ZR557.WAV").getPath());//��������
			backgroundWavFile = new File(Tetris.class.getResource("ZR2613.WAV").getPath());//��������
			//backgroundWavFile = new File("file:\\sound\\ZR2613.WAV");//��������
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// JPanel paint() paint�� ��дpaint()�޸�ԭ�еĻ��Ʒ���
	@Override
	public void paint(Graphics g) {
		//System.out.println("paint");
		// ����������ǽ������������ķ��飬����һ������...
		g.drawImage(background, 0, 0, null);
		g.translate(0, 0);// ����ϵƽ��
		paintWall(g);// ��ǽ
		paintTetromino(g);// ������������ķ���
		paintNextOne(g);// ������һ��Ҫ����ķ���
		paintScore(g);// ���Ʒ���

		if (gameOver) {
			g.drawImage(overImage, 0, 0, null);
		}
		
		//����һ�ػ���
		if (gamePass) {
			g.drawImage(nextImage, 0, 0, null);
		}
	}

	// ��Tetris�����������action()
	public void action() {
		//System.out.println("action");
		wall = new Cell[ROWS][COLS];
		startAction();
		// wall[2][2]=new Cell(2,2,T);
		//�����������ķ��飬������ͼ�Σ����Ƿ���ĵ�ͼ�ε�����
		//System.out.println("�õ�Tetromino.randomOne()");
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		// ������̰����¼����ڰ��°���ʱ��ִ�����䷽��
		KeyAdapter l = new KeyAdapter() {
			// key����Pressed������
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();// �õ�����Unicode
				System.out.println("-------key"+key);
				if (key == KeyEvent.VK_Q) {// Q��ʾ�˳�
					System.exit(0);// ����Java����
				}
				if (gameOver) {
					if (key == KeyEvent.VK_S) {// S��ʾ��ʼ
						startAction();
						repaint();
					}
					return;
				}
				if(gamePass){
					if (key == KeyEvent.VK_N) {// N��ʾ��һ��
						//��һ��
						System.out.println("N");
						//action();
						startAction();
						//continueAction();
						repaint();
					}
					return;
				}
				if (pause) {// pause=true
					if (key == KeyEvent.VK_C) {// C��ʾ����
						continueAction();
						repaint();
					}
					return;
				}

				switch (key) {
				case KeyEvent.VK_DOWN:
					// tetromino.softDrop();
					softDropAction();
					break;
				case KeyEvent.VK_RIGHT:
					// tetromino.moveRight();
					moveRightAction();
					break;
				case KeyEvent.VK_LEFT:
					// tetromino.moveLeft();
					moveLeftAction();
					break;
				case KeyEvent.VK_SPACE:
					hardDropAction();
					break;
				case KeyEvent.VK_UP:
					rotateRightAction();
					break;
				case KeyEvent.VK_P:// �������ϵ�P��ʾ��ͣ
					pauseAction();
					break;
				}
				repaint();// �ٻ�һ��
			}
		};
		// �������̣����������¼�->����¼�ͷ����->
		// ִ�������㷨tetromino.softDrop()->
		// �޸�ÿ�����Ӷ��������->����repaint()->
		// �������paint()->paint��������ݵ�ǰ������
		// ���»��ƽ���->�����ƶ��Ժ�ķ�����

		// ���¼�����ǰ���
		this.requestFocus();
		this.addKeyListener(l);
	}

	// ������������ķ���
	public void paintTetromino(Graphics g) {
		//System.out.println("paintTetromino(Graphics g)");
		if (tetromino == null) {
			return;
		}
		// ��ÿ�����ӵ�row,col����Ϊx,y��Ȼ����ͼ
		Cell[] cells = tetromino.cells;

		for (int i = 0; i < cells.length; i++) {
			// i=0 1 2 3
			Cell cell = cells[i];
			// cellÿ������
			int x = cell.getCol() * CELL_SIZE;
			int y = cell.getRow() * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	//������һ��Ҫ����ķ���
	private void paintNextOne(Graphics g) {
		if (nextOne == null) {
			return;
		}
		// ��ÿ�����ӵ�row,col����Ϊx,y��Ȼ����ͼ
		Cell[] cells = nextOne.cells;
		for (int i = 0; i < cells.length; i++) {
			// i= 0 1 2 3
			Cell cell = cells[i];
			// cell ÿ������
			int x = (cell.getCol() + 10) * CELL_SIZE;
			int y = (cell.getRow() + 1) * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	// ��ǽ
	private void paintWall(Graphics g) {
		for (int row = 0; row < wall.length; row++) {
			Cell[] line = wall[row];
			// line����ǽ�ϵ�ÿһ��
			for (int col = 0; col < line.length; col++) {
				Cell cell = line[col];
				// cell����ǽ��ÿ������
				int x = col * CELL_SIZE;
				int y = row * CELL_SIZE;
				if (cell == null) {
					g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				} else {
					g.drawImage(cell.getImage(), x, y, null);
				}
				// g.drawString(row+","+col,x,y+CELL_SIZE);
			}
		}
	}

	// ��鵱ǰ��������ķ����Ƿ����
	private boolean outOfBounds() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int col = cell.getCol();
			if (col < 0 || col >= COLS) {
				return true;
			}
		}
		return false;
	}

	// �����������ķ����Ƿ���ǽ�ϵ�ש���ص�
	private boolean coincide() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			// ���ǽ��row,colλ���и��ӣ����ص���
			if (row >= 0 && row < ROWS && col >= 0 && col <= COLS
					&& wall[row][col] != null) {
				return true;// �ص�
			}
		}
		return false;
	}

	// �����ƶ����̿���
	public void moveRightAction() {
		// �����������ƶ���������ֳ����˱߽磬�������ƶ�����������
		tetromino.moveRight();// coincide�ص�
		if (outOfBounds() || coincide()) {
			tetromino.moveLeft();
		}
		actionMusic();
	}

	// �����ƶ����̿���
	public void moveLeftAction() {
		tetromino.moveLeft();
		if (outOfBounds() || coincide()) {
			tetromino.moveRight();
		}
		actionMusic();
	}

	// ����������� �������̿���
	public void softDropAction() {
		if (canDrop()) {
			tetromino.softDrop();
		} else {
			landIntoWall();
			destoryLines();

			checkGameOverAction();
			checkGamePassAction();

			tetromino = nextOne;
			nextOne = tetromino.randomOne();
		}
		actionMusic();
	}
	
	// Ӳ�������̣����䵽��������Ϊֹ���󶨵��ո�(VK_SPACE)�¼���
	public void hardDropAction() {
		while (canDrop()) {
			tetromino.softDrop();
		}
		landIntoWall();
		destoryLines();

		checkGameOverAction();
		checkGamePassAction();
		
		tetromino = nextOne;
		nextOne = Tetromino.randomOne();
	}

	// ������
	private void destoryLines() {
		int lines = 0;
		for (int row = 0; row < wall.length; row++) {
			if (fullCells(row)) {
				deleteRow(row);
				lines++;
			}
		}
		
		this.score += scoreTable[lines];
		
		this.lines++;
		
		this.sumLines ++;
		

		
		destoryLinesMusic();
	}

	// ɾ����
	private void deleteRow(int row) {
		for (int i = row; i >= 1; i--) {
			System.arraycopy(wall[i - 1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
		
		deleteRowMusic();
	}

	// ��鵱ǰ�е�ÿ�����ӣ��Ƿ������ģ���������򷵻�true,���߷���false
	private boolean fullCells(int row) {
		Cell[] line = wall[row];
		for (Cell cell : line) {
			if (cell == null) {// �����null����false ���򷵻�true
				return false;
			}
		}
		return true;
	}

	// ���鵽ǽ��
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}

	// ��鵱ǰ�����Ƿ��ܹ����£�����true�ܹ�����
	private boolean canDrop() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			if (row == ROWS - 1) {
				return false;
			}
		}
		for (Cell cell : cells) {
			int row = cell.getRow() + 1;
			int col = cell.getCol();
			if (row >= 0 && row < ROWS && col >= 0 && col <= COLS
					&& wall[row][col] != null) {
				return false;
			}
		}
		for (Cell cell : cells) {// Java 5�Ժ����ʹ��
			int row = cell.getRow() + 1;
			int col = cell.getCol();
			if (row >= 0 && row < ROWS && col >= 0 && col <= COLS
					&& wall[row][col] != null) {
				return false;
			}
		}
		return true;
	}

	

	// ��ת���̿��Ʒ���
	public void rotateRightAction() {
		if(canDrop()){//������䴥�ױ����쳣����
			tetromino.rotateRight();
			if (outOfBounds() || coincide()) {
				tetromino.rotateLeft();
			}
			rotateRightMusic();
		}
	}

	// ���Ʒ���������������
	private void paintScore(Graphics g) {
		int x = 290;
		int y = 160;
		g.setColor(new Color(FONT_COLOR));
		Font font = g.getFont();// ȡ��g��ǰ����
		font = new Font(font.getName(), font.getStyle(), FONT_SIZE);
		g.setFont(font);// ������g����
		String str = "����:" + this.score;
		g.drawString(str, x, y);
		y += 56;
		str = "������:" + this.lines;
		g.drawString(str, x, y);
		
		y += 56;
		str = "[P]��ͣ";
		if (pause) {
			str = "[C]����";
		}
		if (gameOver) {
			str = "[S]��ʼ";
		}
		g.drawString(str, x, y);
		
		y += 56;
		str=this.pass;
		g.drawString(str, x, y);
	}

	// ��Tetris������� ��ʼ���̿���
	public void startAction() {
		pause = false;
		gameOver = false;
		
		gamePass=false;
		
		score =0;
		lines =0;
		
		clearWall();
		
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				softDropAction();
				repaint();
			}
		}, interval, interval);
		backgroundMusic();
	}

	// ���ǽ�ϵķ���
	private void clearWall() {
		for (Cell[] line : wall) {
			Arrays.fill(line, null);
		}
	}

	// ��ͣ
	public void pauseAction() {
		timer.cancel();
		pause = true;
	}

	// ����
	public void continueAction() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				softDropAction();
				repaint();
			}
		}, interval, interval);
		pause = false;
	}

	// ��Ϸ����
	public void checkGameOverAction() {
		if (wall[0][4] != null) {
			gameOver = true;
			timer.cancel();
		}
	}
	
	//��Ϸ���ط�������
	public void checkGamePassScore(){
		num=1;
		if(this.score>0||this.score<100){
			System.out.println("1this.score:"+this.score+",num------------->:"+num);
			num=1;
		}else if(this.score>=100||this.score<200){
			System.out.println("2this.score:"+this.score+",num------------->:"+num);
			num=2;
		}else if(this.score>=200||this.score<300){
			System.out.println("3this.score:"+this.score+",num------------->:"+num);
			num=3;
		}else if(this.score>=300||this.score<400){
			System.out.println("4this.score:"+this.score+",num------------->:"+num);
			num=4;
		}
		//return num;
	}
	
	
	
	//��Ϸ����
	public void checkGamePassAction(){	
		
//		int num=1;
//		if(this.score>0||this.score<100){
//			System.out.println("1this.score:"+this.score+",num------------->:"+num);
//			num=1;
//		}else if(this.score>=100||this.score<200){
//			System.out.println("2this.score:"+this.score+",num------------->:"+num);
//			num=2;
//		}else if(this.score>=200||this.score<300){
//			System.out.println("3this.score:"+this.score+",num------------->:"+num);
//			num=3;
//		}else if(this.score>=300||this.score<400){
//			System.out.println("4this.score:"+this.score+",num------------->:"+num);
//			num=4;
//		}
		
		
		switch (num) {
		case 1:
			this.pass="��һ��";
			checkGamePass();
			System.out.println("��һ��");
			break;
		case 2:
			this.pass="�ڶ���";
			checkGamePass();
			System.out.println("�ڶ���");
			break;
		case 3:
			this.pass="������";
			checkGamePass();
			System.out.println("������");
			break;
		case 4:
			this.pass="���Ĺ�";
			checkGamePass();
			System.out.println("���Ĺ�");
			break;
		}
	}
	
	//��Ϸ����ֹͣ����
	public void checkGamePass() {
		if(sumLines>=10){
			timer.cancel();
			this.gamePass = true;
		}
	}
	
    //���£�������������
	public static void actionMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(actionMusicWavFile);
			
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	//��ת����
	public static void rotateRightMusic() {

		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(rotateRightWavFile);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	//ɾ������
	public static void deleteRowMusic() {
		// �����ǲ���wav�����Ĵ���
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(deleteRowWavFile);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	//��������
	public static void destoryLinesMusic() {
		// �����ǲ���wav�����Ĵ���
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(destoryLinesWavFile);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	//��������
	public static void backgroundMusic() {
		// �����ǲ���wav�����Ĵ���
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(backgroundWavFile);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ����������
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// �ڼ���Tetris���ʱ�򣬻�ִ�о�̬�����
		// ��̬����飬װ����ͼƬ�زģ�ΪͼƬ����
		Tetris tetris = new Tetris();
		//System.out.println("ʵ����Tetris");
		
		// ��������ɫ����Ϊ��ɫ�����ڲ���
		tetris.setBackground(new Color(0x0000ff));
		frame.add(tetris);
		frame.setSize(530, 580);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		tetris.action();
	}
}
