package day05;

import java.util.Arrays;

public class Test04 {

	public static void main(String[] args) {

		// 밑에 둘의 차이점 알아야함
//		 String[] args = {}; // 데이터가 하나도 없다
//		 String[] args = {"5"};

		// [ 난수 발생 ]
		// -> Math.random()

		/*
		 * System.out.println(Math.random()); //=> Math class에 있는 난수발생 method //-> 0보다
		 * 크거나 작고, 1보다 작은 double 형이 결과로 random 하게 나옴
		 * 
		 * System.out.println((int)Math.random()); // 소수점 짤리고 항상 0만 나옴
		 * 
		 * System.out.println((int)(Math.random()*10)); //10을 곱했으므로 0~10 나옴
		 */

		if (args.length == 0) { // args 배열의 사이즈가 0이면 (데이터가 하나도 넘어오지 않으면) return시키는 함수
								// => run - configurations에 아무것도 입력하지 않으면 이거 출력된다!
			System.out.println("배열의 사이즈 정보를 실행 매개변수로 넘겨주세요..");
			System.out.println("실행_예) java day05.Test04 5");
			return;
		}

		int[] nums = new int[Integer.parseInt(args[0])];
		// -> 이렇게 하면 cmd로 실행했을 때 입력한 숫자만큼 방이 만들어짐
		// ->이클립스로 실행 시킬 땐 run - configurations ==> 현재 5 입력해 놓아서 길이가 5인 배열이 만들어짐!

		// nums라는 배열의 길이만큼 for loop돌려서 각 방에 채워넣기
		for (int i = 0; i < nums.length; i++) {

			// 1~45 사이의 정수를 random으로 나오게 하기
			// => Math.random() method 사용!
			nums[i] = (int) (Math.random() * 45) + 1; // *45만 하면 44까지 나오니까 *45 + 1
														// ->Math.random 으로는 0부터 0.99999999... 까지 나올 수 있으니까 int로 바꿨을 때
														// *45 하면 44 까지 나옴
		}
		// Math.random으로 생성된 배열 nums 출력
		System.out.println(Arrays.toString(nums));

		// [ 정렬 (Sort) ]

		System.out.println("--------- 정렬 ----------");

		// 오름차순

		int count = 0; // 스와핑 작업 몇 번 수행하는지 보려고 count 찍었음
		int i, j;
		int small = 0;
		int temp = 0;

		for (i = 0; i < nums.length - 1; i++) {

			small = nums[i];

			for (j = i + 1; j < nums.length; j++) {

				if (small > nums[j]) {

					temp = j;
					small = nums[j];
				}
			}
			nums[temp] = nums[i];
			nums[i] = small;
			count++;
		}

		System.out.println("오름차순으로 정렬된 배열: " + Arrays.toString(nums));
		System.out.println("오름차순 count => " + count);

		// 내림차순

		for (i = 0; i < nums.length - 1; i++) {// 맨 마지막 index로는 자동으로 갈꺼니까 안찾을꺼야

			for (j = i + 1; j < nums.length; j++) {

				if (nums[i] < nums[j]) {

					temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
			//System.out.println(Arrays.toString(nums)); // 여기다 쓰면 어떻게 찍히는지 알 수 있음
		}
		System.out.println("내림차순으로 정렬된 배열 = " + Arrays.toString(nums));
		System.out.println("내림차순 count => " + count);
	}
}