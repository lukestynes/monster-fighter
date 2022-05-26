package main.game;

import java.util.ArrayList;

import main.ui.*;
import main.shop.Shop;
import main.battle.BattleController;
import main.monsters.*;
import main.randomEvents.*;

public class GameController {
	GUIController gui;
	Player player;
	Shop shop;
	RandomEvents randomEvents;
	BattleController battleControl;
	
	private int gameLength;
	private int currentDay = 1;
	private int difficulty;
	
	/**
	 * Default constructor for GameController.
	 * 
	 * This creates instances of the other necessary classes that are needed to run the game.
	 */
	public GameController() {
		gui = new GUIController(this);
		randomEvents = new RandomEvents(this);
		shop = new Shop(this);
		battleControl = new BattleController(this);
	}
	
	public int getGameLength() {
		return gameLength;
	}

	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}

	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * Increments the current day by 1.
	 * 
	 * This method is used to progress to the next day easily.
	 */
	public void increaseCurrentDay() {
		this.currentDay++;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	/**
	 * Returns the main player instance being used.
	 * @return Player this returns the player instance that is being used by the game so other classes can access it easily.
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Returns the main shop instance being used.
	 * @return Shop this returns the shop instance that is being used by the game so other classes can access it easily.
	 */
	public Shop getShop() {

		return shop;
	}
	
	public BattleController getBattleController() {
		return battleControl;
	}
	
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
	}
	
	/**
	 * This is the method that is called by the main method to start the game sequence.
	 * 
	 * This launches the Launch Screen so that the initial values can be gathered from the player.
	 */
	public void run() {
		gui.launchSetupScreen();
	}
	
	/**
	 * This is called to correctly shutdown the game and the Java Runtime.
	 */
	public void endGame() {
		System.exit(0);
	}
	
	/**
	 * Generates a list of 3 random monsters for the start of the game for the player to choose.
	 * @return startingMonsters an ArrayList<Monster> that contains 3 monsters for the player to select from.
	 */
	public ArrayList<Monster> getStartingMonsters() {
		MonsterTeam temporaryTeam = new MonsterTeam();
		return temporaryTeam.generateRandomMonsters(currentDay, 3);
	}
	
	/**
	 * Sets all the initial values that are gathered by the set up screen
	 * @param name the name of the player
	 * @param length the  total length of the game in days
	 * @param difficulty the difficulty of the game (0 = easy, 1 = hard)
	 * @param startingMonster the monster that starts on the players team
	 */
	public void setupValues(String name, int length, int difficulty, Monster startingMonster) {
		this.setDifficulty(difficulty);
		this.setGameLength(length);
		
		player = new Player(name, difficulty, startingMonster);
	}

	/**
	 * Resets everything that needs to be reset at the end of the day when the player sleeps.
	 * 
	 * Does the following items:
	 * <ul>
	 * 	<li>Resets the monsters temporarily increased stats from potions and food.
	 * 	<li>Resets all the items and monsters on sale in the shop.
	 * 	<li>Checks that the player hasn't met a game ending condition (no monsters and not enough gold, or they slept on the final day)
	 * 	<li>Ends the game if a game ending condition is met.
	 * </ul>
	 */
	public void nightReset() {
		if (this.getCurrentDay() < this.getGameLength()) {
		
			
			//Runs all 3 of the random events.
			randomEvents.nightTimeEvents();
			shop.shopRefresh();
			battleControl.createDaysBattles();
			player.setGold(player.getGold() + 50);
			
			//Removes any temporary buffs given to the monsters during the day
			for (Monster monster: player.getMonsterTeam().getMonsterTeamList()) {
				monster.heal();
			}
			
			int cheapestAmount = 5000;
			
			for (Monster monster: shop.getShopMonsters()) {
				if (monster.getPrice() < cheapestAmount) {
					cheapestAmount = monster.getPrice();
				}
			}
			
			if (player.getGold() >= cheapestAmount || player.getMonsterTeam().getMonsterTeamList().size() > 0) {
				this.increaseCurrentDay();
				gui.launchMenuScreen();
			} else {
				System.out.println("DEBUG: PLAYER RAN OUT OF GOLD ENDING GAME");
				gui.launchEndGameScreen();
			}
			
		} else {
			System.out.println("DEBUG: PLAYER RAN OUT OF DAYS ENDING GAME");
			gui.launchEndGameScreen();
		}
		
	}
}