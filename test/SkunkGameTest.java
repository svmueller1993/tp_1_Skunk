import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SkunkGameTest
{

	SkunkGame game;
	PreProgrammedSkunkDie die1;
	PreProgrammedSkunkDie die2;
	SkunkPlayer player1;
	SkunkPlayer player2;
	List<SkunkPlayer> players;

	@Before
	public void setUp() throws Exception
	{
		players = new ArrayList<SkunkPlayer>();
		player1 = new SkunkPlayer("PlayerOne");
		players.add(player1);
		player2 = new SkunkPlayer("PlayerTwo");
		players.add(player2);

	}

	@Test
	public void test_constructor()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 5, 4, 2, 1 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 5, 4, 2, 2 });
		game = new SkunkGame(die1, die2, players);
		assertNotNull(game);
	}

	@Test
	public void test_one_turn()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 6 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(12, player1.getRoundScore());
	}

	@Test
	public void test_one_round_with_two_turns()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 5 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 5 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(20, player1.getRoundScore());
		assertEquals(20, player1.getCurrentScore());
	}

	@Test
	public void test_one_round_with_two_turns_one_skunk()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 1 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 5 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(false, game.playGameForOneRound(player1));
		assertEquals(0, player1.getRoundScore());
		assertEquals(0, player1.getCurrentScore());
	}

	@Test
	public void test_two_rounds_with_one_skunk()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6, 1 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6, 5 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(10, player1.getRoundScore());
		assertEquals(10, player1.getCurrentScore());
		game.finishRound(player1);
		assertEquals(true, game.playGameForOneRound(player2));
		assertEquals(12, player2.getRoundScore());
		assertEquals(12, player2.getCurrentScore());
		game.finishRound(player2);
		assertEquals(false, game.playGameForOneRound(player1));
		assertEquals(0, player1.getRoundScore());
		assertEquals(10, player1.getCurrentScore());
	}

	@Test
	public void test_two_rounds_with_two_skunks()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6, 1 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6, 1 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(10, player1.getRoundScore());
		assertEquals(10, player1.getCurrentScore());
		game.finishRound(player1);
		assertEquals(true, game.playGameForOneRound(player2));
		assertEquals(12, player2.getRoundScore());
		assertEquals(12, player2.getCurrentScore());
		game.finishRound(player2);
		assertEquals(false, game.playGameForOneRound(player1));
		assertEquals(0, player1.getRoundScore());
		assertEquals(0, player1.getCurrentScore());
	}
	
	@Test
	public void test_two_rounds_with_skunk_and_deuce()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6, 1 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6, 2 });
		game = new SkunkGame(die1, die2, players);

		assertEquals(true, game.playGameForOneRound(player1));
		assertEquals(10, player1.getRoundScore());
		assertEquals(10, player1.getCurrentScore());
		game.finishRound(player1);
		assertEquals(true, game.playGameForOneRound(player2));
		assertEquals(12, player2.getRoundScore());
		assertEquals(12, player2.getCurrentScore());
		game.finishRound(player2);
		assertEquals(false, game.playGameForOneRound(player1));
		assertEquals(0, player1.getRoundScore());
		assertEquals(10, player1.getCurrentScore());
		assertEquals(48, player1.getChips());
	}

	@Test
	public void test_game_winner_tie()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6 });
		game = new SkunkGame(die1, die2, players);

		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertTrue(game.getGameWinner().contains(player1));
		assertTrue(game.getGameWinner().contains(player2));
	}
	
	@Test
	public void test_game_winner()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6 });
		game = new SkunkGame(die1, die2, players);

		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertFalse(game.getGameWinner().contains(player1));
		assertTrue(game.getGameWinner().contains(player2));
	}
	
	@Test
	public void test_round_winner()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6 });
		game = new SkunkGame(die1, die2, players);

		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertTrue(game.getRoundWinner().contains(player2));
		assertTrue(game.getRoundWinner().size() == 1);
		assertEquals(55,player2.getChips());
	}
	
	@Test
	public void test_round_winner_with_zero_score_loser()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 0, 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 0, 6 });
		game = new SkunkGame(die1, die2, players);

		game.playGameForOneRound(player1);
		game.finishRound(player1);
		game.playGameForOneRound(player2);
		game.finishRound(player2);
		game.collectChips();
		assertTrue(game.getRoundWinner().contains(player2));
		assertTrue(game.getRoundWinner().size() == 1);
		assertEquals(60,player2.getChips());
	}
	
	@Test
	public void test_game_instructions()
	{
		die1 = new PreProgrammedSkunkDie(new Integer[]
		{ 6, 6 });
		die2 = new PreProgrammedSkunkDie(new Integer[]
		{ 4, 6 });
		game = new SkunkGame(die1, die2, players);

		assertNotNull(game.getGameInstructions());
	}
	
	@Test
	public void test_displayChipNumbers() {
		game = new SkunkGame(die1, die2, players);
		assertEquals("\nPlayerOne, total score:0, chips:50" + 
				"\nPlayerTwo, total score:0, chips:50",game.displayChipNumbers());
	}
	
	@Test
	public void test_roundChips() {
		game = new SkunkGame(die1, die2, players);
		game.setRoundChips(5);
		assertEquals(5, game.getRoundChips());
	}

}