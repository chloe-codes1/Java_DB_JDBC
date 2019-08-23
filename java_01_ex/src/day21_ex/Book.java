package day21_ex;

import java.io.Serializable;

public class Book extends Object implements Comparable<Book>, Serializable{
							//-> sort하기 위해 Comparable implements함!
	
	// [과제 ]
	// : Book을 만든 후 BookMgr를 Collection 기반으로 바꾸어서 CURD가 다 되도록 만든다
	//   + BookApp을 동작하게 수정한다
	
	private int ISBN;
	
	private String title;
	
	private int price;
	
	
	
	
	//기본 생성자
	public Book () {}

	public Book(String title, int price) {
		this.title= title;
		this.price = price;
		
	}
	

	public Book(int ISBN, String title, int price) {
		super();
		this.ISBN = ISBN;
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		//여기에 title이 null일 경우를 잡아주는 코드 있음 좋음!
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

	public void setISBN(int ISBN) {
		this.ISBN=ISBN;
	}
	
	
	
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", price=" + price + "]";
	}

	//ISBN 하나로만 중복 체크 하려고 equals & hashCode ISBN만 넣음

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN;
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
		return true;
	}

	public void print() {
		System.out.printf("Book [제목: %-1s, 가격: %d]\n", title, price );
	}


	@Override
	public int compareTo(Book o) {
		return this.ISBN-o.ISBN;
		//-> ISBN 순으로 정렬
	
	}

	
}
