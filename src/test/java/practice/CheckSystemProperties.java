package practice;

public class CheckSystemProperties {

	public static void main(String[] args) {

		String[] value ={
				"java.class.path", 
				"java.home",
				"java.vendor",
				"java.vendor.url",
				"java.version",
				"os.arch",
				"os.name",
				"os.version",
				"user.language",
				"user.dir",
				"user.home",
				"user.name"
		};


		for (String s : value) System.out.printf("%-20s : [%s] %n", s, System.getProperty(s));
		
	}

}
