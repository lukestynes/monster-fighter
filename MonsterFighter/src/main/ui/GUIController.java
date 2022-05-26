package main.ui;

import main.game.GameController;

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

	/**
	 * Creates a new window
	 */
	public void launchSetupScreen() {
		setupWindow = new SetupScreen(this);
	}
	
	/**
	 * Closes the given window
	 * @param setupWindow the window being closed
	 */
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public SetupScreen getScreen() {
		return this.setupWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchMenuScreen() {
		menuWindow = new MenuScreen(this);
		
	}
	
	/**
	 * Closes the given window
	 * @param menuWindow the window to close
	 */
	public void closeMenuScreen(MenuScreen menuWindow) {
		menuWindow.closeWindow();
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public MenuScreen getMenuScreen() {
		return this.menuWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchMonsterTeamScreen() {
		monsterWindow = new MonsterTeamScreen(this);
	}
	
	/**
	 * Closes the given window
	 * @param monsterWindow the window to close
	 */
	public void closeMonsterTeamScreen(MonsterTeamScreen monsterWindow) {
		monsterWindow.closeWindow();
	}

	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public MonsterTeamScreen getMonsterScreen() {
		return this.monsterWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchInventoryScreen() {
		inventoryWindow = new InventoryScreen(this);
	}
	
	/**
	 * Closes the given window
	 * @param inventoryWindow the window to close
	 */
	public void closeInventoryScreen(InventoryScreen inventoryWindow) {
		inventoryWindow.closeWindow();
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public InventoryScreen getInventoryScreen() {
		return this.inventoryWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchShopScreen() {
		shopWindow = new ShopScreen(this);
	}
	
	/**
	 * Closes the given window 
	 * @param shopWindow the window to close
	 */
	public void closeShopScreen(ShopScreen shopWindow) {
		shopWindow.closeWindow();
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public ShopScreen getShopScreen() {
		return this.shopWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchEndGameScreen() {
		endGameWindow = new EndGameScreen(this);
	}
	
	/**
	 * Closes the given window
	 * @param engGameWindow the window to close
	 */
	public void closeEndGameScreen(EndGameScreen engGameWindow) {
		endGameWindow.closeWindow();	
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public EndGameScreen getEndGameScreen() {
		return this.endGameWindow;
	}
	
	/**
	 * Creates a new window
	 */
	public void launchBattleSelectionScreen() {
		battleSelectionWindow = new BattleSelectionScreen(this);
	}
	
	/**
	 * Closes the given window
	 * @param battleSelectionWindow the window to close
	 */
	public void closeBattleSelectionScreen(BattleSelectionScreen battleSelectionWindow) {
		battleSelectionWindow.closeWindow();
	}
	
	/**
	 * Returns the current window instance
	 * @return the window instance
	 */
	public BattleSelectionScreen getBattleSelectionWindow() {
		return this.battleSelectionWindow;
	}
	
	
}
