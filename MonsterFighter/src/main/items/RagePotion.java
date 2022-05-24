package main.items;

public class RagePotion extends Item {
	public RagePotion( ) {
		this.setInstantHealthBoost(5);
		this.setDamageBoost(10);
		
		this.setName("Rage Potion");
		this.setDescription("A potion that gives you a damage boost of 10 DP and a quick heal of 5 HP");
		this.setPrice(225);
		this.setReturnPrice(200);
	}
}
