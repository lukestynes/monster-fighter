package main.game;

import java.util.ArrayList;

import main.items.Item;
import main.monsters.Monster;

public class Inventory {
	
	private ArrayList<Item> inventory;
	
	public Inventory() {
		inventory =  new ArrayList<Item>();
	}
	
	public void addToInventory(Item item) {
		this.inventory.add(item);
	}
	
	public void removeFromInventory(Item item) {
		this.inventory.remove(item);
	}
	
	public ArrayList<Item> getInventoryList() {
		return inventory;
	}
	
	//Applies the selected item on the monster.
	public void useItem(Item item, Monster monster) {
		item.useItemOnMonster(monster);
		this.removeFromInventory(item);
	}
}
