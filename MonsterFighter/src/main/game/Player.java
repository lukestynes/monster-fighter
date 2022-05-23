package main.game;

import java.util.ArrayList;
import main.items.*;
import main.monsters.*;

public class Player {
	
	private String name;
	private int gold;
	private int score;
	
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

}
