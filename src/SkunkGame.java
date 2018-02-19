import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * This class will have Skunk game logic.
 *  
 * @see CrapsGame.java
 *
 */
public class SkunkGame 
{
	SkunkDice dice;
	SkunkDie die1;
	SkunkDie die2;
	int numberOfPlayers;
	int roundNumber;
	int rollScore;
	int roundScore;
	boolean play;
	ArrayList<SkunkPlayer> players = new ArrayList<SkunkPlayer> ();
	
	
	public SkunkGame(SkunkDie pDie1, SkunkDie pDie2)
	{
		this.dice = new SkunkDice(pDie1, pDie2);
		this.die1 = pDie1;
		this.die2 = pDie2;
	}
	
	/*
	 * Sets up number of players based on user input and adds them to an array list for more automated functions in the game will add option for more players
	 */
	public void setUpPlayers()
	{
		System.out.println("How many players would like to play?");
		Scanner sc = new Scanner(System.in);
		int pnum = sc.nextInt();
		
		if(pnum == 2)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			players.add(p1);
			players.add(p2);
			numberOfPlayers = 2;
			
		}
		
		if(pnum == 3)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			SkunkPlayer p3 = new SkunkPlayer("Player 3");
			players.add(p1);
			players.add(p2);
			players.add(p3);
			numberOfPlayers = 3;
			
			
		}
		
		if(pnum == 4)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			SkunkPlayer p3 = new SkunkPlayer("Player 3");
			SkunkPlayer p4 = new SkunkPlayer("Player 4");
			players.add(p1);
			players.add(p2);
			players.add(p3);
			players.add(p4);
			numberOfPlayers = 4;
			
		}
		
		
	}
	
	/*
	 * Prints scores of every player
	 */
	public void printAllScores()
	{
		for(int i = 0; i < players.size(); i++)
		{
			System.out.println("Player " + i+1 + "total score is: " + players.get(i).getPlayerTotalScore());
		}
	}
	
	
	
	public void playGame()
	{
		boolean flag;
		this.setUpPlayers();
		Scanner sc = new Scanner(System.in);
		
		while (play && roundNumber < 6)
		{
			flag = true; 
			while (flag)
			{
				this.dice.roll();
				System.out.println("Die one rolled: " + this.dice.getLastRoll1() + "Die two rolled:" + this.dice.getLastRoll2() );
				int temp = this.dice.getLastTotalRoll();
				if (temp == 2) //Means both dice rolled a 1 which voids all points
				{
					
					for(int i = 0; i < players.size(); i++)
					{
						players.get(i).totalScoreVoid();
					}
					System.out.println("You rolled two skunks, all scores have been set back to 0");
					flag = false;
				}
				
				else
				{
					rollScore = this.dice.getLastTotalRoll();
					roundScore += rollScore;
					for(int i =0; i < players.size(); i++)
					{
						System.out.println("Does " + players.get(i).getPlayerName() + " want to stand or sit? 1 for stand 2 for sit.");
						int ans = sc.nextInt();
						if (ans == 1)
						{
							players.get(i).setStanding(true);
						}
						else
						{
							players.get(i).setStanding(false);
							players.get(i).addPoints(rollScore);
							
						}
						
						flag = players.get(i).getStanding();
					}
				}
				
			}
			
			roundNumber ++;
			roundScore = 0;	
			
		}
		
		
		
		
		
		
		
	}
	
	/**
	 * Using for testing
	 * @param args
	 */
	public static void main(String[] args)
	{
		SkunkDie d1 = new SkunkDie();
		SkunkDie d2 = new SkunkDie();
		SkunkGame s = new SkunkGame(d1, d2);
		s.playGame();
		
		
	}
}
