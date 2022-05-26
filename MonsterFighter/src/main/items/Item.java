package main.items;

import main.monsters.Monster;

public class Item {
	
	private String name;
	private String description;
	
	private int price;
	private int returnPrice;
	
	private int instantHealthBoost = 0;
	private int damageBoost = 0;
	private int healAmountBoost = 0;
	private int defenceBoost = 0;
	private int maxHealthBoost = 0;
	
	public String getName() {
		return name;
	}
	
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
	
	public int getInstantHealthBoost() {
		return instantHealthBoost;
	}
	
	public void setInstantHealthBoost(int instantHealthBoost) {
		this.instantHealthBoost = instantHealthBoost;
	}
	
	public int getDamageBoost() {
		return damageBoost;
	}
	
	public void setDamageBoost(int damageBoost) {
		this.damageBoost = damageBoost;
	}
	
	public int getHealAmountBoost() {
		return healAmountBoost;
	}
	
	public void setHealAmountBoost(int healAmountBoost) {
		this.healAmountBoost = healAmountBoost;
	}
	
	public int getDefenceBoost() {
		return defenceBoost;
	}
	
	public void setDefenceBoost(int defenseBoost) {
		this.defenceBoost = defenseBoost;
	}
	
	public int getMaxHealthBoost() {
		return maxHealthBoost;
	}
	
	public void setMaxHealthBoost(int maxHealthBoost) {
		this.maxHealthBoost = maxHealthBoost;
	}
	
	public String toString() {
		String thing = """
				Name: %s
				Instant Health Boost: %d
				Damage Boost: %d
				Heal Amount Boost: %d
				Defence Boost: %d
				Max Health Boost: %d
				""";
		return String.format(thing, this.getName(), this.getInstantHealthBoost(), this.getDamageBoost(), this.getHealAmountBoost(), this.getDefenceBoost(), this.getMaxHealthBoost());
	}
	
	/**
	 * Applies the current item onto a monster, improving the relevant stats depending on the item.
	 * @param monster Monster the monster that is being boosted by the item.
	 */
	public void useItemOnMonster(Monster monster) {
		monster.setCurrentHealth(monster.getCurrentHealth() + this.getInstantHealthBoost());
		monster.setDamage(monster.getDamage() + this.getDamageBoost());
		monster.setHealAmount(monster.getHealAmount() + this.getHealAmountBoost());
		monster.setDefence(monster.getDefence() + this.getDefenceBoost());
		monster.setMaxHealth(monster.getMaxHealth() + this.getMaxHealthBoost());
	}
}
