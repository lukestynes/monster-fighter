package main.monsters;

public class Monster {
	private String name;
	private Boolean fainted;
	
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
	
	/**
	 * @return Whether or not the monster has fainted as True or False
	 */
	public Boolean getFainted() {
		return fainted;
	}
	
	/**
	 * @param fainted Set's the current status of the monster has it fainted or not
	 */
	
	public void setFainted(Boolean fainted) {
		this.fainted = fainted;
	}
	
	/**
	 * @return the maxHealth
	 */
	
	public int getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * @param maxHealth the maxHealth to set
	 */
	
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	
	/**
	 * @return the healAmount
	 */
	
	public int getHealAmount() {
		return healAmount;
	}
	
	/**
	 * @param healAmount the healAmount to set
	 */
	
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}
	
	/**
	 * @return the currentHealth
	 */
	
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	/**
	 * @param currentHealth the currentHealth to set
	 */
	
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	/**
	 * @return the defence
	 */
	
	public int getDefence() {
		return defence;
	}
	
	/**
	 * @param defence the defence to set
	 */
	
	public void setDefence(int defence) {
		this.defence = defence;
	}
	
	/**
	 * @return the damage
	 */
	
	public int getDamage() {
		return damage;
	}
	
	/**
	 * @param damage the damage to set
	 */
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * Generates a random name for the monster chosen from a list of names
	 * @return the monsters name
	 */
	public String generateName() {
		
		
		return "name";
	}
	
}
