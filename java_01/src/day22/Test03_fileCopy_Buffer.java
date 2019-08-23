package day22;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test03_fileCopy_Buffer {

	public static void main(String[] args) {

		// [ FileInputStream & FileOutputStream ]
		
		
		
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
			fos =  new FileOutputStream("c:\\lib\\copy_buffer.mp3", false);
						// -> overwrite mode  (원본을 덮어버리기)
			
			
			
			int read = 0;
			int count = 0;
			
			// [ Buffer 사용 ]
			// : byte의 배열 buffer를 만든다
			//  -> 배열을 만들 때 파일의 크기만큼의 크기로 buffer를 만들기!
			
			// [ Buffer 의 한계 ]
			// : 파일의 크기가 너~무 크면 배열로 만들 수가 없음...
			//   -> 그래서 upload 할 때 보면 사이즈 제한 있는것임!
			
			//buffer의 size를 1mb 정도로 설정함!
			byte[] buffer = new byte[1024*1024];
			
			// [ .read() method ]
			//  -> return값은 int type!
			//  -> 읽을 때는 1byte씩 읽는다....

			while((read =fis.read(buffer)) != -1) {
				// -> buffer에 내용이 들어감
				
				System.out.println("read : " +read);
				// -> 이걸 통해 buffer가 얼마만큼씩 I/O를 했는지 알 수 있음
				// -> 맨 마지막에는 buffer를 다 못채웠는데 그대로 buffer에 있는 내용 Write함
				//     => 이래서 복사본의 파일 size가 커진 것!
				
				//읽은 아이를 Write해라
				fos.write(buffer,0,read);
				  // -> 0에서 부터 읽은 만큼만 write 해라!
				  // -> 이렇게 해야 사이즈 커지지 않게 생성 가능!
				
				//읽고 쓴 횟수 확인
				count++;
			}

			System.out.println(" I/O 횟수 : " +count);
			  // -> buffer 사이즈를 1mb로 설정하자, i/o 횟수 4로 출력됨!
			 //  -> but, buffer의 크기 단위로 I/O가 되어서 파일 크기가 커짐  => 안돼~
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
