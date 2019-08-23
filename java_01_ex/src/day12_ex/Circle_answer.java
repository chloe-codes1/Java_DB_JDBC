package day12_ex;

public class Circle_answer extends Shape_answer {

	private double radius;
	
	public Circle_answer() {}
	
	public Circle_answer(String name, double radius) {
		super(name);
		this.radius = radius;
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

}
