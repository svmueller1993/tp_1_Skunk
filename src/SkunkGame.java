/**
 * This class will have Skunk game logic.
 *  
 * @see CrapsGame.java
 *
 */
public class SkunkGame
{
	SkunkDice dice;
	SkunkDie die1;
	SkunkDie die2;
	
	public SkunkGame(SkunkDie pDie1, SkunkDie pDie2)
	{
		this.dice = new SkunkDice(pDie1, pDie2);
		this.die1 = pDie1;
		this.die2 = pDie2;
	}
	
	public void playGame()
	{
		
	}
}
