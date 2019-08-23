package day13_interface;

abstract class shape {

	abstract double area();
}
// -> 이 abstract class가 있음으로써, 밑에 Circle class의 method명과 class name 결정이 쉬워짐

	// [ interface ]

interface Drawable {
	// class name뒤에 able이 붙으면 무조건 interface임!

	public abstract void draw();
	// interface에는 abstract method만 올 수 있어서, 여기에 바디부가 있는 함수가 오면 에러남!
	// -> 그래서 굳이 public abstract안써줘도 됨! => 생략 가능
}
	
	//extends가 먼저오고 implements가 뒤에 옴
public class Circle extends shape implements Drawable {
	//이미 shape를 상속 받았기 때문에 다른 class 상속 받을 수 없음 -> single inheritance
	// -> 더 중요한 것을 상속받고(is a 관계로 가고) 나머지는 Has a 관계로 가야함!

	
	// [ Has a ]
	//-> Point Class를 Has a 관계로 이용
	Point p; //Point class p
	private double radius;

	public Circle() {
	}

	public Circle(double radius, double area) {
		super();
		this.radius = radius;
	}
	
	public Circle(Point point, double radius) {
		super();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	protected double area() {
		return radius * radius * Math.PI;
		// 부모의 abstract method가 default라서 자식은 default, protected, public 가능함!
		// -> 자식의 접근 지정자는 부모의 접근지정자보다 커야한다!!!
	}
	
	@Override
	public String toString() {
		return "Circle [p=" + p + ", radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Circle other = (Circle) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName() + " 그리기");
						//현재 class에서 이름 뽑아와라
	}

}
