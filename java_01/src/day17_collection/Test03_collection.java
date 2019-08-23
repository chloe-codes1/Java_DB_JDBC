package day17_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Test03_collection {

	public static void main(String[] args) {

		// [ Collection ]
		
		//data type을 부모로 해야 활용 범위가 넓어져서 ArrayList의 부모인 List로 데이터 타입 설정함
		List list1 =new ArrayList();
		list1.add("hello");
		list1.add("java");
		list1.add(200);
		list1.add(new Date());
		
		System.out.println(list1);
		// -> list1은 모든 객체 다 들어갈 수 있는 Object type 객체를 관리함 
		
		for(int i=0 ; i<list1.size() ;i++) {
			
		System.out.println(list1.get(i));
		
		}
		
		List list2 =new ArrayList();
		list2.add("hello");
		list2.add("java");
		list2.add(200);
		list2.add(new Date());
		
		System.out.println(list2);
	}
}
