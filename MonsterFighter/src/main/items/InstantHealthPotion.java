package main.items;

public class InstantHealthPotion extends Item {
	
	/**
	 * Generates an instant health potion
	 */
	public InstantHealthPotion() {
		this.setInstantHealthBoost(30);
		
		
		this.setName("Instant Health Potion");
		this.setDescription("A potion that gives you a quick instant heal of 30 HP");
		this.setPrice(200);
		this.setReturnPrice(175);
		}
}
