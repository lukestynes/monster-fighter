package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MenuScreen {

	private JFrame frame;
	private GUIController gui;

	public MenuScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeMenuScreen(this);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
