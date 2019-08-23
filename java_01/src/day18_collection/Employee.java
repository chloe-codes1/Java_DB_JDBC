package day18_collection;

//-> Employee class가 Sort 하기위한 조건
public class Employee implements Comparable<Employee> {
		// -> 이걸 보고 Employee Class가 정렬 기준이 정해진 class라는 것을 읽을 수 있어야함!
	public int number;
	public String name;
	public String dept;

	public Employee() {
	}

	public Employee(int number, String name, String dept) {
		super();
		this.number = number;
		this.name = name;
		this.dept = dept;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [number=" + number + ", name=" + name + ", dept=" + dept + "]";
	}

// 사번(number)을 비교하려고 Eclipse로 hashCode() and equals() 만들 때, number만 체크함! 

//이렇게 함으로써 Test06에 정렬되서 관리됨  => TreeSet!
	@Override
	public int compareTo(Employee o) {

		//이름으로 정렬
//		return name.compareTo(o.name);
	
		//사번으로 정렬
		return number - o.number;
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		Employee other = (Employee) obj;
		if (number != other.number)
			return false;
		return true;
	}
}