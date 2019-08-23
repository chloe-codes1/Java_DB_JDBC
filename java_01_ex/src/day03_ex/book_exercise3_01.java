package day03_ex;

import java.util.Scanner;

public class book_exercise3_01 {

	public static void main(String[] args) {

		// 책 118p

		// [문제1]
		// 나이를  입력하면 몇 십대인지 알려주는 프로그램
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요.");
		int age = sc.nextInt();
		int range = 0;

		// [if문으로 풀기]

		if (age >= 0 && age <= 100) {
			if (age / 10 == 0) {
			} else if (age / 10 == 1) {
				range = 10;
			} else if (age / 10 == 2) {
				range = 20;
			} else if (age / 10 == 3) {
				range = 30;
			} else if (age / 10 == 4) {
				range = 40;
			} else if (age / 10 == 5) {
				range = 50;
			} else if (age / 10 == 6) {
				range = 60;
			} else if (age / 10 == 7) {
				range = 70;
			} else if (age / 10 == 8) {
				range = 80;
			} else if (age / 10 == 9) {
				range = 90;
			} else if (age / 10 == 10) {
				range = 100;

			}

			System.out.println("당신의 나이는 " + age + "살, " + range + " 대 입니다.");
			//System.out.printf("당신의 나이는 %d살, %d 대 입니다. %n", age, range);

		} else {
			System.out.println("제대로 된 나이를 입력하세요!!!!!");

		}

		System.out.println("*******Switch로 풀기********");

		// [Switch 구문으로 풀기]

		switch (age / 10) {
		
		case 0:
			range = 0;
			break;
		case 1:
			range = 10;
			break;
		case 2:
			range = 20;
			break;
		case 3:
			range = 30;
			break;
		case 4:
			range = 40;
			break;
		case 5:
			range = 50;
			break;
		case 6:
			range = 60;
			break;
		case 7:
			range = 70;
			break;
		case 8:
			range = 80;
			break;
		case 9:
			range = 90;
			break;
		case 10:
			range = 100;
			break;

		}

		System.out.printf("당신의 나이는 %d살, %d 대 입니다.", age, range);

	}
}
