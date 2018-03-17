import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SkunkPlayerTest
{

	@Before
	public void setUp() throws Exception
	{
		
	}

	@Test
	public void testSkunkPlayer()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		assertNotNull(p);
	}
	
	@Test
	public void testSetTotalScore()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		p.setTotalScore(10);
		int points = p.getTotalScore();
		assertTrue(points == 10);
	}
	
	@Test
	public void testGetRoundsetRoundScore()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		p.setRoundScore(4);
		assertTrue(p.getRoundScore() == 4);
	}
	
	@Test
	public void testGetPlayerName()
	{
		String name = "Test Player";
		SkunkPlayer p = new SkunkPlayer(name);
		assertTrue(p.getName() == name);
	}
	
	@Test
	public void testSetPlayerName()
	{
		String name = "Test Player";
		SkunkPlayer p = new SkunkPlayer("");
		p.setName(name);
		assertTrue(p.getName() == name);
	}
	
	@Test
	public void testGetChipsSetChips()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		p.setChips(55);
		assertTrue(p.getChips() == 55);
	}
	
	@Test
	public void testToString()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		System.out.println(p.toString());
		assertEquals("Name: Test Player, total score: 0, round score: 0, chips: 50, games won: 0", p.toString());
	}
	
	@Test
	public void testClearScore()
	{
		SkunkPlayer p = new SkunkPlayer("Test Player");
		p.setLastRoundScore(1);
		p.setRoundScore(1);
		p.setTotalScore(1);
		p.clearScores();
		assertEquals(0,p.getLastRoundScore());
		assertEquals(0,p.getTotalScore());
		assertEquals(0,p.getRoundScore());
	}
	
}