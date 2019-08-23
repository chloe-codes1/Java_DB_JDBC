package day16_exception;

public class Test02_uncheckedException2 {

	public static void main(String[] args) {
		
		System.out.println("*** main start ***");
		
		String msg = null;
		
		msg = "xmlsadf";
		
		try {
			System.out.println(msg.charAt(3));
			int num = Integer.parseInt(msg);
			
		} catch (NullPointerException n) {
			
			System.out.println("예 외 발 생 : " +n.getMessage()); //null
			
		} catch (StringIndexOutOfBoundsException s) {
			// -> String class가 갖고있는 문자열의 길이를 벗어나는 메모리 공간에 접근하고자 할 때 발생!
			
			System.out.println("예 외 발 생 : "+s.getMessage()); //index
			
		} catch (NumberFormatException f) {
			
			System.out.println("예 외 발 생 : 정수로 입력 해주세요");
		
		} catch (Exception e) { //나머지 모든 exception들 잡겠다
								// -> 맨 마지막에 둬서 남은 예외를 잡아줌
			System.out.println("예 외 발 생 : "+e.getMessage());
		} finally {
			
			System.out.println(" finally { 자원 반납 코드 }");
		}// 항상 수행되기 때문에 자원반납 코드는 finally {} block으로 들어감!
		
		System.out.println("*** main end ***");
	}
}
