package main.ui;

import main.game.GameController;

public class GUIController {
	GameController game;
	
	public GUIController(GameController game) {
		this.game = game;
	}
	
	public void launchSetupScreen() {
		SetupScreen setupWindow = new SetupScreen(this);
	}
	
	public void closeSetupScreen(SetupScreen setupWindow) {
		setupWindow.closeWindow();
	}
	
	public GameController getGame() {
		return this.game;
	}
	
//	public void safeKeeping() {
//		String name = ftxtName.getText();
//		int gameLength = sldGameLength.getValue();
//		int difficulty = 0;
//		
//		if (rdbtnHardMode.isSelected()) {
//			difficulty = 1;
//		}
//		
//		System.out.printf("%s %d %d", name, gameLength, difficulty);
//	}
}
