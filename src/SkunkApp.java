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

		StdOut.println("You may have up to 8 players. Please, enter number only. How many players would like to play? ");
		int num = StdIn.readInt();
		for (int i = 0; i < num; i++)
		{
			StdOut.println("Enter the name of player: " + (i + 1));
			String name = StdIn.readString();
			players.add(new SkunkPlayer(name));
		}

		SkunkGame game = new SkunkGame(d1, d2, players);
		StdOut.println("====================================================");
		StdOut.println("There are " + players.size() + " players playing:");
		for(int i = 0; i < players.size(); i++)
		{
			StdOut.println(players.get(i).getName());
		}
		StdOut.println("====================================================");
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
				StdOut.println("Round: " + (roundNumber + 1));
				for (Iterator<SkunkPlayer> iterator = players.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					StdOut.println("Your turn, player name: " + skunkPlayer.getName()
						+ " (score: "+ skunkPlayer.getCurrentScore() +", chips: "+ skunkPlayer.getChips() +")");
					game.printAllPlayerScores();
					StdOut.println("--------------------------------------------------");

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

						if (d.equals("n") && skunkPlayer.getCurrentScore() >= 100)
						{
							StdOut.println("==================================================");
							StdOut.println("Player total score is: " + skunkPlayer.getCurrentScore());
							StdOut.println("Your score is more than 100.");
							StdOut.println("The game winner is: " + skunkPlayer.getName());
							skunkPlayer.setLastRoundScore(skunkPlayer.getRoundScore());
							game.finishRound(skunkPlayer);
							break;
						}
					}
					StdOut.println("Your turn is finished, " + skunkPlayer.getName()
							+ " (Total score: "+ skunkPlayer.getCurrentScore() +", round score: " + skunkPlayer.getLastRoundScore() + ", chips: "+ skunkPlayer.getChips() +")");
					StdOut.println("Total chips in the kitty: " + game.getRoundChips());
					StdOut.println("===================================================");

				}


				StdOut.println("===================================================");
				StdOut.println("This round "+ (roundNumber + 1) +" is finished.");
				StdOut.println("This round "+ (roundNumber + 1) +" winner:");
				List<SkunkPlayer> list = game.getRoundWinner();
				if (list != null) {
					for (Iterator iterator = list.iterator(); iterator.hasNext();)
					{
						SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
						StdOut.println(skunkPlayer);
					}
				}
				roundNumber++;
			}
			
			game.collectChips();
			StdOut.println(game.displayChipNumbers());
			StdOut.println("===================================================");
			StdOut.println("This game is finished.");
			StdOut.println("Collected chips.");
			StdOut.println("This game winner:");
			List<SkunkPlayer> list = game.getGameScoreWinner();
			if (list != null) {
				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					skunkPlayer.setGamesWon(skunkPlayer.getGamesWon() + 1);
					StdOut.println(skunkPlayer);
				}
			}

			StdOut.println("\nWould you like to continue play game?(y/n)");
			String y = StdIn.readString();
			if (y.equals("y"))
			{
				
				// clear previous round scores
				for (Iterator iterator = players.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					skunkPlayer.clearScores();
					StdOut.println(skunkPlayer);
				}
				continue;
			}
			else
			{
				break;
			}

		}
		while (true);

		StdOut.println("==================================================");
		StdOut.println("The end of Skunk Game.");
		StdOut.println("The winner of all games:");
		List<SkunkPlayer> list = game.getGameWinner();
		if (list != null) {
			for (Iterator iterator = list.iterator(); iterator.hasNext();)
			{
				SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
				StdOut.println(skunkPlayer);
			}
		}

	}

}