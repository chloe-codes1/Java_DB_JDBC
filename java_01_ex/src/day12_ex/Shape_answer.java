package day12_ex;

public abstract class Shape_answer {

	private String name;
	protected  double area;
	
	
	public Shape_answer() {}
	
	public Shape_answer(String name) {
		super();
		this.name = name;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void calculationArea();
	
	
	public void print() {
		System.out.printf("%s의 면적은 %s%n", name,area);
		
		
	}
	
	
	
	
	
}
