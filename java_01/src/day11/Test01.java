package day11;

public class Test01 {

	public static void main(String[] args) {
		
		//모든 객체의 data type은 부모가 될 수 있으므로 앞에 type선언을 부모로 바꿀 수 있다!
		Person a = new student("홍길동", 20, 200201);
		Person t = new teacher("이순신", 30, "JAVA");
		Object e = new employee("유관순", 40, "교무과");
		
	// [ is a 관계 ]
	// ex) student is a Person, student is an Object
		
		
		//Person1 p = null; 
		
		// 부모 type의 p는 자식 type은 다 받을 수 있다
//		p = a;
//		p.printA();
//		
//		p = t;
//		p.printA();
//		
//		p = e;
//		p.printA();

		
	// [ Down Casting ]	
		//부모 type인 p1,p2,p3가 자식 type들(student 등등)에 있는 print() method를 사용하기 위해 down-casting 함
		
		Person p1 = a;
		((student)p1).print();
		
		Person p2 = t;
		((teacher)p2).print();
		
		
		//Person1 p3 = e;   
			//-> 에러 뜸!
			//-> 맨 위에 New Employee인 e 선언 시, Data type을 Object로 했기 때문에 Object는 person1의 부모라서 에러가 뜸!
		
		// 그래서 p3도  Object로 바꿔줘야 에러 뜨지 않는다
		Object p3 = e; 
		((employee)p3).print();
	}
}

class Person {

	private String name;
	private int age;

	// 기본 생성자
	Person() {
		super();
	}

	// parameter 2개짜리 생성자
	public Person(String name, int age) {
		super(); // 부모인 Object의 기본생성자를 호출하는 문장
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	//처음에 만든 print용 method
	public void printA() {
		System.out.printf("이름: %2s  | 나이: %2d  | ", this.getName(), this.getAge());
	}

	//나중에 Test02에서 Overriding하려고 만든 print() method
	public void print() {
		
		System.out.printf("이름: %2s  | 나이: %2d  | ", this.getName(), this.getAge());
	}
}

class student extends Person {

	private int id;

	public student() {
	}

	public student(String name, int age) {
		super(name, age);
	}

	public student(String name, int age, int id) {
		super(name, age);
		//위에 한줄로 밑에 두줄 표현 가능
//		super.setName(name);
//		super.setAge(age);
		this.id = id;
	}
	@Override
	public void print() {
		// System.out.printf("이름: %2s, 나이: %2d",this.getName(),this.getAge());
		// -> 3개의 class에서 중복되는 코드
		// -> 그래서 부모 class의 printA() method를 super class 이용하여 뽑아옴
		super.printA();
		System.out.printf("학번: %s %n", id);
	}
}

class teacher extends Person {

	private String subject;

	public teacher() {
	}

	public teacher(String name, int age) {
		// super(name, age);
		this(name, age, null); 
			// -> super() 대신 this()를 이용해 이렇게도 쓸 수 있다
			// -> 하지만 this와 super 둘다 가장 처음에 와야 하므로 둘 다 쓸 수는 없다!!!!
	}

	public teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public void print() {
		super.printA();
		System.out.printf("담당과목: %s %n", subject);
	}
}

class employee extends Person {

	private String dept;

	public employee() {
	}

	public employee(String dept) {
		super();
		this.dept = dept;
	}

	public employee(String name, int age) {
		super(name, age);
	}

	public employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public void print() {
		super.printA();
		System.out.printf("부서: %s %n", dept);
	}
}