import java.util.ArrayList;
import java.util.Iterator;
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
		List<SkunkPlayer> players = new ArrayList<SkunkPlayer>();

		StdOut.println("You may have up to 8 players. How many players would like to play? ");
		int num = StdIn.readInt();
		for (int i = 0; i < num; i++)
		{
			StdOut.println("Enter the name of player: " + (i + 1));
			String name = StdIn.readString();
			players.add(new SkunkPlayer(name));
		}

		SkunkGame game = new SkunkGame(d1, d2, players);
		StdOut.println("There are " + players.size() + " players playing:");
		game.printAllPlayerNames();
		StdOut.println("\nWould you like to read the rules of the game?(y/n)");
		String a = StdIn.readString();
		// Part of assignment 3 - option to print out instructions
		if (a.equals("y"))
		{
			StdOut.println(game.getGameInstructions());
		}

		do
		{
			int roundNumber = 0;
			while (roundNumber < 6)
			{
				StdOut.println("====================================================");
				StdOut.println("Game round: " + (roundNumber + 1));
				for (Iterator<SkunkPlayer> iterator = players.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					StdOut.println("Player name: " + skunkPlayer.getName());
					StdOut.println("Your total score is: " + skunkPlayer.getCurrentScore());
					StdOut.println("Your total chips is: " + skunkPlayer.getChips());

					boolean continueGame = true;
					while (continueGame)
					{
						StdOut.println("\nWould you like to roll the dice(y/n)?");
						String d = StdIn.readString();
						if (d.equals("n"))
						{
							// next player will take turn
							skunkPlayer.setLastRoundScore(skunkPlayer.getRoundScore());
							game.finishRound(skunkPlayer);
							break;
						}
						continueGame = game.playGameForOneRound(skunkPlayer);

						if (skunkPlayer.getCurrentScore() >= 100)
						{
							StdOut.println("==================================================");
							StdOut.println("Player total score is: " + skunkPlayer.getCurrentScore());
							StdOut.println("Your score is more than 100.");
							StdOut.println("The round winner is: " + skunkPlayer.getName());
							skunkPlayer.setLastRoundScore(skunkPlayer.getRoundScore());
							game.finishRound(skunkPlayer);
							break;
						}
					}
					StdOut.println("Player total score is: " + skunkPlayer.getCurrentScore());
					StdOut.println("Player total chips is: " + skunkPlayer.getChips());
					StdOut.println("Total chips in the kitty: " + game.getRoundChips());
					StdOut.println("--------------------------------------------------");

				}

				roundNumber++;
			}
			
			game.collectChips();
			StdOut.println(game.displayChipNumbers());

			StdOut.println("\nWould you like to play another game?(y/n)");
			String y = StdIn.readString();
			// Part of assignment 3 - option to print out instructions
			if (y.equals("y"))
			{
				continue;
			}
			else
			{
				break;
			}

		}
		while (true);

		SkunkPlayer winner = game.getGameWinner();
		StdOut.println("==================================================");
		StdOut.println("The game winner is: " + winner.getName());
		StdOut.println("Total score is: " + winner.getTotalScore());
		StdOut.println("Total chips are: " + winner.getChips());

	}

}