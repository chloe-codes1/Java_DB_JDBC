package day19_Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import day18_collection.Employee;

public class Test07_forEach {

	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee(2017001, "홍씨", "영업부"));
		list.add(new Employee(2017005, "김씨", "영업부"));
		list.add(new Employee(2017002, "이씨", "마케팅부"));
		list.add(new Employee(2017003, "박씨", "마케팅부"));
		list.add(new Employee(2017004, "장씨", "인사부"));
		
		// Iterator 사용하여 list 출력하기
		Iterator<Employee> it = list.iterator();
		
		while(it.hasNext()) {
			Employee data = it.next();
			System.out.println(data);
		}
			System.out.println();
			
		// [ forEach 기반 목록 출력 ]
			System.out.println("******** forEach 기반 목록 출력 ********");
			list.forEach(new Consumer<Employee>() {
			//list에 있는 목록을 하나씩 꺼내와줌
			// -> 위에 Iterator로 한 것을 forEach로 바꿔준 것
				
				@Override
				public void accept(Employee t) {
					//list에 있는 목록을 돌면서 하나씩 소비하겠다
					System.out.println(t);
				}
			});
			System.out.println();
			
		// [ forEach 람다로 표현 1]
			System.out.println("******** forEach 람다로 표현 1 ********");
			list.forEach(
					(Employee t) -> {
						System.out.println(t);
					}
				);
			System.out.println();
		// [ forEach 람다로 표현 2]
			System.out.println("******** forEach 람다로 표현 2 ********");
				list.forEach(t -> System.out.println(t));		
				
		// [ forEach 람다로 표현 3] - method reference
			System.out.println("******** forEach 람다로 표현 3 ********");
				list.forEach( System.out::println);			
	}
}
