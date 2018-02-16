
public class SkunkPlayer {
	
	private String playerName;
	private int playerTotalScore;
	private int playerRoundScore;
	private int whiteChips;
	private int blueChips;
	private int redChips;
	
	public SkunkPlayer(String name)
	{
		playerName = name;
		playerTotalScore = 0;
		playerRoundScore = 0;
		whiteChips = 10; //just a filler number, not sure how many chips to assign to each player
		blueChips = 5;
		redChips = 2;
	}
	
	/**
	 * Adds round points to total score
	 * @param numberOfRoundPoints
	 */
	public void addPoints(int numberOfRoundPoints)
	{
		playerRoundScore = numberOfRoundPoints;
		playerTotalScore += playerRoundScore;
	}
	
	/*
	 * Voids the players round score when skunk is rolled
	 */
	public void voidRoundScore()
	{
		playerRoundScore = 0;
	}
	
	/*
	 * Voids the players total score when two skunks rolled
	 */
	public void totalScoreVoid()
	{
		playerTotalScore = 0;
	}
	
	/*
	 * Getter for players total score
	 */
	public int getPlayerTotalScore()
	{
		return playerTotalScore;
	}
	
	/*
	 * Getter for players round score
	 */
	public int getPlayerRoundScore()
	{
		return playerRoundScore;
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
