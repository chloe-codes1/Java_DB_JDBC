package day20;

import java.util.Iterator;
import java.util.Properties;

public class Test02_Properties {

	public static void main(String[] args) {

		// [ Properties ]
		//
		// properties는 보통 (String, String) 으로 사용
		//  + 환경 설정 파일을 handling 할 때 사용
		//	 (대부분의 환경설정 파일은 확장자가 .properties다)
		// -> parsing 까지 대신 해주는 Properties
		
		Properties p = new Properties();
		
		p.setProperty("Java01", "1234");
		p.setProperty("Java02", "2234");
		p.setProperty("Java03", "3234");
		p.setProperty("Java04", "4234");
		p.setProperty("Java05", "5234");

		System.out.println(p.getProperty("Java01"));
		
		//map이랑 똑같음!
		Iterator it = p.keySet().iterator();
		while(it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key + " : " + p.getProperty(key));
			
		}
		
		
		
	}

}
