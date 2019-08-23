package day25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Test02_NetworkStream {

	public static void main(String[] args) {

		// [ Network Stream ]
		
		URL url = null;
		// java.net의 URL 사용

		String address = "https://www.naver.com/index.html";

//		String address = "https://www.google.com";

//		String address = "https://chloe-codes.blogspot.com/";
		
		String line = null;
		// Naver.com에서 한 line 씩 읽어올꺼야
		// -> buffer 필요
		BufferedReader br = null;

		try {

			url = new URL(address);
			// [ InputStreamReader ]
			// : byte로 읽어오는게 아니라 문자 (char)로 읽어오게 함

			// [ BufferedReader ]
			// : 한 줄 씩 읽어오게 함

			br = new BufferedReader(new InputStreamReader(url.openStream()));
			// -> Naver와의 Stream을 열기
			// -> InputStream이 만들어짐! => System.in 이랑 같은 것
			// -> naver랑 노드관이 연결 되었음!

			while ((line = br.readLine()) != null) { //더이상 읽을게 없을 때까지 읽어라~
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {//자원반납

			try {
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
