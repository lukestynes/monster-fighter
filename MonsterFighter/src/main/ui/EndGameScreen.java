package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndGameScreen {

	private JFrame frame;
	private GUIController gui;

	public EndGameScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeEndGameScreen(this);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel(gui.getGame().getPlayer().getName());
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblName.setBounds(437, 283, 117, 31);
		frame.getContentPane().add(lblName);
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblScore.setBounds(437, 444, 117, 31);
		frame.getContentPane().add(lblScore);
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(437, 401, 117, 31);
		frame.getContentPane().add(lblGoldCount);
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setHorizontalAlignment(SwingConstants.CENTER);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(437, 362, 117, 31);
		frame.getContentPane().add(lblDayCount);
		
		JLabel lblGameOver = new JLabel("Game Over!");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblGameOver.setBounds(0, 191, 1000, 80);
		frame.getContentPane().add(lblGameOver);
		
		JLabel lblDifficulty = new JLabel("Difficulty: ");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDifficulty.setBounds(414, 319, 158, 31);
		frame.getContentPane().add(lblDifficulty);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.getGame().endGame();
			}
		});
		btnQuitGame.setBounds(324, 527, 347, 36);
		frame.getContentPane().add(btnQuitGame);
		
		if (gui.getGame().getDifficulty() == 1) {
			lblDifficulty.setText("Difficulty: Hard");
		} else {
			lblDifficulty.setText("Difficulty: Easy");
		}
		
	}

}
