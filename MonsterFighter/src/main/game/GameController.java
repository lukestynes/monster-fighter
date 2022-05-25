package main.game;

import main.ui.*;
import main.shop.Shop;
import main.game.*;

import java.util.ArrayList;

import javax.swing.JFrame;

import main.monsters.*;
import main.randomEvents.*;

public class GameController {
	GUIController gui;
	Player player;
	Shop shop;
	RandomEvents randomEvents;
	
	private int gameLength;
	private int currentDay = 1;
	private int difficulty;
	
	public GameController() {
		gui = new GUIController(this);
		randomEvents = new RandomEvents(this);
		shop = new Shop(this);
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
		gui.launchSetupScreen();
	}
	
	public ArrayList<Monster> getStartingMonsters() {
		MonsterTeam temporaryTeam = new MonsterTeam();
		return temporaryTeam.generateRandomMonsters(currentDay, 3);
	}
	
	public void setupValues(String name, int length, int difficulty, Monster startingMonster) {
		this.setDifficulty(difficulty);
		this.setGameLength(length);
		
		player = new Player(name, difficulty, startingMonster);
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