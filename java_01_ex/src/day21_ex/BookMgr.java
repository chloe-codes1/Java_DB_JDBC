package day21_ex;

import java.awt.TextField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BookMgr extends Object {
	
	Map<Integer, Book> map = new HashMap<Integer, Book>();
	
	String msg;
	Book list;
	public BookMgr() {
	}

	public BookMgr(int size) {
		
	}
	
	public BookMgr(Map<Integer, Book> map) {
		this.map = map;
	}


	// addBook(Book book)메소드
	public void addBook(Integer num, Book book) {
		map.put(num, book);
	}

	// Delete Method
	public boolean deleteBook(int ISBN) {

		if (map.containsKey(ISBN)) {
			map.remove(ISBN);
			
		}
			
//			System.out.println("삭제 정보: " + map.remove(ISBN) + " 도서가 삭제되었습니다.");
//		} else
//
//			System.out.printf("%s 도서가 목록에 없습니다.\n", ISBN);
		
		return true;
		
	}


	// Search Book Method
	public Map<Integer,Book> searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		Map<Integer, Book> smap = new HashMap<Integer, Book>();
		
		Iterator<Integer> keynames = map.keySet().iterator();
		while (keynames.hasNext()) {

			Integer isbn = keynames.next();
			Book book = map.get(isbn);
			if (book.getTitle().toUpperCase().equals(title.toUpperCase())) {
				smap.put(isbn, book);
				
			} else {
				msg =  "입력한 도서가 목록에 없습니다.";
			}
		}
		return smap;
	}
	
	


	// 책 목록을 화면에 출력하는 printBookList()메소드
	public Map<Integer, Book> printBookList() {
//		System.out.println("========== Book List ==========");
//		Iterator<Integer> all = map.keySet().iterator();
//		list=null;
//		while (all.hasNext()) {
//
//			Integer isbn = all.next();
//			Book books = map.get(isbn);
//			list = books;
//		}
//		System.out.println("===============================");
		return map;
	}
}
