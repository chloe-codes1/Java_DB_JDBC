package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Test08_read_Properties {

	public static void main(String[] args) {

		// [ Properties로 file 읽기 ]
		// -> properties는 String/String 일 때만 가능하다!
		// -> DBinfo.txt file 처럼 '=' 등의 문자로 반이 나눠져 있는 key값 value값 같은 파일 읽을 때 효율적!
		
		System.out.println("*** DB File 읽기 ***");

		Properties prop = new Properties();
		FileReader fr = null;

		try {
			fr = new FileReader("c://lib//DBinfo.txt");
			prop.load(fr);
			String id = prop.getProperty("user");
			String pw = prop.getProperty("pw");

			System.out.printf("로그인 시도 %s / %s", id, pw);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
					fr = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 

		}
	}

}
