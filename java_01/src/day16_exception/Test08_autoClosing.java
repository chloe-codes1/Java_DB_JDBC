package day16_exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test08_autoClosing {

	public static void main(String[] args) {

		// [ try catch 구문에서 자원 반납 처리하는 새로운 방법 ]
		// : try() 괄호 안에 넣으면 auto-closing 된다!
		// -> 다 되는 것은 아님!
		// -> Closable이라는 interface를 구현(implements)한 것만 가능

		try (FileInputStream fis = new FileInputStream("sample.txt");) {
			System.out.println("~~ file 처리 ~~");
			// -> file 찾지 못해서 FileNotFoundException 발생하면 이 문장 출력 안됨!
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("-------------------------------------------");
		}

		// Scanner도 Closable interface를 implements 해서 () 안에 넣고 auto-close 가능하다
		try (Scanner scanner = new Scanner(new File("sample.txt"));) {

			while (scanner.hasNextLine()) {
				// .split() 사용
//				String[] data = scanner.nextLine().replace('_', '/').split("/");
//				System.out.println(Arrays.toString(data));
				
				// StringTokenizer 사용
				StringTokenizer st = new StringTokenizer(scanner.nextLine(), "_/");
				while (st.hasMoreTokens()) {
					System.out.print(st.nextToken() + " ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
