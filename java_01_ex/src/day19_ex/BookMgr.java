package day19_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookMgr {
	
	Map<Integer, Book> map = new HashMap<Integer, Book>();
	public BookMgr() {
	}

	public BookMgr(int size) {
		
	}
	
	public BookMgr(Map<Integer, Book> map) {
		this.map = map;
	}


	// addBook(Book book)메소드
	public void addBook(int num,Book book) {
		map.put(num, book);
	}

	// Delete Method
	public void deleteBook(int ISBN) {

		if (map.containsKey(ISBN)) {
			System.out.println("삭제 정보: " + map.remove(ISBN) + " 도서가 삭제되었습니다.");
		} else

			System.out.printf("%s 도서가 목록에 없습니다.\n", ISBN);
	}

	// Search Book Method
	public void searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		Iterator<Integer> keynames = map.keySet().iterator();
		while (keynames.hasNext()) {

			Integer isbn = keynames.next();
			Book book = map.get(isbn);
			if (book.getTitle().equals(title)) {
				System.out.println(book);
				break;
			} else break;
		}
	}

	// 책 목록을 화면에 출력하는 printBookList()메소드
	public void printBookList() {
		System.out.println("========== Book List ==========");

		Iterator<Integer> all = map.keySet().iterator();
		while (all.hasNext()) {

			Integer isbn = all.next();
			Book books = map.get(isbn);
			System.out.println(books);

		}
		System.out.println("===========================");
	}
}
