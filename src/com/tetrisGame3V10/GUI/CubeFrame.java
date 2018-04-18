package com.tetrisGame3V10.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CubeFrame extends JFrame {
	private int cubeX=0; //方块X坐标
	private int cubeY=0; //方块Y坐标
	private int cubeSize=30;//方块的宽和高
	
	private CubePanel cubePanel;
	
	private Timer timer=new Timer();//定时器
	
	public CubeFrame(){
		//设置窗体大小
		setSize(350,500);
		//设置窗体出现的位置
		setLocation(100, 100);
		//设置当前用户点击关闭按钮时退出应用程序
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置窗体不可以由用户调整大小
		setResizable(false);
		
		cubePanel=new CubePanel();
		//设置窗体的顶级容器为cubePanel对象，即，将面板放置在窗体上
		setContentPane(cubePanel);
		
		//设置面板可以获取焦点
		cubePanel.setFocusable(true);
		
		//给面板添加键盘事件
		cubePanel.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				//实现左移、右移、下落
				int keyCode=e.getKeyCode();//得到键的UNICODE码
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					cubeX-=5;
					break;
				case KeyEvent.VK_RIGHT:
					cubeX+=5;
					break;
				case KeyEvent.VK_DOWN:
					cubeY+=5;
					break;
				}
				cubePanel.repaint();//更新面板内容
			}
		});
		
		//定时器任务
		timer.schedule(new TimerTask(){
			public void run(){
				cubeY+=5;//下落
				cubePanel.repaint();//更新面板内容
			}
		}, 0,300);//即时开始，每隔0.3秒执行一次
		
	}
	
	//内部类--绘制面板
	class CubePanel extends JPanel{
		public void paint(Graphics g){
			//设置背景色
			g.setColor(Color.BLACK);
			//绘制背景
			g.fillRect(0, 0, getWidth(), getHeight());
			//设置方块的颜色
			g.setColor(Color.YELLOW);
			//绘制方块
			g.fillRect(cubeX, cubeY, cubeSize, cubeSize);
		}
	}
	
	public static void main(String[] args) {
		CubeFrame frame=new CubeFrame();
		//设置窗体可见（默认为不可见）
		frame.setVisible(true);
	}
}
