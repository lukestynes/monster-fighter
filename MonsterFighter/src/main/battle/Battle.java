package main.battle;

import java.util.ArrayList;
import java.util.Random;

import main.game.GameController;
import main.monsters.AirMonster;
import main.monsters.EarthMonster;
import main.monsters.ElectricityMonster;
import main.monsters.FireMonster;
import main.monsters.IceMonster;
import main.monsters.Monster;
import main.monsters.WaterMonster;

public class Battle {
	private GameController game;
	private Random rng;
	
	private ArrayList<Monster> battleMonsters;
	private int gold = 0;
	private int score = 0;
	private final int[] EASY_SCORES = {50, 100, 150, 200};
	private final int[] HARD_SCORES = {100, 150, 200, 250};
	
	
	public Battle(GameController game) {
		this.game = game;
		this.rng = new Random();
		
		generateBattleMonsters();
	}
	
	public ArrayList<Monster> getBattleMonsters() {
		return battleMonsters;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void generateBattleMonsters() {
		int currentDay = game.getCurrentDay();
		int minLevel, maxLevel;
		int numMonsters;
		
		
		if (currentDay < 7) {
			//1-2 monsters for days 1-6
			numMonsters = rng.nextInt(2);
		} else {
			//2-3 monsters for days 7-15
			numMonsters = rng.nextInt(1) + 2;
		}
		
		if (currentDay < 3) {
			minLevel = maxLevel = 1;
		} else if (currentDay < 6) {
			minLevel = 1;
			maxLevel = 2;
		} else if (currentDay < 9) {
			minLevel = 2;
			maxLevel = 3;
		} else if (currentDay < 12) {
			minLevel = 3;
			maxLevel = 4;
		} else {
			minLevel = maxLevel = 4;
		}
		
		for (int i = 0; i < numMonsters; i++) {
			int monsterType = rng.nextInt(6);
			int monsterLevel = 1;
			
			if (maxLevel != 1) {
				monsterLevel = rng.nextInt(maxLevel-minLevel) + minLevel;
			} 
			
			Monster rngMonster = null;
			
			switch (monsterType) {
			case 0:
				rngMonster = new AirMonster(monsterLevel);
				break;
			case 1:
				rngMonster = new EarthMonster(monsterLevel);
				break;
			case 2:
				rngMonster = new ElectricityMonster(monsterLevel);
				break;
			case 3:
				rngMonster = new FireMonster(monsterLevel);
				break;
			case 4:
				rngMonster = new IceMonster(monsterLevel);
				break;
			case 5:
				rngMonster  = new WaterMonster(monsterLevel);
				break;
			}
			
			this.battleMonsters.add(rngMonster);
		}
	}
	
	public void fightBattle(ArrayList<Monster> playerTeam ) {
		ArrayList<Monster> battleMonsters = this.getBattleMonsters();
		
		for (int i = 0; i < this.getBattleMonsters().size(); i++) {
			if (playerTeam.size() > 0) {
				//PLAYER STRIKES
				battleMonsters.get(i).takeDamage(playerTeam.get(i).getDamage());
				
				//HAS ANYTHING HAPPENED?
				
				if (battleMonsters.get(i).getFainted()) {
					defeatMonster(battleMonsters.get(i));
				}
			}
			
			if (battleMonsters.size() > 0) {
				//MONSTER STRIKES
				playerTeam.get(i).takeDamage(battleMonsters.get(i).getDamage());
				
				//HAS ANYTHING HAPPENED?
				if (playerTeam.get(i).getFainted()) {
					playerTeam.remove(playerTeam.get(i));
				}
			}
		}
		this.battleEnd();
	}
	
	
	
	public void defeatMonster(Monster monster) {
		
		this.setGold(this.getGold() + monster.getReturnPrice());
		
		if (game.getDifficulty() == 0) {
			this.setScore(this.getScore() + EASY_SCORES[monster.getLevel()-1]);
		} else {
			this.setScore(this.getScore() + HARD_SCORES[monster.getLevel()-1]);
		}
		
		this.getBattleMonsters().remove(monster);
	}
	
	public void battleEnd() {
		
		if ()
		
		
		if (game.getDifficulty() == 1) {
			this.setGold(this.getGold()/2);
		}
		
		game.getPlayer().setGold(this.getGold());
		game.getPlayer().setScore(this.getScore());
	}
}
