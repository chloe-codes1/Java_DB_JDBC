package day22;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;

public class Test01_File {

	public static void main(String[] args) {

		//root directory 기반으로 File 객체 생성
		File dir = new File("c:\\");
		String[] list = dir.list();
		
		//c드라이브에 있는 file들 이름만 뽑아와보기
		System.out.print(Arrays.toString(list));
		System.out.println();
		System.out.println("---------------------------------------------");
		
		File file = null;
		
		Date date = null;
		
		//c드라이브에 있는 file들 뽑아보기
		for(String data : list) {
			
			//dir (c드라이브) 안에 있는 목록들을 모아서 file 객체 생성함
			file = new File(dir,data);
		
		
		//file 이름 알려줘
		System.out.print(file.getName() + "\t");
		
		//file 크기 알려줘
		System.out.print(file.length() + "\t");
		
		//file 마지막으로 수정된 날짜 알려줘
		date = new Date(file.lastModified());
		System.out.print(date + "\t");
	
		//file이 directory인지 아닌지 
		if(file.isDirectory())  System.out.print("<dir>");
		System.out.println();
		}
		
	}
}
