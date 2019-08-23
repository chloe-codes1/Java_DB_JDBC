package day18_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test01_arrayList1 {

	public static void main(String[] args) {

	//array를 list로, list를 array로 바꾸기	
		
		// [ArrayList]
		
		//String[] names1 = new String[100];
		String[] names1 = {"이순신","김순신","박순신"};
		System.out.println(Arrays.toString(names1));
		
		// [Arrays의 sort() method 사용]
		// * Arrays: 배열을 관리해주는 util class
		Arrays.sort(names1);
		System.out.println("Arrays.sort 사용 => "+Arrays.toString(names1));
		
		System.out.println("------------------------------------------------");
		

		// [ Collections 중 ArrayList ]	
		
		int index=0;
		List<String> list = new ArrayList<String>();
		
		//ArrayList의 add() method로 배열 사이즈에 대한 걱정없이 계속 입력하다가 배열이 꽉 차면
		//ArrayList가 알아서 사이즈 관리해서 저장해줌
		
		list.add("홍길동");
		list.add("김길동");
		list.add("이길동");
		list.add("박길동");
		list.add("최길동");
		list.add("신길동");
		list.add("유길동");
		list.add("조길동");
		list.add("홍길동"); // -> list 구조는 중복을 허용한다!
		
		System.out.println(list);
		
		// [ Collect Sort() method 사용 ]
		// : 알아서 가나다 순으로 정렬해줌!
		//   * Collections: list를 관리해주는 util class
		Collections.sort(list);
		System.out.println("Collections.sort 사용 => "+list);
		
		System.out.println();
		
		
		// [ .subList(fromIndex, toIndex) method ] 
		
		List<String> list2 = new ArrayList<String>(list.subList(1, 4));
						//1~4까지 subList하라   => 1,2,3 위치에 있는 데이터가 만들어짐(4 빼기 1이니까 3) 
		System.out.println("list.subList 사용 1~3 => " +list2);
		
		List<String> list3 = new ArrayList<String>(list.subList(7, 9));
						//7~9까지 subList하라 => 7,8 위치에 있는 데이터 출력됨 (9 빼기 1이니까 8까지)
		System.out.println("list.subList 사용 7~8 => " +list3);
		
		System.out.println("------------------------------------------------");
		
		// [.toArray() method - Object]
		// : list를 array로 바꿔줌!
		Object[] obj = list.toArray();
		System.out.println("obj => " +Arrays.toString(obj));
	
		// [.toArray() method - String]
		
				//list가 갖고있는 .size() method   => list는 .length 아니고 .size!
 		String[] obj2 = new String[list.size()];
 		list.toArray(obj2);
 		System.out.println("obj2 => " +Arrays.toString(obj2));
 		
 		// [ .asList() method ]
 		// : 배열을 list로 바꿔줌
		String[] sss = {"111","222","333","444"};
		List<String> sslist = new ArrayList<String>(Arrays.asList(sss));
									//-> 원래는 ()에 아무것도 올 수 없음 (생성자니까!)
									// Arrays가 갖고있는 .asList() method 이용해서 Array를 ArrayList로 바꿈
		System.out.println(sslist);
 		
		System.out.println(" ========== list 다루기 ========== ");
		System.out.println(list);
		
		// [ contains() method ]
 		System.out.println("contains() method로 김길동 있는지 확인 => " +list.contains("김길동"));
 		System.out.println();
 		
		for( int i =0 ; i < list.size() ; i++) {
			System.out.print(list.get(i).charAt(0) +"** ");
		}
		System.out.println();
		
		for(String data:list) {
			System.out.print(data.charAt(0) + "** ");
		}
		
		System.out.println();
		System.out.println();
		
		// [ Iterator ]
		// : Collection을 순회하기 위한 표준화된 방법
		//     -> Collection을 순회하려면 Iterator를 써라!
		Iterator<String> it= list.iterator();
		
		while(it.hasNext()) {
			String data = it.next();
			if(data.equals("홍길동")) {
				it.remove();
				System.out.println("홍길동 삭제 되었습니다.");
			}
		}
		
		it = list.iterator();
		while(it.hasNext()) {
			String data = it.next();
			if(data.equals("김길동")) {
				it.remove();
				System.out.println("김길동 삭제 되었습니다.");
			}
		}
		System.out.println("Iterator의 .remove()로 삭제함 => " +list);
	}
}
