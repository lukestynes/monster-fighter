package main.monsters;

public class ElectricityMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 125, 150, 175};
	private final int[] HEAL_AMOUNT = {35, 45, 60, 70};
	private final int[] DAMAGE = {30, 35, 40, 45};
	private final int[] DEFENCE = {5, 10, 15, 20};
	private final int[] PRICES = {650, 750, 850, 950};
	private final int[] RETURN_PRICES = {550, 650, 700, 750};
	
	/**
	 * Constructs an ElectricityMonster of level 1
	 */
	public ElectricityMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName(this.generateName());
		this.setLevel(1);
		this.setType("Electricity Monster");
		this.setDescription("With higher damage than the others, this monster shines for combat, but watch out for its low health");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
	}
	
	/**
	 * Constructs an ElectricityMonster of a given level
	 * @param level the level of monster you want
	 */
	public ElectricityMonster(int level) {
		int index = level - 1;
		this.setLevel(level);
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
	
		this.setName(this.generateName());
		this.setType("Electricity Monster");
		this.setDescription("With higher damage than the others, this monster shines for combat, but watch out for its low health");
		
		this.setPrice(PRICES[index]);
		this.setReturnPrice(RETURN_PRICES[index]);
	}
	
	/**
	 * Resets the monsters values that could have potentially been boosted by an item during the day.
	 */
	@Override
	public void nightResetMonster() {
		int index = this.getLevel() - 1;

		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		this.setHealAmount(HEAL_AMOUNT[index]);
		
		this.setFainted(false);
	}
	
	
	/**
	 * Levels up a monster and ensures the values are correct.
	 */
	@Override
	public void levelUp() {
		this.setLevel(this.getLevel() + 1);
		
		int index = this.getLevel() - 1;
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		this.setPrice(PRICES[index]);
		this.setReturnPrice(RETURN_PRICES[index]);
	}
}
