package main.monsters;

public class WaterMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {125, 150, 175, 200};
	private final int[] HEAL_AMOUNT = {55, 65, 70, 80};
	private final int[] DAMAGE = {20, 25, 30, 35};
	private final int[] DEFENCE = {6, 12, 18, 24};
	private final int[] PRICES = {600, 700, 800, 900};
	private final int[] RETURN_PRICES = {500, 600, 700, 800};
	
	//Default level 1 monster
	public WaterMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Water Monster LVL 1");
		this.setType("Water Monster");
		this.setDescription("With slightly higher health than some monsters, this is a good monster for beginners");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
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
		this.setType("Water Monster");
		this.setDescription("With slightly higher health than some monsters, this is a good monster for beginners");
		
		this.setPrice(PRICES[index]);
		this.setReturnPrice(RETURN_PRICES[index]);
	}
}
