package day08_ex;


public class BookTest {
	Book[] booklist;
	
	
	public static void main(String[] args) {

		BookMgr a = new BookMgr();
		
		//생성자 함수를 이용하여 
		Book book1 = new Book("Java Program", 5000);
		Book book2 = new Book("JSP Program", 19000);
		Book book3 = new Book("SQL Fundametals", 20000);
		Book book4 = new Book("JDBC Program", 8000);
		Book book5 = new Book("EJB Program", 25000);
		
		
		a.addBook(book1);
		a.addBook(book2);
		a.addBook(book3);
		a.addBook(book4);
		a.addBook(book5);
		
		
		a.printBookList();
		a.printTotalPrice();
		
			
	}

}