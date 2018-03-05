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
		players.add(new SkunkPlayer("PlayerOne"));
		players.add(new SkunkPlayer("PlayerTwo"));

		SkunkGame game = new SkunkGame(d1, d2, players);

		StdOut.println("\nWould you like to read the rules of the game?(y/n)");
		String a = StdIn.readString();
		// Part of assignment 3 - option to print out instructions
		if (a.equals("y"))
		{
			StdOut.println(game.getGameInstructions());
		}

		int roundNumber = 0;
		while (roundNumber < 6)
		{
			StdOut.println("====================================================");
			StdOut.println("Game round : " + (roundNumber + 1));
			for (Iterator<SkunkPlayer> iterator = players.iterator(); iterator.hasNext();)
			{
				SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
				StdOut.println("Player name : " + skunkPlayer.getPlayerName());
				StdOut.println("Your total score is: " + skunkPlayer.getPlayerTotalScore()
						+ ". Your total number of round wins are: " + skunkPlayer.getRoundWins());

				boolean continueGame = true;
				while (continueGame)
				{
					StdOut.println("\nWould you like to roll the dice(y/n)?");
					String d = StdIn.readString();
					if (d.equals("n"))
					{
						game.setRoundScore(0);
						// next player will take turn
						break;
					}
					continueGame = game.playGameForOnePlayer(skunkPlayer);

					if (skunkPlayer.getPlayerTotalScore() >= 100)
					{
						StdOut.println("==================================================");
						StdOut.println("Player total score : " + skunkPlayer.getPlayerTotalScore());
						StdOut.println("Your score is more than 100.");
						StdOut.println("The game winner is " + skunkPlayer.getPlayerName());
						System.exit(0);
					}
				}
				StdOut.println("Player total score : " + skunkPlayer.getPlayerTotalScore());
				StdOut.println("--------------------------------------------------");

			}
			SkunkPlayer roundWinner = game.getRoundWinner();
			roundWinner.setChips(roundWinner.getChips() + game.getRoundChips());
			// adding chips taken from players who rolled skunk and giving it to
			// the player with the highest round score
			StdOut.println("The round winner is: " + roundWinner.getPlayerName() + " with a round score of "
					+ roundWinner.getRoundScore() + " and has recieved " + game.getRoundChips()
					+ " chips for a total of " + roundWinner.getChips() + " chips!");
			roundNumber++;
		}

		SkunkPlayer winner = game.getGameWinner();
		StdOut.println("==================================================");
		StdOut.println("The game winner is " + winner.getPlayerName());
		StdOut.println("Total score : " + winner.getPlayerTotalScore());

	}

}