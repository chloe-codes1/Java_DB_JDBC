package day03_ex;

public class book_exercise3_03 {

	public static void main(String[] args) {

		// 책 118p - 3번문제

		// 구구단을 형식에 맞게 출력하기

		System.out.println("----------- Java Run -----------");

		int a, b;

		for (a = 1; a <= 9; a++) {

			for (b = 2; b <= 9; b++) {

				System.out.print(b + "*" + a + "=" + a * b +"\t");
			}
			System.out.println();
		}
		System.out.println("Normal Termination");
	}
}