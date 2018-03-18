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
		int num;
		while (true) {
			StdOut.println("How many players would like to play (2-8)? ");
			num = StdIn.readInt();

			if (num < 2 || num > 8) {
				StdOut.println("Invalid number. Please enter again.");
			} else {
				break;
			}
		}
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
outterloop: 	while (roundNumber < 6)
			{
				StdOut.println("====================================================");
				StdOut.println("Round: " + (roundNumber + 1));
				for (Iterator<SkunkPlayer> iterator = players.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					StdOut.println("Your turn " + skunkPlayer.getName()
						+ " (score: "+ skunkPlayer.getCurrentScore() +", chips: "+ skunkPlayer.getChips() +")");
					StdOut.println("\nThe Scoreboard is: ");
					for(Iterator iterator1 = players.iterator(); iterator1.hasNext();)
					{
						SkunkPlayer skunkPlayer1 = (SkunkPlayer) iterator1.next();
						StdOut.println("\n" + skunkPlayer1.getName() + ": total score: " + skunkPlayer1.getTotalScore() + ", chips: " + skunkPlayer1.getChips());
					}
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
							if (skunkPlayer.getCurrentScore() >= 100)
							{
								StdOut.println("==================================================");
								StdOut.println("\n" + skunkPlayer.getName() + "'s total score is: " + skunkPlayer.getCurrentScore());
								StdOut.println("Your score is more than 100.");
								StdOut.println("The game winner is: " + skunkPlayer.getName());
								skunkPlayer.setLastRoundScore(skunkPlayer.getRoundScore());
								game.finishRound(skunkPlayer);
								
								for(int i = 0; i < players.size(); i++)
								{
									SkunkPlayer p = players.get(i);
									if (p != skunkPlayer)
									{	
										StdOut.println("\n" + p.getName() + " you have one more chance to get to 100.");
										boolean continueRoundGame = true;
										while (continueRoundGame)
										{
											StdOut.println("\n" + p.getName() + " Would you like to roll the dice(y/n)?");
											d = StdIn.readString();
											if (d.equals("n"))
											{
												// next player will take turn
												p.setLastRoundScore(p.getRoundScore());
												game.finishRound(p);
												if (p.getCurrentScore() >= 100)
												{
													StdOut.println("==================================================");
													StdOut.println(p.getName() + "'s total score is: " + p.getCurrentScore());
													StdOut.println("Your score is more than 100.");
													StdOut.println("The game winner is: " + p.getName());
													p.setLastRoundScore(p.getRoundScore());
													p.setGamesWon(p.getGamesWon() + 1);
													game.finishRound(p);
													break;
											
												}
												break;
											}
											
											else
											{
												continueGame = game.playGameForOneRound(p);
											}
										}
									}
								}
								break outterloop;
							}
							break;
						}
						continueGame = game.playGameForOneRound(skunkPlayer);
							
					}
					StdOut.println("Your turn is over, " + skunkPlayer.getName()
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
			StdOut.println("=======================================");
			if (list != null) {
				for (Iterator iterator = list.iterator(); iterator.hasNext();)
				{
					SkunkPlayer skunkPlayer = (SkunkPlayer) iterator.next();
					skunkPlayer.setGamesWon(skunkPlayer.getGamesWon() + 1);
					StdOut.println(skunkPlayer);
				}
			}

			StdOut.println("\nWould you like to play another game?(y/n)");
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