public class SkunkDie
{
	//Test class
	private ArrayList <Integer> die = new <Integer> ArrayList();
	Scanner scan = new Scanner(System.in);
	private int lastRoll;
	
	public SkunkDie()
	{
		die.add(1);
		die.add(2);
		die.add(3);
		die.add(4);
		die.add(5);
		die.add(6);
		lastRoll = 0;
		
		
	}
	
	public void PreDeterminedRoll() //Due Sat 2/17
	{
		System.out.println("Would you like to roll the dice? Enter 1 for yes 2 for no");
		int ans = scan.nextInt();
		lastRoll = 0;
		while (ans == 1)
		{
		System.out.println(die.get(lastRoll));
		System.out.println("Would you like to roll again?");
		ans = scan.nextInt();
		if(ans ==1)
		{
		lastRoll++;
		continue;
		}
		if (ans == 2)
		{
			break;
		}
		}
		
		if(ans == 2)
		{
			System.out.println("Thanks for playing!");
		}
			
	}
		
		
	
	
	
	public static void main(String[] args)
	{
		SkunkDie s = new SkunkDie();
		s.PreDeterminedRoll();
	}
	
}

