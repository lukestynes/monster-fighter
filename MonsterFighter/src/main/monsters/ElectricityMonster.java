package main.monsters;

public class ElectricityMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 125, 150, 175};
	private final int[] HEAL_AMOUNT = {35, 45, 60, 70};
	private final int[] DAMAGE = {30, 35, 40, 45};
	private final int[] DEFENCE = {5, 10, 15, 20};
	private final int[] PRICES = {650, 750, 850, 950};
	private final int[] RETURN_PRICES = {550, 650, 700, 750};
	
	//Default level 1 monster
	public ElectricityMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Electricity Monster LVL 1");
		this.setType("Electricity Monster");
		this.setDescription("With higher damage than the others, this monster shines for combat, but watch out for its low health");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
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
		this.setType("Electricity Monster");
		this.setDescription("With higher damage than the others, this monster shines for combat, but watch out for its low health");
		
		this.setPrice(PRICES[index]);
		this.setReturnPrice(RETURN_PRICES[index]);
	}
}
