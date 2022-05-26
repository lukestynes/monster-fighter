package main.monsters;

import java.util.Random;

public class Monster {
	private String name;
	private String description;

	private int price;
	private int returnPrice;


	private Boolean fainted = false;
	private int faintCount = 0;

	private int level = 1;
	private String type;

	private int maxHealth;
	private int healAmount;
	private int currentHealth;

	private int defence;
	private int damage;

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

	public int getModifiedReturnPrice() {
		return (1 - (this.getCurrentHealth()/this.getMaxHealth())) * this.getReturnPrice();
	}

	public Boolean getFainted() {
		return fainted;
	}

	public void setFainted(Boolean fainted) {
		this.fainted = fainted;

		//Every time a monster faints it is added to the tally, as it changes probabilities of random events.
		if (fainted) {
			this.incFaintCount();
		}
	}

	public void setFaintCount(int faintCount) {
		this.faintCount = faintCount;
	}

	public void incFaintCount() {
		this.faintCount++;
	}

	public int getFaintCount() {
		return faintCount;
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
		if (currentHealth < 0) {
			this.currentHealth = 0;
			this.setFainted(true);
		}

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
	 * Makes the monster take damage depending on their current defence value. It will be lowered by the defence.
	 * @param damage the damage dealt by the attacking monster.
	 */
	public void takeDamage(int damage) {
		this.setCurrentHealth(this.getCurrentHealth() - (damage - this.getDefence()));
		if (this.getCurrentHealth() <= 0) {
			this.setFainted(true);
		}
	}

	/**
	 * Generates a random name for the monster chosen from a list of names
	 * @return name a random name for the monsters.
	 */
	public String generateName() {
		String[] nameList = {"Callie","Scooter","Rocky","Belle","Luna","Peanut","Tigger","Izzy","Sadie","Fred","Zeus","Lady Gaga","Boots","Kitty","Jasper","Boomer","Coco","Lily","Cher","Cali","Oprah","Sugar","Garfield","Pumpkin","Simba","Misty","Ginger","Maggie","Oliver","Charlie"};
		Random rng = new Random();
		return nameList[rng.nextInt(30)];
	}

	@Override
	public String toString() {
		String thing = """
				Name: %s
				Type: %s
				Level: %s
				Description: %s
				Health: %d
				Defence: %d
				Damage: %d
				Heal Amount: %d
				FAINTED: %s
				Return Price: %d
				""";
		String temp;
		
		if (this.getFainted()) {
			temp = "TRUE";
		} else {
			temp = "FALSE";
		}
		return String.format(thing, this.getName(), this.getLevel(), this.getType(), this.getDescription(), this.getCurrentHealth(), this.getDefence(), this.getDamage(), this.getHealAmount(), temp, this.getReturnPrice());
	}
	
	/**
	 * Returns a string representation of the monster for the setup screen
	 * @return a string of monster information
	 */
	public String toStringSetup() {
		String thing = """
				Name: %s
				Type: %s
				Level: %s
				Description: %s
				Health: %d
				Defence: %d
				Damage: %d
				Heal Amount: %d
				""";
		return String.format(thing, this.getName(), this.getLevel(), this.getType(), this.getDescription(), this.getCurrentHealth(), this.getDefence(), this.getDamage(), this.getHealAmount());
	}

	/**
	 * Returns a string representation that is used by the shop
	 * @return stringShop monster information for shop
	 */
	public String toStringShop() {
		String thing = """
				Name: %s
				Type: %s
				Level: %s
				Description: %s
				Health: %d
				Defence: %d
				Damage: %d
				Heal Amount: %d

				Price: %d
				""";
		return String.format(thing, this.getName(), this.getLevel(), this.getType(), this.getDescription(), this.getCurrentHealth(), this.getDefence(), this.getDamage(), this.getHealAmount(), this.getPrice());
	}

	/**
	 * Returns a string representation that is used by the inventory
	 * @return stringInv monster information for inventory
	 */
	public String toStringInv() {
		String thing = """
				Name: %s
				Type: %s
				Level: %d
				Health: %d
				Defence: %d
				Damage: %d
				Heal Amount: %d
				""";
		return String.format(thing, this.getName(), this.getType(), this.getLevel(), this.getCurrentHealth(), this.getDefence(), this.getDamage(), this.getHealAmount());
	}

	
	/**
	 * Night reset method for resetting the monsters values at nighttime
	 */
	public void nightResetMonster() {
		this.setFainted(false);
	}
	
	/**
	 * Heals the monster by their set heal amount. Runs at night time.
	 */
	public void heal() {
		this.setCurrentHealth(this.getCurrentHealth() + this.getHealAmount());
		if (this.getCurrentHealth() > this.getMaxHealth()) {
			this.setCurrentHealth(this.getMaxHealth());
		}
	}
	
	/**
	 * Increases a monsters level by 1
	 */
	public void levelUp() {
		this.setLevel(this.getLevel() + 1);
	}
}
