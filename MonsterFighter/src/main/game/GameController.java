package main.game;

import main.ui.*;

public class GameController {
	CLInterface cli;
	Player player;
	
	private int gameLength;
	private int currentDay = 1;
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
		game.run(game);
	}
	
	public void run(GameController game) {
		gameSetup(game);
	}
	
	public void gameSetup(GameController game) {
		cli.setupScreen(player, game);
		
		//TODO: Display the starting monsters and let you choose them
	}
}