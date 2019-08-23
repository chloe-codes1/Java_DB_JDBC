package day17_collection;

public class Book1<T extends Number> {
			//<T> -> generic 
			// -> 원래는 <T> 였다가 extends Number로 바꿈!
			// -> T 자리에 Number의 자식까지만 허용을 하겠다는 제약을 둠
	
	private String title;
	
	private T price;
	//data type 못정해서 일단 T로 넣음
	// -> class name 옆에도 <T> 넣자, 에러 해결됨!
	// -> [  generic  ]
	// -> 이렇게 생성하면 자동으로 T의 data type이 Object가 됨
	
	public String getTitle() {
		return title;
	}

	public Book1() {}
	
	public Book1(String title, T price) {
		super();
		this.title = title;
		this.price = price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public T getPrice() {
		return price;
	}
	public void setPrice(T price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book1 other = (Book1) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
