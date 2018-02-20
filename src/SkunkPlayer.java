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
	private int whiteChips;
	private int blueChips;
	private int redChips;
	private boolean standing;
	
	
	public SkunkPlayer(String name)
	{
		playerName = name;
		playerTotalScore = 0;
		whiteChips = 10; //just a filler number, not sure how many chips to assign to each player
		blueChips = 5;
		redChips = 2;
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
	public int getWhiteChips()
	{
		return whiteChips;
	}
	
	/*
	 * Getter for players amount of red chips
	 */
	public int getRedChips()
	{
		return redChips;
	}
	
	/*
	 * Getter for players amount of blue chips
	 */
	public int getBlueChips()
	{
		return blueChips;
	}

}
