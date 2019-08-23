package day12_ex;



public class Circle extends Shape {

	private double radius;
	
	
	public Circle() {
		super("원");
	}

	public Circle(String name) {
		super(name);
	}


	public Circle(double radius) {
		super("원");
		this.radius = radius;
	}

	public Circle(double area, String name) {
		super(area, name);
	}

	public Circle(String name, double radius) {
		super("원");
		
		this.radius= radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public void calculationArea() {
			
		area = radius*radius*Math.PI;
			
	}

	@Override
	public void print() {
		
		System.out.printf("%s의 면적은 %s%n",super.getName(),area);
	}
}
