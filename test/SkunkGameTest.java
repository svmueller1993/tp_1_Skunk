import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;
//Can't  test getRoundWinner, playGame, or playGameForOnePlayer
class SkunkGameTest
{

	@Before
	public void setUp() throws Exception
	{
	}
	
	
	@Test
	void testSetUpPlayers()
	{
		SkunkDie d1 = new SkunkDie();
		SkunkDie d2 = new SkunkDie();
		SkunkGame s = new SkunkGame(d1,d2);
		s.setUpPlayers();
		assertTrue(s.players.size() == 2);//as long as user enters 2 when prompted
		
	}
	

}
