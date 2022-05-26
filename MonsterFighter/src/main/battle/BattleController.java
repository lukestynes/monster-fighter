package main.battle;

import java.util.ArrayList;

import main.game.GameController;

public class BattleController {
	private GameController game;
	
	private ArrayList<Battle> battleList;
	private int battlesWonToday = 0;
	
	/**
	 * Constructs a new battle controller for a game.
	 * @param game the game controller instance running the game.
	 */
	public BattleController(GameController game) {
		this.game = game;
		battleList = new ArrayList<Battle>();
		createDaysBattles();
	}
	
	/**
	 * This is run to generate 3 new random battles for the day.
	 */
	public void createDaysBattles() {
		battleList.clear();
		battlesWonToday = 0;
		
		//There are always 3 battles
		int numBattles = 3;
		
		for (int i = 0; i < numBattles; i++) {
			battleList.add(new Battle(game));
		}
	}
	
	/**
	 * Returns the list of battles for the day
	 * @return battlelist the list of todays battles
	 */
	public ArrayList<Battle> getBattleList() {
		return this.battleList;
	}
	
	/**
	 * Increments the battle won tracker for each day.
	 */
	public void addBattleWon() {
		this.battlesWonToday++;
	}
	
	/**
	 * Returns the battles won that day.
	 * @return battlesWon an int of how many battles the player won.
	 */
	public int getBattlesWonToday() {
		return this.battlesWonToday;
	}
}
