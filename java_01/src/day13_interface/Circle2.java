package day13_interface;

public class Circle2 extends shape implements Drawable {

	// [ Has a 관계 ]
	
	//Circle2 class가 Point type의 점 하나를 가지고 있는 것
	
//	Point p = new Point(3,5);
		//Point의 위치가 3,5로 정해져 있는 것
		//-> [ 강력한 관계 (강력한 구조) ]
		//-> life cycle을 같이 갖는 관계
		//-> Circle2가 생성 될 때, 3,5위치를 갖고있는 Point p가 같이 생성됨


	// Point Class를 Has a 관계로 이용
	Point p;
	int radius;
	
	
	public Circle2() {
		p = new Point(0,0);
	//좌표값(point)가 null로 출력되지 않도록 (0,0)으로 default설정해줌	
	}
	
	
	//Test02에서 사용되는 Point랑 반지름 찍게 하는 생성자
	public Circle2(Point p, int radius) {
		super();
		this.p = p;
		this.radius = radius;
	}

	
	public Point getP() {
		return p;
	}

	//set method를 통해 point의 값을 변경 가능
	// -> [ 느슨한 관계 ] 
	// --> 값을 뺐다가 넣었다가 하기가 쉬운 관계
	// -> 생성자를 통해서 뿐만 아니라 멤버변수인 set method를 통해서도 초기화가 가능하다!!!!
	public void setP(Point p) {
		this.p = p;
	}
	
	@Override
	public String toString() {
		return "Circle2 [p=" + p + ", radius=" + radius + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
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
		Circle2 other = (Circle2) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	@Override
	double area() {
		return radius*radius*Math.PI;
	}

	@Override
	public void draw() {
		System.out.println(getClass().getName() + " 그리기");
	}
}
