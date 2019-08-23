package day19_ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class BookMgr_answer2_Map {

	Map<Integer, Book> map = null;
	
	//List<Book>이 생성 될 때 ArrayList<Book>이 생성 될 수 있도록 생성자에 넣음 
	public BookMgr_answer2_Map() {
		map = new HashMap<Integer, Book>();
		
	}


	// addBook(Book book)메소드
	public void addBook(Book book) {
		map.put(book.getISBN(), book);
	}

	// Delete Method
	public void deleteBook(int ISBN) {

		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()) {
			Integer isbn = it.next();
			Book data = map.get(isbn);
			if(data.getISBN()==ISBN) {
				System.out.println(data + " => 삭제됩니다.");
				it.remove();
				break;
			}
		}	

	}

	// Search Book Method
	public void searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer isbn = it.next();
			Book book = map.get(isbn);
			if(book.getTitle().toUpperCase().contains(title.toUpperCase())) {
				System.out.println(book);
			}else {
				System.out.println("입력한 도서가 목록에 없습니다.");
				break;
			}
		}
	}

	// 책 목록을 화면에 출력하는 printBookList()메소드
	public void printBookList() {
		System.out.println("========== Book List forEach 기반 ==========");
		
	// [ Map에서 forEach 사용하기 ]
		
		// BiConsumer
		// -> key와 value 두개 가질 수 있는 Consumer
		// -> BiConsumer는 Functional Interface 라서 람다로 표현 가능하다!
		
//		map.forEach(new BiConsumer <Integer,Book>(){
//
//			@Override
//			public void accept(Integer key, Book value) {
//				System.out.println(key +" : " + value );
//			}
//			
//		});
		
	// [ Map에서의 forEach ]	
//		map.forEach( (k, v)-> System.out.println(k+" : " + v));
		
		//key 값 안찍고 싶으면 이렇게 하기
		map.forEach( (k, v)-> System.out.println(v));
		
		
		
//		Iterator<Integer>it = map.keySet().iterator();
//		while(it.hasNext()) {
//			
//			Integer isbn = it.next();
//			Book books = map.get(isbn);
//			System.out.println(books);
//		}
		System.out.println("===========================");
		}
	}
