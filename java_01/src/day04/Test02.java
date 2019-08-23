package day04;

public class Test02 {

	public static void main(String[] args) {

		
		//별(*)찍기
		
		for (int j = 0; j < 5; j++) {
			//System.out.println("j = " + j);			//별 찍으면서 j가 어떻게 커지는지 보려고 이거 씀
			for (int i = 0; i <= j; i++) {   //i <= j 대신에 i < j+1이라고 해도 같은 값 나옴~!
				//System.out.print("i = " + i);
				System.out.print('*');
					//i는 5가 되는 순간 scope가 끝남
			}
			System.out.println();
		}

		
		//*이 역순으로 찍히게 하기
		for (int j = 5; j > 0; j--) {
						
			for (int i = 0; i < j ; i++) {   //i <= j 대신에 i < j+1이라고 해도 같은 값 나옴~!
				
				System.out.print('*');
			}
			System.out.println();
		}
	}
}