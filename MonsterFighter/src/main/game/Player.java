package main.game;

import java.util.ArrayList;
import main.items.*;
import main.monsters.*;

public class Player {
	
	static final int EASY_START_GOLD = 500;
	static final int HARD_START_GOLD = 300;
	
	private String name;
	private int gold;
	private int score = 0;
	
	MonsterTeam monsterTeam;
	Inventory inventory;
	
	
	public Player() {
		monsterTeam = new MonsterTeam();
		inventory = new Inventory();
	}
	
	/**
	 * @return the players chosen name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name sets the name to what the player chose
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the players total amount of current gold
	 */
	public int getGold() {
		return gold;
	}
	/**
	 * @param gold the amount of gold to set for the players score
	 */
	public void setGold(int gold) {
		this.gold = gold;
	}
	/**
	 * @return the players current total score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set for the player
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setupValues(String name, int difficulty, Monster startingMonster) {
		this.setName(name);
		
		//Sets the starting gold based on the chosen difficulty
		if (difficulty == 0) {
			this.setGold(EASY_START_GOLD);
		} else {
			this.setGold(HARD_START_GOLD);
		}
		
		//Adds chosen starting monster to team
		monsterTeam.addMonsterToTeam(startingMonster);
	}
	
	public String toString() {
		String niceString = """
				Name: %s
				Score: %d
				Gold: %d
				Monsters: %s
				Inventory: -----
				""";
		return String.format(niceString, this.getName(), this.getScore(), this.getGold(), monsterTeam.getMonsterTeam());
	}
}
