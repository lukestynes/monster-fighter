package main.ui;

import java.util.ArrayList;

import main.game.GameController;
import main.monsters.Monster;

public class GUIController {
	GameController game;
	
	SetupScreen setupWindow;
	MenuScreen menuWindow;
	MonsterTeamScreen monsterWindow;
	InventoryScreen inventoryWindow;
	ShopScreen shopWindow;
	BattleSelectionScreen battleSelectionWindow;
	EndGameScreen endGameWindow;
	
	public GUIController(GameController game) {
		this.game = game;
	}
	
	public GameController getGame() {
		return this.game;
	}
	
	public ArrayList<String> updateMonsters() {
		ArrayList<Monster> monsterTeam = game.getPlayer().getMonsterTeam().getMonsterTeamList();
		String monst1 = "This Slot is Empty";
		String monst2, monst3, monst4;
		monst4 = monst2 = monst3 = monst1;
		
		
		switch (monsterTeam.size()) {
		case 1:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(), monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			break;
		case 2:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			break;
		case 3:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			monst3 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(2).getName(), monsterTeam.get(0).getType(),monsterTeam.get(2).getLevel(), monsterTeam.get(2).getDescription(), monsterTeam.get(2).getMaxHealth(), monsterTeam.get(2).getHealAmount(), monsterTeam.get(2).getDefence(), monsterTeam.get(2).getDamage());
			break;
		case 4:
			monst1 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(0).getName(), monsterTeam.get(0).getType(),monsterTeam.get(0).getLevel(), monsterTeam.get(0).getDescription(), monsterTeam.get(0).getMaxHealth(), monsterTeam.get(0).getHealAmount(), monsterTeam.get(0).getDefence(), monsterTeam.get(0).getDamage());
			monst2 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(1).getName(), monsterTeam.get(0).getType(),monsterTeam.get(1).getLevel(), monsterTeam.get(1).getDescription(), monsterTeam.get(1).getMaxHealth(), monsterTeam.get(1).getHealAmount(), monsterTeam.get(1).getDefence(), monsterTeam.get(1).getDamage());
			monst3 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(2).getName(), monsterTeam.get(0).getType(),monsterTeam.get(2).getLevel(), monsterTeam.get(2).getDescription(), monsterTeam.get(2).getMaxHealth(), monsterTeam.get(2).getHealAmount(), monsterTeam.get(2).getDefence(), monsterTeam.get(2).getDamage());
			monst4 = String.format("%s\nType: %s \nLevel: %s\nDescription: %s\n\nHealth: %d\nHeal Amount: %d\nDefence: %d\nDamage: %d\n", monsterTeam.get(3).getName(), monsterTeam.get(0).getType(),monsterTeam.get(3).getLevel(), monsterTeam.get(3).getDescription(), monsterTeam.get(3).getMaxHealth(), monsterTeam.get(3).getHealAmount(), monsterTeam.get(3).getDefence(), monsterTeam.get(3).getDamage());
			break;
		}
		
		ArrayList<String> words = new ArrayList<String>(4);
		words.add(monst1);
		words.add(monst2);
		words.add(monst3);
		words.add(monst4);
		
		return words;
	}
	
	

	public void launchSetupScreen() {
		System.out.println("DEBUG [GUICONTROLLER]: LAUNCHING SETUP SCREEN");
		setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	public SetupScreen getScreen() {
		return this.setupWindow;
	}
	
	public void launchMenuScreen() {
		System.out.println("DEBUG [GUICONTROLLER]: LAUNCHING MENU SCREEN");
		menuWindow = new MenuScreen(this);
		
	}
	
	public void closeMenuScreen(MenuScreen menuWindow) {
		menuWindow.closeWindow();
	}
	
	public MenuScreen getMenuScreen() {
		return this.menuWindow;
	}
	
	public void launchMonsterTeamScreen() {
		System.out.println("DEBUG [GUICONTROLLER]: LAUNCHING MONSTERTEAM SCREEN");
		monsterWindow = new MonsterTeamScreen(this);
	}
	
	public void closeMonsterTeamScreen(MonsterTeamScreen monsterWindow) {
		monsterWindow.closeWindow();
	}

	public MonsterTeamScreen getMonsterScreen() {
		return this.monsterWindow;
	}
	
	public void launchInventoryScreen() {
		inventoryWindow = new InventoryScreen(this);
	}
	
	public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
	}
	
	public InventoryScreen getInventoryScreen() {
		return this.inventoryWindow;
	}
	
	public void launchShopScreen() {
		shopWindow = new ShopScreen(this);
	}
	
	public void closeShopScreen(ShopScreen shopWindow) {
		shopWindow.closeWindow();
	}
	
	public ShopScreen getShopScreen() {
		return this.shopWindow;
	}
	
	public void launchEndGameScreen() {
		endGameWindow = new EndGameScreen(this);
	}
	
	public void closeEndGameScreen(EndGameScreen engGameWindow) {
		endGameWindow.closeWindow();	
	}
	
	public EndGameScreen getEndGameScreen() {
		return this.endGameWindow;
	}
	
	public void launchBattleSelectionScreen() {
		System.out.println("DEBUG [GUICONTROLLER]: LAUNCHING BATTLESELECTION SCREEN");
		battleSelectionWindow = new BattleSelectionScreen(this);
	}
	
	public void closeBattleSelectionScreen(BattleSelectionScreen battleSelectionWindow) {
		battleSelectionWindow.closeWindow();
	}
	
	public BattleSelectionScreen getBattleSelectionWindow() {
		return this.battleSelectionWindow;
	}
	
	
}
