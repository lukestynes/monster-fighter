package main.items;


public class BezerkerPotion extends Item {
	/**
	 *Generates a new bezerker potion
	 */
	public BezerkerPotion() {
		this.setInstantHealthBoost(20);
		this.setDamageBoost(25);
		this.setDefenceBoost(10);
		
		this.setName("Bezerker Potion");
		this.setDescription("A potion that heavily increases your damage and defence, with a quick heal of 20HP");
		
		this.setPrice(750);
		this.setReturnPrice(700);
	}

}
