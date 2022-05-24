package ma.monsters;


public class FireMonster extends Monster {
	//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 125, 150, 175};
	private final int[] HEAL_AMOUNT = {20, 30, 40, 50};
	private final int[] DAMAGE = {25, 30, 35, 40};
	private final int[] DEFENCE = {10, 15, 20, 25};
	
	//Default level 1 monster
	public FireMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		
	}
	
	//Constructs a monster at a stronger level for later game mechanics
}
