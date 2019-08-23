package day19_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test02_map {

	public static void main(String[] args) {

	// [ MAP 구조 ]	
	// : Key값, Value값으로 관리되는 형태
	//  -> Map<Object, Object> 다
	//  -> Object type이므로 모든 자원 관리 가능하다!
	//  -> Map은 interface다
	
	// Map은 데이터 집어 넣을 때 add() 아니고 put() method 사용
		
	// 중복되지 않는 데이터(ex. ID)를 Key, 중복 될 수도 있는 (ex. Password)같은 것을 Value에 넣는다!
	// -> value값을 구분해 줄 수 있는 절대 중복되지 않는 값을 key값에 넣어서 사용
		
		
	// [ Map 구조를 사용하는 이유 ]
	//  : Map 구조는 key 값 - value값을 뽑아내는 속도가 엄~청나게 빠르고, 관리하기가 쉬움!
	
	// [ HashMap ]
	//  : 특정 key값을 기준으로 그 key값에 바인딩 된 value를 찾아주는 속도가 엄청나게 빠른 구조
	//    -> HashMap은 정렬되지 않은 상태로 나옴! 정렬을 원하면 TreeMap사용하라~ (근데 주로 HashMap 많이 씀)
		
									//Map의 자식인 HashMap!
		Map<String, String> map = new HashMap<String, String>();
		
		//      ID        PW
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("admin", "admin");

		//테스트용으로 여러개의 계정 한번에 만들기
		for(int i = 0 ; i < 30; i++) {
			map.put("test"+i, "abc" + (int)(Math.random()*3));
									//PW는 Math.random으로 random하게 생성
		}
		System.out.println(map);
		
		// [ .get() method ]
		// : key값으로 부터 value 값을 뽑아오는 method
		//   -> ID (key 값) admin의 PW (value 값) 알고싶을 때 사용
		System.out.println("admin = pw? " +map.get("admin"));
		System.out.println("java01 = pw? " +map.get("java01"));
		System.out.println("java02 = pw? " +map.get("java02"));
		
		//map에 없는 key값의 value값 찾아달라고 하기
		System.out.println("java09 = pw? " +map.get("java09")); //null이라고 나옴 (당연히!)
		
		//비밀번호를 Math.random으로 생성해서 우리가 모르는 test1의 비밀번호 알려줘
		System.out.println("test1 = pw? " +map.get("test1"));
		
		System.out.println("------------------------------------------");
		
		// [ .keySet() method ]
		//key이름만 뽑아와서 set구조로 return 해줌  => key names만 뽑아서 보여줌!
		//return type Set임!
		
		Set<String> keynames =map.keySet();
		System.out.printf("key names 보여줘 %n  ===> %s",keynames);
		//.keySet()은 key값들을 보여주기만 해서 이제 이걸 바탕으로 Iterator를 이용하여 각 key값과 그에 대한 value값 뽑을 수 있음!
		
		// (Iterator 사용)
		// -> Set type의 keynames가 <String>이라서 Iterator<String>!
		Iterator<String> it = keynames.iterator();
		while(it.hasNext()) {
			
			String key = it.next();
			System.out.printf("ID : %s, PW : %s%n", key, map.get(key));
		}
	}
}
