package day23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Set;

public class Test06 {

	public static void main(String[] args) {

		String fileName = "account.obj";
		// -> 경로를 지정해주지 않으면 Eclipse에서는 class, dos에서는 bin folder!

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {

			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);

			System.out.println("*** Data Object Read ***");

			//(ver1.) Test05에 Set 만들기 전에 Account 객체 두개 만들어서 저장 후 read 했을 때
//			Account a = (Account) ois.readObject();
//			System.out.println(a);
//			
//			Account b = (Account) ois.readObject();
//			System.out.println(b);
			
			//(ver2.) Set 구조 만들어서 그 안에 Account 객체 넣어둔 것 출력
			Set<Account> account = (Set<Account>) ois.readObject();
			
			//for each로 뽑기
			account.forEach(e -> System.out.println(e));
			
			
		} catch (Exception e) {

			e.printStackTrace();
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
