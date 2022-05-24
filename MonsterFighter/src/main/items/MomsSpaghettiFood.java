package main.items;

public class MomsSpaghettiFood extends Item {
	public MomsSpaghettiFood() {
		this.setInstantHealthBoost(55);
		this.setHealAmountBoost(10);
		this.setDefenceBoost(5);
		this.setMaxHealthBoost(20);
		
		this.setName("Mom's Spaghetti");
		this.setDescription("A food that gives you all the perks of Mom's special spaghetti. I wonder what she puts in that sauce?");
		this.setPrice(500);
		this.setReturnPrice(450);
	}
}
