import java.util.ArrayList;
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
	
	SkunkPlayer roundWinner;
	List<SkunkPlayer> players = new ArrayList<SkunkPlayer>();

	public SkunkGame(SkunkDie pDie1, SkunkDie pDie2, List<SkunkPlayer> players)
	{
		this.dice = new SkunkDice(pDie1, pDie2);
		this.die1 = pDie1;
		this.die2 = pDie2;
		this.players = players;
	}

	/*
	 * Finds the winner of each round in order to give the winner the round chips
	 */
	public SkunkPlayer getRoundWinner()
	{
		int winner = 0;
		int maxScore = players.get(0).getRoundScore();
		for (int i = 1; i < players.size(); i++)
		{
			if(maxScore < players.get(i).getRoundScore()) 
			{
				winner = i;
				maxScore = players.get(i).getRoundScore();
			}
		}
		
		roundWinner = players.get(winner);
		roundWinner.setRoundWins(roundWinner.getRoundWins() + 1);
		return roundWinner;
	}
	
	/*
	 * Finds game winner
	 */
	public SkunkPlayer getGameWinner()
	{
		int winner = 0;
		int maxScore = players.get(0).getPlayerTotalScore();
		for (int i = 1; i < players.size(); i++)
		{
			if(maxScore < players.get(i).getPlayerTotalScore()) 
			{
				winner = i;
				maxScore = players.get(i).getPlayerTotalScore();
			}
		}
		
		return players.get(winner);
	}
	
	public void printAllPlayerNames()
	{
		for(int i = 0; i < players.size(); i++)
		{
			StdOut.println(players.get(i).getPlayerName());
		}
	}
	
	public boolean playGameForOnePlayer(SkunkPlayer player)
	{
		
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
			return false;
		} 
		else if (dice.getLastRoll1() == 1 || dice.getLastRoll2() == 1) // next player will take turn and voids players round score
		{
			if(rollScore ==3) //rolling a skunk and a "Deuce, needs to be in this if statement because if they roll a 2 and a 1 it goes to both statements and removes chips from both
			{
				player.setTotalScore(player.getPlayerTotalScore() - roundScore);
				player.setChips(player.getChips() - 2);
				StdOut.println("You rolled one skunk and a duece, next player will take turn." + " You have " + player.getChips() + " chips left");
				roundScore = 0;
				player.setRoundScore(roundScore);
				roundChips = roundChips + 2;
				return false;
			}
			else 
			{
				player.setTotalScore(player.getPlayerTotalScore() - roundScore);
				player.setChips(player.getChips() - 1);
				StdOut.println("You rolled one skunks, next player will take turn." + " You have " + player.getChips() + " chips left");
				roundScore = 0;
				player.setRoundScore(roundScore);
				roundChips ++;
				return false;
			}
		}
		else
		{
			roundScore += rollScore;
			player.setRoundScore(roundScore);
			player.addPoints(rollScore);
			
			StdOut.println("Your total score is " + player.getPlayerTotalScore());
		}
		return true;
	}
	
	public String getGameInstructions() 
	{
		return "The objective of the game is to accumulate a score of 100 points or more. A score is made by rolling the dice and combining \n"
				+ "the points on the two dice. The player has the privilege of continuing to shake to increase his score or of passing the dice to wait for \n"
				+ "the next series, thus preventing the possibility of rolling a Skunk and losing his score.\n"
				+ "Any number of players can play,The suggested number of chips to start is 50 \n"
				+ "The winner of each round collects all chips in \"kitty\" and in addition five chips from each losing player or 10 chips from any player without a score. \n"
				+ "The first player to accumulate a total of 100 or more points can continue to score as many points over 100 as he believes is needed to win.\n"
				+ "When he decides to stop, his total score is the \"goal.\" Each succeeding player receives one more chance to better the goal and end the game.\n"
				+ "\nPENALTIES: A skunk in any series voids the score for that series only and draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.\n"
				+ "A skunk and a deuce voids the score for that series only and draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.\n"
				+ "TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice.\nPlayer must again start to score from scratch.\n";
	}
	
	public int getRoundScore()
	{
		return roundScore;
	}

	public void setRoundScore(int roundScore)
	{
		this.roundScore = roundScore;
	}

	public int getRoundChips()
	{
		return roundChips;
	}

	public void setRoundChips(int roundChips)
	{
		this.roundChips = roundChips;
	}
	
}