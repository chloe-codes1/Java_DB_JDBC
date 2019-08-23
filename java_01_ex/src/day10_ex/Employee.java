package day10_ex;

public class Employee extends Person {

	private String name;
	private int age;
	private String dept;
	
	public Employee() {
		super();
	}


	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	public Employee(String name, int age, String dept) {
		super(name,age);
//		this.name = name;
//		this.age = age;
		this.dept = dept;
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

		System.out.printf("[ 이름: %-6s 나이: %-4d 부     서: %s   ]\n", super.getName(), super.getAge(), this.dept);
		
	}
}
