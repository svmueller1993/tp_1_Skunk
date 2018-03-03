import java.util.ArrayList;
import java.util.List;

/**
 * This class starts Skunk game.
 * 
 * @author Bagy, Sara
 *
 */
public class SkunkApp
{

	public static void main(String[] args)
	{
		SkunkDie d1 = new SkunkDie();
		SkunkDie d2 = new SkunkDie();
		SkunkGame game = new SkunkGame(d1, d2);
		
		List<SkunkPlayer> players = new ArrayList<SkunkPlayer>();
		players.add(new SkunkPlayer("PlayerOne"));
		players.add(new SkunkPlayer("PlayerTwo"));
		
		game.startGame(players);
	}

}