package main.ui;

import java.util.Scanner;

import main.game.*;

public class CLInterface {
	
	Scanner scan = new Scanner(System.in);
	
	/**
	 * Gets the players name, the game length they want, and the difficulty they want for the game they are starting.
	 * @param player the player object that stores all of the relevant player information
	 * @param game the game object which is responsible for the control of the entire game system
	 */
	public void setupScreen(Player player, GameController game) {
		String name;
		int length;
		int difficulty;
		//TODO: Starting monster
		
		
		System.out.println("###############################################################");
		System.out.println("Welcome to Monster Fighter");
		System.out.println("Made by Luke\n\n");
		
		System.out.println("What is your name?");
		name = scan.nextLine();
		
		System.out.println("How long do you want the game to be? (5-15 days)");
		length = scan.nextInt();
		
		System.out.println("What difficulty do you want to play on? (0=easy, 1=hard)");
		difficulty = scan.nextInt();	
		
		player.setupValues(name, difficulty);
		game.setDifficulty(difficulty);
		game.setGameLength(length);
	}
	
	/**
	 * Lets the player choose 1 monster out of 3-5 monsters (depending on difficulty) that will be their starting monster
	 * <p>
	 * <ol>
	 * 	<li> Easy Difficulty (0) = 5 monsters to choose from
	 * 	<li> Hard Difficulty (1) = 3 monsters to choose from
	 * <ol>
	 * <p>
	 * @param player the player object that stores all of the relevant player information
	 * @param game the game object which is responsible for the control of the entire game system
	 */
	public void startingMonsterScreen(Player player, GameController game) {
		
	}
}
