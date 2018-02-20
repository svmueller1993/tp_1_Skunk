import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
	List<SkunkPlayer> players = new ArrayList<SkunkPlayer>();

	public SkunkGame(SkunkDie pDie1, SkunkDie pDie2)
	{
		this.dice = new SkunkDice(pDie1, pDie2);
		this.die1 = pDie1;
		this.die2 = pDie2;
	}

	/*
	 * Sets up number of players based on user input and adds them to an array
	 * list for more automated functions in the game will add option for more
	 * players
	 */
	public void setUpPlayers()
	{
		StdOut.println("How many players would like to play?");
		int numberOfPlayers = StdIn.readInt();

		for (int i = 0; i < numberOfPlayers; i++)
		{
			players.add(new SkunkPlayer("Player" + (i + 1)));
		}

	}

	/*
	 * Prints scores of every player
	 */
	public void printAllScores()
	{
		for (int i = 0; i < players.size(); i++)
		{
			System.out.println("Player " + i + 1 + "total score is: " + players.get(i).getPlayerTotalScore());
		}
	}

	public void playGame()
	{
		setUpPlayers();
		play = true;
		roundNumber = 0;
		while (roundNumber < 6)
		{   
			StdOut.println("====================================================");
			StdOut.println("Game round : " + (roundNumber + 1));
			for (Iterator iterator = players.iterator(); iterator.hasNext();)
			{
				SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
				StdOut.println("Player name : " + skunkPlayer.getPlayerName());
				StdOut.println("By now you score is : " + skunkPlayer.getPlayerTotalScore());
				playGameForOnePlayer(skunkPlayer);
				StdOut.println("Player total score : " + skunkPlayer.getPlayerTotalScore());
				StdOut.println("--------------------------------------------------");
			}

			roundNumber++;
		}
		
		// needs to check winner if after 6 round no one gets more than 100 score
	}

	public void playGameForOnePlayer(SkunkPlayer player)
	{
		boolean flag = true;
		while (flag)
		{	
			StdOut.println("\nWould you like to roll the dice(y/n)?");
			String d = StdIn.readString();
			if(d.equals("n")) {
				// next player will take turn
				return;
			}
			this.dice.roll();
			StdOut.println("Die one rolled: " + this.dice.getLastRoll1());
			StdOut.println("Die two rolled: " + this.dice.getLastRoll2());
			int rollScore = this.dice.getLastTotalRoll();
			
			if (rollScore == 2) // Means both dice rolled a 1 which voids all points
			{
				player.totalScoreVoid();
				StdOut.println("You rolled two skunks, all scores have been set back to 0.");
				return;
			} 
			else if (dice.getLastRoll1() == 1 || dice.getLastRoll2() == 1) // next player will take turn
			{
				StdOut.println("You rolled one skunks, next player will take turn.");
				return;
			}
			else
			{
				player.addPoints(rollScore);
				if (player.getPlayerTotalScore() >= 100) {
					StdOut.println("Your score is more than 100.");
					StdOut.println("Winner is " + player.getPlayerName());
					System.exit(0);
				}
				StdOut.println("Your score is " + player.getPlayerTotalScore());
			}
		}
	}

	/**
	 * Using for testing
	 * 
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
