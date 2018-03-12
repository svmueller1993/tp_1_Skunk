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
		
		StdOut.println("How many players would like to play? You may have up to 8 players.");
		int num = StdIn.readInt();
		for(int i = 0; i < num; i++)
		{
			StdOut.println("Enter the name of player " + (i+ 1));
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

		int roundNumber = 0;
		while (roundNumber < 6)
		{
			StdOut.println("====================================================");
			StdOut.println("Game round : " + (roundNumber + 1));
			for (Iterator<SkunkPlayer> iterator = players.iterator(); iterator.hasNext();)
			{
				SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
				StdOut.println("Player name : " + skunkPlayer.getName());
				StdOut.println("Your total score is: " + skunkPlayer.getCurrentScore());

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
						StdOut.println("Player total score : " + skunkPlayer.getCurrentScore());
						StdOut.println("Your score is more than 100.");
						StdOut.println("The game winner is " + skunkPlayer.getName());
						System.exit(0);
					}
				}
				StdOut.println("Player total score : " + skunkPlayer.getCurrentScore());
				StdOut.println("--------------------------------------------------");

			}
			boolean temp = game.checkForTie();
			if(temp == false)
			{
			SkunkPlayer roundWinner = game.getRoundWinner();
			roundWinner.setChips(roundWinner.getChips() + game.getRoundChips());
			StdOut.println("The round winner is: " + roundWinner.getName() + " with a round score of "
					+ roundWinner.getLastRoundScore() + " and has recieved " + game.getRoundChips()
					+ " chips for a total of " + roundWinner.getChips() + " chips!");
			game.setRoundChips(0);
			}
			
			
			if(temp == true)
			{
				StdOut.println("There are " + game.roundTies.size() + " winners this round: " + " with a score of " + game.roundTies.get(0).getLastRoundScore() + ".");
				StdOut.println("Each player will recieve " + game.getRoundChips()/(game.roundTies.size()) +  " chips.");
				for (int i = 0; i < game.roundTies.size(); i++)
				{
					game.roundTies.get(i).setChips(game.roundTies.get(i).getChips() + game.getRoundChips()/(game.roundTies.size()));
					StdOut.println(game.roundTies.get(i).getName() + " now has a total of " + game.roundTies.get(i).getChips() + " chips");
				}
				
				game.setRoundChips(0);
			}
			
			
			roundNumber++;
		}

		SkunkPlayer winner = game.getGameWinner();
		StdOut.println("==================================================");
		StdOut.println("The game winner is " + winner.getName());
		StdOut.println("Total score : " + winner.getCurrentScore());

	}

}