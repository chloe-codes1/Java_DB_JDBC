package day04;

public class Test03 {

	public static void main(String[] args) {
		
		
	//[ 구구단 만들기 ]
		
		//구구단
		int a, b;
		for( a = 2 ; a<=9 ; a++) { //단이 바깥쪽 for loop 임
			
			for( b =1 ; b<=9 ; b++) {
				System.out.printf(" %d * %d = %d%n",a,b,a*b);
				if(b==9) System.out.println();
			}
		}
		
		//한 줄씩 나눈 구구단
		int i,j;
		
		//OUT:
			for(i=1 ; i<=9 ; i++) {   //5단 이후로 빠져나오기 위해 겉에 있는 for loop를 빠져나오기 위해 "OUT"이라고 labeling 함
			
			for(j=2 ; j<=9 ; j++) {  //단이 안쪽 루프에 있어야 함!  -> j 가 단이다!
									//-> why? 찍힐때는 가로로 한줄씩 찍히니까
									//  ex) 바깥 루프의 i가 1인 동안에 안쪽 루프가 9번 돌아야 가로로 n단*1 이 9번 찍힘
				
				//System.out.print(j + "*" + i + "=" + i*j + "\t|");
				
				
				//if(j==5) break OUT; // -> 이렇게 하면 5단 이후로는 처리가 안됨!   + labeling한 OUT을 break문에 쓰면 아예 바깥 for loop를 빠져나옴!!
				//if(j==5) continue; //j 가 5일때 5단만 처리하지 않고, for loop의 j++로 재진입 해서 5단만 찍히지 않음! => 5단만 건너뜀
				
				
				System.out.printf("%d*%d=%d\t|", j, i, i*j);
				
			}
			System.out.println();
		}
	}
}
