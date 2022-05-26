package main.monsters;

public class IceMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {150, 175, 200, 225};
	private final int[] HEAL_AMOUNT = {70, 90, 100, 120};
	private final int[] DAMAGE = {10, 15, 20, 25};
	private final int[] DEFENCE = {5, 10, 15, 20};
	private final int[] PRICES = {550, 650, 750, 850};
	private final int[] RETURN_PRICES = {450, 550, 650, 750};
	
	/**
	 * Constructs an IceMonster of level 1
	 */
	public IceMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName(this.generateName());
		this.setLevel(1);
		this.setType("Ice Monster");
		this.setDescription("This monster has a lot of health, but it's damage is quite low. It's more of a tank");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
	}
	
	/**
	 * Constructs an IceMonster of given level
	 * @param level the level of monster you want
	 */
	public IceMonster(int level) {
		int index = level - 1;
		this.setLevel(level);
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		this.setName(this.generateName());
		this.setType("Ice Monster");
		this.setDescription("This monster has a lot of health, but it's damage is quite low. It's more of a tank");
		
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
