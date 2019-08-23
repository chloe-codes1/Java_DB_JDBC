package day18_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class Test03_vector {

	
	//Test02 복사해서 ArrayList만 Vector로 바꿈!
	// -> Vector로 바꿔도 전혀 문제 없이 똑같이 동작함!
	
	
	public static void main(String[] args) {

		Student[] s = new Student[10];
		
		Student[] ss = {
				new Student("김주현", 100, 100),
				new Student("이주현", 80, 70),
				new Student("박주현", 50, 60),
				new Student("최주현", 90, 10)
		};
		Arrays.sort(ss);
		// -> sort 명령이 제대로 되려면 Student class가 comparable을 implements하고,
		//    compareTo() method를 override 하고 있어야함!
		
		System.out.println("sorted array ss = " + Arrays.toString(ss));
		
		// [ Vector ]
		
											//여기 괄호로 Vector의 사이즈 조절 가능! (ArrayList는 이거 안됨)
											// 왼쪽 처음 방 사이즈, 꽉차면 얼만큼씩 늘릴건가
		Vector<Student> list = new Vector<Student>(5,10);
		// Vector의 add method를 보기 위해 data type List에서 Vector로 바꿈!
		// -> Vector의 add() 
		// 여러명이 똑같은 data에 접근해서 서로 쓰려고 할 때 어떻게 할 것이냐
		//  => [ Synchronize 동기화 문제 ]
		// 누군가 이미 쓰고 있을 때 나중에 접근하면 데이터를 쓰지 못하고 읽을수만 있게 하는 것 -> Synchronized block
		//  -> ArrayList는 동기화 처리가 안되고, Vector는 동기화 처리가 되어 있음
		//	-> 동기화가 필요하면 Vector 쓰고, 아닐 땐 ArrayList
		//		(여러명이 쓸게 아니라면 ArrayList!)
		
	// [ 스스로 resizing 하는 Vector ]
	//   : 꽉 차면 알아서 두배로 늘려놓음 
		
		
		// [ capacity ] 
		// : 내가 얼마나 저장할 수 있느냐 ( 방 수 )
		System.out.println("capacity : " +list.capacity());
		System.out.println("size : " +list.size());
		
		list.add(new Student("김주현", 100, 100));
		list.add(new Student("이주현", 80, 70));
		list.add(new Student("박주현", 50, 60));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));
		list.add(new Student("최주현", 90, 10));

		
		System.out.println("capacity : " +list.capacity());
		System.out.println("size : " +list.size());
		
		
		
		System.out.println("ArrayList list = " +list);
		System.out.println();

		// [Iterator로 데이터 뽑기]

		Iterator<Student> iter = list.iterator();

		while (iter.hasNext()) {
			Student data = iter.next();

			// 평균 90 이상인 학생만 뽑기
			if (data.avg >= 90)
				System.out.println("평균 90점 이상인 학생은? = " +data);
		}

		System.out.println("목록에 Student(\"김주현\", 100, 100) 가 있는가? " +list.contains(new Student("김주현", 100, 100)));
		// -> Student class에 내부적으로 equals() method가 없어서 처음에 false라고 나옴
		// -> Student class에 equals() method 오버라이딩 하자 제대로 나옴
		// -> equals() 오버라이딩 되어 있어야 동작한다!

	// [ CRUD ]	
		// 모든 application은 CRUD 작업을 함
		// C: Create
		// R: Read
		// U: Update
		// D: Delete

		// C - 홍길동,90,90 등록하기

		//st 객체가 생성이 되었을 때에만 (list에 없을 때에만) 등록 하기 위해 boolean flag 사용
		Student st = new Student("홍길동", 90, 90);
		boolean flag = list.add(st);
		if (flag)
			System.out.println(st + " 등록되었습니다");
		else
			System.out.println(st + " 등록에 실패하였습니다");

		System.out.println();
		System.out.println("========== 홍길동 등록된 학생 정보 List 출력 ==========");
		System.out.println();
		
		iter = list.iterator();
		while (iter.hasNext()) {
			Student info = iter.next();
			System.out.println(info);

		}
		System.out.println();
		// U - 홍길동,100,100으로 수정하기

		// *** Iterator는 계속 생성해야 샤용 가능! ***
		// -> 한번 만들었다고 계속 쓸 수 있는 것 아님
		// -> 왜냐면 이미 이전 iterator 사용 시 hasNext() 하면서 돌아서 다 소진되었기 때문!
		iter = list.iterator(); // -> 이렇게 계속 해줘야함!

		while (iter.hasNext()) {
			Student info = iter.next();

			if (info.equals(new Student("홍길동", 90, 90))) {

				info.setKor(100);
				// info.kor = 100; 이라고 해도 됨!
				// -> kor private 처리 안했음~ (현재 default임)
				info.setMath(100);
				info.setAvg();
				System.out.println(info + " 으로 수정되었습니다.");
			}
		}
		System.out.println();
		System.out.println("========== 홍길동 점수 수정된 학생 정보 List 출력 ==========");

		iter = list.iterator();
		while (iter.hasNext()) {
			Student info = iter.next();
			System.out.println(info);
		}

		System.out.println();
		
		// D - 홍길동 삭제하기

		iter = list.iterator();
		while (iter.hasNext()) {
			Student info = iter.next();
			if (info.equals(st)) {

				iter.remove();
				System.out.println(st + " 삭제되었습니다");
			}
		}
		System.out.println();

		// List 출력하기 전에 Sort하기

		Collections.sort(list);
		// sort 명령이 안먹음
		// -> why? sort를 쓰려면 comparable을 implements해야 하는데 Student 는 implements안해서!
		// student class에 compareTo() method override해서 avg의 내림차순으로 sort함

		System.out.println("========== 학생 정보 List 출력 ==========");

		iter = list.iterator();
		while (iter.hasNext()) {
			Student info = iter.next();
			System.out.println(info);
		}

	}
}

