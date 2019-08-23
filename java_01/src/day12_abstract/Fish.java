package day12_abstract;

public class Fish extends Animal{

	String name;
	
	public Fish() {
		super("물고기");
	}

	public Fish(String name) {
		super("물고기");
		this.name = name;
	}
	public Fish(String kind, String name) {
		super(kind);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void breath() {
		System.out.printf("%s: 아가미로 숨쉬기~!%n",super.kind);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Fish [name=");
		sb.append(name);
		sb.append("]");
		
		return sb.toString();
	}
}
