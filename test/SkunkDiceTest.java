<<<<<<< HEAD
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class SkunkDiceTest
{

	SkunkDie die1 = new PreProgrammedSkunkDie();
	SkunkDie die2 = new PreProgrammedSkunkDie();

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSkunkDice()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		assertNotNull(dice);
	}

	@Test
	public void testRoll()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll1());
		assertEquals(1, dice.getLastRoll2());
		dice.roll();
		assertEquals(2, dice.getLastRoll1());
		assertEquals(2, dice.getLastRoll2());

	}

	@Test
	public void testGetLastRoll1()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll1());
	}

	@Test
	public void testGetLastRoll2()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll2());
	}

}
=======
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class SkunkDiceTest
{

	SkunkDie die1 = new PreProgrammedSkunkDie();
	SkunkDie die2 = new PreProgrammedSkunkDie();

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testSkunkDice()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		assertNotNull(dice);
	}

	@Test
	public void testRoll()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll1());
		assertEquals(1, dice.getLastRoll2());
		dice.roll();
		assertEquals(2, dice.getLastRoll1());
		assertEquals(2, dice.getLastRoll2());

	}

	@Test
	public void testGetLastRoll1()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll1());
	}

	@Test
	public void testGetLastRoll2()
	{
		SkunkDice dice = new SkunkDice(die1, die2);
		dice.roll();
		assertEquals(1, dice.getLastRoll2());
	}

}
>>>>>>> branch 'master' of https://github.com/svmueller1993/tp_1_Skunk
