package main.game;

import main.ui.*;
import main.shop.Shop;

import java.util.ArrayList;

import main.monsters.*;
import main.randomEvents.*;

public class GameController {
	CLInterface cli;
	Player player;
	Shop shop;
	RandomEvents randomEvents;
	
	//Constants for how many monsters there are to choose from at the start
	private Monster[] easyStartingMonsters = {new FireMonster(), new WaterMonster(), new IceMonster(), new ElectricityMonster()};
	private Monster[] hardStartingMonsters = {new WaterMonster(), new AirMonster(), new EarthMonster()};
	
	private int gameLength;
	private int currentDay = 1;
	private int difficulty;
	
	private Boolean running = true;
	
	public GameController() {
		cli = new CLInterface();
		randomEvents = new RandomEvents(this);
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
	
	public Shop getShop() {
		return shop;
	}
	
	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
	}
	
	public void run() {
		shop = new Shop(this);
		player = cli.setupScreen(this, easyStartingMonsters, hardStartingMonsters);
		
		//SIMPLE GAME LOOP FOR JUST THE CLI
		do {
			cli.menuScreen(player, this);
		} while (running);
	}
	
	public void nightReset() {
		ArrayList<Monster> monstersList = player.getMonsterTeam().getMonsterTeamList();
		
		//Removes any temporary buffs given to the monsters during the day
		for (Monster monster: monstersList) {
			monster.nightResetMonster();
		}
		
		//Runs all 3 of the random events.
		randomEvents.nightTimeEvents();
		shop.shopRefresh();
		this.increaseCurrentDay();
	}
}