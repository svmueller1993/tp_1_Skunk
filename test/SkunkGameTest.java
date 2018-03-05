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
		die1 = new PreProgrammedSkunkDie(new Integer[] {6,5,4,2,1});
		die2 = new PreProgrammedSkunkDie(new Integer[] {6,5,4,2,2});
		game = new SkunkGame(die1, die2, players);
		assertNotNull(game);
	}
	
	@Test
	public void test_one_roll() 
	{	
		die1 = new PreProgrammedSkunkDie(new Integer[] {6});
		die2 = new PreProgrammedSkunkDie(new Integer[] {6});
		game = new SkunkGame(die1, die2, players);
		
		assertEquals(true,game.playGameForOnePlayer(player1));
		assertEquals(12, player1.getRoundScore());
	}
	
	@Test
	public void test_two_rolls() 
	{	
		die1 = new PreProgrammedSkunkDie(new Integer[] {6, 5});
		die2 = new PreProgrammedSkunkDie(new Integer[] {4, 5});
		game = new SkunkGame(die1, die2, players);
		
		assertEquals(true,game.playGameForOnePlayer(player1));
		assertEquals(true,game.playGameForOnePlayer(player1));
		assertEquals(20, player1.getRoundScore());
		assertEquals(20, player1.getPlayerTotalScore());
	}
	
	@Test
	public void test_two_rolls_with_one_skunk() 
	{	
		die1 = new PreProgrammedSkunkDie(new Integer[] {6, 1});
		die2 = new PreProgrammedSkunkDie(new Integer[] {4, 5});
		game = new SkunkGame(die1, die2, players);
		
		assertEquals(true,game.playGameForOnePlayer(player1));
		assertEquals(false,game.playGameForOnePlayer(player1));
		assertEquals(0, player1.getRoundScore());
		assertEquals(0, player1.getPlayerTotalScore());
	}

}
