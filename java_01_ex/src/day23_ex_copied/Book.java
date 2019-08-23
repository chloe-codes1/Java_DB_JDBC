package day23_ex_copied;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {

	
	String title;
	int price;
	int ISBN;
	public Book() {}
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	
	public Book(String title, int price, int iSBN) {
		super();
		this.title = title;
		this.price = price;
		ISBN = iSBN;
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
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", ISBN=" + ISBN + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
		result = prime * result + price;
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
		Book other = (Book) obj;
		if (ISBN != other.ISBN)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Book o) {
		//title 순으로 정렬할 수 있는 메커니즘
		return title.compareTo(o.title);
	}
	
}
