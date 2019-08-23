package day09_ex;

public class Book {
	
	//Book class는 Data라고 보면 됨! -> data에 초점이 맞춰진 class
		//실질적인 기능은 BookMgr에 있다~
	
	//책 제목 저장하는 private member variable
	private String title;
	
	//책 가격 저장하는 private member variable
	private int price;
	

	//기본 생성자
	public Book () {}

	//멤버변수를 초기화 하는 생성자 (parameter 2개짜리)
	public Book (String title, int price) {
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
	
	public void print() {
		System.out.printf("Book [제목: %-1s, 가격: %d]\n", title, price );
	}
	
}
