package main.monsters;

public class EarthMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 120, 175, 200};
	private final int[] HEAL_AMOUNT = {90, 100, 110, 115};
	private final int[] DAMAGE = {10, 15, 35, 40};
	private final int[] DEFENCE = {5, 10, 20, 25};
	private final int[] PRICES = {650, 700, 750, 800};
	private final int[] RETURN_PRICES = {550, 650, 700, 750};
	
	/**
	 * Constructs an EarthMonster of level 1
	 */
	public EarthMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName(this.generateName());
		this.setLevel(1);
		this.setType("Earth Monster");
		this.setDescription("This monster is the strongest at the lower levels but is weaker later on. If you have the money it can make your early game easier");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
	}
	
	/**
	 * Constructs an EarthMonster at a given level
	 * @param level the level of the monster you want
	 */
	public EarthMonster(int level) {
		int index = level - 1;
		this.setLevel(level);
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		this.setName(this.generateName());
		this.setType("Earth Monster");
		this.setDescription("This monster is the strongest at the lower levels but is weaker later on. If you have the money it can make your early game easier");
		
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
