package main.game;

import java.util.ArrayList;
import java.util.Random;

import main.monsters.AirMonster;
import main.monsters.EarthMonster;
import main.monsters.ElectricityMonster;
import main.monsters.FireMonster;
import main.monsters.IceMonster;
import main.monsters.Monster;
import main.monsters.WaterMonster;

public class MonsterTeam {
	private ArrayList<Monster> monsterTeam;
	
	/**
	 * Constructs a blank monster team list.
	 */
	public MonsterTeam() {
		monsterTeam = new ArrayList<Monster>();
	}
	
	/**
	 * Adds a given monster to the players team, as long as the capacity isn't reached.
	 * @param monster the monster being added to the team.
	 */
	public void addMonsterToTeam(Monster monster) {
		//TODO: Update to properly limit the monster team to a size of 4
		if (monsterTeam.size() < 4) {
			monsterTeam.add(monster);
		}
		
	}
	
	/**
	 * Removes a specified monster from the players monster team.
	 * @param monster the monster being removed from the team.
	 */
	public void removeMonsterFromTeam(Monster monster) {
		//TODO: maybe look at setting up an equals method properly for monster to handle the comparison
		this.monsterTeam.remove(monster);
	}
	
	/**
	 * Returns the monster team list incase it is needed by other game objects.
	 * @return monsterTeam an ArrayList<Monster> that contains all of the players current monsters.
	 */
	public ArrayList<Monster> getMonsterTeamList() {
		return monsterTeam;
	}
	
	/**
	 * Gets the total amount of faints between all the monsters on the team.
	 * 
	 * This property is used by the random event generator to change the probability of a monster leaving.
	 * @return totalFaints an int of the total faints between all monsters on the team.
	 */
	public int getTotalTeamFaints() {
		int faintCounter = 0;
		
		for (Monster monster: monsterTeam) {
			faintCounter += monster.getFaintCount();
		}
		
		return faintCounter;
	}
	
	/**
	 * Returns the monster on the team with the lowest health. It will be the first to leave in a random event.
	 * @return monster the monster on the team with the lowest current health.
	 */
	public Monster weakestMonster() {
		//Returns the monster who has fainted the most.
		
		int mostFaints = -1;
		Monster weakestMonster = null;
		for (Monster monster: monsterTeam) {
			if (monster.getFaintCount() > mostFaints) {
				mostFaints = monster.getFaintCount();
				weakestMonster = monster;
			}
		}		
		return weakestMonster;
	}
	
	public Monster strongestMonster() {
		int leastFaints = 1000;
		
		Monster strongestMonster = null;
		
		for (Monster monster: monsterTeam) {
			if (monster.getFaintCount() < leastFaints) {
				leastFaints = monster.getFaintCount();
				strongestMonster = monster;
			}
		}
		return strongestMonster;
	}
	
	/**
	 * Returns how many empty slots are left on the monster team.
	 * @return emptySlots an int of remaining slots on the monster team.
	 */
	public int getEmptySlots() {
		return 4 - monsterTeam.size();
	}
	
	/**
	 * Generates a specified amount of random monsters depending on the stage of the game.
	 * @param currentDay int the current ingame day (affects max level)
	 * @param numMonsters int the total amount of monsters to generate.
	 * @return monsterList an ArrayList<Monster> of the freshly generated monsters.
	 */
	public ArrayList<Monster> generateRandomMonsters(int currentDay, int numMonsters) {
		Random rng = new Random();
		ArrayList<Monster> randomMonsters = new ArrayList<Monster>();
		int minLevel, maxLevel;
		
		//Depending on the current day only certain level monsters can show up
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
			
			randomMonsters.add(rngMonster);
		}
		
		return randomMonsters;
	}
}
