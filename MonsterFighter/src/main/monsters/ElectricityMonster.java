package main.monsters;

public class ElectricityMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 125, 150, 175};
	private final int[] HEAL_AMOUNT = {20, 30, 40, 50};
	private final int[] DAMAGE = {30, 35, 40, 45};
	private final int[] DEFENCE = {5, 10, 15, 20};
	
	//Default level 1 monster
	public ElectricityMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Electricity Monster LVL 1");
	}
	
	//Constructs a monster at a specified level
	public ElectricityMonster(int level) {
		int index = level--;
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		//TODO: REMOVE THIS AND ADD NAME GENERATOR
		this.setName("Electricity Monster LVL " + level);
	}
}
