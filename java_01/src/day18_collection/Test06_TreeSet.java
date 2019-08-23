package day18_collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test06_TreeSet {

	public static void main(String[] args) {

		// [ Set 중 TreeSet ]
		// : set은 주머니 같은 것!
		//   -> 중복을 불허한다
		//		(ArrayList와 Vector는 중복 허용)
		
		TreeSet<Employee> set = new TreeSet<Employee>();
		//Tree가 들어가면 다 내부적으로 Sort 하겠다는 의미로 생각하기!
		
		set.add(new Employee(2017001, "홍씨", "영업부"));
		set.add(new Employee(2017002, "김씨", "영업부"));
		set.add(new Employee(2017002, "이씨", "마케팅부"));
		set.add(new Employee(2017003, "박씨", "마케팅부"));
		
		
		boolean flag = set.add(new Employee(2017001, "홍씨", "영업부"));
			// -> 똑같은 data를 Employee class equals()를 override 하자 걸러줌! 
		if(flag) {
			System.out.println("등록 되었습니다.");
		}else System.out.println("이미 존재하는 데이터 입니다.");
			// -> add에 실패했다는 것을 알리려고 boolean flag로 메세지 출력
		
		
		System.out.println("=== 사원 목록 ===");
		
		Iterator<Employee>it = set.iterator();
		while(it.hasNext()) {
			Employee data = it.next();
			System.out.println(data);
						//-> Employee class에서 toString() Override 해야 주소 아니고 제대로된 정보 출력됨!
		}				//-> ***** Set은 입력된 순서대로 출력되지 않음!!!!!!! *****
		
		
		//2017003 사번의 사원을 검색 출력하세요
		
		it = set.iterator();
		
		while(it.hasNext()) {
			Employee data = it.next();
			if(data.getNumber()==2017003) {
				System.out.println("[검색 결과] 사번 2017003 사원의 정보입니다 => " +data);
			}
			
		}
		
		
		
		
	}

}
