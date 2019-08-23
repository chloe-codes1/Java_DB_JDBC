package day12;

public class Book extends Object{

	private String title;
	private int price;
	
	
	public Book() {}
	
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	//parameter의 type과 개수가 같아도 type의 순서가 다르면 Overloading 가능!
	public Book(int price, String title) {
		super();
		this.title = title;
		this.price = price;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	// [ toString() method의 Overriding ]
	
	@Override
	public String toString() {
		
		// [ StringBuilder ]
		StringBuilder sb = new StringBuilder();
		sb.append("Book 정보) title: ");
		sb.append(title);
		sb.append(", price : ");
		sb.append(price);
		return sb.toString();
		
	}
	
	// [ equals() method의 Overriding ]
	
	@Override
	public boolean equals(Object obj) {

		boolean flag = false;
		if(obj==null || !(obj instanceof Book)) {
			return false;
		}
		Book data = (Book)obj;
		if(price == data.price && title.equals(data.title)) {
			flag = true;
		}
		return flag;
	}	
	
	// [ finalize() method의 Overriding ]
	//: 객체가 소멸되기 직전에 호출되는 method
	//  -> 소멸자 역할을 하는 method이지만, JAVA에서는 사용하지 않고 별도의 자원반납 기능을 만들어 사용한다.
	@Override
	protected void finalize()  {
		System.out.println("자원 반납 코드~!");
	}
	
	// [ close() method ]
	// 이게 바로 자원 반납 기능
	public void close() {
		System.out.println("close: 자원 반납 코드~!");
		//원래는 자원 반납 할 기능이 이 안에 들어가지만 지금은 반납할 자원이 없어서 그냥 출력문만 넣어둠!
	}
	
	
}
