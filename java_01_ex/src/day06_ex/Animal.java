package day06_ex;

public class Animal {

	private boolean live;
	private int age;
	private String name;

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
		return;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (!(age >= 0 && age <= 150)) {
			System.out.println("제대로 된 나이를 입력하세요.");
			return;
		}
		this.age = age;
		return;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!(name.length() >= 1)) {
			System.out.println("제대로 된 이름을 입력하세요.");
			return;
		}
		this.name = name;
		return;
	}

	public void display() {
		//여기서 display는 주소가 있어야지만 호출 가능한 instance method다!
		//ex) ani.display();
	System.out.printf("[동물의 이름 = %s, 나이 = %d살, 생존여부 %b] \n", name, age, live);
	return;
	}
}
