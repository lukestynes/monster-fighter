package main.items;

public class HeartFruit extends Item {
	/**
	 * Generates a heart fruit
	 */
	public HeartFruit() {
		this.setInstantHealthBoost(20);
		this.setHealAmountBoost(10);
		this.setDefenceBoost(10);
		this.setMaxHealthBoost(50);
		
		this.setName("Heart Fruit");
		this.setDescription("A rare fruit that gives your monster a permanent max health increase");
		this.setPrice(1000);
		this.setReturnPrice(700);
	}

}
