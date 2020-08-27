package common;

public class Logger {
	
	public static void log(String log) {
		System.out.println(log);
	}
	
	public static void err(String log) {
		System.err.println(log);
	}
	
	public static void start(String methodName) {
		System.out.println(String.format("\nTEST CASE: %s", methodName));
		System.out.println("\t\t---------");
	}
	
	public static void drawLine() {
		System.out.println("===============================================");
	}

}
