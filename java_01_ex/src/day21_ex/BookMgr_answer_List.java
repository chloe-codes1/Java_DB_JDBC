package day21_ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookMgr_answer_List {

	List<Book> list = null;

	// List<Book>이 생성 될 때 ArrayList<Book>이 생성 될 수 있도록 생성자에 넣음
	public BookMgr_answer_List() {
		list = new ArrayList<Book>();

	}

	public BookMgr_answer_List(List<Book> list) {
		this.list = list;
	}

	// addBook(Book book)메소드
	public boolean addBook(Book book) {
		return list.add(book);
	}

	// Delete Method
	public boolean deleteBook(int ISBN) {
		boolean result = false;
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {
			Book data = it.next();
			if (data.getISBN() == ISBN) {
				System.out.println(data + " => 삭제됩니다.");
				it.remove();
				result = true;
				break;
			}
//			} else
//
//				System.out.printf("%s 도서가 목록에 없습니다.\n", ISBN);
//				break;
		}
		return result;

	}

	// Search Book Method
	public List<Book> searchTitleBook(String title) {
		System.out.printf("%s 도서를 검색합니다.\n", title);

		List<Book> slist = new ArrayList<Book>();
		Iterator<Book> it = list.iterator();
		while (it.hasNext()) {

			Book data = it.next();
			// 제목으로 검색 시, 대소문자 구분 없이 검색 가능하게 하기위해 입력값과 비교값을 모두 대문자로 바꾸고 비교
			if (data.getTitle().toUpperCase().contains(title.toUpperCase())) {
				slist.add(data);
			}else break;
		}
		return slist;
	}

	// 책 목록을 화면에 출력하는 printBookList()메소드
	public List<Book> BookList() {
		return list;
	}

	public void saveBook() {
		String fileName = "c:\\lib\\BookApp.txt";

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {

			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

	public List<Book> loadBook() {
		List<Book> books = null;

		String fileName = "c:\\lib\\BookApp.txt";

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);

			System.out.println("*** 저장된 Book List ***");

			books = (List<Book>) ois.readObject();

			books.forEach(e -> System.out.println(e));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} finally {

			try {
				if (ois != null) {
					ois.close();
					ois = null;
				}

				if (fis != null) {
					fis.close();
					fis = null;
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		return books;
	}

}
