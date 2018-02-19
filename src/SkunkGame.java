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
	
	
	public SkunkGame(SkunkDie pDie1, SkunkDie pDie2)
	{
		this.dice = new SkunkDice(pDie1, pDie2);
		this.die1 = pDie1;
		this.die2 = pDie2;
	}
	
	public void playGame()
	{
		System.out.println("How many players would like to play?");
		Scanner sc = new Scanner(System.in);
		int pnum = sc.nextInt();
		
		
		if(pnum == 2)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			numberOfPlayers = 2;
			
		}
		
		if(pnum == 3)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			SkunkPlayer p3 = new SkunkPlayer("Player 3");
			numberOfPlayers = 3;
			
			
		}
		
		if(pnum == 4)
		{
			SkunkPlayer p1 = new SkunkPlayer("Player 1");
			SkunkPlayer p2 = new SkunkPlayer("Player 2");
			SkunkPlayer p3 = new SkunkPlayer("Player 3");
			SkunkPlayer p4 = new SkunkPlayer("Player 4");
			numberOfPlayers = 4;
			
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
