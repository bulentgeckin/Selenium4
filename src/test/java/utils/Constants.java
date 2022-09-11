package utils;

public class Constants {

	public static final String USER_PATH = java.lang.System.getProperty("user.dir");
	public static final String OS_NAME = java.lang.System.getProperty("os.name");
	public static final String USER_NAME = java.lang.System.getProperty("user.name");

	public static final String WEB_DRIVERS_PATH = USER_PATH + "/src/test/resources/webDrivers/";
	public static final long PAGE_LOAD_TIME = 30;
	public static final long IMPLICITLY_LOAD_TIME = 10;
	public static final long EXPLICIT_LOAD_TIME = 30;
	public static final String SCREENSHOTS_FILEPATH = USER_PATH + "/target/screenshots/";
	public static final String CREDENTIALS_FILEPATH = USER_PATH + "/src/test/resources/Configuration.properties";



}
