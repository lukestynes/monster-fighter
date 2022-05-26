package main.ui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import main.battle.Battle;
import main.monsters.Monster;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BattleSelectionScreen {

	private JFrame frame;
	private GUIController gui;

	public BattleSelectionScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeBattleSelectionScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1250, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centers the window
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel(gui.getGame().getPlayer().getName());
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setBounds(6, 4, 117, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblScore.setBounds(6, 32, 117, 31);
		frame.getContentPane().add(lblScore);
		
		JLabel lblBattleSelection = new JLabel("Battle Selection");
		lblBattleSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattleSelection.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblBattleSelection.setBounds(154, 0, 922, 63);
		frame.getContentPane().add(lblBattleSelection);
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(1088, 4, 117, 31);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(1088, 32, 117, 31);
		frame.getContentPane().add(lblGoldCount);
		
		JButton btnReturnToMenu = new JButton("Return to Menu");
		btnReturnToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeBattleSelectionScreen(gui.getBattleSelectionWindow());
				gui.launchMenuScreen();
			}
		});
		btnReturnToMenu.setBounds(884, 672, 246, 36);
		frame.getContentPane().add(btnReturnToMenu);
		
	
		JPanel panel = new JPanel();
		panel.setBounds(-54, 102, 304, 606);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpB1M1 = new JTextPane();
		txtpB1M1.setText("This Slot is Empty");
		txtpB1M1.setEditable(false);
		txtpB1M1.setBounds(77, 50, 161, 161);
		panel.add(txtpB1M1);
		
		JRadioButton rdbtnBattle1 = new JRadioButton("");
		rdbtnBattle1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBattle1.setBounds(87, 577, 141, 23);
		panel.add(rdbtnBattle1);
		
		JTextPane txtpB1M2 = new JTextPane();
		txtpB1M2.setText("This Slot is Empty");
		txtpB1M2.setEditable(false);
		txtpB1M2.setBounds(77, 223, 161, 161);
		panel.add(txtpB1M2);
		
		JTextPane txtpB1M3 = new JTextPane();
		txtpB1M3.setText("This Slot is Empty");
		txtpB1M3.setEditable(false);
		txtpB1M3.setBounds(77, 396, 161, 161);
		panel.add(txtpB1M3);
		
		JLabel lblBattle = new JLabel("Battle 1");
		lblBattle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBattle.setBounds(100, 6, 117, 31);
		panel.add(lblBattle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(181, 102, 304, 606);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnBattle2 = new JRadioButton("");
		rdbtnBattle2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBattle2.setBounds(87, 577, 141, 23);
		panel_1.add(rdbtnBattle2);
		
		JTextPane txtpB2M3 = new JTextPane();
		txtpB2M3.setText("This Slot is Empty");
		txtpB2M3.setEditable(false);
		txtpB2M3.setBounds(77, 396, 161, 161);
		panel_1.add(txtpB2M3);
		
		JTextPane txtpB2M2 = new JTextPane();
		txtpB2M2.setText("This Slot is Empty");
		txtpB2M2.setEditable(false);
		txtpB2M2.setBounds(77, 223, 161, 161);
		panel_1.add(txtpB2M2);
		
		JTextPane txtpB2M1 = new JTextPane();
		txtpB2M1.setText("This Slot is Empty");
		txtpB2M1.setEditable(false);
		txtpB2M1.setBounds(77, 50, 161, 161);
		panel_1.add(txtpB2M1);
		
		JLabel lblBattle2 = new JLabel("Battle 2");
		lblBattle2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBattle2.setBounds(96, 6, 117, 31);
		panel_1.add(lblBattle2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(424, 102, 304, 606);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JRadioButton rdbtnBattle3 = new JRadioButton("");
		rdbtnBattle3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBattle3.setBounds(84, 577, 141, 23);
		panel_2.add(rdbtnBattle3);
		
		JTextPane txtpB3M3 = new JTextPane();
		txtpB3M3.setText("This Slot is Empty");
		txtpB3M3.setEditable(false);
		txtpB3M3.setBounds(74, 396, 161, 161);
		panel_2.add(txtpB3M3);
		
		JTextPane txtpB3M2 = new JTextPane();
		txtpB3M2.setText("This Slot is Empty");
		txtpB3M2.setEditable(false);
		txtpB3M2.setBounds(74, 223, 161, 161);
		panel_2.add(txtpB3M2);
		
		JTextPane txtpB3M1 = new JTextPane();
		txtpB3M1.setText("This Slot is Empty");
		txtpB3M1.setEditable(false);
		txtpB3M1.setBounds(74, 50, 161, 161);
		panel_2.add(txtpB3M1);
		
		JLabel lblBattle3 = new JLabel("Battle 3");
		lblBattle3.setHorizontalAlignment(SwingConstants.CENTER);
		lblBattle3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblBattle3.setBounds(94, 7, 117, 31);
		panel_2.add(lblBattle3);
		
		JLabel lblYourMonsterTeams = new JLabel("Your Monster Teams Order");
		lblYourMonsterTeams.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourMonsterTeams.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblYourMonsterTeams.setBounds(871, 88, 246, 31);
		frame.getContentPane().add(lblYourMonsterTeams);
		
		JTextPane txtpMonstTeam1 = new JTextPane();
		txtpMonstTeam1.setText("This Slot is Empty");
		txtpMonstTeam1.setEditable(false);
		txtpMonstTeam1.setBounds(807, 157, 161, 161);
		frame.getContentPane().add(txtpMonstTeam1);
		
		JTextPane txtpMonstTeam3 = new JTextPane();
		txtpMonstTeam3.setText("This Slot is Empty");
		txtpMonstTeam3.setEditable(false);
		txtpMonstTeam3.setBounds(807, 387, 161, 161);
		frame.getContentPane().add(txtpMonstTeam3);
		
		JTextPane txtpMonstTeam4 = new JTextPane();
		txtpMonstTeam4.setText("This Slot is Empty");
		txtpMonstTeam4.setEditable(false);
		txtpMonstTeam4.setBounds(1038, 387, 161, 161);
		frame.getContentPane().add(txtpMonstTeam4);
		
		JTextPane txtpMonstTeam2 = new JTextPane();
		txtpMonstTeam2.setText("This Slot is Empty");
		txtpMonstTeam2.setEditable(false);
		txtpMonstTeam2.setBounds(1038, 158, 161, 161);
		frame.getContentPane().add(txtpMonstTeam2);
		
		JRadioButton rdbtnMonster1 = new JRadioButton("");
		rdbtnMonster1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonster1.setBounds(817, 323, 141, 23);
		frame.getContentPane().add(rdbtnMonster1);
		
		JRadioButton rdbtnMonster2 = new JRadioButton("");
		rdbtnMonster2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonster2.setBounds(1058, 323, 141, 23);
		frame.getContentPane().add(rdbtnMonster2);
		
		JRadioButton rdbtnMonster3 = new JRadioButton("");
		rdbtnMonster3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonster3.setBounds(817, 550, 141, 23);
		frame.getContentPane().add(rdbtnMonster3);
		
		JRadioButton rdbtnMonster4 = new JRadioButton("");
		rdbtnMonster4.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonster4.setBounds(1048, 550, 141, 23);
		frame.getContentPane().add(rdbtnMonster4);
		
		
		
		//Add radio buttons to a group to make sure only one is selected
		ButtonGroup battleButtons = new ButtonGroup();
		battleButtons.add(rdbtnBattle1);
		battleButtons.add(rdbtnBattle2);
		battleButtons.add(rdbtnBattle3);
		
		//Add radio buttons to a list for checking their properties
		ArrayList<JRadioButton> battleButtonList = new ArrayList<JRadioButton>(3);
		battleButtonList.add(rdbtnBattle1);
		battleButtonList.add(rdbtnBattle2);
		battleButtonList.add(rdbtnBattle3);
		
		ArrayList<JRadioButton> monsterButtonList = new ArrayList<JRadioButton>(4);
		monsterButtonList.add(rdbtnMonster1);
		monsterButtonList.add(rdbtnMonster2);
		monsterButtonList.add(rdbtnMonster3);
		monsterButtonList.add(rdbtnMonster4);
		
		
		//Add the monster slots in each battle to a separate list.
		ArrayList<JTextPane> battle1Monsters= new ArrayList<JTextPane>(3);
		battle1Monsters.add(txtpB1M1);
		battle1Monsters.add(txtpB1M2);
		battle1Monsters.add(txtpB1M3);
		
		ArrayList<JTextPane> battle2Monsters = new ArrayList<JTextPane>(3);
		battle2Monsters.add(txtpB2M1);
		battle2Monsters.add(txtpB2M2);
		battle2Monsters.add(txtpB2M3);
		
		ArrayList<JTextPane> battle3Monsters = new ArrayList<JTextPane>(3);
		battle3Monsters.add(txtpB3M1);
		battle3Monsters.add(txtpB3M2);
		battle3Monsters.add(txtpB3M3);
		
		//Add our monster team slots to a list
		ArrayList<JTextPane> monsterTeamSlots = new ArrayList<JTextPane>(4);
		monsterTeamSlots.add(txtpMonstTeam1);
		monsterTeamSlots.add(txtpMonstTeam3);
		monsterTeamSlots.add(txtpMonstTeam4);
		monsterTeamSlots.add(txtpMonstTeam2);
		
		//Populate the battle lists with monsters
		ArrayList<Battle> daysBattles = gui.getGame().getBattleController().getBattleList();
		
		
		/*
		 * 
		 * THIS DISPLAYS ALL THE MONSTERS THAT ARE CONTAINED WITHIN EACH BATTLE
		 * 
		 */
		
		
		System.out.println(daysBattles.get(0).getBattleMonsters());
		System.out.println(daysBattles.get(0).getBattleMonsters().size());
		
		int count = 0;
		for (JTextPane monstSlot: battle1Monsters) {
			if (count < daysBattles.get(0).getBattleMonsters().size()) {
				monstSlot.setText(daysBattles.get(0).getBattleMonsters().get(count).toStringInv());
			}
			count++;
		}
		
		count = 0;
		for (JTextPane monstSlot: battle2Monsters) {
			if (count < daysBattles.get(1).getBattleMonsters().size()) {
				monstSlot.setText(daysBattles.get(1).getBattleMonsters().get(count).toStringInv());
			}
			count++;
		}
		
		count = 0;
		for (JTextPane monstSlot: battle3Monsters) {
			if (count < daysBattles.get(2).getBattleMonsters().size()) {
				monstSlot.setText(daysBattles.get(2).getBattleMonsters().get(count).toStringInv());
			}
			count++;
		}

		/*
		 * 
		 * Updating the monster team and their order
		 * 
		 */
	
		
		ArrayList<Monster> monsterTeam = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList();
		
		//Display our monster team in the 4 boxes
		count = 0;
		for (JTextPane monsterSlot: monsterTeamSlots) {
			if (count < monsterTeam.size()) {
				monsterSlot.setText(monsterTeam.get(count).toStringInv());
				if (!monsterTeam.get(count).getFainted()) {
					monsterButtonList.get(count).setEnabled(true);
				} else {
					monsterButtonList.get(count).setEnabled(false);
				}
			} else {
				monsterButtonList.get(count).setEnabled(false);
			}
			count++;
		}
		
		
		JButton btnFightChosenBattle = new JButton("Fight Chosen Battle");
		btnFightChosenBattle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean won = false;
				
				//Get the order of our monster team for the battle controller
				ArrayList<Monster> battleTeam = new ArrayList<Monster>(4);
	
				ArrayList<Monster> monsterTeam = gui.getGame().getPlayer().getMonsterTeam().getMonsterTeamList();
				
				int count = 0;
				for (JRadioButton button: monsterButtonList) {
					if (button.isSelected()) {
						battleTeam.add(monsterTeam.get(count));
					}
					count++;
				}
				
				//Find out which battle the player has selected
				
				count = 0;
				for (JRadioButton battleButton: battleButtonList) {
					if (battleButton.isSelected()) {
						won = daysBattles.get(count).fightBattle(battleTeam);
					}
					count++;
				}
				
				if (won) {
					JOptionPane.showMessageDialog(frame, "You Won The Battle!");
				} else {
					
					JOptionPane.showMessageDialog(frame, "You Lost The Battle!");
				}
				
				gui.closeBattleSelectionScreen(gui.getBattleSelectionWindow());
				gui.launchBattleSelectionScreen();
			}
		});
		btnFightChosenBattle.setBounds(854, 607, 294, 36);
		frame.getContentPane().add(btnFightChosenBattle);
		
		
	}
}
