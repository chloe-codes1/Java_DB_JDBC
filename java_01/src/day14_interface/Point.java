package day14_interface;

public class Point implements Cloneable{
	//Point class에서도 Object class가 갖고있는 .clone() method를 사용하기 위해 Cloneable을 implements 함
	// -> Point가 복제 가능한 class라는 뜻
	// -> interface Cloneable을 implements 하지 않으면 clone() method를 override해도 사용할 수 없음
	// -> [ Java에서 제공하는 interface Cloneable ]
	//		: 객체가 복제 가능하게 하고싶을 때 사용 + clone() method overriding도 수반됨.
	
	private int x;
	private int y;
	

	public Point() {
		super();
	}
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	//toString을 override 하지 않으면 주소 찍힌다!
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	//source - generate hashCode() and equals()로 자동 생성하여 Override했음!
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	//clone() method를 override 할 때, return type을 Point로 casting해야 .clone() method 사용 가능!
	//Object class의 clone() method는 protected지만, 자녀의 접근지정자는 부모의 접근지정자와 같거나 크면 되므로 public도 가능!
	@Override
	public Point clone() throws CloneNotSupportedException {
							//-> 복제하다가 문제 발생 할 수 있다고 알려주는 문장
							//-> clone이 다 되는게 아니라고 알려주는 것! clone이 안될 시에 문제가 생길 수 있다~ 경고한다~~
		return (Point)super.clone();
	}
}
