package main.shop;

import main.game.Player;

public interface Purchasable {
	public void playerPurchase(Player player, int price, Object bought);
	public void playerReturn(Player player, int returnPrice, Object returned);	
}
