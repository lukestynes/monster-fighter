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
	
	/**
	 * Constructs a new shop controller
	 * @param game the game instance
	 */
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
	
	
	/**
	 * Resets all of the items and monsters in the shop.
	 */
	public void shopRefresh() {
		refreshMonsters();
		this.shopItems = refreshItems();
	}
	
	/**
	 * Completely replaces all the items in the shop randomly.
	 * @return a list of the new refreshed items
	 */
	public ArrayList<Item> refreshItems() {
		shopItems.clear();
		
		int numItems = rng.nextInt(2) + 3;
		int currentDay = game.getCurrentDay();
		
		
		//Certain items won't appear till later in the game as given by this chart
		int maxItemValue;
		
		if (currentDay < 5) {
			maxItemValue = 3;
		} else if (currentDay < 10) {
			maxItemValue = 5;
		} else {
			maxItemValue = 6; 
		}
		
		//This then selects which item to generate
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
	
	/**
	 * Refreshes the monsters available in the shop.
	 */
	public void refreshMonsters() {
		//Dump all the previous monsters in the shop before repopulating
		shopMonsters.clear();
		
		int minLevel, maxLevel;
		//Randomly decides how many monsters to display that day (between 3 and 5)
		int numMonsters = rng.nextInt(2) + 3;
		
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
		
		//This prevents an out of bound error for the random generation
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
			
			
			//Selecting what type of monster to generate
			//Yes this code should really be kept in a class somewhere else but I ran out of time.
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
	
	/**
	 * Purchase an item from the shop.
	 * @param item what is being purchased
	 * @param player the player instance buying it
	 * @return true or false depending on if the purchase was successful
	 */
	public boolean purchaseItem(Item item, Player player) {
		//Checks the players inventory space
		if (player.getInventory().getInventoryList().size() < 10) {
			//Checks the player can afford it
			if (player.getGold() >= item.getPrice()) {
				player.setGold(player.getGold() - item.getPrice());
				player.getInventory().addToInventory(item);
				this.shopItems.remove(item);
				return true;
			} return false;
		} return false;
	}
	
	/**
	 * Returns an item to the shop
	 * @param item the item being returned
	 * @param player the player returning teh item
	 */
	public void returnItem(Item item, Player player) {
		player.setGold(player.getGold() + item.getReturnPrice());
		player.getInventory().removeFromInventory(item);
	}
	
	/**
	 * Purchases a monster from the shop
	 * @param monster the monster being purchased
	 * @param player the player doing the purchasing
	 * @return true or false if the purchase was successful.
	 */
	public boolean purchaseMonster(Monster monster, Player player) {
		//Checks the team isn't full
		if (player.getMonsterTeam().getMonsterTeamList().size() < 4) {
			//Checks the player can afford it
			if (player.getGold() >= monster.getPrice()) {
				player.setGold(player.getGold() - monster.getPrice());
				player.getMonsterTeam().addMonsterToTeam(monster);
				this.shopMonsters.remove(monster);
				return true;
			} return false;
		} return false;
	}
	
	/**
	 * Returns a monster to the shop in exchange for money
	 * @param monster the monster being returned
	 * @param player the player returning
	 */
	public void returnMonster(Monster monster, Player player) {
		player.setGold(player.getGold() + monster.getReturnPrice());
		player.getMonsterTeam().removeMonsterFromTeam(monster);
	}
	
}
