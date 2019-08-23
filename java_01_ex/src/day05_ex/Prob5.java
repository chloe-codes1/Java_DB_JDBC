package day05_ex;

import java.util.Arrays;

public class Prob5 {

	public static void main(String[] args) {

		/*
		 * 1. int[] num = new int[6]
		 * 
		 * 배열 num에 정수 1~45 사이의 난수를 집어넣는다. 중복제거한다. 정렬후 화면에 출력한다. (+ swapping 횟수 최소화)
		 * 
		 */

		int[] num = new int[6];

		for (int i = 0; i < num.length; i++) {

			num[i] = (int) (Math.random() * 45)+ 1;

			for (int j = 0; j < i; j++) {

				if (num[i] == num[j])

					j--;
				break;
			}
		}

		System.out.printf("중복을 제거한 원본 배열 = %s%n", Arrays.toString(num));

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = i + 1; j < num.length; j++) {

				if (num[i] > num[j]) {

					int temp = num[j];
					num[j] = num[i];
					num[i] = temp;
				}
			}
			System.out.println(Arrays.toString(num)); //-> 배열이 어떻게 바뀌는지 보려고
		}

		System.out.println("정열된 배열 = " + Arrays.toString(num));
	}
}
