package day05_ex;

import java.util.Arrays;

public class Prob5_answer {

	public static void main(String[] args) {

		// 이거 시험에 서술형으로 나온다~~ 라라라라~~~

		/*
		 * 1. int[] num = new int[6]
		 * 
		 * 배열 num에 정수 1~45 사이의 난수를 집어넣는다. 중복제거한다. 정렬후 화면에 출력한다.
		 * 
		 */

//		int[] num = null;
//		num = new int[6];
		int[]num = new int[6];
		// System.out.println(num.length);

		for (int i = 0; i < num.length; i++) {
			num[i] = (int) (Math.random() * 6) + 1; // *45)+1 해야 1부터 45까지 나옴
			// => 나중에 검증할 때 *5로 하면 확인 제대로 할 수 있음!
			// + 디버깅 모드로 확인하면 더 정확하게 과정 볼 수 있다!
			for (int j = 0; j < i; j++) { // num[j] -> 이미 만들어져서 들어가있는 애, num[i] -> 지금 만들어진 애

				if (num[j] == num[i]) {
					i--; // i값을 1감소 시켜야 바깥 for loop에서 건너뛰지 않고, 다시 그 자리로 재진입함 => i 값 변하지 않음!
					break;
				}
			}
			// System.out.println(Arrays.toString(num)); // 어떻게 찍히는지 보려고
		}

		System.out.printf("중복 제거된 배열: %s%n", Arrays.toString(num)); // 진짜 결과 출력

		System.out.println("-------------------------- Sort ---------------------------");

		// 오름차순
		// swapping 횟수 새는 용 변수
		
		int count = 0;
		for (int i = 0; i < num.length - 1; i++) { // 배열 정리 시 맨 뒤에자리는 비교할 필요 없으므로 .lenght -1

			int min = i; // 가장 작은 값의 위치 인덱스를 담아놓기 !!! (swapping을 최소화 하기 위해)

			for (int j = i + 1; j < num.length; j++) {

				if (num[min] > num[j]) { // 큰걸 뒤로 보내겠다 -> 오름차순
					min = j;
				}
			}
			if (i != min) { // min값과 i값이 같을 때에는 swapping 안할 수 있도록!
							// 이게 있느냐 없느냐에 따라 횟수 엄청 차이남!
				int temp = num[i];
				num[i] = num[min];
				num[min] = temp;

				count++;

				/*
				 * 위의 if 구문을 if (i == min) { continue; }
				 * 
				 * 이렇게 바꿀 수도 있다!
				 */
			}
		}

		System.out.printf("오름차순의 Swapping 횟수는 %d%n",count);
		System.out.printf("오름차순으로 정렬한 배열: %s%n",Arrays.toString(num));
		
		
		// 내림차순으로
		// swapping 횟수 최소화

		for (int j = 0; j < num.length - 1; j++) {
			int max = j;

			for (int i = j + 1; i < num.length; i++) {
				if (num[max] < num[i]) {
					max = i;
				}
			}
			if (j != max) {

				int temp = num[j];
				num[j] = num[max];
				num[max] = temp;
				count++;
			}
		}

		System.out.printf("내림차순의 Swapping 횟수는 %d%n",count);
		System.out.printf("내림차순으로 정렬한 배열: %s%n",Arrays.toString(num));

	}
}
