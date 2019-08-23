package day17_collection;

import java.util.ArrayList;
import java.util.List;

public class Test04_arrayList {

	public static void main(String[] args) {

		//[ Collection - ArrayList ]
		
		List<String> list = new ArrayList<String>();
		
		list.add("hello");
		list.add("java");
//		list.add(new Date());
		// -> String type만 들어갈 수 있게 Generic을 선언해서 에러 뜸!
		
		for(String data : list) {
			System.out.println(data.toString());
		}
	}
}
