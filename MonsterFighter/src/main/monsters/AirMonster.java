package main.monsters;

public class AirMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 120, 175, 200};
	private final int[] HEAL_AMOUNT = {10, 20, 40, 50};
	private final int[] DAMAGE = {10, 15, 35, 40};
	private final int[] DEFENCE = {5, 10, 20, 25};
	
	//Default level 1 monster
	public AirMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Air Monster LVL 1");
	}
	
	//Constructs a monster at a specified level
	public AirMonster(int level) {
		int index = level--;
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		//TODO: REMOVE THIS AND ADD NAME GENERATOR
		this.setName("Air Monster LVL " + level);
	}
}
