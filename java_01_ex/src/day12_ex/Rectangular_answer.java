package day12_ex;

public class Rectangular_answer extends Shape_answer{

	private double width;
	private double height;
	
	
	public Rectangular_answer() {}
	
	
	public Rectangular_answer(String name, double width, double height) {
		super(name);
		this.width = width;
		this.height = height;
	}



	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	@Override
	public void calculationArea() {
		area = width*height;
	}
	
	
	
	
}
