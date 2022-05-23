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
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Monster> monsterTeam = new ArrayList<Monster>();
	
	
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
	
	//TODO: Methods for managing the inventory
	//TODO: methods for managing the monster team
	
	
	public void setupValues(String name, int difficulty) {
		this.setName(name);
		
		//Sets the starting gold based on the chosen difficulty
		if (difficulty == 0) {
			this.setGold(EASY_START_GOLD);
		} else {
			this.setGold(HARD_START_GOLD);
		}
		
		//TODO: add the chosen monster to the starting team
	}
}
