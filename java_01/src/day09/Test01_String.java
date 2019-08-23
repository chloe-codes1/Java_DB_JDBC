package day09;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Test01_String {

	public static void main(String[] args) {

		
	// [ String ]
		
//		String msg1 ="";
//		String msg2 = new String();
//		String msg3 = new String(new char[] {'a', 'b'});
//		String msg4 = args[0];
			//등등... string의 생성자 만드는 방법 15개가있음
		
	
	// [ keyboard로 입력받는 새로운 방법 ]	
		//==> JOptionPane.showInputDialog()
		
		String msg1 = JOptionPane.showInputDialog("book 정보를 입력하세요 ex. title/가격");
//		//Java Programming /23000 을 입력했음
//			//-> 이 문자열이 내부적으로는 char type의 배열로 관리됨
//				//= 배열이라서 문자열의 길이만큼의 (유효한) index를 벗어나면 안됨!
//			//-> 전체가 문자열이라 안에 있는 제목 정보와 가격 숫자를 구분 못해서
//			//slash(/)를 기준으로 쪼개야 함!
//		System.out.println(msg1);
//		
//		//소문자를 대문자로 바꾸어주는 기능 -> .toUpperCase()
//		System.out.println(msg1.toUpperCase());
//
//		System.out.println(msg1);
//		//.toUpperCase()를 써도 원본은 변하지 않음!
//				//-> 바뀐결과값을 return시키기만 하고 data를 변화 시키지는 않는다!
//			//-> String은 immutable(불변의) 객체라서 한번 메모리에 올라가면 변하지 않는것을 알 수 있음
//		
//		// 그래서 .toUpperCase() 쓴 결과로 data를 바꾸고 싶으면 이렇게 해야함
//		System.out.println(msg1=msg1.toUpperCase());
		
		
		
		
		//String msg1 = "Java Programming/23000";
		System.out.println(msg1);
		
	// [ .indexOf ]
		
		
		
		// .split() 을 제대로 동작시키기 위해 기준인 "/" 가 있는지 확인
		if(msg1.indexOf("/")==-1) {
			System.out.println("다시 입력하세요");
			System.out.println(" /가 필요합니다");
			return;
		}
		
	// [ .split() ]	
		// .split() -> split( )안에 들어가는 내용을 기준으로 쪼개줘라 
		String[] data = msg1.split("/");
		
		System.out.println(Arrays.toString(data));
		
	// [ .trim() ]
		// .trim() method로 앞뒤 공백 제거하기
		Book book1 = new Book(data[0].trim(),Integer.parseInt(data[1].trim()));
		
		
		Book book2 = new Book(data[0].trim(),Integer.parseInt(data[1].trim()));
		//Integer.parseInt로 / 뒤의 int data 받아옴
		
		book1.print();
		book2.print();
		
		
		
	}

}
