package main.ui;

import java.util.Scanner;

import main.game.*;
import main.monsters.Monster;

public class CLInterface {
	
	Scanner scan = new Scanner(System.in);
	
	/**
	 * Gets the players name, the game length they want, and the difficulty they want for the game they are starting.
	 * @param player the player object that stores all of the relevant player information
	 * @param game the game object which is responsible for the control of the entire game system
	 */
	public void setupScreen(Player player, GameController game, Monster[] easyStartingMonsters, Monster[] hardStartingMonsters) {
		String name;
		int length;
		int difficulty;
		Monster startingMonster;
		
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
		
		
		game.setDifficulty(difficulty);
		game.setGameLength(length);
		
		if (game.getDifficulty() == 0) {
			startingMonster = startingMonsterScreen(player, game, easyStartingMonsters);
		} else {
			startingMonster = startingMonsterScreen(player, game, hardStartingMonsters);
		}
		
		
		player.setupValues(name, difficulty, startingMonster);
		
		System.out.println("\n\n******* LET THE ADVENTURE BEGIN!**********\n\n");
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
	public Monster startingMonsterScreen(Player player, GameController game, Monster[] startingMonsters) {
		int count = 1;
		int chosenMonster;
		
		System.out.println("Have a look at these monsters below and choose your starter\n\n");
		
		
		for (Monster monster: startingMonsters) {
			System.out.println(count + ": " + monster);
			count++;
		}
		
		System.out.println("Enter the number of the monster you want to start with: ");
		
		chosenMonster = scan.nextInt();
		
		return startingMonsters[chosenMonster-1];
	}
	
	public void menuScreen(Player player, GameController game) {
		String toDisplay = """
				Choose an option:
				
				1. View your score, gold and current day
				2. View your monster team
				3. View your inventory
				4. Go to Battle
				5. Visit the shop
				6. Go to sleep (end the day)
				""";
		int playerChoice = scan.nextInt();
	}
	
	public void inventoryViewer() {
		
	}
}
