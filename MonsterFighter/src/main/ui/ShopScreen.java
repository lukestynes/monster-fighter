package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ShopScreen {

	private JFrame frame;
	private GUIController gui;

	public ShopScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeShopScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centers the window
		frame.setLocationRelativeTo(null);
	}

}
