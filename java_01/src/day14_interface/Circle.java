package day14_interface;

abstract class shape implements DrawAndMove, Cloneable{
//shape가 DrawAndMove를 implements함으로써, Drawable과 Movable에 있는 Draw() method와 Move() method를 쓸 수 있게됨!
//-> Circle이 DrawAndMove를 implements 할 필요 없어짐!
//-> 상위 class인 shape가 DrawAndMove를 implements 해서 통합이 가능해진다!
//-> [ interface 통합 ]

	abstract double area();
}
// -> 이 abstract class가 있음으로써, 밑에 Circle class의 method명과 class name 결정이 쉬워짐

	// [ interface ]

interface Drawable {
	// class name뒤에 able이 붙으면 무조건 interface임!

	public abstract void draw();
	// interface에는 abstract method만 올 수 있어서, 여기에 바디부가 있는 함수가 오면 에러남!
	// -> + 굳이 public abstract안써줘도 됨! => 생략 가능
}

interface Movable {
	
	void move(int m);
}


// [ interface의 다중 상속 ]

interface DrawAndMove extends Drawable, Movable{
	//interface DrawandMove는 interface인  Drawable과 Movable을 다중 상속 할 수 있다!
	//-> Java에서는 단일 상속만 가능하지만 interface만 예외적으로 다중 상속 가능하다!
	//-> interface를 extends하는 class는 반드시 interface여야 한다!
	abstract void draw();
	void move(int m);
	

	
	
}

					//-> extends가 먼저오고 implements가 뒤에 옴
public class Circle extends shape implements Drawable, Movable,Cloneable {
	//이미 shape를 상속 받았기 때문에 다른 class 상속 받을 수 없음 -> "single inheritance"
	// -> 더 중요한 것을 상속받고(is a 관계로 가고) 나머지는 Has a 관계로 가야함!
	//+ 나중에 shape이 DrawAndMove를 implements함으로써, Circle 이 Drawable과 Movable을 implements 할 필요 없게 됨!
	//  -> 이 선언부를 보고 Circle class가 Drawable하고, Movable하다는 것을 읽어낼 수 있어야함!
	
	
	// [ Has a 관계 ]
	//-> Point Class를 Has a 관계로 이용
	public Point p; //Point class p
	private double radius;

	public Circle() {
	}

	public Circle(double radius, double area) {
		super();
		this.radius = radius;
	}
	
	public Circle(Point point, double radius) {
		super();
		this.p=point;
		this.radius = radius;
	}
	
	
	
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
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
		// -> 자식의 접근 지정자는 부모의 접근지정자보다 같거나 커야한다!!!
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
						//현재 class명이랑 이름 뽑아와라
	}

	@Override
	public void move(int m) {
		//x,y좌표를 각각 m만큼 이동
		
		p.setX(p.getX()+m);
		p.setY(p.getY()+m);
		//-> Point class의 x,y가 private한 자원이라 set get method 사용함!
		
	}
	
	public Circle clone() throws CloneNotSupportedException {
		//-> 복제하다가 문제 발생 할 수 있다고 알려주는 문장
		//-> clone이 다 되는게 아니라고 알려주는 것! clone이 안될 시에 문제가 생길 수 있다~ 경고한다~~
//		return (Circle)super.clone(); //-> 원래 이 코드였는데 바꿈	
		
		// -> Test01에서 쓰려고 p 자원도 복제 할 수 있도록 코드 바꿨음!
		Circle c = (Circle)super.clone();//c에다가 clone을 넣음
		Point p = c.p.clone();//p에 복제한 c의 복제한 p값을 넣음
		c.p = p; //c의 point에 복사한 p값을 넣음
		return c;
		// -> [ Deep Cloning ]
		
	}
}
