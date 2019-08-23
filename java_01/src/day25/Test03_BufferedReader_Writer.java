package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;

public class Test03_BufferedReader_Writer {

	public static void main(String[] args) {

		// [ Network Stream ]

		// ( read )
		URL url = null;
		// java.net의 URL 사용

		String address = "https://www.naver.com/index.html";
		String line = null;
		// Naver.com에서 한 line 씩 읽어올꺼야
		// -> buffer로 감싸야함!
		BufferedReader br = null;

		
		// ( write )
		String fileName = "naver.html";
		BufferedWriter bw = null;

		try {
			url = new URL(address);
			// [ InputStreamReader ]
			// : byte로 읽어오는게 아니라 문자 (char)로 읽어오게 함

			// [ BufferedReader ]
			// : 한 줄 씩 읽어오게 함

			// ( read )
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			// -> Naver와의 Stream을 열기  => naver랑 노드관이 연결 되었음!
			// -> InputStream이 만들어짐! => System.in 이랑 같은 것 -> 문자로 읽어들이기
			// -> buffer로 감싸서 문자로 읽되, 한줄씩 읽도록 함!
			
			// ( write )
			bw = new BufferedWriter(new FileWriter(fileName));
												//-> 채팅 프로그램에서는 fileName위치에 chat하려는 사람의 ip가 오면 됨!

			while ((line = br.readLine()) != null) { //더이상 읽을 라인 없을때까지 계속 읽어라
				System.out.println(line);
				bw.write(line + "\n"); // ->\n으로 줄바꿈을 해줘야 buffer가 제대로 한줄씩 write 함!
			}
//			bw.flush();  
			//-> 근데 굳이 flush 할 필요 없음! 즉각적으로 저장되어야 하는 데이터 아니라서~
			//-> buffer 가득 차면 자동으로 flush 되고, 밑에 finally에서 자원반납 (bw.close()) 할 때 flush 되어서!
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
				if (bw != null) {
					bw.close();
					bw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
