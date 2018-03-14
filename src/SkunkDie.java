/**
 * This class presents die. It can be rolled and return last rolled value.
 * 
 * @author Bagy, Sara
 * @see Die.java file in the 635_craps_simulation project as reference
 */
public class SkunkDie
{
	private int lastRoll;

	public SkunkDie()
	{
		roll();
	}

	/**
	 * Set last roll value with random number between 1 and 6
	 */
	public void roll()
	{
		lastRoll = ((int) (Math.random() * 6 + 1));
	}

	/**
	 * Returns last roll value
	 * 
	 * @return value between 1 and 6
	 */
	public int getLastRoll()
	{
		return lastRoll;
	}

	@Override
	public String toString()
	{
		return "Die lastRoll=" + lastRoll;
	}

}