package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Filing {

	public static void save(Object data, String fileName) {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.flush();
			System.out.printf("%s 객체가 %s 파일에 저장되었습니다.%n", data, fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {

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

	public static Object load(String fileName) {

		FileInputStream fis = null;
		ObjectInputStream ois= null;
		
		Object data = null;
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			data = ois.readObject();
			System.out.printf("%s 파일로부터  %s Load 완료.%n", fileName,data);
		}catch (Exception e) {
//			e.printStackTrace();
		}finally {
			try {
				if (fis!=null) {
					fis.close();
					fis = null;
				}
				if (ois != null) {
					ois.close();
					ois = null;
				}
			} catch (IOException e) {
				System.out.println("이게 뜨면 그거야");
				e.printStackTrace();
			}
		}
		
			return data;
	}

}
