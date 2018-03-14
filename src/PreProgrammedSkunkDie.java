import java.util.ArrayList;

/**
 * This die class returns predefined values on rolling.
 * @see CrookedDie2.java file in the 635_craps_simulation project as reference
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
		predefinedRoll = -1;
	}
	
	public PreProgrammedSkunkDie(Integer[] values)
	{
		for (int i = 0; i < values.length; i++)
		{
			predefinedValues.add(values[i]);
		}
		predefinedRoll = -1;
	}

	@Override
	public void roll()
	{
		predefinedRoll++;
	}

	@Override
	public int getLastRoll()
	{
		if (predefinedRoll >= predefinedValues.size())
		{
			predefinedRoll = 0;
		}
		if (predefinedRoll < 0)
		{
			predefinedRoll = 0;
		}
		return predefinedValues.get(predefinedRoll);
	}

}