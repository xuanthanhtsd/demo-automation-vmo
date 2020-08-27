package common;

import org.testng.Assert;

public class Assertion extends Assert {
	
	public static void AssertTrue(boolean expected, String log) {
		if (!expected) {
			Report.error(log);
		}
		Assert.assertTrue(expected);
	}

	public static void AssertEqual(String actual, String expected, String log) {
		if (!actual.equals(expected)) {
			Report.error(log);
		}
		Assert.assertEquals(actual, expected);
	}

}
