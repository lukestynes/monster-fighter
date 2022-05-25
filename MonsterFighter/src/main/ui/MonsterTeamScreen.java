package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import main.monsters.Monster;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class MonsterTeamScreen {

	private JFrame frame;
	private GUIController gui;

	public MonsterTeamScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
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
		
		JLabel lblPlayerName = new JLabel(gui.getGame().getPlayer().getName());
		lblPlayerName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPlayerName.setBounds(6, 4, 117, 31);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblScore.setBounds(6, 32, 117, 31);
		frame.getContentPane().add(lblScore);
		
		JLabel lblMonsterTeam = new JLabel("Monster Team");
		lblMonsterTeam.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterTeam.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblMonsterTeam.setBounds(0, 0, 1000, 63);
		frame.getContentPane().add(lblMonsterTeam);
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(877, 4, 117, 31);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(877, 32, 117, 31);
		frame.getContentPane().add(lblGoldCount);
		
		JPanel panelMonster1 = new JPanel();
		panelMonster1.setBounds(34, 231, 200, 250);
		frame.getContentPane().add(panelMonster1);
		panelMonster1.setLayout(null);
		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setBounds(0, 0, 200, 250);
		panelMonster1.add(txtpMonst1);
		
		ArrayList<Monster> monsterTeam = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList();
		String monst1 = "This Slot is Empty";
		String monst2, monst3, monst4;
		monst4 = monst2 = monst3 = monst1;
		
		
		switch (monsterTeam.size()) {
		case 1:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(), monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			break;
		case 2:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			break;
		case 3:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			monst3 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(2).getName(), monsterTeam.get(0).getType(),monsterTeam.get(2).getLevel(), monsterTeam.get(2).getDescription(), monsterTeam.get(2).getMaxHealth(), monsterTeam.get(2).getHealAmount(), monsterTeam.get(2).getDefence(), monsterTeam.get(2).getDamage());
			break;
		case 4:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			monst3 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(2).getName(), monsterTeam.get(0).getType(),monsterTeam.get(2).getLevel(), monsterTeam.get(2).getDescription(), monsterTeam.get(2).getMaxHealth(), monsterTeam.get(2).getHealAmount(), monsterTeam.get(2).getDefence(), monsterTeam.get(2).getDamage());
			monst4 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(3).getName(), monsterTeam.get(0).getType(),monsterTeam.get(3).getLevel(), monsterTeam.get(3).getDescription(), monsterTeam.get(3).getMaxHealth(), monsterTeam.get(3).getHealAmount(), monsterTeam.get(3).getDefence(), monsterTeam.get(3).getDamage());
			break;
		
		}
		txtpMonst1.setText(monst1);
		txtpMonst1.setEditable(false);
		
		JPanel panelMonster4 = new JPanel();
		panelMonster4.setBounds(769, 231, 200, 250);
		frame.getContentPane().add(panelMonster4);
		panelMonster4.setLayout(null);
		
		JTextPane txtpMonst1_3 = new JTextPane();
		txtpMonst1_3.setText(monst2);
		txtpMonst1_3.setEditable(false);
		txtpMonst1_3.setBounds(0, 0, 200, 250);
		panelMonster4.add(txtpMonst1_3);
		
		JPanel panelMonster2 = new JPanel();
		panelMonster2.setBounds(285, 231, 200, 250);
		frame.getContentPane().add(panelMonster2);
		panelMonster2.setLayout(null);
		
		JTextPane txtpMonst1_1 = new JTextPane();
		txtpMonst1_1.setText(monst3);
		txtpMonst1_1.setEditable(false);
		txtpMonst1_1.setBounds(0, 0, 200, 250);
		panelMonster2.add(txtpMonst1_1);
		
		JPanel panelMonster3 = new JPanel();
		panelMonster3.setBounds(525, 231, 200, 250);
		frame.getContentPane().add(panelMonster3);
		panelMonster3.setLayout(null);
		
		JTextPane txtpMonst1_2 = new JTextPane();
		txtpMonst1_2.setText(monst4);
		txtpMonst1_2.setEditable(false);
		txtpMonst1_2.setBounds(0, 0, 200, 250);
		panelMonster3.add(txtpMonst1_2);
		
		JButton btnReturn = new JButton("Return to Menu");
		btnReturn.setBounds(423, 549, 161, 29);
		frame.getContentPane().add(btnReturn);
	}

}
