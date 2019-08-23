package day12_ex;

public class Rectangular extends Shape{

	private double width;
	private double height;

	
	public Rectangular() {
		super();
	}

	public Rectangular(String name) {
		super(name);
	}

	public Rectangular(double area, String name) {
		super(area, name);
	}

	public Rectangular(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}


	public Rectangular(String name, double width, double height) {
		super("직사각형");
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
	
	@Override
	public void print() {
		
		System.out.printf("%s의 면적은 %s%n",super.getName(),area);
		
	}
	
}
