package day02_ex;

public class Prob1 {

	public static void main(String[] args) {
		int tom = -1;
		char marry = '9';
		boolean john = 4>10;
		String sarah = "Sarah Jang";
		
		System.out.println("our friends..\n"
		+ tom + ", " + marry + ", " + john + " and " + sarah);
		

		System.out.printf("our friends..\n%d, %c, %b and %s %n", tom, marry, john, sarah);  //%n은 줄바꿈~~
		
		System.out.printf("our friends..\n%s, %s, %s and %s %n", tom, marry, john, sarah);  //이렇게 다 %s (string) 으로 해도 됨!!!

		
	}

}
