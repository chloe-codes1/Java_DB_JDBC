package day22;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test05_fileCopy_Buffer3 {

	public static void main(String[] args) {

		// [ FileInputStream & FileOutputStream ]
		
		// [ BufferedInputStream 사용하기 
		
		
		// : buffer에 모아뒀다가 기록하는 작업을 반복한다
		
		
		//원본 파일 위치
		String src = "c:\\lib\\Ben.mp3";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		System.out.println(" 파일 복사 작업을 시작합니다. ");
		
		try {
			fis = new FileInputStream(src);
			

			//ver3. file name + append 할 지 여부까지 주기 - false일 떼
			fos =  new FileOutputStream("c:\\lib\\copy_buffered_flush.mp3", false);
						// -> overwrite mode  (원본을 덮어버리기)
			
			// FileInputStream으로 읽은 것을 BufferedInputStream에 넣기
			bis = new BufferedInputStream(fis);
			// -> source file을 읽을 때 buffer를 해달라는 것
			
			
			bos = new BufferedOutputStream(fos);
			// -> read 한 data를 write 할 때에도 buffer를 해달라는 것
			
			
			
			
			int read = 0;
			int count = 0;

			while((read = bis.read()) !=-1) {
				
				//읽은 것을 기억해달라
				bos.write(read);
			}
			
			//Buffer는 꽉차면 비워지도록 설계가 되어 있는데
			//맨 마지막에는 Buffer가 꽉 차지 않으니까 비워지지 않고, 기록도 안됨!
			// -> buffer에 남아있는 것을 비워줘야함!
			
			// [ .flush() ]
			// : buffer에 혹시라도 남은 data가 있으면 비워줘서 남김 없이 write하게 하는 것
			//   -> why? buffer는 가득 차면 비워지니까!
			bos.flush();
			
			

			System.out.println(" I/O 횟수 : " +count); 
				// -> buffer는 i/o 횟수 0으로 출력됨!
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
