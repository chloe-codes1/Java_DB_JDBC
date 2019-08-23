package day08_ex;

import java.util.Arrays;

public class BookMgr {
	
	//책 목록 저장하는 배열 멤버변수
	Book[] booklist;
	int count=0;
		//booklist 안에 몇권의 책이 있는지 확인하기 위해 count 변수를 둠
	
				//booklist = Book.toStringArray();
	
	
	//booklist 배열변수를 초기화 하는 생성자 -> 생성자 함수를 통해 booklist의 크기 조정함
	public BookMgr () {
	
		booklist = new Book[10];
	}
	
	//Book 객체를 booklist에 등록하는 메서드
	public void addBook(Book book) {
						//addBook을 호출 할 때는 반드시 Book type을 넘겨줘야 함
		
			if(count==booklist.length) {
			
				Book[] copy = new Book[booklist.length+1]; // 새로운 배열 만들어서
				//원본과 크기 똑같게 만듬
				System.arraycopy(booklist, 0, copy, 0, booklist.length); // 복사해놓음 -> 원본을 보존하기 위해! (주소 공유하지 않도록!)
				
				booklist = copy;
			}
			
			booklist[count] = book;
			
			count++;
		
		}
	
	//책 목록 화면에 출력하는 method
	public void printBookList() {
		System.out.println("=== 책 목록 ===");
		
		for(int i=0 ; i<count ; i++) {
			
			System.out.println(booklist[i].getTitle());
			
		}
	}
	
	
	//책 가격의 합을 출력하는 method
	public void printTotalPrice() {
		System.out.println("=== 책 가격의 총합 ===");

		
		int sum= 0;
		for(int i=0 ; i<count ; i++) {
			sum+=booklist[i].getPrice();
		}
		
		System.out.println(sum);
	}
	
	
}