package main.game;

import java.util.ArrayList;

import main.monsters.Monster;

public class MonsterTeam {
	private ArrayList<Monster> monsterTeam;
	
	public MonsterTeam() {
		monsterTeam = new ArrayList<Monster>();
	}
	
	public void addMonsterToTeam(Monster monster) {
		//TODO: Update to properly limit the monster team to a size of 4
		if (monsterTeam.size() < 4) {
			monsterTeam.add(monster);
		} else {
			System.out.println("ERROR: MAX TEAM SIZE ALREADY REACHED");
		}
		
	}
	
	public void removeMonsterFromTeam(Monster monster) {
		//TODO: maybe look at setting up an equals method properly for monster to handle the comparison
		this.monsterTeam.remove(monster);
	}
	
	public ArrayList<Monster> getMonsterTeamList() {
		return monsterTeam;
	}
	
	public int getTotalTeamFaints() {
		int faintCounter = 0;
		
		for (Monster monster: monsterTeam) {
			faintCounter += monster.getFaintCount();
		}
		
		return faintCounter;
	}
	
	public int getEmptySlots() {
		return 4 - monsterTeam.size();
	}
}
