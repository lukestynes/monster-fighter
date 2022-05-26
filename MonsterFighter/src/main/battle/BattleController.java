package main.battle;

import java.util.ArrayList;

import main.game.GameController;

public class BattleController {
	private GameController game;
	
	private ArrayList<Battle> battleList;
	private int battlesWonToday = 0;
	
	public BattleController(GameController game) {
		this.game = game;
		battleList = new ArrayList<Battle>();
		createDaysBattles();
	}
	
	public void createDaysBattles() {
		battleList.clear();
		battlesWonToday = 0;
		
		//There are always 3 battles
		int numBattles = 3;
		
		for (int i = 0; i < numBattles; i++) {
			battleList.add(new Battle(game));
		}
	}
	
	public ArrayList<Battle> getBattleList() {
		return this.battleList;
	}
	
	public void addBattleWon() {
		this.battlesWonToday++;
	}
	
	public int getBattlesWonToday() {
		return this.battlesWonToday;
	}
}
