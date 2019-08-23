package day09_ex;

import java.util.Arrays;

public class BookTest_answer {

	public static void main(String[] args) {
		BookMgr mgr = new BookMgr(5);
			//BookMgr_answer의 기본 생성자 함수가 10개의 방을 만드는 것으로 설정되어있으므로 () 안에 아무것도 넣지 않으면 10개의 방이 만들어 지는것을 알 수 있음
		
			//BookMgr_answer의 생성자 함수 중 int size에 의해 ()안에 숫자에 따라 방의 개수 다르게 만들 수 있음!
				//괄호 안에 숫자를 어떤것을 넣느냐에 따라 몇개를 BookMgr_anser이 관리할 지 알 수 있음
		
		//내가 쓴 것
		//Book book1 = new Book("랄랄라", 10000);
		//mgr.addBook(book1);
		
	
		mgr.addBook(new Book("랄",10000));
		mgr.addBook(new Book("랄랄",10000));
		mgr.addBook(new Book("랄랄라",10000));
		mgr.addBook(new Book("랄랄랄라",10000));
		mgr.addBook(new Book("랄랄랄랄라",10000));
		mgr.addBook(new Book("랄랄랄랄랄라",10000));
			//-> 배열에 5개의 방을 만들었으니까 6번째를 쓰면 죽었었으나, addBook()에 배열의 크기 늘리는 것 만들어서 안죽음! 		
		
		//System.out.println(Arrays.toString(mgr.getBookList())); =>BookMgr_answer에서 주석해서 이제 못씀
			//위에 mgr이 몇개의 방을 관리하는지 확인용! => 주소만 뜸! 
			//아무것도 입력안하면 10개 -> [null, null, null, null, null, null, null, null, null, null] 이렇게 뜸 
		
	
		mgr.printBookList();
		System.out.println("총합계 = " + mgr.printTotalPrice());
		mgr.searchBook("랄랄");
		
	}

}
