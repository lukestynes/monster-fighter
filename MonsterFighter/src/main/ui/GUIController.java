package main.ui;

import java.util.ArrayList;

import main.game.GameController;
import main.monsters.Monster;

public class GUIController {
	GameController game;
	SetupScreen setupWindow;
	MenuScreen menuWindow;
	
	public GUIController(GameController game) {
		this.game = game;
	}
	
	public GameController getGame() {
		return this.game;
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
}
