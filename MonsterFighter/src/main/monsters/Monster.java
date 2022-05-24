package main.monsters;

import main.game.Player;
import main.shop.Purchasable;

public class Monster implements Purchasable {
	private String name;
	private String description;
	
	private int price;
	private int returnPrice;
	
	
	private Boolean fainted = false;
	private int level = 1;
	private String type;
	
	private int maxHealth;
	private int healAmount;
	private int currentHealth;
	
	private int defence;
	private int damage;
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getReturnPrice() {
		return returnPrice;
	}
	
	public void setReturnPrice(int returnPrice) {
		this.returnPrice = returnPrice;
	}
	
	
	public Boolean getFainted() {
		return fainted;
	}

	public void setFainted(Boolean fainted) {
		this.fainted = fainted;
	}
	
	public int getMaxHealth() {
		return maxHealth;
	}
		
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	

	public int getHealAmount() {
		return healAmount;
	}
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getDefence() {
		return defence;
	}	

	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	/**
	 * Generates a random name for the monster chosen from a list of names
	 * @return the monsters name
	 */
	public String generateName() {
		//TODO: implement the random name generation
		
		return "";
	}
	
	public String toString() {
		String thing = """
				Name: %s
				Type: %s
				Description: %s
				Health: %d
				Defence: %d
				Damage: %d
				Heal Amount: %d
				""";
		return String.format(thing, this.getName(), this.getType(), this.getDescription(), this.getMaxHealth(), this.getDefence(), this.getDamage(), this.getHealAmount());
	}

	@Override
	public void playerPurchase(Player player, int price, Object bought) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerReturn(Player player, int returnPrice, Object returned) {
		// TODO Auto-generated method stub
		
	}
	
}
