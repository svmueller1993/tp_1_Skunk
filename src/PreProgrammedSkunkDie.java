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
	
	
}