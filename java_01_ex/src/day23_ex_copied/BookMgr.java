package day23_ex_copied;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMgr {

	// Book[] 관리를 array로 만들면 내가 관리해야 하니까 Collection이 관리하도록 List로 만들기!
	// -> FrameWork (IoC = Inversion of Control) -> 제어권을 넘겨주기
	List<Book> list = null;
	String fileName;

	BookMgr() {
		this("book.data");

	}

	BookMgr(String fileName) {
		// fileName이 들어오면 그 이름으로 저장해라!
		// -> 생성되어 있는 파일이 없으면 기본 생성자에 있는 "book.data"로 만들어라
		this.fileName = fileName;
		list = (List<Book>) MyFile.load(fileName);
		if (list == null) {
			list = new ArrayList<Book>();
		}
		Thread t1 = new AutoSave();
		t1.start();
	}

	// CRUD

	// C
	public void add(Book book) {
		list.add(book);
	}

	// R
	public List<Book> getBookList() {
		return list;
	}

	// D
	public boolean deleteBook(int ISBN) {
		boolean result = false;

		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (ISBN == data.getISBN()) {
				System.out.println(data + " => 삭제됩니다.");
				it.remove();
				result = true;
				break;
			}
		}
		return result;
	}

	public List<Book> searchBook(String title) {

		List<Book> newList = new ArrayList();

		if (!(title.equals(""))) {
			Iterator<Book> it = list.iterator();
			while (it.hasNext()) {
				Book data = it.next();
				if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
					newList.add(data);
				}else break;
			}

		}

		return newList;
	}

	public void save() {
		MyFile.save(fileName, list);
	}
	
	class AutoSave extends Thread{
		
		@Override
		public void run() {

		while(true) {
			save();
			
			System.out.println("AutoSave() ~~~");
			try {
				Thread.sleep(1000*60*2);
				// -> 1000이 1초니까 *60은 60초 *2는 2분
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		}
	}
}
