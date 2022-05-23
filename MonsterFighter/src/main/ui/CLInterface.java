package main.ui;

import java.util.Scanner;

import main.game.*;

public class CLInterface {
	
	Scanner scan = new Scanner(System.in);
	
	public void setupScreen(Player player) {
		String name;
		int length;
		int difficulty;
		//TODO: Starting monster
		
		
		System.out.println("###############################################################");
		System.out.println("Welcome to Monster Fighter");
		System.out.println("Made by Luke\n\n");
		
		System.out.println("What is your name?");
		name = scan.nextLine();
		
		System.out.println("How long do you want the game to be? (5-15 days)");
		length = scan.nextInt();
		
		System.out.println("What difficulty do you want to play on? (0=easy, 1=hard)");
		difficulty = scan.nextInt();	
		
		
	}
}
