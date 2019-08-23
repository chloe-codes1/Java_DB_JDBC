package day06;

public class Test01 {

	public static void main(String[] args) {
		
	// [ 배열	 ]
		int[] num = {2,4,6,8}; //배열의 선언-생성-초기화 한번에 했음
		
		int[] num2;
		//num2 = {1,2,3,4,5,6,7}; // -> 에러남
		num2 = new int[] {1,2,3,4,5,6,7};  //=> 이렇게 new int[]로 써야함!
		
		
		//새로 나온 for loop
		String[] arr = {"hello", "java", "test"};
		
		for(int data : num) {
			System.out.println(data);
		}
		for(String data : arr) {
			System.out.println(data);
		}
	}
}
