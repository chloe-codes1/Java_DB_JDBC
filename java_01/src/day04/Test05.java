package day04;

import java.util.Arrays;

public class Test05 {

	public static void main(String[] args) {
		
		//배열 선언, 생성, 초기화 동시에 하기
		
		int[] scores= {44,55,66,77,88, 99, 100};
		String[] names= {"김주현", "홍길동", "박길동", "이길동", "고길동", "최길동"};   //선언,생성,초기화를 동시에 하려면 이렇게 쓰면 된다~~
		
	// [Arrays.toString() ]
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(names));
		
		
		if(names.length> 6) System.out.println(names[6]); //6번째 없어서 오류 안남
		
		System.out.println("------------------------------------");
		
		
	// [ 새로나온 for loop] 
		//data 전체를 뽑아올때만 가능~!
	
		for(String data :names) { // data : names => names라는 컬렉션이 있는데 JVM아 니가 data 꺼내줘 
			
			System.out.print("**" + data.charAt(data.length()-1) + "      \n");
							//이름에서 맨 마지막 글자 꺼내기
							//-> 이름이 몇글자인지 모르니끼 charAt() 에 data.length()-1 함
							//data names의 크기 -1 = 맨 마지막 위치)
							// ->Java 배열은 0부터 시작이니까 맨마지막이 -1이다!
		}

		double sum=0;
		for(int data : scores) {
			sum += data; //scores가 가리키는 점수들을 하나씩 꺼내와서 더한게 sum이다~
		}
		System.out.printf("평균은 %.2f", sum/scores.length);  
							// %.2f로 소수점 두번째 자리까지만 출력하게 했음!
							// sum/scores.length
							//= 점수들의 합계 sum을 점수들의 수 scores.length로 나누면 평균 구할 수 있음! 
	}
}
