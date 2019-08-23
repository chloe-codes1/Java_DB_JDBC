package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test04 {

	public static void main(String[] args) {

		String fileName = "data.obj";
				// -> 경로를 지정해주지 않으면 Eclipse에서는 class, dos에서는 bin folder!
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {

			fis = new FileInputStream(fileName);
			ois =  new ObjectInputStream(fis);
			
			
			System.out.println("*** Data Object Read ***");
			
			//Test03에서 처음에 이름을 입력했으므로 String으로 casting
			// -> 읽고 쓰는게 순서가 맞아야함!
		
			String name = (String) ois.readObject();
			
			Date date = (Date) ois.readObject();
			

			System.out.println("Read "+ name);
		System.out.println("Read " +date);
		
		
		} catch (Exception e) {

		} finally {

			try {
				if (ois != null) {
					ois.close();
					ois = null;
				}

				if (fis != null) {
					fis.close();
					fis = null;
				}

			} catch (Exception e2) {

			}
		}

		
		// -> 이렇게 만들고 생성된 파일 열어보면 JAVA가 알아볼 수 있는 내용으로 저장해 놓은 것을 알수 있음!
		
		System.out.println("====== main end ======");
	}

}
