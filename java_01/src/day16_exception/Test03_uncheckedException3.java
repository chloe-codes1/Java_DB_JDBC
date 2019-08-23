package day16_exception;

public class Test03_uncheckedException3 {

public static void main(String[] args) {
		
		System.out.println("*** main start ***");
		
		//NullPointerException을 if구문으로 잡기
		
		String msg = null;
		
		msg = "xmlsadf";
		
		try {
			if (msg!= null) { 
				System.out.println(msg.charAt(3));
			int num = Integer.parseInt(msg);
			}
		} catch (Exception e) { //나머지 모든 exception들 잡겠다

			System.out.println("예 외 발 생 : "+e.getMessage());
		} finally {
			System.out.println(" finally { 자원 반납 코드 }");
		} // -> 항상 수행되기 때문에 자원반납 코드는 finally {} block으로 들어감!
		System.out.println("*** main end ***");
	}
}
