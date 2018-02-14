import java.util.ArrayList;

/**
 * This die class returns predefined values on rolling.
 *
 */
public class PreProgrammedSkunkDie extends SkunkDie
{
	// Test class
	private ArrayList<Integer> predefinedValues = new ArrayList<Integer>();
	private int predefinedRoll;
	
	public PreProgrammedSkunkDie()
	{
		predefinedValues.add(1);
		predefinedValues.add(2);
		predefinedValues.add(3);
		predefinedValues.add(4);
		predefinedValues.add(5);
		predefinedValues.add(6);
		predefinedRoll = 0;
	}
	
	@Override
	public void roll()
	{	
		predefinedRoll++;
	}
	
	@Override
	public int getLastRoll()
	{
		if (predefinedRoll == predefinedValues.size()) {
			predefinedRoll = 0;
		}
		return predefinedValues.get(predefinedRoll);
	}
	
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
}