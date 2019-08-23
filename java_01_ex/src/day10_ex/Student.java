package day10_ex;

public class Student extends Person {

	private String name;
	private int age;
	private int id;
	
	public Student() {
		super();
	}


	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	public Student(String name, int age, int id) {
		super(name,age);
		//이렇게도 가능하다~
//		this.name = name;
//		this.age = age;
		this.id=id;
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
	
	@Override
	public void Print() {
		//System.out.printf("[%s : %s : %s]%n",super.kind,this.kind, this.name);

		System.out.printf("[ 이름: %-6s 나이: %-4d 학     번: %s]\n", super.getName(), super.getAge(), this.id);
		
	}
	
	
	
}
