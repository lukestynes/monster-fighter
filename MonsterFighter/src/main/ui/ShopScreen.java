package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import main.items.Item;
import main.monsters.Monster;

import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 1000, 900);
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
		
		JLabel lbldisp = new JLabel(gui.getGame().getPlayer().getName());
		lbldisp.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lbldisp.setBounds(1, -3, 117, 31);
		panelTopBar.add(lbldisp);
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblScore.setBounds(1, 30, 117, 31);
		panelTopBar.add(lblScore);
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(881, 1, 117, 31);
		panelTopBar.add(lblDayCount);
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(881, 37, 117, 31);
		panelTopBar.add(lblGoldCount);
		
		
		//ITEMS FOR SALE
		JTextPane txtpItem1 = new JTextPane();
		txtpItem1.setText("This Slot is Empty");
		txtpItem1.setEditable(false);
		txtpItem1.setBounds(25, 128, 161, 161);
		frame.getContentPane().add(txtpItem1);
		
		JCheckBox chckbxItem1 = new JCheckBox("");
		chckbxItem1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxItem1.setBounds(25, 290, 161, 23);
		frame.getContentPane().add(chckbxItem1);
		
		JTextPane txtpItem2 = new JTextPane();
		txtpItem2.setText("This Slot is Empty");
		txtpItem2.setEditable(false);
		txtpItem2.setBounds(222, 128, 161, 161);
		frame.getContentPane().add(txtpItem2);
		
		JCheckBox chckbxItem2 = new JCheckBox("");
		chckbxItem2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxItem2.setBounds(222, 290, 161, 23);
		frame.getContentPane().add(chckbxItem2);
		
		JTextPane txtpItem3 = new JTextPane();
		txtpItem3.setText("This Slot is Empty");
		txtpItem3.setEditable(false);
		txtpItem3.setBounds(423, 128, 161, 161);
		frame.getContentPane().add(txtpItem3);
		
		JCheckBox chckbxItem3 = new JCheckBox("");
		chckbxItem3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxItem3.setBounds(423, 290, 161, 23);
		frame.getContentPane().add(chckbxItem3);
		
		JTextPane txtpItem4 = new JTextPane();
		txtpItem4.setText("This Slot is Empty");
		txtpItem4.setEditable(false);
		txtpItem4.setBounds(614, 128, 161, 161);
		frame.getContentPane().add(txtpItem4);
		
		JCheckBox chckbxItem4 = new JCheckBox("");
		chckbxItem4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxItem4.setBounds(614, 290, 161, 23);
		frame.getContentPane().add(chckbxItem4);
		
		JTextPane txtpItem5 = new JTextPane();
		txtpItem5.setText("This Slot is Empty");
		txtpItem5.setEditable(false);
		txtpItem5.setBounds(811, 128, 161, 161);
		frame.getContentPane().add(txtpItem5);
		
		JCheckBox chckbxItem5 = new JCheckBox("");
		chckbxItem5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxItem5.setBounds(811, 290, 161, 23);
		frame.getContentPane().add(chckbxItem5);
		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setText("This Slot is Empty");
		txtpMonst1.setEditable(false);
		txtpMonst1.setBounds(25, 360, 161, 245);
		frame.getContentPane().add(txtpMonst1);
		
		JCheckBox chckbxMonst1 = new JCheckBox("");
		chckbxMonst1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMonst1.setBounds(25, 617, 161, 23);
		frame.getContentPane().add(chckbxMonst1);
		
		JTextPane txtpMonst2 = new JTextPane();
		txtpMonst2.setText("This Slot is Empty");
		txtpMonst2.setEditable(false);
		txtpMonst2.setBounds(222, 360, 161, 245);
		frame.getContentPane().add(txtpMonst2);
		
		JCheckBox chckbxMonst2 = new JCheckBox("");
		chckbxMonst2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMonst2.setBounds(222, 617, 161, 23);
		frame.getContentPane().add(chckbxMonst2);
		
		JTextPane txtpMonst3 = new JTextPane();
		txtpMonst3.setText("This Slot is Empty");
		txtpMonst3.setEditable(false);
		txtpMonst3.setBounds(423, 360, 161, 245);
		frame.getContentPane().add(txtpMonst3);
		
		JCheckBox chckbxMonst3 = new JCheckBox("");
		chckbxMonst3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMonst3.setBounds(423, 617, 161, 23);
		frame.getContentPane().add(chckbxMonst3);
		
		JTextPane txtpMonst4 = new JTextPane();
		txtpMonst4.setText("This Slot is Empty");
		txtpMonst4.setEditable(false);
		txtpMonst4.setBounds(614, 360, 161, 245);
		frame.getContentPane().add(txtpMonst4);
		
		JCheckBox chckbxMonst4 = new JCheckBox("");
		chckbxMonst4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMonst4.setBounds(614, 617, 161, 23);
		frame.getContentPane().add(chckbxMonst4);
		
		JTextPane txtpMonst5 = new JTextPane();
		txtpMonst5.setText("This Slot is Empty");
		txtpMonst5.setEditable(false);
		txtpMonst5.setBounds(811, 360, 161, 245);
		frame.getContentPane().add(txtpMonst5);
		
		JCheckBox chckbxMonst5 = new JCheckBox("");
		chckbxMonst5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxMonst5.setBounds(811, 617, 161, 23);
		frame.getContentPane().add(chckbxMonst5);
		
		
		ArrayList<JTextPane> itemSlots = new ArrayList<JTextPane>(5);
		itemSlots.add(txtpItem1);
		itemSlots.add(txtpItem2);
		itemSlots.add(txtpItem3);
		itemSlots.add(txtpItem4);
		itemSlots.add(txtpItem5);
		
		ArrayList<JTextPane> monsterSlots = new ArrayList<JTextPane>(5);
		monsterSlots.add(txtpMonst1);
		monsterSlots.add(txtpMonst2);
		monsterSlots.add(txtpMonst3);
		monsterSlots.add(txtpMonst4);
		monsterSlots.add(txtpMonst5);
		
		ArrayList<JCheckBox> selectedMonsters = new ArrayList<JCheckBox>(5);
		selectedMonsters.add(chckbxMonst1);
		selectedMonsters.add(chckbxMonst2);
		selectedMonsters.add(chckbxMonst3);
		selectedMonsters.add(chckbxMonst4);
		selectedMonsters.add(chckbxMonst5);
		
		ArrayList<JCheckBox> selectedItems = new ArrayList<JCheckBox>(5);
		selectedItems.add(chckbxItem1);
		selectedItems.add(chckbxItem2);
		selectedItems.add(chckbxItem3);
		selectedItems.add(chckbxItem4);
		selectedItems.add(chckbxItem5);
		
		
		
		
		ArrayList<Item> shopItems= gui.getGame().getShop().getShopItems();
		ArrayList<Monster> shopMonsters = gui.getGame().getShop().getShopMonsters();
		
		for (int i = 0; i < selectedItems.size(); i++) {
			
			//BLANKS OUT UNUSED TICK BOXES
			if (i < shopItems.size()) {
				selectedItems.get(i).setEnabled(true);
			} else {
				selectedItems.get(i).setEnabled(false);
			}
			
			if (i < shopMonsters.size()) {
				selectedMonsters.get(i).setEnabled(true);
			} else {
				selectedMonsters.get(i).setEnabled(false);
			}
			
			//UPDATES ALL THE TEXT FIELDS FOR ITEMS AND MONSTERS
			if (i < shopItems.size()) {
				itemSlots.get(i).setText(shopItems.get(i).toString() + "\n Price: " + shopItems.get(i).getPrice());
			}
			
			if (i < shopMonsters.size()) {
				monsterSlots.get(i).setText(shopMonsters.get(i).toStringShop());
			}
			
		}
		
		
		
		JButton btnBuySelectedThings = new JButton("Buy Selected Things");
		btnBuySelectedThings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				for (int i = 0; i < selectedMonsters.size(); i++) {
					//BUYS MONSTERS
					if (selectedMonsters.get(i).isSelected()) {
						gui.getGame().getShop().purchaseMonster(shopMonsters.get(i), gui.getGame().getPlayer());
					}
					
					//BUYS ITEMS
					if (selectedItems.get(i).isSelected()) {
						gui.getGame().getShop().purchaseItem(shopItems.get(i), gui.getGame().getPlayer());
					}
				}
				
				gui.closeShopScreen(gui.getShopScreen());
				gui.launchShopScreen();
			}
		});
		btnBuySelectedThings.setBounds(396, 663, 218, 29);
		frame.getContentPane().add(btnBuySelectedThings);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeShopScreen(gui.getShopScreen());
				gui.launchMenuScreen();
			}
		});
		btnReturnToMenu.setBounds(425, 704, 169, 29);
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
