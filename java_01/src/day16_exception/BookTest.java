package day16_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BookTest {

	public static void main(String[] args) {

		//객체 생성하여 try catch로 예외 처리
		
//		try {
//			Book book = new Book("java", -9000);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			
//			//객체 만들 때마다 try-catch해야해서 번거롭다고 생각 할 수 있지만,
//			//에러메세지를 내가 원하는곳에서 출력시킬 수 있다는 장점이 있음
//		}
	
		//Scanner로 생성한 객체 예외 처리
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("sampleTest.txt"));
			while (scanner.hasNextLine()) {
					String[] data = scanner.nextLine().replace('_','/').split("/");
			//System.out.println(Arrays.toString(data));
					
			Book book=null;
			//Book price로 음수가 들어오면 예외 처리 할 수 있도록 사용자 생성 에러인 PriceException을 try-catch로 잡음
			// -> Book class에 setPrice() method가 PriceException을 throw함
			try{
			book = new Book(data[0], Integer.parseInt(data[1]));
			}catch (PriceException e) {
				System.out.println(e.getMessage());
			}
			if(book !=null)
			// -> PriceException 발생하면 Book 객체가 생성되지 않고 null이 출력되니까 null 아닐때만 출력하라는 조건문을 줬음
			System.out.println(book);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if(scanner!=null) {
				scanner.close();
			    scanner=null;
			System.out.println("자원반납");
	}
		System.out.println("End");
}
}
}