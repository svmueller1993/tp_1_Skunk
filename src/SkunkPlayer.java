/**
 * This class creates new player objects
 * @author saramueller
 *
 */
public class SkunkPlayer 
{
	private String name;
	private int totalScore;
	private int roundScore;
	private int lastRoundScore;
	private int chips;
	
	public SkunkPlayer(String name)
	{
		this.name = name;
		this.totalScore = 0;
		this.chips = 50; 
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getCurrentScore()
	{
		return totalScore + roundScore;
	}

	public int getTotalScore()
	{
		return totalScore;
	}

	public void setTotalScore(int totalScore)
	{
		this.totalScore = totalScore;
	}

	public int getRoundScore()
	{
		return roundScore;
	}

	public void setRoundScore(int roundScore)
	{
		this.roundScore = roundScore;
	}

	public int getChips()
	{
		return chips;
	}

	public void setChips(int chips)
	{
		this.chips = chips;
	}

	public int getLastRoundScore()
	{
		return lastRoundScore;
	}

	public void setLastRoundScore(int lastRoundScore)
	{
		this.lastRoundScore = lastRoundScore;
	}
	
	public void clearScores() {
		totalScore = 0;
		roundScore = 0;
		lastRoundScore = 0;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + name + ", score: " + totalScore + ", chips: " +chips;
	}
}