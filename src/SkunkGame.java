import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	int roundChips;
	boolean play;
	SkunkPlayer roundWinner;
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
		StdOut.println("There are " + numberOfPlayers +  " players playing during this game.");
		for (int i = 0; i < numberOfPlayers; i++)
		{
			players.add(new SkunkPlayer("Player " + (i + 1)));
			StdOut.println("Player " + (i + 1));
			
		}

	}

	/*
	 * Finds the winner of each round in order to give them the round chips
	 */
	public void getRoundWinner()
	{
		ArrayList <Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i<players.size(); i++)
		{
			scores.add(players.get(i).getRoundScore());
		}
		
		int topScore = Collections.max(scores);
		int a = scores.indexOf(topScore);
		roundWinner = players.get(a);
		
	}

	public void playGame()
	{
		setUpPlayers();
		StdOut.println("\nWould you like to read the rules of the game?(y/n)");
		String a = StdIn.readString();
		if(a.equals("y"))//Part of assignment 3 - option to print out instructions
		{
			StdOut.println("The objective of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining \n"
		+ "the points on the two dice. The player has the privilege of continuing to shake to increase his score or of passing the dice to wait for \n"
		+ "the next series, thus preventing the possibility of rolling a Skunk and losing his score.\n"
		+ "Any number of players can play,The suggested number of chips to start is 50 \n"
		+ "The winner of each game collects all chips in \"kitty\" and in addition ﬁve chips from each losing player or 10 chips from any player without a score. \n"
		+ "The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win.\n"
		+ "When he decides to stop, his total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\n"
		+ "\nPENALTIES: A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\n"
		+ "A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\n"
		+ "TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice.\nPlayer must again start to score from scratch.\n"
		);
		}
		
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
				StdOut.println("Your total score is: " + skunkPlayer.getPlayerTotalScore());
				playGameForOnePlayer(skunkPlayer);
				StdOut.println("Player total score : " + skunkPlayer.getPlayerTotalScore());
				StdOut.println("--------------------------------------------------");
			}
			this.getRoundWinner();
			roundWinner.setChips(roundWinner.getChips() + roundChips);//adding chips taken from players who rolled skunk and giving it to the player with the highest round score
			StdOut.println("The round winner is: " +  roundWinner.getPlayerName() + " with a round score of " + roundWinner.getRoundScore() + " and has recieved " + roundChips + " chips for a total of " + roundWinner.getChips() + " chips!" );
			roundWinner = null;
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
				roundScore = 0;
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
				player.setChips(player.getChips() - 4);
				StdOut.println("You rolled two skunks, all scores have been set back to 0." + " You have " + player.getChips() + " chips left");
				roundScore = 0;
				player.setRoundScore(roundScore);
				roundChips = roundChips + 4;
				return;
			} 
			if(rollScore ==3) //rolling a skunk and a "Deuce
			{
				player.setTotalScore(player.getPlayerTotalScore() - roundScore);
				player.setChips(player.getChips() - 2);
				StdOut.println("You rolled one skunk and a duece, next player will take turn." + " You have " + player.getChips() + " chips left");
				roundScore = 0;
				player.setRoundScore(roundScore);
				roundChips = roundChips + 2;
				return;
			}
			else if (dice.getLastRoll1() == 1 || dice.getLastRoll2() == 1) // next player will take turn and voids players round score
			{
				player.setTotalScore(player.getPlayerTotalScore() - roundScore);
				player.setChips(player.getChips() - 1);
				StdOut.println("You rolled one skunks, next player will take turn." + " You have " + player.getChips() + " chips left");
				roundScore = 0;
				player.setRoundScore(roundScore);
				roundChips ++;
				return;
			}
			else
			{
				roundScore += rollScore;
				player.setRoundScore(roundScore);
				player.addPoints(rollScore);
				if (player.getPlayerTotalScore() >= 100) {
					StdOut.println("Your score is more than 100.");
					StdOut.println("Winner is " + player.getPlayerName());
					System.exit(0);
				}
				
				StdOut.println("Your score is " + player.getPlayerTotalScore());
				StdOut.println(roundChips);
				
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
