package exercises;

//import java.util.Scanner;

import javax.swing.JOptionPane;

public class RockPaperSisors_switch {

	public static void main(String[] args) {

		int user, com;
		
//		System.out.println("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.");
//		
//		Scanner sc = new Scanner(System.in);
//		String temp = sc.nextLine();	
		
		
		String temp = JOptionPane.showInputDialog("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.");

		
		
		user = Integer.parseInt(temp);
		
		if(!(user>=1 && user<=3)) return;
		
		
		com = (int)(Math.random()*3+1);
		
		System.out.printf("당신은 %s 입니다.%n",user);
		System.out.printf("컴퓨터는 %s 입니다.%n",com);
		
		switch(user-com) {
		
		case 1 :
		case -2:
			System.out.println("당신이 이겼습니다!");
			break;
		case -1:
		case 2:
			System.out.println("당신이 졌습니다....");
			break;
		case 0:
			System.out.println("비겼습니다.");
		
		}
		
	}

}
