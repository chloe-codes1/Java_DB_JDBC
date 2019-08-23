package day23;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Test03_data_output {

	public static void main(String[] args) {

		String fileName = "data.obj";
				// -> 경로를 지정해주지 않으면 Eclipse에서는 class, dos에서는 bin folder!
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			fos = new FileOutputStream(fileName);
			oos =  new ObjectOutputStream(fos);
			
			String name = "김주현";
			Date d = new Date();
			
			oos.writeObject(name);
			oos.flush();  // buffering 한다는걸 알 수 있음
			
			oos.writeObject(d);
			oos.flush();
			
			System.out.println("파일에 저장되었습니다.");
		} catch (Exception e) {

		} finally {

			try {
				if (oos != null) {
					oos.close();
					oos = null;
				}

				if (fos != null) {
					fos.close();
					fos = null;
				}

			} catch (Exception e2) {

			}
		}

		
		// -> 이렇게 만들고 생성된 파일 열어보면 JAVA가 알아볼 수 있는 내용으로 저장해 놓은 것을 알수 있음!
		
		System.out.println("main end");
	}

}
