/**
 * This class starts Skunk game.
 * 
 * @author Bagy, Sara
 *
 */
public class SkunkApp 
{
	/**
	 * Testing roll method for pre-determined outcomes of the die roll
	 */
	public void PreDeterminedRoll()
	{
		StdOut.println("Would you like to roll the dice? Enter 1 for yes 2 for no");
		int ans = StdIn.readInt();

		PreProgrammedSkunkDie die1 = new PreProgrammedSkunkDie();
		PreProgrammedSkunkDie die2 = new PreProgrammedSkunkDie();
		SkunkDice dice = new SkunkDice(die1, die2);
		if(ans == 2)
		{
			System.out.println("Thanks for playing!");
		}
		while (ans == 1)
		{
			System.out.println(dice.getLastRoll1());
			System.out.println("Would you like to roll again?");
			ans = StdIn.readInt();
			if (ans == 1)
			{
				dice.roll();
				continue;
			}
			if (ans == 2)
			{
				StdOut.println("Thanks for playing!");
				break;
			}
		}

	}
	public static void main(String[]args)
	{
		SkunkApp p = new SkunkApp();
		p.PreDeterminedRoll();
	}
		
}