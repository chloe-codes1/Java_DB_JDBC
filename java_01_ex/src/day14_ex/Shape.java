package day14_ex;

public abstract class Shape {
	/*
	[문제]
		1. 각 클래스 및 인터페이스를 작성하십시오
			Shape 추상 클래스를 작성하십시오.
			getArea  메쏘드의  리턴 타입은 double 형입니다.
			RectTriangle(직각삼각형) 클래스를 작성하십시오. 
			Rectangle(직사각형) 클래스를 작성하십시오.
			Resizable 인터페이스를 작성하고, Rectangle 클래스가 implement 하도록 하십시오. resize 메쏘	드는 double type의 argument 하나를 받아서, 기존 width와 height를 해당 인자를 곱한 값으로 	변경합니다. (예: width = width * s; )

		2. ShapeTest 클래스를 작성하여 위에서 작성한 클래스를 테스트 하십시오.
			밑변이 5, 높이가 6인 Rectangle Object를 하나 생성합니다.
			밑변이 6, 높이가 2인 RectTriangle Object를 하나 생성합니다.
			위의 2가지 Object를 Shpae[] 에 추가합니다.
			순환문을 사용해서 Shpae[] 에 들어 있는 각 Shape들의
			area를 출력합니다.
			만일 해당 Shape가 Resizable 하다면, 0.5 만큼 resize한 후 새로운 area를 출력합니다. (new area 	)

		======================================================================

		화면 출력(ShpeTest 실행):

		area: 30.0
		new area: 7.5
		area: 6.0

		>>주의 사항 <<
		별도로 제시되는 소스 파일이 없습니다.
		이번 문제에서 작성해야할 소스 파일은 총 5개입니다. (Shape.java, Resizable.java, Rectangle.java, RectTriangle.java, ShapeTest.java)
		테스트 목적으로 스스로 main을 구현할 수 있습니다. 
	*/
	
	private int numSides;
	
	// [ 기본생성자를 없앤 이유 ]
	// : parameter 하나짜리 생성자를 꼭 쓰라고 강조하기 위해서!!
	
//	public Shape() {
//		super();
//	}

	public Shape(int numSides) {
		super();
		this.numSides = numSides;
	}

	public int getNumSides() {
		return numSides;
	}

	public void setNumSides(int numSides) {
		this.numSides = numSides;
	}

	@Override
	public String toString() {
		return "Shape [numSides=" + numSides + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numSides;
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
		Shape other = (Shape) obj;
		if (numSides != other.numSides)
			return false;
		return true;
	}

	abstract double getArea();
}
