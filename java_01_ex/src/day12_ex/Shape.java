package day12_ex;

public abstract class Shape {
	
	protected double area;
	private String name;
	
	
	public Shape() {}
	
	public Shape(String name) {
		super();
		this.name = name;
		
	}
	
	
	public Shape(double area, String name) {
		super();
		this.area = area;
		this.name = name;
	}
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public void print() {}

	public abstract void calculationArea();

}
