package main.items;

import main.game.Player;
import main.shop.Purchasable;

public class Item implements Purchasable {
	
	private String name;
	private String description;
	
	private int price;
	private int returnPrice;
	
	private int instantHealthBoost = 0;
	private int damageBoost = 0;
	private int healAmountBoost = 0;
	private int defenseBoost = 0;
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
	
	public int getDefenseBoost() {
		return defenseBoost;
	}
	
	public void setDefenseBoost(int defenseBoost) {
		this.defenseBoost = defenseBoost;
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
		return String.format(thing, this.getName(), this.getInstantHealthBoost(), this.getDamageBoost(), this.getHealAmountBoost(), this.getDefenseBoost(), this.getMaxHealthBoost());
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
