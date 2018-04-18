package test;

import java.applet.Applet;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestSound extends JFrame {
	private static final long serialVersionUID = -8058205459841043819L;

	public static void main(String[] args) {
		TestSound frame = new TestSound();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public TestSound() {
		super();
		setSize(500, 400);
		getContentPane().add(new Music());
	}

	class Music extends JPanel {

		private static final long serialVersionUID = -4902962461712252077L;

		
	}

}