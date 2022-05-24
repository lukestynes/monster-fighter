package main.game;

import main.ui.*;
import main.monsters.*;

public class GameController {
	CLInterface cli;
	Player player;
	
	//Constants for how many monsters there are to choose from at the start
	private Monster[] easyStartingMonsters = {new FireMonster(), new WaterMonster(), new IceMonster(), new ElectricityMonster()};
	private Monster[] hardStartingMonsters = {new WaterMonster(), new AirMonster(), new EarthMonster()};
	
	private int gameLength;
	private int currentDay = 1;
	private int difficulty;
	
	private Boolean running = true;
	
	
	public GameController() {
		cli = new CLInterface();
	}
	
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
	
	public Player getPlayer() {
		return player;
	}
	
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run(game);
	}
	
	public void run(GameController game) {
		gameSetup(game);
		cliGameLoop(game);
	}
	
	public void gameSetup(GameController game) {
		player = cli.setupScreen(game, easyStartingMonsters, hardStartingMonsters);
	}
	
	public void cliGameLoop(GameController game) {
		do {
			cli.menuScreen(player, game);
		} while (running);
		
	}
}