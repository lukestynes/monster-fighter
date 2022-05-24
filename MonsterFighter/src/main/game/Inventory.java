package main.game;

import java.util.ArrayList;

import main.items.Item;

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
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
}
