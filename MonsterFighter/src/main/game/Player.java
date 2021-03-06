package main.game;

import main.monsters.*;

public class Player {
	
	static final int EASY_START_GOLD = 500;
	static final int HARD_START_GOLD = 300;
	
	private String name;
	private int gold;
	private int score = 0;
	
	MonsterTeam monsterTeam;
	Inventory inventory;
	
	
	/**
	 * Constructs a new player with the given values.
	 * @param name String the name of the player.
	 * @param difficulty int the difficulty of the game.
	 * @param startingMonster Monster the selected starting monster for the team.
	 */
	public Player(String name, int difficulty, Monster startingMonster) {
		monsterTeam = new MonsterTeam();
		inventory = new Inventory();
		
		this.setName(name);
		
		if (difficulty == 0) {
			this.setGold(EASY_START_GOLD);
		} else {
			this.setGold(HARD_START_GOLD);
		}
		
		monsterTeam.addMonsterToTeam(startingMonster);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public MonsterTeam getMonsterTeam() {
		return monsterTeam;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	/**Returns a well formatted string of the players central info
	 * @return string string of the players info
	 */
	public String toString() {
		String niceString = """
				Name: %s
				Score: %d
				Gold: %d
				Monsters: -----
				Inventory: -----
				""";
		
		return String.format(niceString, this.getName(), this.getScore(), this.getGold());
	}
}
