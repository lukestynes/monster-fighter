package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;

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
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centers the window
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTopBar = new JPanel();
		panelTopBar.setLayout(null);
		panelTopBar.setBounds(0, 0, 1000, 71);
		frame.getContentPane().add(panelTopBar);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblShop.setBounds(-2, 3, 1000, 63);
		panelTopBar.add(lblShop);
		
		JLabel lbldisp = new JLabel("{disp}");
		lbldisp.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbldisp.setBounds(1, -3, 117, 31);
		panelTopBar.add(lbldisp);
		
		JLabel lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblScore.setBounds(1, 30, 117, 31);
		panelTopBar.add(lblScore);
		
		JLabel lblDayCount = new JLabel("Day: 0/0");
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(881, 1, 117, 31);
		panelTopBar.add(lblDayCount);
		
		JLabel lblGoldCount = new JLabel("Gold: 0");
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(881, 37, 117, 31);
		panelTopBar.add(lblGoldCount);
		
		JTextPane txtpInv1 = new JTextPane();
		txtpInv1.setText("This Slot is Empty");
		txtpInv1.setEditable(false);
		txtpInv1.setBounds(25, 128, 161, 161);
		frame.getContentPane().add(txtpInv1);
		
		JCheckBox chckbxInv1 = new JCheckBox("");
		chckbxInv1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv1.setBounds(25, 290, 161, 23);
		frame.getContentPane().add(chckbxInv1);
		
		JTextPane txtpInv2 = new JTextPane();
		txtpInv2.setText("This Slot is Empty");
		txtpInv2.setEditable(false);
		txtpInv2.setBounds(222, 128, 161, 161);
		frame.getContentPane().add(txtpInv2);
		
		JCheckBox chckbxInv2 = new JCheckBox("");
		chckbxInv2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv2.setBounds(222, 290, 161, 23);
		frame.getContentPane().add(chckbxInv2);
		
		JTextPane txtpInv3 = new JTextPane();
		txtpInv3.setText("This Slot is Empty");
		txtpInv3.setEditable(false);
		txtpInv3.setBounds(423, 128, 161, 161);
		frame.getContentPane().add(txtpInv3);
		
		JCheckBox chckbxInv3 = new JCheckBox("");
		chckbxInv3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv3.setBounds(423, 290, 161, 23);
		frame.getContentPane().add(chckbxInv3);
		
		JTextPane txtpInv4 = new JTextPane();
		txtpInv4.setText("This Slot is Empty");
		txtpInv4.setEditable(false);
		txtpInv4.setBounds(614, 128, 161, 161);
		frame.getContentPane().add(txtpInv4);
		
		JCheckBox chckbxInv4 = new JCheckBox("");
		chckbxInv4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv4.setBounds(614, 290, 161, 23);
		frame.getContentPane().add(chckbxInv4);
		
		JTextPane txtpInv5 = new JTextPane();
		txtpInv5.setText("This Slot is Empty");
		txtpInv5.setEditable(false);
		txtpInv5.setBounds(811, 128, 161, 161);
		frame.getContentPane().add(txtpInv5);
		
		JCheckBox chckbxInv5 = new JCheckBox("");
		chckbxInv5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv5.setBounds(811, 290, 161, 23);
		frame.getContentPane().add(chckbxInv5);
		
		JTextPane txtpInv1_1 = new JTextPane();
		txtpInv1_1.setText("This Slot is Empty");
		txtpInv1_1.setEditable(false);
		txtpInv1_1.setBounds(25, 360, 161, 161);
		frame.getContentPane().add(txtpInv1_1);
		
		JCheckBox chckbxInv1_1 = new JCheckBox("");
		chckbxInv1_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv1_1.setBounds(25, 522, 161, 23);
		frame.getContentPane().add(chckbxInv1_1);
		
		JTextPane txtpInv2_1 = new JTextPane();
		txtpInv2_1.setText("This Slot is Empty");
		txtpInv2_1.setEditable(false);
		txtpInv2_1.setBounds(222, 360, 161, 161);
		frame.getContentPane().add(txtpInv2_1);
		
		JCheckBox chckbxInv2_1 = new JCheckBox("");
		chckbxInv2_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv2_1.setBounds(222, 522, 161, 23);
		frame.getContentPane().add(chckbxInv2_1);
		
		JTextPane txtpInv3_1 = new JTextPane();
		txtpInv3_1.setText("This Slot is Empty");
		txtpInv3_1.setEditable(false);
		txtpInv3_1.setBounds(423, 360, 161, 161);
		frame.getContentPane().add(txtpInv3_1);
		
		JCheckBox chckbxInv3_1 = new JCheckBox("");
		chckbxInv3_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv3_1.setBounds(423, 522, 161, 23);
		frame.getContentPane().add(chckbxInv3_1);
		
		JTextPane txtpInv4_1 = new JTextPane();
		txtpInv4_1.setText("This Slot is Empty");
		txtpInv4_1.setEditable(false);
		txtpInv4_1.setBounds(614, 360, 161, 161);
		frame.getContentPane().add(txtpInv4_1);
		
		JCheckBox chckbxInv4_1 = new JCheckBox("");
		chckbxInv4_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv4_1.setBounds(614, 522, 161, 23);
		frame.getContentPane().add(chckbxInv4_1);
		
		JTextPane txtpInv5_1 = new JTextPane();
		txtpInv5_1.setText("This Slot is Empty");
		txtpInv5_1.setEditable(false);
		txtpInv5_1.setBounds(811, 360, 161, 161);
		frame.getContentPane().add(txtpInv5_1);
		
		JCheckBox chckbxInv5_1 = new JCheckBox("");
		chckbxInv5_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv5_1.setBounds(811, 522, 161, 23);
		frame.getContentPane().add(chckbxInv5_1);
		
		JButton btnBuySelectedThings = new JButton("Buy Selected Things");
		btnBuySelectedThings.setBounds(388, 569, 218, 29);
		frame.getContentPane().add(btnBuySelectedThings);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.setBounds(415, 610, 169, 29);
		frame.getContentPane().add(btnReturnToMenu);
		
		JLabel lblMonsters = new JLabel("Monsters");
		lblMonsters.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsters.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblMonsters.setBounds(0, 306, 1000, 63);
		frame.getContentPane().add(lblMonsters);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setFont(new Font("Lucida Grande", Font.BOLD, 24));
		lblItems.setBounds(0, 65, 1000, 63);
		frame.getContentPane().add(lblItems);
	}

}
