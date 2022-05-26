package main.monsters;

public class AirMonster extends Monster {
//All of the values for the monster at levels 1, 2, 3, and 4
	private final int[] MAX_HEALTH = {100, 120, 175, 200};
	private final int[] HEAL_AMOUNT = {30, 50, 80, 120};
	private final int[] DAMAGE = {10, 15, 35, 40};
	private final int[] DEFENCE = {5, 10, 20, 25};
	private final int[] PRICES = {400, 500, 650, 800};
	private final int[] RETURN_PRICES = {350, 450, 550, 750};
	
	//Default level 1 monster
	public AirMonster() {
		this.setMaxHealth(MAX_HEALTH[0]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[0]);
		this.setDamage(DAMAGE[0]);
		this.setDefence(DEFENCE[0]);
		
		this.setName(this.generateName());
		this.setLevel(1);
		this.setType("Air Monster");
		this.setDescription("Weaker in the early game, this monster really comes out to play when it's leveled up.");
		
		this.setPrice(PRICES[0]);
		this.setReturnPrice(RETURN_PRICES[0]);
	}
	
	//Constructs a monster at a specified level
	public AirMonster(int level) {
		int index = level - 1;
		this.setLevel(level);
		
		this.setMaxHealth(MAX_HEALTH[index]);
		this.setCurrentHealth(getMaxHealth());
		
		this.setHealAmount(HEAL_AMOUNT[index]);
		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		
		//TODO: REMOVE THIS AND ADD NAME GENERATOR
		this.setName(this.generateName());
		this.setType("Air Monster");
		this.setDescription("Weaker in the early game, this monster really comes out to play when it's leveled up.");
		
		this.setPrice(PRICES[index]);
		this.setReturnPrice(RETURN_PRICES[index]);
	}
	
	@Override
	public void nightResetMonster() {
		int index = this.getLevel() - 1;

		this.setDamage(DAMAGE[index]);
		this.setDefence(DEFENCE[index]);
		this.setHealAmount(HEAL_AMOUNT[index]);
		
		this.setFainted(false);
	}
	
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
