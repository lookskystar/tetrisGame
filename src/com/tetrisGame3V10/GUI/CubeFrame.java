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
	private int cubeX=0; //����X����
	private int cubeY=0; //����Y����
	private int cubeSize=30;//����Ŀ�͸�
	
	private CubePanel cubePanel;
	
	private Timer timer=new Timer();//��ʱ��
	
	public CubeFrame(){
		//���ô����С
		setSize(350,500);
		//���ô�����ֵ�λ��
		setLocation(100, 100);
		//���õ�ǰ�û�����رհ�ťʱ�˳�Ӧ�ó���
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��岻�������û�������С
		setResizable(false);
		
		cubePanel=new CubePanel();
		//���ô���Ķ�������ΪcubePanel���󣬼������������ڴ�����
		setContentPane(cubePanel);
		
		//���������Ի�ȡ����
		cubePanel.setFocusable(true);
		
		//�������Ӽ����¼�
		cubePanel.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				//ʵ�����ơ����ơ�����
				int keyCode=e.getKeyCode();//�õ�����UNICODE��
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
				cubePanel.repaint();//�����������
			}
		});
		
		//��ʱ������
		timer.schedule(new TimerTask(){
			public void run(){
				cubeY+=5;//����
				cubePanel.repaint();//�����������
			}
		}, 0,300);//��ʱ��ʼ��ÿ��0.3��ִ��һ��
		
	}
	
	//�ڲ���--�������
	class CubePanel extends JPanel{
		public void paint(Graphics g){
			//���ñ���ɫ
			g.setColor(Color.BLACK);
			//���Ʊ���
			g.fillRect(0, 0, getWidth(), getHeight());
			//���÷������ɫ
			g.setColor(Color.YELLOW);
			//���Ʒ���
			g.fillRect(cubeX, cubeY, cubeSize, cubeSize);
		}
	}
	
	public static void main(String[] args) {
		CubeFrame frame=new CubeFrame();
		//���ô���ɼ���Ĭ��Ϊ���ɼ���
		frame.setVisible(true);
	}
}
