package main.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuScreen {

	private JFrame frame;
	private GUIController gui;

	public MenuScreen(GUIController gui) {
		this.gui = gui;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		gui.closeMenuScreen(this);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Monster Fighter");
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayerName = new JLabel(gui.getGame().getPlayer().getName());
		lblPlayerName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblPlayerName.setBounds(6, 6, 117, 31);
		frame.getContentPane().add(lblPlayerName);
		
		JLabel lblGoldCount = new JLabel("Gold: " + gui.getGame().getPlayer().getGold());
		lblGoldCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGoldCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblGoldCount.setBounds(877, 34, 117, 31);
		frame.getContentPane().add(lblGoldCount);
		
		JLabel lblScore = new JLabel("Score: " + gui.getGame().getPlayer().getScore());
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblScore.setBounds(6, 34, 117, 31);
		frame.getContentPane().add(lblScore);
		
		JLabel lblDayCount = new JLabel("Day: " + gui.getGame().getCurrentDay() + "/" + gui.getGame().getGameLength());
		lblDayCount.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDayCount.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblDayCount.setBounds(877, 6, 117, 31);
		frame.getContentPane().add(lblDayCount);
		
		JButton btnMonsterTeam = new JButton("View your Monster Team");
		btnMonsterTeam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.launchMonsterTeamScreen();
				gui.closeMenuScreen(gui.getMenuScreen());
			}
		});
		btnMonsterTeam.setBounds(242, 236, 535, 36);
		frame.getContentPane().add(btnMonsterTeam);
		
		JButton btnInventory = new JButton("View your Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMenuScreen(gui.getMenuScreen());
				gui.launchInventoryScreen();
			}
		});
		btnInventory.setBounds(242, 291, 535, 36);
		frame.getContentPane().add(btnInventory);
		
		JButton btnShop = new JButton("Visit the Shop");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMenuScreen(gui.getMenuScreen());
				gui.launchShopScreen();
			}
		});
		btnShop.setBounds(242, 352, 535, 36);
		frame.getContentPane().add(btnShop);
		
		JButton btnBattle = new JButton("View Available Battles");
		btnBattle.setBounds(242, 413, 535, 36);
		frame.getContentPane().add(btnBattle);
		
		JButton btnSleep = new JButton("Sleep (Progress to Next Day)");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMenuScreen(gui.getMenuScreen());
				gui.getGame().nightReset();
			}
		});
		btnSleep.setBounds(242, 478, 535, 36);
		frame.getContentPane().add(btnSleep);
		
		JLabel lblLogo = new JLabel("Monster Fighter");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setFont(new Font("Lucida Grande", Font.BOLD, 26));
		lblLogo.setBounds(0, 2, 1000, 63);
		frame.getContentPane().add(lblLogo);
		
		JButton btnQuitGame = new JButton("Quit Game");
		btnQuitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.getGame().endGame();
			}
		});
		btnQuitGame.setBounds(242, 589, 535, 36);
		frame.getContentPane().add(btnQuitGame);
		
		JButton btnEndGame = new JButton("End Game Now");
		btnEndGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.closeMenuScreen(gui.getMenuScreen());
				gui.launchEndGameScreen();
			}
		});
		btnEndGame.setBounds(242, 541, 535, 36);
		frame.getContentPane().add(btnEndGame);
		
		//Centers the window
		frame.setLocationRelativeTo(null);
	}

}
