package day20;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test03 {

	public static void main(String[] args) {

	// DBinfo.txt file 기반으로 Properties Setting 하기	
		
		Properties p = new Properties();
		
		// properties야... 이 file을 읽어들여서 구축해서 관리해줘...
		try {
			// [ FileInputStream ]
			//	=> 이 파일을 읽어드리겠습니다
			
//			p.load(new FileInputStream("DBinfo.txt"));
		
			//   ===> 이거 DOS 창에서 실행하면 파일 못찾읍!
			//		-> why? file명으로 조회해서
			//      -> file 주소를 정확히 기재해줘야함 (절대주소를 사용해야함)
	
			// 절대주소 사용함
			//    *절대주소 = 드라이브 이름부터 사용하는 아래같은 주소!
			p.load(new FileInputStream("c:\\lib\\DBinfo.txt"));
			
			p.setProperty("jdkver", "1.8");
			p.setProperty("oraclever", "11g");
			p.setProperty("tomcatver", "9");
			
			//xml로 저장
			
			// [ FileOutputStream ]
			// : 특정 파일로 저장하고 싶을 때
			p.storeToXML(new FileOutputStream("data.xml"), "DB Info");
				// -> data.xml file생성 된 것 확인 가능!
			
			
		} catch (FileNotFoundException e) {
			System.out.println("DBinfo.txt file을 준비해 주세요...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		// properties야... url 정보 뽑아와줘...
		String url = p.getProperty("url");
		System.out.println(url);
		
		String driver = p.getProperty("driver");
		System.out.println(driver);
		
		String user = p.getProperty("user");
		System.out.println(user);
		
		String pw = p.getProperty("pw");
		System.out.println(pw);
		
		
		// -> 여기서 url, driver가 DBinfo.txt file의 '='(-> 구분자) 왼쪽에 있어서 key, 오른쪽은 value로 알아서 처리되어서
		//    key값인 url, driver, user, pw 입력하자, value값 뽑아주는 것!
		
		System.out.println(" ==== main end ====");
		
	}

}
