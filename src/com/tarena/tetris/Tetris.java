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

//俄罗斯方块
public class Tetris extends JPanel {
	private int score=0;// 分数
	private int lines=0;// 销毁行数(方块数)
	
	private int sumScore=0;// 总分数
	private int sumLines=0;// 总销毁行数(方块数)
	
	private Cell[][] wall;// 背景墙
	private Tetromino tetromino;// 正在下落的四格方块
	private Tetromino nextOne;// 下一个四格方块
	
	private String pass="第一关";
	private int num;  //关数
	private boolean gamePass;//是否游戏过关

	// 背景图片
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

	private static final int ROWS = 20;// 背景墙的行数
	private static final int COLS = 10;// 背景墙的列数
	private static final int CELL_SIZE = 26;

	private static int[] scoreTable = { 0, 1, 10, 50, 100 };
	// 0 1 2 3 4

	public static final int FONT_COLOR = 0x667799;
	public static final int FONT_SIZE = 30;

	private Timer timer;// 定时器
	private boolean pause;// 是否为暂停状态
	private boolean gameOver;// 是否游戏结束状态
	private long interval = 600;// 间隔时间
	
	// 将图片素材，复制到com.tarena.tetris包中
	// 使用静态代码块加载静态的图片
	static {
		try {
			// Tetris.class的同时一个包中找到"tetris.png"
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
			//actionMusicWavFile = new File("E:\\new\\tetrisGame\\src\\com\\tarena\\tetris\\ZR882.WAV");//向下，向左，向右音响
			rotateRightWavFile = new File(Tetris.class.getResource("ZR2014.WAV").getPath());//旋转音响
			deleteRowWavFile = new File(Tetris.class.getResource("ZR927.WAV").getPath());// 删除音响
			destoryLinesWavFile = new File(Tetris.class.getResource("ZR557.WAV").getPath());//销毁音响
			backgroundWavFile = new File(Tetris.class.getResource("ZR2613.WAV").getPath());//背景音响
			//backgroundWavFile = new File("file:\\sound\\ZR2613.WAV");//背景音响
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// JPanel paint() paint画 重写paint()修改原有的绘制方法
	@Override
	public void paint(Graphics g) {
		//System.out.println("paint");
		// 画背景，画墙，画正在下落的方块，画下一个方块...
		g.drawImage(background, 0, 0, null);
		g.translate(0, 0);// 坐标系平移
		paintWall(g);// 画墙
		paintTetromino(g);// 绘制正在下落的方块
		paintNextOne(g);// 绘制下一个要下落的方块
		paintScore(g);// 绘制分数

		if (gameOver) {
			g.drawImage(overImage, 0, 0, null);
		}
		
		//画下一关画面
		if (gamePass) {
			g.drawImage(nextImage, 0, 0, null);
		}
	}

	// 在Tetris添加启动方法action()
	public void action() {
		//System.out.println("action");
		wall = new Cell[ROWS][COLS];
		startAction();
		// wall[2][2]=new Cell(2,2,T);
		//这个随机产生的方块，并不是图形，而是方块的的图形的坐标
		//System.out.println("得到Tetromino.randomOne()");
		tetromino = Tetromino.randomOne();
		nextOne = Tetromino.randomOne();
		// 处理键盘按下事件，在按下按键时候执行下落方法
		KeyAdapter l = new KeyAdapter() {
			// key按键Pressed按下了
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();// 得到键的Unicode
				System.out.println("-------key"+key);
				if (key == KeyEvent.VK_Q) {// Q表示退出
					System.exit(0);// 结束Java进程
				}
				if (gameOver) {
					if (key == KeyEvent.VK_S) {// S表示开始
						startAction();
						repaint();
					}
					return;
				}
				if(gamePass){
					if (key == KeyEvent.VK_N) {// N表示下一关
						//下一关
						System.out.println("N");
						//action();
						startAction();
						//continueAction();
						repaint();
					}
					return;
				}
				if (pause) {// pause=true
					if (key == KeyEvent.VK_C) {// C表示继续
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
				case KeyEvent.VK_P:// 按键盘上的P表示暂停
					pauseAction();
					break;
				}
				repaint();// 再画一次
			}
		};
		// 下落流程：监听键盘事件->如果下箭头按下->
		// 执行下落算法tetromino.softDrop()->
		// 修改每个格子对象的数据->调用repaint()->
		// 尽快调用paint()->paint方法会根据当前的数据
		// 重新绘制界面->看到移动以后的方块了

		// 绑定事件到当前面板
		this.requestFocus();
		this.addKeyListener(l);
	}

	// 绘制正在下落的方块
	public void paintTetromino(Graphics g) {
		//System.out.println("paintTetromino(Graphics g)");
		if (tetromino == null) {
			return;
		}
		// 将每个格子的row,col换算为x,y，然后贴图
		Cell[] cells = tetromino.cells;

		for (int i = 0; i < cells.length; i++) {
			// i=0 1 2 3
			Cell cell = cells[i];
			// cell每个格子
			int x = cell.getCol() * CELL_SIZE;
			int y = cell.getRow() * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	//绘制下一个要下落的方块
	private void paintNextOne(Graphics g) {
		if (nextOne == null) {
			return;
		}
		// 将每个格子的row,col换算为x,y，然后贴图
		Cell[] cells = nextOne.cells;
		for (int i = 0; i < cells.length; i++) {
			// i= 0 1 2 3
			Cell cell = cells[i];
			// cell 每个格子
			int x = (cell.getCol() + 10) * CELL_SIZE;
			int y = (cell.getRow() + 1) * CELL_SIZE;
			g.drawImage(cell.getImage(), x, y, null);
		}
	}

	// 画墙
	private void paintWall(Graphics g) {
		for (int row = 0; row < wall.length; row++) {
			Cell[] line = wall[row];
			// line代表墙上的每一行
			for (int col = 0; col < line.length; col++) {
				Cell cell = line[col];
				// cell代表墙上每个格子
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

	// 检查当前正在下落的方块是否出界
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

	// 检查正在下落的方块是否与墙上的砖块重叠
	private boolean coincide() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			// 如果墙的row,col位置有格子，就重叠了
			if (row >= 0 && row < ROWS && col >= 0 && col <= COLS
					&& wall[row][col] != null) {
				return true;// 重叠
			}
		}
		return false;
	}

	// 向右移动流程控制
	public void moveRightAction() {
		// 尝试先向右移动，如果发现超出了边界，就向左移动，修正回来
		tetromino.moveRight();// coincide重叠
		if (outOfBounds() || coincide()) {
			tetromino.moveLeft();
		}
		actionMusic();
	}

	// 向左移动流程控制
	public void moveLeftAction() {
		tetromino.moveLeft();
		if (outOfBounds() || coincide()) {
			tetromino.moveRight();
		}
		actionMusic();
	}

	// 软件下落流程 向下流程控制
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
	
	// 硬下落流程，下落到不能下落为止，绑定到空格(VK_SPACE)事件上
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

	// 销毁行
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

	// 删除行
	private void deleteRow(int row) {
		for (int i = row; i >= 1; i--) {
			System.arraycopy(wall[i - 1], 0, wall[i], 0, COLS);
		}
		Arrays.fill(wall[0], null);
		
		deleteRowMusic();
	}

	// 检查当前行的每个格子，是否是满的，如果满了则返回true,否者返回false
	private boolean fullCells(int row) {
		Cell[] line = wall[row];
		for (Cell cell : line) {
			if (cell == null) {// 如果有null返回false 否则返回true
				return false;
			}
		}
		return true;
	}

	// 方块到墙上
	private void landIntoWall() {
		Cell[] cells = tetromino.cells;
		for (int i = 0; i < cells.length; i++) {
			Cell cell = cells[i];
			int row = cell.getRow();
			int col = cell.getCol();
			wall[row][col] = cell;
		}
	}

	// 检查当前方块是否能够落下，返回true能够落下
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
		for (Cell cell : cells) {// Java 5以后可以使用
			int row = cell.getRow() + 1;
			int col = cell.getCol();
			if (row >= 0 && row < ROWS && col >= 0 && col <= COLS
					&& wall[row][col] != null) {
				return false;
			}
		}
		return true;
	}

	

	// 旋转流程控制方法
	public void rotateRightAction() {
		if(canDrop()){//解决下落触底变形异常问题
			tetromino.rotateRight();
			if (outOfBounds() || coincide()) {
				tetromino.rotateLeft();
			}
			rotateRightMusic();
		}
	}

	// 绘制分数，方块数，关
	private void paintScore(Graphics g) {
		int x = 290;
		int y = 160;
		g.setColor(new Color(FONT_COLOR));
		Font font = g.getFont();// 取得g当前字体
		font = new Font(font.getName(), font.getStyle(), FONT_SIZE);
		g.setFont(font);// 更改了g字体
		String str = "分数:" + this.score;
		g.drawString(str, x, y);
		y += 56;
		str = "方块数:" + this.lines;
		g.drawString(str, x, y);
		
		y += 56;
		str = "[P]暂停";
		if (pause) {
			str = "[C]继续";
		}
		if (gameOver) {
			str = "[S]开始";
		}
		g.drawString(str, x, y);
		
		y += 56;
		str=this.pass;
		g.drawString(str, x, y);
	}

	// 在Tetris类中添加 开始流程控制
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

	// 清除墙上的方块
	private void clearWall() {
		for (Cell[] line : wall) {
			Arrays.fill(line, null);
		}
	}

	// 暂停
	public void pauseAction() {
		timer.cancel();
		pause = true;
	}

	// 继续
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

	// 游戏结束
	public void checkGameOverAction() {
		if (wall[0][4] != null) {
			gameOver = true;
			timer.cancel();
		}
	}
	
	//游戏过关分数划分
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
	
	
	
	//游戏过关
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
			this.pass="第一关";
			checkGamePass();
			System.out.println("第一关");
			break;
		case 2:
			this.pass="第二关";
			checkGamePass();
			System.out.println("第二关");
			break;
		case 3:
			this.pass="第三关";
			checkGamePass();
			System.out.println("第三关");
			break;
		case 4:
			this.pass="第四关";
			checkGamePass();
			System.out.println("第四关");
			break;
		}
	}
	
	//游戏过关停止画面
	public void checkGamePass() {
		if(sumLines>=10){
			timer.cancel();
			this.gamePass = true;
		}
	}
	
    //向下，向左，向右音响
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
	//旋转音响
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
	//删除音响
	public static void deleteRowMusic() {
		// 下面是播放wav声音的代码
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
	//销毁音响
	public static void destoryLinesMusic() {
		// 下面是播放wav声音的代码
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
	//背景音乐
	public static void backgroundMusic() {
		// 下面是播放wav声音的代码
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
	
	
	
	// 主函数测试
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		// 在加载Tetris类的时候，会执行静态代码块
		// 静态代码块，装载了图片素材，为图片对象
		Tetris tetris = new Tetris();
		//System.out.println("实例化Tetris");
		
		// 将面板的颜色设置为蓝色，用于测试
		tetris.setBackground(new Color(0x0000ff));
		frame.add(tetris);
		frame.setSize(530, 580);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		tetris.action();
	}
}
