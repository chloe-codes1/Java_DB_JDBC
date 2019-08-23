package day17_ex;

import java.io.IOException;


// [ 주사위 게임 ]

class Dice {
	int size;

	Dice(int size) {
		this.size = size;
	}

	int play() {
		int number = (int) (Math.random() * size) + 1;
		return number;
	}
}

public class DiceGame {

	public static void main(String args[]) {
		DiceGame game = new DiceGame();

		try {
			int result1 = game.countSameEye(10);
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result1);

			int result2 = game.countSameEye(-10);
			// -> 던지는 횟수가 -10 (음수)이기 때문에 예외가 발생할 것이고,
			//    바로 catch {} block으로 가기 때문에 아래의 문장은 출력되지 않는다!
			System.out.println("면의 개수가 8개인 주사위 2개를  던져서 같은 눈이 나온 횟수 : " + result2);
			
		} catch (NegativeNumberException e) {
			System.err.println(e.getMessage());
		}
	}

	int countSameEye(int n) throws NegativeNumberException {

		Dice dice1 = new Dice(8);
		Dice dice2 = new Dice(8);

		int count = 0;
		
		// 주사위 던지는 횟수 (n)가 음수 일 때, 예외 발생 시키기
		if (n < 0)  throw new NegativeNumberException();

			for (int i = 0; i < n; i++) {

				if (dice1.play() == dice2.play()) {
					count++;
				}
			}
		return count;
	}
}
