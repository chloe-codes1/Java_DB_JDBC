package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test07_read_File {

	public static void main(String[] args) {

		System.out.println("*** DB File 읽기 ***");

		//파일위치+파일명
		String src = "c://lib//DBinfo.txt";
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(src);
			br = new BufferedReader(fr);

			String id = null;
			String pw = null;
			String read = null;

			while ((read = br.readLine()) != null) {
				String[] data = read.split("=");
				if (data[0].equals("user"))
					id = data[1];
				if (data[0].equals("pw"))
					pw = data[1];

			}
			System.out.printf("로그인 시도 %s / %s", id, pw);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

		} finally {
			try {
				if (fr != null) {
					fr.close();
					fr = null;
				}
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
