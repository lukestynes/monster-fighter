package main.items;

public class MysterySoupFood extends Item {
	public MysterySoupFood() {
		this.setInstantHealthBoost(15);
		this.setDamageBoost(5);
		this.setDefenceBoost(10);
		
		this.setName("Mystery Soup");
		this.setDescription("A soup made from what we had lying around. It seems to make you stronger...?");
		this.setPrice(175);
		this.setReturnPrice(150);
	}

}
