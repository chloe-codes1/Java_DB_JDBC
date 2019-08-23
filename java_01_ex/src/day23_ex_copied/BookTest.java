package day23_ex_copied;

public class BookTest {

	public static void main(String[] args) {

		BookMgr bookMgr = new BookMgr();
//		bookMgr.getBookList().forEach(i -> System.out.println(i));
		
//		bookMgr.add(new Book("JAVA",900));
//		bookMgr.add(new Book("JSP",1900));
//		bookMgr.add(new Book("DB",2900));
		

		
		bookMgr.getBookList().forEach(i -> System.out.println(i));
		
		
//		bookMgr.add(new Book("blah blah",0));
		
		//종료 하기 전에 save 작업이 이루어져야함!
		// -> 기존 file에 update
		bookMgr.save();
		
	}

}
