package day19_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BookMgr_answer_List {

	List<Book> list = null;
	
	//List<Book>이 생성 될 때 ArrayList<Book>이 생성 될 수 있도록 생성자에 넣음 
	public BookMgr_answer_List() {
		list = new ArrayList<Book>();
		
		//list = new Vector<Book>();
		//list = new LinkedLinst<Book>();
			//-> ArrayList자리에 Vector, LinkedList 써도 같은 list 자식이라서 똑같이 동작
			// ->ArrayList는 배열로 동작, LinkedList는 노드 기반으로 동작
			//   => 내부적으로 어떻게 동작하는지만 다르고 우리가 보는 결과값은 동일하다
			// -> 삽입/삭제가 잦으면 LinkedList가 성능이 좋다
		
	}

	public BookMgr_answer_List(List<Book> list) {
		this.list = list;
	}

	// addBook(Book book)메소드
	public void addBook(Book book) {
		list.add(book);
	}

	// Delete Method
	public void deleteBook(int ISBN) {

		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getISBN() == ISBN) {
				System.out.println(data + " => 삭제됩니다.");
				it.remove();
			} else

				System.out.printf("%s 도서가 목록에 없습니다.\n", ISBN);
		}

	}

	// Search Book Method
	public void searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {

			Book data = it.next();
			//제목으로 검색 시, 대소문자 구분 없이 검색 가능하게 하기위해 입력값과 비교값을 모두 대문자로 바꾸고 비교
			if(data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(data);
			}
		}
	}

	// 책 목록을 화면에 출력하는 printBookList()메소드
	public void printBookList() {
		System.out.println("========== Book List ==========");

		list.forEach(i->System.out.println(i));
		
		System.out.println("===========================");
		}
		
	}

