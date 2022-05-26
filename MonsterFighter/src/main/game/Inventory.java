package main.game;

import java.util.ArrayList;

import main.items.Item;
import main.monsters.Monster;

public class Inventory {
	
	private ArrayList<Item> inventory;
	
	/**
	 * Constructs a new blank inventory for the player to store items.
	 */
	public Inventory() {
		inventory =  new ArrayList<Item>();
	}
	
	/**
	 * Adds an item purchased from the shop to the players inventory
	 * @param item the item that was purchased from the shop
	 */
	public void addToInventory(Item item) {
		this.inventory.add(item);
	}
	
	/**
	 * Removes a given item from a players inventory.
	 * @param item the thing to be removed from the players inventory.
	 */
	public void removeFromInventory(Item item) {
		this.inventory.remove(item);
	}
	
	/**
	 * Gets a copy of the inventory list if needed by other parts of the game.
	 * @return inventoryList an ArrayList<Item> of the players current inventory.
	 */
	public ArrayList<Item> getInventoryList() {
		return inventory;
	}
	
	/**
	 * Takes a given item and monster and uses that item on the monster.
	 * @param item the item being used.
	 * @param monster the monster the item is being used on.
	 */
	public void useItem(Item item, Monster monster) {
		item.useItemOnMonster(monster);
		this.removeFromInventory(item);
	}
}
