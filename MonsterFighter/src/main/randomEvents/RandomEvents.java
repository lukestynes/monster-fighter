package main.randomEvents;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.game.GameController;
import main.monsters.*;

public class RandomEvents {
	private Random rng;
	private GameController game;
	private JFrame frame;
	
	private final double EASY_LEAVE_CHANCE = 0.01;
	private final double HARD_LEAVE_CHANCE = 0.02;
	private final double[] ARRIVE_CHANCE = {0.005, .01, .025, .05};
	private final double BASE_LEVEL_UP = 0.025;
	
	
	public RandomEvents(GameController game) {
		rng = new Random();
		this.game = game;
	}
	
	public void randomMonsterLevelUp() {
		int battlesWon = game.getBattleController().getBattlesWonToday();
		
		double randomChance = rng.nextDouble();
		double probability = BASE_LEVEL_UP + (0.01 * battlesWon);
		
		//If this runs the probability succeeded
		if (randomChance < probability) {
			if (game.getPlayer().getMonsterTeam().strongestMonster().getLevel() < 4) {
				int index = game.getPlayer().getMonsterTeam().getMonsterTeamList().indexOf(game.getPlayer().getMonsterTeam().strongestMonster());
				game.getPlayer().getMonsterTeam().getMonsterTeamList().get(index).levelUp();
				JOptionPane.showMessageDialog(frame, "A monster has level up in the night!");
			}
			
			
		}
	}
	
	public void randomMonsterLeaves() {
		boolean easyMode = game.getDifficulty() == 0;
		int faintCount = game.getPlayer().getMonsterTeam().getTotalTeamFaints();
		
		double randomChance = rng.nextDouble();
		double probability = HARD_LEAVE_CHANCE;
		
		if (easyMode) {
			probability = EASY_LEAVE_CHANCE;
		}
		
		//This runs when the probability is met
		if (randomChance < (probability + 0.2 * faintCount)) {
			game.getPlayer().getMonsterTeam().removeMonsterFromTeam(game.getPlayer().getMonsterTeam().weakestMonster());
			JOptionPane.showMessageDialog(frame, "A monster has left in the night!");
		} 
	}
	
	public void randomMonsterArrives() {
		int freeSlots = game.getPlayer().getMonsterTeam().getEmptySlots();
		double probability = 0;
		switch (freeSlots) {
		case 1:
			probability = ARRIVE_CHANCE[0];
			break;
		case 2:
			probability = ARRIVE_CHANCE[1];
			break;
		case 3:
			probability = ARRIVE_CHANCE[2];
			break;
		case 4: 
			probability = ARRIVE_CHANCE[3];
			break;	
		}
		
		double randomChance = rng.nextDouble();
		
		int minLevel, maxLevel;
		int currentDay = game.getCurrentDay();
		
		if (randomChance < probability) {
			JOptionPane.showMessageDialog(frame, "A monster has arrived in the night!");
			
			//If this runs then the probability has happened and a monster will join the team.
			if (currentDay < 3) {
				minLevel = maxLevel = 1;
			} else if (currentDay < 6) {
				minLevel = 1;
				maxLevel = 2;
			} else if (currentDay < 9) {
				minLevel = 2;
				maxLevel = 3;
			} else if (currentDay < 12) {
				minLevel = 3;
				maxLevel = 4;
			} else {
				minLevel = maxLevel = 4;
			}
			
			int monsterType = rng.nextInt(6);
			
			int monsterLevel = 1;
			if (maxLevel != 1) {
				monsterLevel = rng.nextInt(maxLevel-minLevel) + minLevel;
			} 
			
			Monster rngMonster = null;
			
			switch (monsterType) {
			case 0:
				rngMonster = new AirMonster(monsterLevel);
				break;
			case 1:
				rngMonster = new EarthMonster(monsterLevel);
				break;
			case 2:
				rngMonster = new ElectricityMonster(monsterLevel);
				break;
			case 3:
				rngMonster = new FireMonster(monsterLevel);
				break;
			case 4:
				rngMonster = new IceMonster(monsterLevel);
				break;
			case 5:
				rngMonster  = new WaterMonster(monsterLevel);
				break;
			}
			
			game.getPlayer().getMonsterTeam().addMonsterToTeam(rngMonster);
		}
		
		
	}
	
	public void nightTimeEvents() {
		this.randomMonsterArrives();
		this.randomMonsterLeaves();
		this.randomMonsterLevelUp();
	}
}
