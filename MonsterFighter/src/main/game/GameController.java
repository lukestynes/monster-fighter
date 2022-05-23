package main.game;

import main.ui.*;

public class GameController {
	
	CLInterface cli = new CLInterface();

	public static void main(String[] args) {
		GameController game = new GameController();
		game.run();
	}
	
	public void run() {
		//Create an interface instance
		
		gameSetup();
	}
	
	public void gameSetup() {
		cli.setupScreen();
	}
		//TODO: Get player name 3-15 chars
		//TODO: Get game length 5-15 days
		//TODO: Choose a starting monster for your team
		//TODO: Choose a difficulty
	}

