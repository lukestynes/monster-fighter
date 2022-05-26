package main.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import main.monsters.Monster;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class MonsterTeamScreen {

	private JFrame frame;
	private GUIController gui;

	/**
	 * Constructs a new monster team screen
	 * @param gui the gui controller
	 */
	public MonsterTeamScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	/**
	 * Ensures the window shuts correctly
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Shuts the window
	 */
	public void finishedWindow() {
		gui.closeMonsterTeamScreen(this);
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
		
		JPanel panelMonster1 = new JPanel();
		panelMonster1.setBounds(34, 231, 200, 250);
		frame.getContentPane().add(panelMonster1);
		panelMonster1.setLayout(null);
		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setBounds(0, 0, 200, 250);
		panelMonster1.add(txtpMonst1);
		txtpMonst1.setText("This Slot is Empty");
		txtpMonst1.setEditable(false);
		
		JPanel panelMonster4 = new JPanel();
		panelMonster4.setBounds(769, 231, 200, 250);
		frame.getContentPane().add(panelMonster4);
		panelMonster4.setLayout(null);
		
		JTextPane txtpMonst4 = new JTextPane();
		txtpMonst4.setText("This Slot is Empty");
		txtpMonst4.setEditable(false);
		txtpMonst4.setBounds(0, 0, 200, 250);
		panelMonster4.add(txtpMonst4);
		
		JPanel panelMonster2 = new JPanel();
		panelMonster2.setBounds(285, 231, 200, 250);
		frame.getContentPane().add(panelMonster2);
		panelMonster2.setLayout(null);
		
		JTextPane txtpMonst2 = new JTextPane();
		txtpMonst2.setText("This Slot is Empty");
		txtpMonst2.setEditable(false);
		txtpMonst2.setBounds(0, 0, 200, 250);
		panelMonster2.add(txtpMonst2);
		
		JPanel panelMonster3 = new JPanel();
		panelMonster3.setBounds(525, 231, 200, 250);
		frame.getContentPane().add(panelMonster3);
		panelMonster3.setLayout(null);
		
		JTextPane txtpMonst3 = new JTextPane();
		txtpMonst3.setText("This Slot is Empty");
		txtpMonst3.setEditable(false);
		txtpMonst3.setBounds(0, 0, 200, 250);
		panelMonster3.add(txtpMonst3);
		
		
		
		JButton btnReturn = new JButton("Return to Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.launchMenuScreen();
				gui.closeMonsterTeamScreen(gui.getMonsterScreen());
			}
		});
		btnReturn.setBounds(424, 608, 161, 29);
		frame.getContentPane().add(btnReturn);
		
		JPanel panelTopBar = new JPanel();
		panelTopBar.setBounds(0, 4, 1000, 71);
		frame.getContentPane().add(panelTopBar);
		panelTopBar.setLayout(null);
		
		JLabel lblPlayerName = new JLabel(gui.getGame().getPlayer().getName());
		lblPlayerName.setBounds(1, -3, 117, 31);
		panelTopBar.add(lblPlayerName);
		lblPlayerName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setBounds(1, 30, 117, 31);
		panelTopBar.add(lblScore);
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setBounds(838, -1, 117, 31);
		panelTopBar.add(lblDayCount);
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setBounds(838, 35, 117, 31);
		panelTopBar.add(lblGoldCount);
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblMonsterTeam = new JLabel("Monster Team");
		lblMonsterTeam.setBounds(-2, 3, 1000, 63);
		panelTopBar.add(lblMonsterTeam);
		lblMonsterTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterTeam.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		
		JCheckBox chckbx1 = new JCheckBox("");
		chckbx1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx1.setBounds(34, 481, 200, 23);
		frame.getContentPane().add(chckbx1);
		
		
		JCheckBox chckbx2 = new JCheckBox("");
		chckbx2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx2.setBounds(285, 481, 200, 23);
		frame.getContentPane().add(chckbx2);
		
	
		JCheckBox chckbx3 = new JCheckBox("");
		chckbx3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx3.setBounds(525, 481, 200, 23);
		frame.getContentPane().add(chckbx3);
	
		
		JCheckBox chckbx4 = new JCheckBox("");
		chckbx4.setHorizontalAlignment(SwingConstants.CENTER);
		chckbx4.setBounds(769, 481, 200, 23);
		frame.getContentPane().add(chckbx4);
	
		
		//UPDATES ALL THE INV SLOTS
		ArrayList<JTextPane> monsterSlots = new ArrayList<JTextPane>(4);
		monsterSlots.add(txtpMonst1);
		monsterSlots.add(txtpMonst2);
		monsterSlots.add(txtpMonst3);
		monsterSlots.add(txtpMonst4);
		
		ArrayList<Monster> monsterTeam = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList();
		
		int count = 0;
		
		for (Monster monster: monsterTeam) {
			if (count < monsterTeam.size()) {
				monsterSlots.get(count).setText(monster.toString());
			}
			count++;
		}
		
		
		//BLANKS OUT THE UNUSED CHECKBOXES
		ArrayList<JCheckBox> checkedMonsters = new ArrayList<>(4);
		
		checkedMonsters.add(chckbx1);
		checkedMonsters.add(chckbx2);
		checkedMonsters.add(chckbx3);
		checkedMonsters.add(chckbx4);
		
		count = 0;
		for (JCheckBox checkbox: checkedMonsters) {
			if (count < monsterTeam.size()) {
				checkbox.setEnabled(true);
			} else {
				checkbox.setEnabled(false);
			}
			
			count++;
		}
	
		//SELL MONSTERS BACK TO THE SHOP
		JButton btnSellSelectedMonsters = new JButton("Sell Selected Monsters");
		btnSellSelectedMonsters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = 0;
				
				for (JCheckBox checkbox: checkedMonsters) {
					
					
					if (checkbox.isSelected()) {
						gui.getGame().getShop().returnMonster(gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList().get(count), gui.getGame().getPlayer());
					}
					count++;
				}
				
				gui.closeMonsterTeamScreen(gui.getMonsterScreen());
				gui.launchMonsterTeamScreen();
			}
		});
		btnSellSelectedMonsters.setBounds(392, 545, 205, 29);
		frame.getContentPane().add(btnSellSelectedMonsters);
	}

}
