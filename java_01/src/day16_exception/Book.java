package day16_exception;

public class Book {

	private String title;
	private int price;
	
	public Book() {}
	
	public Book(String title, int price) throws PriceException {
		// -> 생성자에 걸려있는 throws Exception
		//   -> 이거 대신 try catch 할 수도 있음!
		//   -> 그렇게하면 BookTest에서 객체 생성시마다 try - catch 할 필요가 없음
		//   -> 편한 것 같지만 그렇게 하면 에러 메세지를 원하는 위치에 출력하기 어려워짐
		setTitle(title);
		setPrice(price);
	}
	
	public String getBook() {
		return title;
	}
	public void setBook(String book) {
		title = book;
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
	
	//예외 발생시키기
										//사용자정의 exception 만들어서 썼음
	public void setPrice(int price) throws PriceException{
		//-> "setPrice라는 method는 예외가 발생 할 수 있다" 는 뜻
		// => 여기를 RuntimeException으로 바꾸면 생성자에 throws 안해도 됨
		
		//price가 0보다 작으면 예외를 던진다!
		// => 어디까지 던질지 고민해야함 
		// -> 예외 메세지를 어느 단 까지 던질 것인가 (서버단 or clients단) 
		
		if(price<0) throw new PriceException();
		// -> price가 0보다 작을 때 예외 발생시키기
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [Book=" + title + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + price;
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
}
