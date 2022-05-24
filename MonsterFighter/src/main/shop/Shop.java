package main.shop;

import java.util.ArrayList;
import java.util.Random;

import main.game.GameController;
import main.game.Player;
import main.monsters.*;
import main.items.*;

public class Shop {
	private ArrayList<Item> shopItems;
	private ArrayList<Monster> shopMonsters;
	private GameController game;
	private Random rng;
	
	public Shop(GameController game) {
		shopItems = new ArrayList<Item>();
		shopMonsters = new ArrayList<Monster>();
		this.game = game;
		rng = new Random();
		
		shopRefresh();
	}
	
	public ArrayList<Monster> getShopMonsters() {
		return shopMonsters;
	}
	
	public ArrayList<Item> getShopItems() {
		return shopItems;
	}
	
	
	//Resets all the items in the shop. Typically happens overnight
	public void shopRefresh() {
		refreshMonsters();
		this.shopItems = refreshItems();
	}
	
	public ArrayList<Item> refreshItems() {
		shopItems.clear();
		
		int numItems = rng.nextInt(4, 7);
		int currentDay = game.getCurrentDay();
		
		int maxItemValue;
		
		if (currentDay < 5) {
			maxItemValue = 3;
		} else if (currentDay < 10) {
			maxItemValue = 5;
		} else {
			maxItemValue = 6; 
		}
		
		for (int i = 0; i < numItems; i++) {
			int itemType = rng.nextInt(maxItemValue);
			Item rngItem = null;
			
			
			switch (itemType) {
			case 0:
				rngItem = new InstantHealthPotion();
				break;
			case 1:
				rngItem = new MysterySoup();
				break;
			case 2:
				rngItem = new RagePotion();
				break;
			case 3:
				rngItem = new MomsSpaghetti();
				break;
			case 4:
				rngItem = new BezerkerPotion();
				break;
			case 5:
				rngItem = new HeartFruit();
				break;
			}
			
			shopItems.add(rngItem);
		}
		
		return shopItems;
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
	
	//Used to purchase anything
	public void purchaseItem(Item item, Player player) {
		//TODO: check there's space on players inventory
		
		if (player.getGold() >= item.getPrice()) {
			player.setGold(player.getGold() - item.getPrice());
			player.getInventory().addToInventory(item);
			this.shopItems.remove(item);
		} else {
			System.out.println("ERROR: YOU DON'T HAVE ENOUGH GOLD!");
		}
	}
	
	public void returnItem(Item item, Player player) {
		player.setGold(player.getGold() + item.getReturnPrice());
		player.getInventory().removeFromInventory(item);
	}
	
	public void purchaseMonster(Monster monster, Player player) {
		if (player.getGold() >= monster.getPrice()) {
			player.setGold(player.getGold() - monster.getPrice());
			player.getMonsterTeam().addMonsterToTeam(monster);
			this.shopMonsters.remove(monster);
		} else {
			System.out.println("ERROR: YOU DON'T HAVE ENOUGH GOLD!");
		}
	}
	
	public void returnMonster(Monster monster, Player player) {
		player.setGold(player.getGold() + monster.getReturnPrice());
		player.getMonsterTeam().removeMonsterFromTeam(monster);
	}
	
}
