package day18_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Test02_arrayList2 {

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
		
		System.out.println("Sorted Array ss = " + Arrays.toString(ss));
		
		
		List<Student> list = new ArrayList<Student>();
		// 내부에 Student[]을 만들어서 관리해주는 ArrayList

		list.add(new Student("김주현", 100, 100));
		list.add(new Student("이주현", 80, 70));
		list.add(new Student("박주현", 50, 60));
		list.add(new Student("최주현", 90, 10));

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
		// -> but, Student class에 equals() method 오버라이딩 하자 제대로 나옴
		// -> equals() method가 오버라이딩 되어 있어야 제대로 동작한다!

	// [ CRUD ]	
		// 모든 application은 CRUD 작업을 함
		// C: Create
		// R: Read
		// U: Update
		// D: Delete

		// C - 홍길동,90,90 등록하기

		Student st = new Student("홍길동", 90, 90);
		boolean flag = list.add(st);
		//-> st 객체가 정상적으로 생성이 되었을 때에만 (list에 없을 때에만) 등록 하기 위해 boolean flag 사용
		if (flag)
			System.out.println(st + " 등록 되었습니다");
		else
			System.out.println(st + " 등록에 실패하였습니다");

		System.out.println();
		System.out.println("========== 홍길동 학생이 등록된 학생 정보 List 출력 ==========");
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

//			if (info.equals(new Student("홍길동", 90, 90))) {
				if (info.equals(st)) {

				info.setKor(100); 
				// -> 홍길동 국어점수 100점으로 수정
				//     + info.kor = 100; 이라고 해도 됨!
				//        -> kor private 처리 안했음~ (현재 default임)
				info.setMath(100); 
				// -> 홍길동 수학점수 100점으로 수정
				info.setAvg(); 
				// -> 점수가 바뀌었으므로 평균값 다시 설정
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
		// Student class에 compareTo() method override해서 이름순으로 sort함

		System.out.println("========== 학생 정보 List 출력 ==========");

		iter = list.iterator();
		while (iter.hasNext()) {
			Student info = iter.next();
			System.out.println(info);
		}
	}
}

class Student extends Object implements Comparable<Student> {
	// -> Collections.sort() method 쓰기 위해 comparable<Student>를 implements함!
	
	String name;
	int kor;
	int math;
	double avg;

	public Student() {
	}

	public Student(String name, int kor, int math) {
		this.name = name;
		this.kor = kor;
		this.math = math;
		setAvg();
		// -> avg는 생성자 parameter에 넣지 않고, Setter로 만든 값을 생성자에 넣는 방식!
		// -> toString() method override 했기 때문에 계산된 avg값이 자동으로 출력됨!
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg() {
		// setAvg로 평균 구하기
		this.avg = (kor + math) / 2.;
				// -> Double type의 avg라서 /2. 했음
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", math=" + math + ", avg=" + avg + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + kor;
		result = prime * result + math;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (kor != other.kor)
			return false;
		if (math != other.math)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	// Collections.sort method() 사용하기 위해 override함
	@Override
	public int compareTo(Student o) {
		// -> 나와 비교대상을 기준으로 그 둘의 크기를 뺐을 때 결과에 따라 비교해서 sort 해준다

		//ver1) 평균 순으로 정렬
//		return (int) (o.getAvg()-avg);

		//ver2) 국어점수 순으로 정렬
//		return kor - o.kor;
		// -> Kor은 나 , o.kor은 비교대상으로 넘어온 국어점수

		// => 이 둘은 정수 or double 연산이라 빼기 연산이 가능했음
		// -> 근데 이름(String)은 그렇게 비교할 수 없음!
		// -> String class는 이미 Comparable을 implements 하고 있고,
		//    compareTo() method를 override하고 있어서 바로 compareTo() 쓰면 됨!

		//ver3) 이름 순으로 정렬
		return name.compareTo(o.name);
	}
}

// [ more info from String API ]
// : String method가 어떻게 sort하는지 보기 위해 compareTo method 복사해옴!
//   -> 이걸 참조하여 나중에 나도 어떻게 이름 정렬 할 지 참고하기~

/*
public int compareTo(String anotherString) {
    int len1 = value.length;
    int len2 = anotherString.value.length;
    int lim = Math.min(len1, len2);
    char v1[] = value;
    char v2[] = anotherString.value;

    int k = 0;
    while (k < lim) {
        char c1 = v1[k];
        char c2 = v2[k];
        if (c1 != c2) {
            return c1 - c2;
        }
        k++;
    }
    return len1 - len2;
}
*/