package day23_ex_copied;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyFile {

	//save() method와 load() method는 util하기 때문에 활용도가 높아서 따로 빼서 재활용 할 수 있게 만들었음!
	
	
	public synchronized static void save(String fileName, Object obj) {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
			System.out.printf("%s 객체가 %s 파일에 저장되었습니다.%n", obj,fileName);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				if (fos != null) {
				fos.close();
				fos = null;
				}
				if (oos != null) {
					oos.close();
					oos = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
											
	public synchronized static Object load(String fileName) {
		    // -> 이 method를 호출하는 곳에서 FileNotFoundException을 잡을 수 있도록 throws 함!
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		Object data = null;
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			data = ois.readObject();
			System.out.printf("%s 파일로부터  %s Load 완료.%n", fileName,data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis!=null) {
				fis.close();
				fis = null;
				}
				if (ois!=null) {
					ois.close();
					ois = null;
					}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	
}
