package common;

import org.testng.Reporter;

public class Report extends Reporter {
	
	public static void step(String log) {
		Logger.log(log);
		Reporter.log(log);
	}
	
	public static void precondition(String log) {
		String value = "-----Precondition: " + log;
		Logger.log(value);
		Reporter.log(value);
	}
	
	public static void verify(String log) {
		Logger.log("\t- " + log);
		Reporter.log("&emsp;&emsp;- " + log);
	}
	
	public static void error(String log) {
		String value = "-----Error: " + log;
		Logger.err(value);
		Reporter.log(value);
	}

}
