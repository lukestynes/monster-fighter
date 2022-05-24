package main.monsters;

public class WaterMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {125, 150, 175, 200};
	private final int[] HEAL_AMOUNT = {15, 25, 35, 45};
	private final int[] DAMAGE = {20, 25, 30, 35};
	private final int[] DEFENCE = {6, 12, 18, 24};
	
	//Default level 1 monster
	public WaterMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Water Monster LVL 1");
	}
	
	//Constructs a monster at a specified level
	public WaterMonster(int level) {
		int index = level--;
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		//TODO: REMOVE THIS AND ADD NAME GENERATOR
		this.setName("Water Monster LVL " + level);
	}
}
