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
	
	public int getGameLength() {
		return gameLength;
	}

	public void setGameLength(int gameLength) {
		this.gameLength = gameLength;
	}

	public int getCurrentDay() {
		return currentDay;
	}
	
	public void increaseCurrentDay() {
		this.currentDay++;
	}

	public int getDifficulty() {
		return difficulty;
	}

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