package day10_ex;

public class Prob10 {

	public static void main(String[] args) {

		new student1("홍길동", 20, 200201).print();;
		new teacher1("이순신", 30, "JAVA").print();;
		new employee1("유관순", 40, "교무과").print();;
		
	}
}

class Person1 {

	private String name;
	private int age;

	// 기본 생성자
	Person1() {
		super();
	}

	// parameter 2개짜리 생성자
	public Person1(String name, int age) {
		super(); // object의 기본생성자를 호출하는 문장
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

	public void printA() {
		System.out.printf("이름: %2s  | 나이: %2d  | ", this.getName(), this.getAge());
	}
}

class student1 extends Person1 {

	private int id;

	public student1() {
	}

	public student1(String name, int age) {
		super(name, age);
	}

	public student1(String name, int age, int id) {
		super(name, age);
//		super.setName(name);
//		super.setAge(age);
		this.id = id;
	}

	public void print() {
		// System.out.printf("이름: %2s, 나이: %2d",this.getName(),this.getAge());
		// -> 3개의 class에서 중복되는 문장
		// -> 그래서 부모 class의 print() method를 super class 이용하여 뽑아옴
		super.printA();
		System.out.printf("학번: %s %n", id);
	}

}

class teacher1 extends Person1 {

	private String subject;

	public teacher1() {
	}

	public teacher1(String name, int age) {
		// super(name, age);
		this(name, age, null); // 이렇게도 쓸 수 있다
								// -> 하지만 this와 super 둘다 가장 처음에 와야 하므로 둘 다 쓸 수는 없다!!!!
	}

	public teacher1(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void print() {
		super.printA();
		System.out.printf("담당과목: %s %n", subject);
	}

}

class employee1 extends Person1 {

	private String dept;

	public employee1() {
	}

	public employee1(String dept) {
		super();
		this.dept = dept;
	}

	public employee1(String name, int age) {
		super(name, age);
	}

	public employee1(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;

	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void print() {
		super.printA();
		System.out.printf("부서: %s %n", dept);
	}

}