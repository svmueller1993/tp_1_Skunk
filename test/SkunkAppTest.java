import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class SkunkAppTest
{

	@Test
	public void test()
	{
		fail("Not yet implemented");
	}

	@Test
	public static void testPreDeterminedRoll()
	{
		SkunkApp s = new SkunkApp();
		s.roll();
		s.roll();
		s.roll();
		Assert.assertEquals(3, s.getLastRoll());
	}

}
