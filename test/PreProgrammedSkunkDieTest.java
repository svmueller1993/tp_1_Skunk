<<<<<<< HEAD
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreProgrammedSkunkDieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testRoll()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(2, die.getLastRoll());
	}

	@Test
	public void testGetLastRoll()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		die.roll();
		assertEquals(1, die.getLastRoll());
	}

	@Test
	public void testPreProgrammedSkunkDie()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		assertNotNull(die);
	}

}
=======
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreProgrammedSkunkDieTest
{

	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testRoll()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		die.roll();
		assertEquals(1, die.getLastRoll());
		die.roll();
		assertEquals(2, die.getLastRoll());
	}

	@Test
	public void testGetLastRoll()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		die.roll();
		assertEquals(1, die.getLastRoll());
	}

	@Test
	public void testPreProgrammedSkunkDie()
	{
		PreProgrammedSkunkDie die = new PreProgrammedSkunkDie();
		assertNotNull(die);
	}

}
>>>>>>> branch 'master' of https://github.com/svmueller1993/tp_1_Skunk
