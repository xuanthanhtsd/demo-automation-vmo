package common;

import org.apache.commons.lang3.RandomStringUtils;

public class Const {
	
	public static class Configurations{
		
		public static String CHROME_PATH = "src/test/resources/driver/chromedriver.exe";
		public static String FIREFOX_PATH = "src/test/resources/driver/geckodriver.exe";
		public static String PATH = "https://simon-wbo.btn.vmo.group/";
		public static String GRID_HUB = "http://172.16.0.8:4444/wd/hub";
		public static Browser browser = Browser.CHROME;
		public static boolean HEADLESS = false;
		public static boolean GRID = true;
	}
	
	public static class Expectations{
		public static String REQUIRED_USER_NAME = "Username is required";
		public static String REQUIRED_PASSWORD = "Password is required";
		public static String WRONG_USER_PASS = "username or password incorrect.";
		public static String FAIL = "test case is failed";
		public static String LOGIN_TITLE = "Login";
		public static String HOME_PAGE_TITLE = "Home";
	}
	
	public static class Inputs{
		public static String USER_NAME = "huong";
		public static String PASSWORD = "btn654321";
		public static String BLANK_VALUE = "";
		public static String WRONG_USER_PASS = RandomStringUtils.randomAlphabetic(10);
		public static String SPECIAL_CHARACTER = "!@#$%^&*()";
	}
	
	

}
