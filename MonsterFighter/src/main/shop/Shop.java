package main.shop;

import java.util.ArrayList;
import java.util.Random;

import main.game.GameController;
import main.monsters.*;
import main.items.*;

public class Shop {
	private ArrayList<Item> shopItems;
	private ArrayList<Monster> shopMonsters;
	private GameController game;
	private Random rng;
	
	public Shop() {
		shopItems = new ArrayList<Item>();
		shopMonsters = new ArrayList<Monster>();
		
		rng = new Random();
	}
	
	//Resets all the items in the shop. Typically happens overnight
	public void shopRefresh() {
		refreshMonsters();
	}
	
	public void refreshItems() {
		
	}
	
	public void refreshMonsters() {
		//Dump all the previous monsters in the shop before repopulating
		shopMonsters.clear();
		
		int minLevel, maxLevel;
		//Randomly decides how many monsters to display that day (between 3 and 5)
		int numMonsters = rng.nextInt(3, 6);
		
		int currentDay = game.getCurrentDay();
		
		
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
			int monsterLevel = rng.nextInt(minLevel, maxLevel + 1);
			
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
			
			shopMonsters.add(rngMonster);
		}
	}
}
