/**
 * This class has two dice and allows roll them.
 * @see Dice.java file in the 635_craps_simulation project as reference
 */
public class SkunkDice
{
	private SkunkDie die1;
	private SkunkDie die2;

	public SkunkDice(SkunkDie die1, SkunkDie die2)
	{
		this.die1 = die1;
		this.die2 = die2;
	}

	public void roll()
	{
		die1.roll();
		die2.roll();
	}

	public int getLastRoll1()
	{
		return die1.getLastRoll();
	}

	public int getLastRoll2()
	{
		return die2.getLastRoll();
	}
	
	/*
	 * Returns total of both dice
	 */
	public int getLastTotalRoll()
	{
		return die1.getLastRoll() + die2.getLastRoll();
		
	}
}