<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SkunkDieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSkunkDie()
	{
		SkunkDie die = new SkunkDie();
		assertNotNull(die);
	}

	@Test
	public void testRoll()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertTrue(lastRoll < 7);
		assertTrue(lastRoll > 0);
	}

	@Test
	public void testGetLastRoll()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertTrue(lastRoll < 7);
		assertTrue(lastRoll > 0);
	}

	@Test
	public void testToString()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertEquals("Die lastRoll=" + lastRoll, die.toString());
	}

}
=======
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SkunkDieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSkunkDie()
	{
		SkunkDie die = new SkunkDie();
		assertNotNull(die);
	}

	@Test
	public void testRoll()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertTrue(lastRoll < 7);
		assertTrue(lastRoll > 0);
	}

	@Test
	public void testGetLastRoll()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertTrue(lastRoll < 7);
		assertTrue(lastRoll > 0);
	}

	@Test
	public void testToString()
	{
		SkunkDie die = new SkunkDie();
		die.roll();
		int lastRoll = die.getLastRoll();
		assertEquals("Die lastRoll=" + lastRoll, die.toString());
	}

}
>>>>>>> branch 'master' of https://github.com/svmueller1993/tp_1_Skunk
