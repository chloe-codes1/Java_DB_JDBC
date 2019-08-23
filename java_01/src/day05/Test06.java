package day05;

public class Test06 {

	public static void main(String[] args) {

		int[][] t1 = new int [4][];   //행은 4행인 것 결정 됐는데, 열은 결정 안된 것
		
		t1[0] = new int [4];
		
		System.out.println(t1[0]); //[I@15db9742 -> 주소 출력됨 => 1차원 배열은 2차원 배열의 주소를 가리키고 있으니까!
		System.out.println(t1[0][0]); //아무것도 입력된게 없어서 int의 default값인 0이 출력됨
		
		//이차원 배열의 선언,생성,초기화 동시에 하기
		//-> 이때, 초기화는 {{}} 괄호를 두번 써야함
		int[][] t2 = {
				{1,2,3,4,5,6} ,
				{44,55,66,77,88,99} , 
				{11,22}
		};
		
		//이차원 배열의 길이
		System.out.println("t2.length = " + t2.length); //t2가 참조하고 있는 배열의 길이이므로 = 3
		System.out.println("t2[2].length = " +t2[2].length); //t2[2]가 참조하고 있는 배열은  {11,22}이므로 2
		
		
		System.out.println("-----------------------");
		
		
		//이차원 배열 출력하기
		for(int i=0 ; i<t2.length ; i++) {
		
			for(int j=0 ; j<t2[i].length ; j++) {
			System.out.print(t2[i][j] + " "); //각 일차원 배열들의 주소 찍음
			}
			System.out.println(); 
		}
		
		//ex) 영화관 남은 자리 찾기
		
		//크기가 [3][7]인 이차원 배열 s
		char[][] seat = {   
				{'x','x','x','x','x','x','x','x'},
				{'x','x','o','x','x','x','x','x'},
				{'x','x','x','o','x','x','x','x'}
		};
		
		for(int i= 0 ; i< seat.length ;i++) {
			for(int j=0 ; j<seat[i].length ; j++) {
			if(seat[i][j]=='o') {
				
				System.out.printf("[%2d행 %2d열 ]%n",i,j);
			}
			
		}
		}
	}
}
