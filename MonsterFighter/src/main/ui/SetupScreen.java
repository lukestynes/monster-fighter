package main.ui;

import main.game.*;
import main.monsters.Monster;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame frame;
	private JTextField txtName;
	private GUIController gui;
	
	private ArrayList<Monster> startingMonsters;

	public SetupScreen(GUIController gui) {
		this.gui = gui;
		startingMonsters = gui.getGame().getStartingMonsters();
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeSetupScreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Monster Fighter");
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Monster Fighter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 6, 1000, 63);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblTitleName = new JLabel("What is your name?");
		lblTitleName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleName.setBounds(0, 81, 422, 40);
		frame.getContentPane().add(lblTitleName);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(126, 133, 173, 26);
		frame.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblTitleLength = new JLabel("How long of a game do you want?");
		lblTitleLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLength.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleLength.setBounds(0, 226, 422, 40);
		frame.getContentPane().add(lblTitleLength);
		
		JSlider sldGameLength = new JSlider();
		sldGameLength.setValue(10);
		sldGameLength.setToolTipText("Length in Days");
		sldGameLength.setMajorTickSpacing(1);
		sldGameLength.setMinimum(5);
		sldGameLength.setMaximum(15);
		sldGameLength.setMinorTickSpacing(1);
		sldGameLength.setPaintLabels(true);
		sldGameLength.setPaintTicks(true);
		sldGameLength.setSnapToTicks(true);
		sldGameLength.setBounds(72, 270, 277, 52);
		frame.getContentPane().add(sldGameLength);
		
		JLabel lblTitleDifficulty = new JLabel("Choose your difficulty: ");
		lblTitleDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDifficulty.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleDifficulty.setBounds(6, 387, 422, 40);
		frame.getContentPane().add(lblTitleDifficulty);
		
		JPanel panelDifficultyButtons = new JPanel();
		panelDifficultyButtons.setBounds(132, 439, 156, 63);
		frame.getContentPane().add(panelDifficultyButtons);
		
		ButtonGroup difficultyButtonGroup = new ButtonGroup();
		
		JRadioButton rdbtnEasyMode = new JRadioButton("Easy Mode");
		panelDifficultyButtons.add(rdbtnEasyMode);
		
		JRadioButton rdbtnHardMode = new JRadioButton("Hard Mode");
		panelDifficultyButtons.add(rdbtnHardMode);
		
		difficultyButtonGroup.add(rdbtnEasyMode);
		difficultyButtonGroup.add(rdbtnHardMode);
		
		JPanel panelStartMonsters = new JPanel();
		panelStartMonsters.setBounds(440, 84, 560, 438);
		frame.getContentPane().add(panelStartMonsters);
		panelStartMonsters.setLayout(null);
		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setEditable(false);
		
		Monster monster1 = startingMonsters.get(0);
		String monster1Text = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monster1.getName(),monster1.getType(), monster1.getLevel(), monster1.getDescription(), monster1.getMaxHealth(), monster1.getHealAmount(), monster1.getDefence(), monster1.getDamage());
		
		txtpMonst1.setText(monster1Text);
		txtpMonst1.setBounds(0, 0, 476, 144);
		panelStartMonsters.add(txtpMonst1);
		
		JTextPane txtpMonst2 = new JTextPane();
		txtpMonst2.setEditable(false);
		
		Monster monster2 = startingMonsters.get(1);
		String monster2Text = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monster2.getName(),monster2.getType(), monster2.getLevel(), monster2.getDescription(), monster2.getMaxHealth(), monster2.getHealAmount(), monster2.getDefence(), monster2.getDamage());
		
		txtpMonst2.setText(monster2Text);
		txtpMonst2.setBounds(0, 145, 476, 144);
		panelStartMonsters.add(txtpMonst2);
		
		JTextPane txtpMonst3 = new JTextPane();
		txtpMonst3.setEditable(false);
		
		Monster monster3 = startingMonsters.get(2);
		String monster3Text = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monster3.getName(),monster3.getType(), monster3.getLevel(), monster3.getDescription(), monster3.getMaxHealth(), monster3.getHealAmount(), monster3.getDefence(), monster3.getDamage());
		
		txtpMonst3.setText(monster3Text);
		txtpMonst3.setBounds(0, 290, 476, 144);
		panelStartMonsters.add(txtpMonst3);
		
		JPanel panel = new JPanel();
		panel.setBounds(477, 0, 77, 438);
		panelStartMonsters.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnMonst3 = new JRadioButton("");
		rdbtnMonst3.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst3.setBounds(0, 290, 71, 148);
		panel.add(rdbtnMonst3);
		
		JRadioButton rdbtnMonst2 = new JRadioButton("");
		rdbtnMonst2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst2.setBounds(0, 141, 71, 148);
		panel.add(rdbtnMonst2);
		
		JRadioButton rdbtnMonst1 = new JRadioButton("");
		rdbtnMonst1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMonst1.setBounds(0, 0, 71, 148);
		panel.add(rdbtnMonst1);
		
		ButtonGroup monsterButtons = new ButtonGroup();
		monsterButtons.add(rdbtnMonst1);
		monsterButtons.add(rdbtnMonst2);
		monsterButtons.add(rdbtnMonst3);
		
		JLabel lblTitleSelected = new JLabel("Selection");
		lblTitleSelected.setBounds(922, 67, 61, 16);
		frame.getContentPane().add(lblTitleSelected);
		
		JButton btnStartAdventure = new JButton("Start your Adventure!");
		btnStartAdventure.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				int gameLength = sldGameLength.getValue();
				int difficulty = 0;
				int startingMonster = 1;
				
				if (rdbtnHardMode.isSelected()) {
					difficulty = 1;
				}
				
				if (rdbtnMonst1.isSelected()) {
					startingMonster = 0;
				} else if (rdbtnMonst2.isSelected()) {
					startingMonster = 1;
				} else if( rdbtnMonst3.isSelected()) {
					startingMonster = 2;
				}
				
				
				
				gui.getGame().setupValues(name, gameLength, difficulty, startingMonsters.get(startingMonster));
				
				System.out.printf("DEBUG: %s %d %d %d", name, gameLength, difficulty, startingMonster);
				gui.launchMenuScreen();
				gui.closeSetupScreen(gui.getScreen());
			}
		});
		btnStartAdventure.setBounds(408, 576, 186, 29);
		frame.getContentPane().add(btnStartAdventure);
		
		//Centers the window
		frame.setLocationRelativeTo(null);

	}
}
