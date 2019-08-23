package day16_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test06_FileInputStream {

	public static void main(String[] args) {

		System.out.println("*** main start ***");
		
	// [ java.io.FileInputStream ]
		
		FileInputStream fis = null;
		FileInputStream fis2 = null;
		try {
			fis = new FileInputStream("sample.txt");
			System.out.println("sample.txt 파일 준비 완료"); //sample.txt 파일을 만들었기 때문에 에러 안뜨고, 이 문장 출력됨
			
			fis2 = new FileInputStream("c://lib//sample.txt");
				// -> 파일 IO 작업은 절대 위치를 기준으로 잡아주는 것이 좋다!
			System.out.println("c://lib//sample.txt 파일 준비 완료");
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			System.out.println("파일을 확인해 주세요");
		}catch (Exception ex) {
			// -> FileNotFoundException에서 찾지 못한 Exception들을 handling 하기 위해 넣음
			ex.printStackTrace();
		} finally {
			// [ 자원 반납 ]
			// -> 자원반납은 finally에서 한다!
			try {
				if(fis!=null) {
					fis.close();
					fis=null;
				}
			} catch (IOException e) {
				//그러나, IOException 외에, 위의 try에서 file을 찾지 못한다면 객체 생성에 실패하고
				//null point exception이 발생 할 것이다 -> null.close()는 안되니까!
				// -> 객체 생성을 try {} block 안에서 했기 때문!
				// -> 그래서 if구문으로 잡았음!
				// -> 예외가 발생해도 자원 반납 하도록 if구문으로 설계 한 것!
				e.printStackTrace();
			}
			try {
				if(fis2!=null) {
					fis2.close();
					fis2=null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("*** main end ***");
	}
}
