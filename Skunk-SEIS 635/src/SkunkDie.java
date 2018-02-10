import java.util.ArrayList;
import java.util.Scanner;


public class SkunkDie
{

	private ArrayList <Integer> die = new <Integer> ArrayList();
	Scanner scan = new Scanner(System.in);
	
	public SkunkDie()
	{
		die.add(1);
		die.add(2);
		die.add(3);
		die.add(4);
		die.add(5);
		die.add(6);
		
		
	}
	
	public void roll()
	{
		System.out.println("Would you like to roll the die? Enter 1 for yes and 2 for no");
		int ans = scan.nextInt();
		
	}
	
	
}
