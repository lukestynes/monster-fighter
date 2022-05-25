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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryScreen {

	private JFrame frame;
	private GUIController gui;

	public InventoryScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeInventoryScreen(this);
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
		panelTopBar.setBounds(0, 1, 1000, 71);
		frame.getContentPane().add(panelTopBar);
		
		JLabel lblnventory = new JLabel("Inventory");
		lblnventory.setHorizontalAlignment(SwingConstants.CENTER);
		lblnventory.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblnventory.setBounds(-2, 3, 1000, 63);
		panelTopBar.add(lblnventory);
		
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
		
		
		
		JTextPane txtpInv1 = new JTextPane();
		txtpInv1.setBounds(29, 97, 161, 161);
		frame.getContentPane().add(txtpInv1);
		txtpInv1.setText("This Slot is Empty");
		txtpInv1.setEditable(false);
		
		JTextPane txtpInv2 = new JTextPane();
		txtpInv2.setText("This Slot is Empty");
		txtpInv2.setEditable(false);
		txtpInv2.setBounds(226, 97, 161, 161);
		frame.getContentPane().add(txtpInv2);
		
		JTextPane txtpInv3 = new JTextPane();
		txtpInv3.setText("This Slot is Empty");
		txtpInv3.setEditable(false);
		txtpInv3.setBounds(427, 97, 161, 161);
		frame.getContentPane().add(txtpInv3);
		
		JTextPane txtpInv4 = new JTextPane();
		txtpInv4.setText("This Slot is Empty");
		txtpInv4.setEditable(false);
		txtpInv4.setBounds(618, 97, 161, 161);
		frame.getContentPane().add(txtpInv4);
		
		JTextPane txtpInv5 = new JTextPane();
		txtpInv5.setText("This Slot is Empty");
		txtpInv5.setEditable(false);
		txtpInv5.setBounds(815, 97, 161, 161);
		frame.getContentPane().add(txtpInv5);
		
		JTextPane txtpInv6 = new JTextPane();
		txtpInv6.setText("This Slot is Empty");
		txtpInv6.setEditable(false);
		txtpInv6.setBounds(29, 289, 161, 161);
		frame.getContentPane().add(txtpInv6);
		
		JTextPane txtpInv7 = new JTextPane();
		txtpInv7.setText("This Slot is Empty");
		txtpInv7.setEditable(false);
		txtpInv7.setBounds(226, 289, 161, 161);
		frame.getContentPane().add(txtpInv7);
		
		JTextPane txtpInv8 = new JTextPane();
		txtpInv8.setText("This Slot is Empty");
		txtpInv8.setEditable(false);
		txtpInv8.setBounds(427, 289, 161, 161);
		frame.getContentPane().add(txtpInv8);
		
		JTextPane txtpInv9 = new JTextPane();
		txtpInv9.setText("This Slot is Empty");
		txtpInv9.setEditable(false);
		txtpInv9.setBounds(618, 289, 161, 161);
		frame.getContentPane().add(txtpInv9);
		
		JTextPane txtpInv10 = new JTextPane();
		txtpInv10.setText("This Slot is Empty");
		txtpInv10.setEditable(false);
		txtpInv10.setBounds(815, 289, 161, 161);
		frame.getContentPane().add(txtpInv10);
		
		
		//ADD ALL THE INVENTORY SLOTS TO A LIST FOR EASY MANAGEMENT
		ArrayList<JTextPane> invSlots = new ArrayList<>(10);
		invSlots.add(txtpInv1);
		invSlots.add(txtpInv2);
		invSlots.add(txtpInv3);
		invSlots.add(txtpInv4);
		invSlots.add(txtpInv5);
		invSlots.add(txtpInv6);
		invSlots.add(txtpInv7);
		invSlots.add(txtpInv8);
		invSlots.add(txtpInv9);
		invSlots.add(txtpInv10);
		
		
		
		
		//SETS THE TEXT FOR ALL THE INVENTORY SLOTS DEPENDING ON THE ITEM IN THEM.
		int count = 0;
		ArrayList<Item> inventory = gui.getGame().getPlayer().getInventory().getInventoryList();
		
		for (JTextPane invSlot: invSlots) {
			if (count < inventory.size()) {
				invSlot.setText(inventory.get(count).toString());
			}
			
			count++;
		}
		
		
		
		JCheckBox chckbxInv1 = new JCheckBox("");
		chckbxInv1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv1.setBounds(29, 259, 161, 23);
		frame.getContentPane().add(chckbxInv1);
		
		JCheckBox chckbxInv2 = new JCheckBox("");
		chckbxInv2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv2.setBounds(226, 259, 161, 23);
		frame.getContentPane().add(chckbxInv2);
		
		JCheckBox chckbxInv4 = new JCheckBox("");
		chckbxInv4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv4.setBounds(618, 259, 161, 23);
		frame.getContentPane().add(chckbxInv4);
		
		JCheckBox chckbxInv3 = new JCheckBox("");
		chckbxInv3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv3.setBounds(427, 259, 161, 23);
		frame.getContentPane().add(chckbxInv3);
		
		JCheckBox chckbxInv5 = new JCheckBox("");
		chckbxInv5.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv5.setBounds(815, 259, 161, 23);
		frame.getContentPane().add(chckbxInv5);
		
		JCheckBox chckbxInv10 = new JCheckBox("");
		chckbxInv10.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv10.setBounds(815, 450, 161, 23);
		frame.getContentPane().add(chckbxInv10);
		
		JCheckBox chckbxInv9 = new JCheckBox("");
		chckbxInv9.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv9.setBounds(618, 450, 161, 23);
		frame.getContentPane().add(chckbxInv9);
		
		JCheckBox chckbxInv8 = new JCheckBox("");
		chckbxInv8.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv8.setBounds(427, 450, 161, 23);
		frame.getContentPane().add(chckbxInv8);
		
		JCheckBox chckbxInv7 = new JCheckBox("");
		chckbxInv7.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv7.setBounds(226, 450, 161, 23);
		frame.getContentPane().add(chckbxInv7);
		
		JCheckBox chckbxInv6 = new JCheckBox("");
		chckbxInv6.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxInv6.setBounds(29, 450, 161, 23);
		frame.getContentPane().add(chckbxInv6);
		
		

		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setText("This Slot is Empty");
		txtpMonst1.setEditable(false);
		txtpMonst1.setBounds(128, 512, 161, 161);
		frame.getContentPane().add(txtpMonst1);
		
		JTextPane txtpMonst2 = new JTextPane();
		txtpMonst2.setText("This Slot is Empty");
		txtpMonst2.setEditable(false);
		txtpMonst2.setBounds(325, 512, 161, 161);
		frame.getContentPane().add(txtpMonst2);
		
		JTextPane txtpMonst3 = new JTextPane();
		txtpMonst3.setText("This Slot is Empty");
		txtpMonst3.setEditable(false);
		txtpMonst3.setBounds(526, 512, 161, 161);
		frame.getContentPane().add(txtpMonst3);
		
		JTextPane txtpMonst4 = new JTextPane();
		txtpMonst4.setText("This Slot is Empty");
		txtpMonst4.setEditable(false);
		txtpMonst4.setBounds(717, 512, 161, 161);
		frame.getContentPane().add(txtpMonst4);
		
		JLabel lblMonsters = new JLabel("Monsters");
		lblMonsters.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsters.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblMonsters.setBounds(0, 459, 1000, 63);
		frame.getContentPane().add(lblMonsters);
		
		
		//SETS ALL THE TEXT FOR THE MONSTERS IN THE TEAM
		ArrayList<JTextPane> monsterSlots = new ArrayList<JTextPane>(5);
		monsterSlots.add(txtpMonst1);
		monsterSlots.add(txtpMonst2);
		monsterSlots.add(txtpMonst3);
		monsterSlots.add(txtpMonst4);
		
		ArrayList<Monster> monsterTeam = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList();
		
		count = 0;
		for (Monster monster: monsterTeam) {
			if (count < monsterTeam.size()) {
				monsterSlots.get(count).setText(monsterTeam.get(count).toStringInv());
			}
		}
		
		
		
		//ADD ALL THE CHECKBOXES TO A GROUP TO MAKE LIFE EASY
		ArrayList<JCheckBox> checkedItems = new ArrayList<>(4);
		checkedItems.add(chckbxInv1);
		checkedItems.add(chckbxInv2);
		checkedItems.add(chckbxInv3);
		checkedItems.add(chckbxInv4);
		checkedItems.add(chckbxInv5);
		checkedItems.add(chckbxInv6);
		checkedItems.add(chckbxInv7);
		checkedItems.add(chckbxInv8);
		checkedItems.add(chckbxInv9);
		checkedItems.add(chckbxInv10);
		
		
		//BLANKS OUT THE CHECKS FOR EMPTY ITEM SLOTS
		count = 0;
		for (JCheckBox checkbox: checkedItems) {
			if (count < inventory.size()) {
				checkbox.setEnabled(true);
			} else {
				checkbox.setEnabled(false);
			}
			count++;
		}
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(128, 685, 752, 36);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnMonst1 = new JRadioButton("");
		rdbtnMonst1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst1.setBounds(6, 6, 141, 23);
		panel.add(rdbtnMonst1);
		
		JRadioButton rdbtnMonst2 = new JRadioButton("");
		rdbtnMonst2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst2.setBounds(210, 6, 141, 23);
		panel.add(rdbtnMonst2);
		
		JRadioButton rdbtnMonst3 = new JRadioButton("");
		rdbtnMonst3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst3.setBounds(406, 6, 141, 23);
		panel.add(rdbtnMonst3);
		
		JRadioButton rdbtnMonst4 = new JRadioButton("");
		rdbtnMonst4.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst4.setBounds(594, 6, 141, 23);
		panel.add(rdbtnMonst4);
		
		
		//Groups radio buttons so only one is selected at once.
		ButtonGroup monsterButtons = new ButtonGroup();
		monsterButtons.add(rdbtnMonst1);
		monsterButtons.add(rdbtnMonst2);
		monsterButtons.add(rdbtnMonst3);
		monsterButtons.add(rdbtnMonst4);
		
		
		ArrayList<JRadioButton> monsterRadButtons = new ArrayList<>(4);
		monsterRadButtons.add(rdbtnMonst1);
		monsterRadButtons.add(rdbtnMonst2);
		monsterRadButtons.add(rdbtnMonst3);
		monsterRadButtons.add(rdbtnMonst4);
		
		count = 0;
		for (JRadioButton button: monsterRadButtons) {
			if (count < monsterTeam.size()) {
				button.setEnabled(true);
			} else {
				button.setEnabled(false);
			}
			count++;
		}
		
		
		
		
		
		
		JButton btnUseItems = new JButton("Use Selected Items on Monster");
		btnUseItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Monster affectedMonster = null;
				
				
				int count = 0;
				for (JRadioButton button: monsterRadButtons) {
					
					if (button.isSelected()) {
						affectedMonster = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList().get(count);
					}
					count++;
				}
				
				count = 0;
				for (JCheckBox checked: checkedItems) {
					if (checked.isSelected()) {
						gui.getGame().getPlayer().getInventory().useItem(gui.getGame().getPlayer().getInventory().getInventoryList().get(count), affectedMonster);
					}
					count++;
				}
				
				gui.closeInventoryScreen(gui.getInventoryScreen());
				gui.launchInventoryScreen();
			}
		});
		btnUseItems.setBounds(357, 733, 270, 29);
		frame.getContentPane().add(btnUseItems);
		
		
		JButton btnSellItems = new JButton("Sell Selected Items");
		btnSellItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				for (JCheckBox checkbox: checkedItems) {
					if (checkbox.isSelected()) {
						gui.getGame().getShop().returnItem(gui.getGame().getPlayer().getInventory().getInventoryList().get(count), gui.getGame().getPlayer());
					}
					count++;
				}
				
				gui.closeInventoryScreen(gui.getInventoryScreen());
				gui.launchInventoryScreen();
			}
		});
		btnSellItems.setBounds(385, 765, 218, 29);
		frame.getContentPane().add(btnSellItems);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gui.closeInventoryScreen(gui.getInventoryScreen());
				gui.launchMenuScreen();
			}
		});
		btnReturnToMenu.setBounds(385, 826, 218, 29);
		frame.getContentPane().add(btnReturnToMenu);
	}
}
