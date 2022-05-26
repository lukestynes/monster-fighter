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
		this.battleMonsters = new ArrayList<Monster>();

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
			numMonsters = rng.nextInt(2) + 1;
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
			int monsterLevel;
			
			if (maxLevel == 1) {
				monsterLevel = 1;	
			} else if (minLevel == 4) {
				monsterLevel = 4;
			} else {
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
	
	public boolean fightBattle(ArrayList<Monster> playerTeam ) {
		ArrayList<Monster> battleMonsters = this.getBattleMonsters();
		
		System.out.println("DEBUG: CLASH BANG BATTLE");
		
		for (int i = 0; i < this.getBattleMonsters().size(); i++) {
			boolean fightOn = true;
			if (playerTeam.size() > 0) {
				while (fightOn) {
					if (playerTeam.size() > 0) {
						//PLAYER STRIKES
						System.out.println("PLAYER SWINGS");
						battleMonsters.get(i).takeDamage(playerTeam.get(i).getDamage());
						System.out.println("MONSTER HEALTH: " + battleMonsters.get(i).getCurrentHealth());
						
						//HAS ANYTHING HAPPENED?
						
						if (battleMonsters.get(i).getFainted()) {
							System.out.println("MONSTER FAINTS");
							defeatMonster(battleMonsters.get(i));
							
							fightOn = false;
						}
					}
					
					if (battleMonsters.size() > 0) {
						//MONSTER STRIKES\
						System.out.println("MONSTER SWINGS");
						
						playerTeam.get(i).takeDamage(battleMonsters.get(i).getDamage());
//						int index = game.getPlayer().getMonsterTeam().getMonsterTeamList().indexOf(playerTeam.get(i));
//						game.getPlayer().getMonsterTeam().getMonsterTeamList().get(index).takeDamage(battleMonsters.get(i).getDamage());
						

						
						System.out.println("Player HEALTH: " + playerTeam.get(i).getCurrentHealth());
						
						//HAS ANYTHING HAPPENED?
						if (playerTeam.get(i).getFainted()) {
							fightOn = false;
							System.out.println("PLAYER FAINTS");
							playerTeam.remove(playerTeam.get(i));
						}
					}
				}
			} 
		}
		
		if (this.getBattleMonsters().size() == 0) {//Battle won
			System.out.println("BATTLE WON");
			this.battleEndWin(playerTeam);
			return true;
		} else {//Battle lost
			System.out.println("BATTLE LOST");
			this.battleEndLoss();
			return false;
		}
		
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
	
	public void battleEndWin(ArrayList<Monster> playerTeam) {		
		if (game.getDifficulty() == 1) {
			this.setGold(this.getGold()/2);
		}
		
		game.getPlayer().setGold(this.getGold());
		game.getPlayer().setScore(this.getScore());
		
		for (Monster monster: game.getPlayer().getMonsterTeam().getMonsterTeamList()) {
			int index = playerTeam.indexOf(monster);
			
			if (playerTeam.get(index).getCurrentHealth() < 0) {
				monster.setCurrentHealth(0);
				monster.setFainted(true);
			} else {
				monster.setCurrentHealth(playerTeam.get(index).getCurrentHealth());
			}
		}
		
		game.getBattleController().addBattleWon();
	}
	
	public void battleEndLoss() {
		for (Monster monster: game.getPlayer().getMonsterTeam().getMonsterTeamList()) {
			monster.setCurrentHealth(0);
			monster.setFainted(true);
		}
	}
}
