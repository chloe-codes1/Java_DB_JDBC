package day10;

public class Test01 {

	public static void main(String[] args) {
		
		
	// [ equals 활용 ]	
		
		System.out.println("java Programing".equals("Java Programing"));
		System.out.println("java Programing".equals("JAVA Programing"));
		System.out.println("java Programing".equalsIgnoreCase("JAVA proGRAMING"));
		System.out.println("java Programing".equalsIgnoreCase("JAVA"));
		System.out.println("java Programing".equalsIgnoreCase("java"));
		System.out.println("java Programing".contains("JAVA"));
		System.out.println("java Programing".toLowerCase().contains("JAVA"));
		System.out.println("java Programing".toLowerCase().contains("JAVA".toLowerCase()));
		
		System.out.println("-----------------------------------");
		
	}

}
