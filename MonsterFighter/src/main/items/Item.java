package main.items;

public class Item {
	
	private String name;
	
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
	
}
