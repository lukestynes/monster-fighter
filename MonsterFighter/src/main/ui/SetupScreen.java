package main.ui;

import main.game.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetupScreen {

	private JFrame window;
	private JTextField txtName;
	private GUIController gui;

	public SetupScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		window.setVisible(true);
	}
	
	public void closeWindow() {
		window.dispose();
	}
	
	public void finishedWindow() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		window = new JFrame();
		window.setResizable(false);
		window.setTitle("Monster Fighter");
		window.setBounds(100, 100, 1000, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Monster Fighter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblNewLabel.setBounds(0, 6, 1000, 63);
		window.getContentPane().add(lblNewLabel);
		
		JLabel lblTitleName = new JLabel("What is your name?");
		lblTitleName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleName.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleName.setBounds(0, 81, 422, 40);
		window.getContentPane().add(lblTitleName);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setBounds(126, 133, 173, 26);
		window.getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblTitleLength = new JLabel("How long of a game do you want?");
		lblTitleLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleLength.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleLength.setBounds(0, 226, 422, 40);
		window.getContentPane().add(lblTitleLength);
		
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
		window.getContentPane().add(sldGameLength);
		
		JLabel lblTitleDifficulty = new JLabel("Choose your difficulty: ");
		lblTitleDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitleDifficulty.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTitleDifficulty.setBounds(6, 387, 422, 40);
		window.getContentPane().add(lblTitleDifficulty);
		
		JPanel panelDifficultyButtons = new JPanel();
		panelDifficultyButtons.setBounds(132, 439, 156, 63);
		window.getContentPane().add(panelDifficultyButtons);
		
		JRadioButton rdbtnEasyMode = new JRadioButton("Easy Mode");
		panelDifficultyButtons.add(rdbtnEasyMode);
		
		JRadioButton rdbtnHardMode = new JRadioButton("Hard Mode");
		panelDifficultyButtons.add(rdbtnHardMode);
		
		JPanel panelStartMonsters = new JPanel();
		panelStartMonsters.setBounds(440, 84, 560, 438);
		window.getContentPane().add(panelStartMonsters);
		panelStartMonsters.setLayout(null);
		
		JTextPane txtpMonst1 = new JTextPane();
		txtpMonst1.setText("1. [NAME]\nDescription: [X]\n\nHealth: [X]\nHeal Amount: [X]\nDefence: [X]\nDamage: [X]\n");
		txtpMonst1.setBounds(0, 0, 476, 144);
		panelStartMonsters.add(txtpMonst1);
		
		JTextPane txtpMonst2 = new JTextPane();
		txtpMonst2.setText("2. [NAME]\nDescription: [X]\n\nHealth: [X]\nHeal Amount: [X]\nDefence: [X]\nDamage: [X]\n");
		txtpMonst2.setBounds(0, 145, 476, 144);
		panelStartMonsters.add(txtpMonst2);
		
		JTextPane txtpMonst3 = new JTextPane();
		txtpMonst3.setText("3. [NAME]\nDescription: [X]\n\nHealth: [X]\nHeal Amount: [X]\nDefence: [X]\nDamage: [X]\n");
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
		
		JLabel lblTitleSelected = new JLabel("Selection");
		lblTitleSelected.setBounds(922, 67, 61, 16);
		window.getContentPane().add(lblTitleSelected);
		
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
					startingMonster = 1;
				} else if (rdbtnMonst2.isSelected()) {
					startingMonster = 2;
				} else if( rdbtnMonst3.isSelected()) {
					startingMonster = 3;
				}
				
				gui.getGame().setupValues(name, gameLength, difficulty, startingMonster);
				
				System.out.printf("DEBUG: %s %d %d", name, gameLength, difficulty, startingMonster);
			}
		});
		btnStartAdventure.setBounds(408, 576, 186, 29);
		window.getContentPane().add(btnStartAdventure);
		
	}
}
