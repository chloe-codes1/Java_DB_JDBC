package day19_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import day18_collection.Employee;

public class Test04_HashMap {

	public static void main(String[] args) {

		// Map구조를 이용하여 Employee객체 관리하기

		Map<Integer, Employee> map = new HashMap<Integer, Employee>();
		// Employee들을 구분할 수 있는 key 값 = 사번이므로 key값에 Integer 넣음

		map.put(2017001, (new Employee(2017001, "홍씨", "영업부")));
		map.put(2017002, (new Employee(2017002, "이씨", "마케팅부")));
		map.put(2017003, (new Employee(2017003, "김씨", "영업부")));
		map.put(2017004, (new Employee(2017004, "박씨", "영업부")));
		map.put(2017005, (new Employee(2017005, "홍씨", "마케팅부")));

		Scanner sc = new Scanner(System.in);
		System.out.println("사번을 입력하세요");
		int data = sc.nextInt();

		sc.close();
		sc = null;

		if (map.containsKey(data)) {
			System.out.println("조회 결과 : " + map.get(data));
		} else {
			System.out.println("입력하신 사번으로 조회되는 사원이 없습니다.");
		}

		// 사번으로 사원 조회
		System.out.println("2017001 사번의 사원 조회 내역");
		System.out.println(map.get(2017001));

		System.out.println();

		// 마케팅부 사원 목록 출력
		System.out.println("마케팅부 사원 목록 출력");

		// Iterator로 조회
		
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			Integer data2 = it.next();
			Employee employee = map.get(data2);
			if(employee.getDept().equals("마케팅부")) {
				
				System.out.println(employee);
			}
		}
		System.out.println();

		// 사원 삭제
		System.out.println("2017005 사원의 삭제 (퇴사 처리)");
		if (map.containsKey(2017005)) {
			System.out.println("삭제정보: " + map.remove(2017005) + "사원이 삭제 되었습니다.");
		}

		// 잘 삭제 되었는지 확인
		System.out.println("2017005 사원 정보 =>" + map.get(2017005));

		System.out.println();
		System.out.println("사원 전체 목록");

		Iterator<Integer> all = map.keySet().iterator();
		while (all.hasNext()) {
			Integer id = all.next();
			Employee staff = map.get(id);
			System.out.println(staff);
		}
	}
}
