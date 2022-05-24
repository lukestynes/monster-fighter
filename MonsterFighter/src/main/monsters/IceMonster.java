package main.monsters;

public class IceMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {150, 175, 200, 225};
	private final int[] HEAL_AMOUNT = {70, 90, 100, 120};
	private final int[] DAMAGE = {10, 15, 20, 25};
	private final int[] DEFENCE = {5, 10, 15, 20};
	
	//Default level 1 monster
	public IceMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName("Ice Monster LVL 1");
		this.setType("Ice Monster");
	}
	
	//Constructs a monster at a specified level
	public IceMonster(int level) {
		int index = level--;
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		//TODO: REMOVE THIS AND ADD NAME GENERATOR
		this.setName("Ice Monster LVL " + level);
		this.setType("Ice Monster");
	}
}
