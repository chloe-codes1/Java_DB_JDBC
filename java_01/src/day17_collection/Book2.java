package day17_collection;

public class Book2<T,P extends Number> {
				// 두개면 그냥 ,로 이으면 됨~	
				// -> T도 extends 하고 싶으면 따로 extends ___ 써야함!
				// -> T로 title 받을거라서 extends Number 안했음~
	
	// [ Generic ]
	
	T title;
	P price;
	
	public Book2() {}
	
	public Book2(T title, P price) {
		super();
		this.title = title;
		this.price = price;
	}
	public T getTitle() {
		return title;
	}
	public void setTitle(T title) {
		this.title = title;
	}
	public P getPrice() {
		return price;
	}
	public void setPrice(P price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book2 [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book2 other = (Book2) obj;
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
