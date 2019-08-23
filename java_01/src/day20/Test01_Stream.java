package day20;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import day18_collection.Employee;


public class Test01_Stream {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		
		list.forEach(i -> System.out.print(i+ "  "));
		System.out.println();

		// [ .removeIf() method ] 
		// : 조건식을 줘서 조건에 맞으면 삭제하라
		//	 -> 조건에 맞는 element 삭제
		
		list.removeIf(i->i%2==0);
		 //-> 2로 나눴을때 나머지가 0인 애들만 삭제해라
		list.forEach(i->System.out.print(i+ "  "));
		System.out.println();
		
		System.out.println("=======================");
		
		List<Employee> emp = new ArrayList<Employee>();
		
		emp.add(new Employee(2017001, "김주현", "영업부"));
		emp.add(new Employee(2018002, "이주현", "전산부"));
		emp.add(new Employee(2017011, "박주현", "인사부"));
		emp.add(new Employee(2019011, "최주현", "인사부"));
		
	// [ stream() ]
	// : 모든 Collection들은 stream 화가 가능하다
	//  - 배열이든 collection이든 쉽게 handling 할 수 있는 집합체로 만드는 것
		
		System.out.println(emp.stream().filter(i -> i.getNumber() > 2018001).count()); //2
		//-> 사번이 2018001보다 큰 사원들을 filtering 해서 그 수를 count 해라
		
		emp.stream().filter(i -> i.getNumber() > 2018001)
		.forEach(i -> System.out.println(i));
		// -> 사번이 2018001보다 큰 사원들을 출력해라
		
		
		System.out.println("========= Array Stream 처리 =========");
		
		// 배열로 만들어봄
		Employee[] e = {
				new Employee(2017001, "김주현", "영업부"),
				new Employee(2017002, "이주현", "전산부"),
				new Employee(2017011, "박주현", "인사부"),
				new Employee(2019011, "최주현", "인사부")
				
		};
		
		// [ Stream.of() ]
		// -> 배열로 Stream 사용시 이렇게 함
		//	-> 배열을 for loop 없이 converting 하기 위해서 Stream 사용!
		
		
		Stream.of(e).filter(i -> i.getDept().equals("인사부"))
		.forEach( i -> System.out.println(i));
		// -> 배열을 Stream으로 바꾼 후 인사부 사원만 추출하여 출력하라!
		
		System.out.println();
		
		Stream.of(e).sorted().forEach(i -> System.out.println(i));
		// -> 배열을 Stream으로 바꾼 후 정렬하여 출력하라!
		
		System.out.println("======= Comparator 사용 =======");
		// [ Comparator ]
		
		Stream.of(e).sorted(new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}).forEach(i-> System.out.println(i));
		
		System.out.println();
		
		// 람다식으로 표현
		Stream.of(e)
		.sorted((o1, o2) ->o1.getName().compareTo(o2.getName()))
		.forEach(i-> System.out.println(i));
		
	}
}
