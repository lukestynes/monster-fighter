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
		
		if (monsterTeam.contains(monster)) {
			monsterTeam.remove(monster);
		} else {
			System.out.println("ERROR: MONSTER NOT ON TEAM");
		}
	}
	
	public ArrayList<Monster> getMonsterTeam() {
		return monsterTeam;
	}
}
