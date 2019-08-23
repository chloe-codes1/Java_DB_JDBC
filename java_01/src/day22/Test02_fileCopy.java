package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02_fileCopy {

	public static void main(String[] args) {

		// [ FileInputStream & FileOutputStream ]
		
		// 파일 복사 하기 -buffer 안썼을 때  -> 엄청 느림!!
		
		
		//원본 파일 위치
		String src = "c:\\lib\\Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		System.out.println(" 파일 복사 작업을 시작합니다. ");
		
		try {
			fis = new FileInputStream(src);
			
			//ver1. file name만 주기
//			fos =  new FileOutputStream("c:\\lib\\copy.mp3");
					//copy file의 이름과 확장자 지정
					// -> 이름은 내맘이지만 확장자는 같아야 함!
			
			//ver2. file name + append 할 지 여부까지 주기 - true일 떼
//			fos =  new FileOutputStream("c:\\lib\\copy.mp3", true);
						// -> append mode   (원본 +복사본)
			
			//ver3. file name + append 할 지 여부까지 주기 - false일 떼
			fos =  new FileOutputStream("c:\\lib\\copy.mp3", false);
						// -> overwrite mode  (원본을 덮어버리기)
			
			
			
			int read = 0;
			int count = 0;
			
			// [ .read() method ]
			//  -> return값은 int type!
			//  -> 읽을 때는 1byte씩 읽는다....

			while((read =fis.read()) != -1) {
				// -1이 들어오면 더이상 읽을 값이 없다는 뜻이므로 -1이 될때가지 계속 돌아라 while아~
				
				//읽은 아이를 Write해라
				fos.write(read);
				
				//읽고 쓴 횟수 확인
				count++;
			}

			System.out.println(" I/O 횟수 : " +count);
			System.out.println(" 파일 복사가 완료 되었습니다. ");
			
		} catch (FileNotFoundException e) {
			System.out.println(src + " File(복사 원본)을 확인해 주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// finally에서 자원 반납
			try {
				if(fis!=null)fis.close();
				if(fos!=null)fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(" main end ");
	}

}
