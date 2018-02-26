import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class creates new player objects
 * @author saramueller
 *
 */

public class SkunkPlayer 
{
	
	private String playerName;
	private int playerTotalScore;
	private int playerRollScore;
	private int playerRoundScore;
	private int Chips;
	private boolean standing;
	private int roundWins;
	
	
	public SkunkPlayer(String name)
	{
		playerName = name;
		playerTotalScore = 0;
		Chips = 50; 
		
	}
	
	
	/**
	 * Adds round points to total score
	 * @param numberOfRoundPoints
	 */
	public void addPoints(int numberOfRollPoints)
	{
		playerRollScore = numberOfRollPoints;
		playerTotalScore += playerRollScore;
	}
	
	/*
	 * Voids the players total score when two skunks rolled
	 */
	public void totalScoreVoid()
	{
		playerTotalScore = 0;
	}
	
	
	public void setTotalScore(int score)
	{
		playerTotalScore = score;
	}
	/*
	 * getter for players round score
	 */
	public int getRoundScore()
	{
		return playerRoundScore;
	}
	/*
	 * Setter for round score
	 */
	public void setRoundScore(int score)
	{
		playerRoundScore = score;
	}
	/*
	 * Setter for if the player is standing or not
	 */
	public void setStanding(boolean a)
	{
		standing = a;
	}
	
	/*
	 * returns whether or not the player is standing
	 */
	public boolean getStanding()
	{
		return standing;
	}
	
	/*
	 * Getter for player name
	 */
	public String getPlayerName()
	{
		return playerName;
	}
	
	/*
	 * Getter for players total score
	 */
	public int getPlayerTotalScore()
	{
		return playerTotalScore;
	}
	
	/*
	 * Getter for players amount of white chips
	 */
	public int getChips()
	{
		return Chips;
	}
	
	/*
	 * Setter for chips
	 */
	public void setChips(int num)
	{
		Chips = num;
	}
	
	public void setRoundWins(int num)
	{
		roundWins = num;
	}
	
	public int getRoundWins()
	{
		return roundWins;
	}
	
}
