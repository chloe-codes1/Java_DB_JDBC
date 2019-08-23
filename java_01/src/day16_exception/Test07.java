package day16_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test07 {

	public static void main(String[] args) {

		System.out.println("*** main start ***");

		// Scanner를 써서 File로 부터 데이터 입력받기
		Scanner sc = null;
		try {
			sc = new Scanner(new File("sample.txt"));
			// -> Scanner를 이용하여 file에 있는 내용 읽어오기
			
			while (sc.hasNextLine()) {
			// -> Scanner가 읽을 line이 있는 동안은 계속 수행하도록 while문 넣음

			// [. split() 사용 ]	              .
//				String[] data = sc.nextLine().replace('_','/').split("/");
//				System.out.println(Arrays.toString(data));
				
			// [ StringTokenizer 사용 ]	
				
				StringTokenizer st = new StringTokenizer(sc.nextLine(), "_/ ");
				while(st.hasMoreTokens()) {
					System.out.print(st.nextToken() + " ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			// 자원반납
			if (sc != null)
				sc.close();
				sc = null;
			// -> Scanner는 throw 하는 exception이 없어서 try catch 안해도 된다!
			
			System.out.println("자원 반납 수행");
		}
		System.out.println("*** main end ***");
	}
}
