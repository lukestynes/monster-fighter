package main.game;

import main.ui.*;

public class GameController {
	CLInterface cli;
	Player player;
	
	private int gameLength;
	private int currentDay;
	private int difficulty;
	
	/**
	 * @return the gameLength in in-game days
	 */
	public int getGameLength() {
		return gameLength;
	}

	/**
	 * @param gameLength sets how long the game will run for in in-game days
	 */
	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}
	/**
	 * @return the current day in game
	 */
	public int getCurrentDay() {
		return currentDay;
	}
	
	/**
	 * Increments the current in game day by 1
	 */
	public void increaseCurrentDay() {
		this.currentDay++;
	}

	/**
	 * @return the difficulty (0=easy, 1=hard)
	 */
	public int getDifficulty() {
		return difficulty;
	}

	/**
	 * @param difficulty sets the difficulty to easy(0) or hard(1)
	 */
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	
	
	public GameController() {
		CLInterface cli = new CLInterface();
		Player player = new Player();
	}
	

	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
	}
	
	public void run() {
		gameSetup();
	}
	
	public void gameSetup() {
		cli.setupScreen(player);
		
		//TODO: Display the starting monsters and let you choose them
	}
}