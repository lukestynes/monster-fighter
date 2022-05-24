package main.ui;

import java.util.Scanner;

import main.game.*;
import main.items.Item;
import main.monsters.Monster;
import main.shop.Shop;

public class CLInterface {
	
	Scanner scan = new Scanner(System.in);
	Shop shop;
	
	public Player setupScreen(GameController game, Monster[] easyStartingMonsters, Monster[] hardStartingMonsters) {
		String name;
		int length;
		int difficulty;
		Monster startingMonster;
		shop = new Shop(game);
		
		System.out.println("###############################################################");
		System.out.println("Welcome to Monster Fighter");
		System.out.println("Made by Luke\n\n");
		
		System.out.println("What is your name?");
		name = scan.nextLine();
		
		System.out.println("How long do you want the game to be? (5-15 days)");
		length = scan.nextInt();
		
		System.out.println("What difficulty do you want to play on? (0=easy, 1=hard)");
		difficulty = scan.nextInt();	
		
		
		game.setDifficulty(difficulty);
		game.setGameLength(length);
		
		if (game.getDifficulty() == 0) {
			startingMonster = startingMonsterScreen(game, easyStartingMonsters);
		} else {
			startingMonster = startingMonsterScreen(game, hardStartingMonsters);
		}
		
		Player player = new Player(name, difficulty, startingMonster);

		System.out.println("\n\n******* LET THE ADVENTURE BEGIN!**********\n\n");
		return player;
	}
	
	public Monster startingMonsterScreen(GameController game, Monster[] startingMonsters) {
		int count = 1;
		int chosenMonster;
		
		System.out.println("Have a look at these monsters below and choose your starter\n\n");
		
		
		for (Monster monster: startingMonsters) {
			System.out.println(count + ": " + monster);
			count++;
		}
		
		System.out.println("Enter the number of the monster you want to start with: ");
		
		chosenMonster = scan.nextInt();
		
		return startingMonsters[chosenMonster-1];
	}
	
	public void menuScreen(Player player, GameController game) {
		String toDisplay = """
				Choose an option:
				
				1. View your score, gold and current day
				2. View your monster team
				3. View your inventory
				4. Visit the shop
				5. Go to Battle
				6. Go to sleep (end the day)
				""";
		
		System.out.println(toDisplay);
		
		int playerChoice = scan.nextInt();
		
		switch (playerChoice) {
		case 1:
			System.out.printf("\n%s: Gold: %d | Score: %d | Day: %d/%d\n\n\n", player.getName(), player.getGold(), player.getScore(), game.getCurrentDay(), game.getGameLength());
			break;
		case 2:
			monsterScreen(player);
			break;
		case 3:
			inventoryScreen(player);
			break;
		case 4:
			shopScreen(player, game);
			break;
		case 5:
			break;
		case 6:
			game.nightReset();
			break;
		}
	}
	
	public void monsterScreen(Player player) {
		System.out.println("\n\n\nYour Monster Team: \n");
		
		int count = 1;
		for (Monster monster: player.getMonsterTeam().getMonsterTeamList()) {
			System.out.println("\n " + count + " " + monster + "\n");
			System.out.println("SELLBACK PRICE: " + monster.getReturnPrice());
			count++;
		}
		
		System.out.println("Do you want to sell anything? 1 or 0");
		
		int response = scan.nextInt();
		
		if (response == 1) {
			System.out.println("Enter the number of the thing you want to buy: ");
			int returnMonster = scan.nextInt();
			Monster monsterToReturn = player.getMonsterTeam().getMonsterTeamList().get(returnMonster - 1);
			shop.returnMonster(monsterToReturn, player);
		}
	}
	
	public void inventoryScreen(Player player) {
		System.out.println("\n\n\n**********Your Inventory: \n********");
		
		int count = 1;
		
		for (Item item: player.getInventory().getInventoryList()) {
			System.out.println("\n " + count + " " + item);
			System.out.println("SELLBACK PRICE: " + item.getReturnPrice());
			count++;
		}
		
		System.out.println("Do you want to sell anything (1) or use anything (2)?");
		
		int response = scan.nextInt();
		
		if (response == 1) {
			System.out.println("Enter the number of the thing you want to sell: ");
			int returnItem = scan.nextInt();
			Item itemToReturn = player.getInventory().getInventoryList().get(returnItem - 1);
			shop.returnItem(itemToReturn, player);
		} else if (response == 2) {
			System.out.println("Enter the number of the item you want to use? ");
			int useItem = scan.nextInt();
			
			Item usedItem = player.getInventory().getInventoryList().get(useItem - 1);
			
			System.out.println("\n\n\nYour Monster Team: \n");
			
			count = 1;
			for (Monster monster: player.getMonsterTeam().getMonsterTeamList()) {
				System.out.println("\n " + count + " " + monster + "\n");
				count++;
			}
			System.out.println("Enter the number of the monster you want to use it on? ");
			
			int usingMonster = scan.nextInt();
			Monster monsterToImpact = player.getMonsterTeam().getMonsterTeamList().get(usingMonster - 1);
			
			player.getInventory().useItem(usedItem, monsterToImpact);
		}
		
		//TODO: something about using items on monsters
	}
	
	public void shopScreen(Player player, GameController game) {
		System.out.println("\n\n-----Welcome to the Shop-----\n\n");
		System.out.println("Would you like to shop for Monsters (1) or Items (2)? ");
		
		int playerChoice = scan.nextInt();
		Boolean buyingMonsters = null;
		
		switch (playerChoice) {
		case 1:
			System.out.println("***MONSTERS***");
			
			int count = 1;
			for (Monster monster: shop.getShopMonsters()) {
				System.out.println("\n\n" + count + ": " + monster);
				System.out.println("PRICE: " + monster.getPrice());
				count++;
			}
			buyingMonsters = true;
			break;
		case 2:
			count = 1;
			System.out.println("***ITEMS***");
			
			for (Item item: shop.getShopItems()) {
				System.out.println("\n\n" + count + ": " + item);
				System.out.println("PRICE: " + item.getPrice());
				count++;
			}
			buyingMonsters = false;
			break;
		}
		
		System.out.println("Your gold is currently: " + player.getGold());
		System.out.println("Do you want to buy anything? 0 or 1");
		int response = scan.nextInt();
		if (response == 1) {
			System.out.println("Enter the number of the thing you want to buy: ");
			int purchaseItem = scan.nextInt();
			
			if (buyingMonsters) {
				shop.purchaseMonster(shop.getShopMonsters().get(purchaseItem - 1), player);
			} else {
				shop.purchaseItem(shop.getShopItems().get(purchaseItem - 1), player);
			}
			
			
		}
	}
}