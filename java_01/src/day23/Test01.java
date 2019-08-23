package day23;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test01 {

	public static void main(String[] args) {

		// System.in -> InputStream

		// [ InputStreamReader ]
		// keyboard로 들어오는 byte type의 data를 char type으로 (Reader)로 바꿔줌
		InputStreamReader ir = new InputStreamReader(System.in);

		// Buffer 돌리기
		BufferedReader br = new BufferedReader(ir);

		System.out.println("키보드로 문자열를 입력하세요");

		String s = null;

		try {
			while ((s = br.readLine()) != null) {
				System.out.println("keyboard input data => " + s);
			}
		} catch (Exception e) {

		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}

				if (ir != null) {
					ir.close();
					ir = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
