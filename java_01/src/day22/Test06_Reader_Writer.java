package day22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test06_Reader_Writer {

	public static void main(String[] args) {

		// [FileReader & FileWriter 사용하기 ]

		System.out.println(" 파일 복사 .txt ");

		String src = "c://lib//sample.txt";
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader(src);
			fw = new FileWriter("c://lib//copiedFile.txt");

			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			String read = null;

			// readLine -> 줄단위로 읽기
			while ((read = br.readLine()) != null) {
				bw.write(read + "\r\n");
			}

			// 추가적으로 내용을 write하기
			bw.write("sample.txt 파일을 복사한 내용입니다.\r\n");
			bw.flush();
			System.out.println(" 파일 기록 완료 ");

		} catch (FileNotFoundException e) {
			System.out.println(src + " File(복사 원본)을 확인해 주세요.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
					fr = null;
				}
				if (fw != null) {
					fw.close();
					fw = null;
				}
				if (br != null) {
					br.close();
					br = null;
				}
				if (bw != null) {
					bw.close();
					bw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
