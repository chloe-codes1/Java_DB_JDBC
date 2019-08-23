package day09_ex;

public class BookMgr {

	//실질적인 기능을 갖고 있음
	
	
	private Book[] bookList;
	// member 변수 bookList 생성함
	int count = 0;
	int location = 0;
	// count 변수를 둬서 BookMgr_answer가 몇개의 book을 관리하는지 확인하기

	// bookList의 Set Get Method 만들기

	// bookList에 직접 접근할 수 없도록 getBookList()는 제공하지 않도록 함!
	/*
	 * public Book[] getBookList() { //이렇게 Book[]의 배열도 return type 쓸 수도 있다! return
	 * bookList; }
	 */

	public void setBookList(Book[] bookList) { // 이렇게 Book[]의 배열을 매개변수로 쓸 수도 있다!
		this.bookList = bookList;
	}

	// 생성자 함수 만들기

	// 기본 생성자
	public BookMgr() {
		this(10);
		// 밑에 매개변수가 int size인 생성자 함수에 같은 코드가 있으므로 this() method로 가져와서 사용함
	}

	// 매개변수가 int size인 생성자
	// 이거로 BookMgr_answer mgr = new BookMgr_answer(); 에서 괄호 안에 사이즈 입력 할 수 있게 함
	public BookMgr(int size) {
		bookList = new Book[size];
	}

	// Book 객체를 bookList에 등록하는 addBook(Book book)메소드

	public void addBook(Book book) {
		if (count == bookList.length) {
			// bookList의 저장할 공간이 부족할 때 더 큰공간을 만들기 위해 if문 만들었음

			Book[] copy = new Book[bookList.length * 2];
			// bookList의 방을 2배로 늘린 copy라는 배열 만들기
			System.arraycopy(bookList, 0, copy, 0, bookList.length);
			// 원래 bookList에 있는 정보들을 새로만든 copy 배열에 복사하기
			bookList = copy;

		}

		bookList[count] = book;
		count++;
		// bookList에 책이 추가되면 count 변수가 증가함! => 이럼으로써 어느 위치에 book이 저장되는지 관리할 수 있음 ->
		// count 변수의 목적!
	}

//Delete book도 만들어보기   --> 삭제 후 그 자리르를 null처리 하고 뒤에 있는 책들을 앞으로 땡기고 count--하기		
	public void deleteBook(String book) {

		int location = 0;
		for (int i = 0; i < count; i++) {

			if (book.equals(bookList[i].getTitle())) {

				location = i;

				for (int j = i; j < count; j++) {

					bookList[j] = bookList[j + 1];

				}

			}
			count--;
		}

	}

//Search book도 만들어보기  --> title을 넘겨받아서 갖고있는 bookList 안에 입력한 title과 동일한게 있는지 다 돌려야함
	//대소문자 구문 없이 만들기
	public void searchBook(String book) {

		if (count == 0) {

			System.out.println("목록에 책이 없습니다.");
		}
	
		
		for (int i = 0; i < count; i++) {
			
			if (bookList[i].getTitle().toUpperCase().contains(book.toUpperCase())) {
				System.out.println("입력한 책이 목록에 있습니다");
			} else {

				System.out.println("입력한 책은 목록에 없습니다");
			}
		}
	}
//		for(int i=0 ; i<count ; i++) {
//			if(book.equalsIgnoreCase()) {
//				location = i+1;
//			}
//				
//		}
//		
//		System.out.printf("%s은 %s번째에 있습니다",book,location);
//
//	
//				

	// 책 목록을 화면에 출력하는 printBookList() 메소드
	public void printBookList() {

		for (int i = 0; i < count; i++) {
			// count변수가 몇개의 책이 bookList에 저장되어 있는지 알고 있으므로!

			bookList[i].print();
		}
	}

	// 모든 책 가격의 합을 출력하는 printTotalPrice() 메소드
	public int printTotalPrice() {
		int sum = 0;
		for (int i = 0; i < count; i++) {

			sum += bookList[i].getPrice();
		}
		return sum;
	}

}
