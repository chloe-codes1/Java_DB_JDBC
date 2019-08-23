package day10_ex;

public class Teacher extends Person {

	private String name;
	private int age;
	private String subject;
	
	public Teacher() {
		super();
	}


	public Teacher(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Teacher(String name, int age, String subject) {
		super(name,age);
//		this.name = name;
//		this.age = age;
		this.subject=subject;
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

		System.out.printf("[ 이름: %-6s 나이: %-4d 담당과목: %s  ]\n", super.getName(), super.getAge(), this.subject);
		
	}
	
	
	
}
