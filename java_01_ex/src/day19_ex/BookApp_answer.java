package day19_ex;

import java.util.Scanner;

public class BookApp_answer {

	public static void main(String[] args) {

		BookMgr_answer2_Map book = new BookMgr_answer2_Map();
		int count = 10;

		Scanner scanner = new Scanner(System.in);
		String cmd = null;

		while (true) {

			System.out.println("******** 명령 선택 *********");
			System.out.println("                         ");
			System.out.println("1. search(검색) \n");
			System.out.println("2. insert(등록) \n");
			System.out.println("3. delete(삭제) \n");
			System.out.println("4. print list(목록 출력) \n");
			System.out.println("5. quit(종료) \n");
			System.out.println("************************* \n \n");
			System.out.println("수행할 명령을 선택하세요 \n1 2 3 4 5 중 하나를 선택하세요..");

			cmd = scanner.nextLine().trim();

			switch (cmd.trim()) {

			case "1":
				System.out.println("검색할 Book Title을 입력하세요.");
				String title = scanner.nextLine();
				book.searchTitleBook(title);
				break;

			case "2":

				System.out.println("Book Title을 입력하세요.");
				title = scanner.nextLine();

				System.out.println("Book Price를 입력하세요.");
				int price = scanner.nextInt();
				scanner.nextLine();

				count++;
				book.addBook(new Book(count, title, price));

				break;

			case "3":
				System.out.println("삭제할 Book ISVN을 입력하세요.");
				int isbn = 0;
				try {
					isbn = scanner.nextInt();
					//nextInt는 Integer만 가져가기 때문에 nextInt로 int를 입력한 후에 enter누르면 enter가 남음
					//-> scanner.nextLine(); 이 enter key를 소진시켜줌!
					scanner.nextLine();
					book.deleteBook(isbn);
				} catch (Exception e) {
					break;
				}
				break;
			case "4":
				book.printBookList();
				break;

			case "5":
				System.out.println("정말 종료하시겠습니까? Q/q 를 입력하세요");
				String quit = scanner.nextLine().trim();

				if (quit.equals("Q") || quit.equals("q")) {
					System.out.println("종료합니다.");
					scanner.close();
					scanner = null;
					System.exit(0);
				}
				break;

			default:
				System.out.println("잘못 입력 하셨습니다 \n수행할 명령을 선택하세요 \n1 2 3 4 중 하나를 선택하세요..");
				break;
			}
		}
	}
}
