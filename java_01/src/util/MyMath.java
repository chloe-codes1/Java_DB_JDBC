package util;

public class MyMath {
		
	//[ Method Overloading ]
		//매개변수(parameter)의 type이나 개수가 달라야 구분 가능하다!
		//return type은 method overloading에 영향을 미치지 않는다! parameter에 달려있다!
			//ex) public static long 이랑   public static double  이렇게 해도 overloading 불가능 함
			// => 여기서 long과 double은 return type 이니까!
	
		public static long add(int a, int b) { //public을 넣어야만 다른 패키지에 있는 MyMathTest에서 사용 가능!
			return a+b;
		}
		
		public static double add(double a, double b) {
			//똑같은걸 두개 쓰면 구분할 수 있는 능력이 없어서 에러남
			//이름은 동일한데 parameter에 data type이나 개수가 다르면 구분할 수 있다!
				//->*** Method Overloading ***
				//-> 이렇게 하면 add() method로 정수나 실수 넘겨도 다 add가 처리 할 수 있도록 해줌!
			return a+b;
		}
		
		//parameter 3개짜리
		public static double add(double a, double b, double c) {
			return a+b+c;
		}

	//[ 가변인자 처리 ]
		//parameter(매개변수)에 몇개의 숫자가 들어와도 처리 가능하게 함!
		//+ 가변인자는 매개변수에서 가장 마지막 위치에 와야한다!
			//why? 가변인자는 몇개가 입력될 지 모르기 때문에 그 후에 나오는 매개변수를 처리하기가 어려움
			//ex) public static double add(double a, double...nums) -> 가능
				//public static double add(double...nums, double b) -> 불가능
		
 		public static double add(double...nums) {
 			// 이렇게 하면 배열 처리가 됨!! []
 			//(...으로 가변인자가 된다)
 			
 			double sum=0; //local variable -> method 안에 있으니까
 			for (double data : nums ) {
 				sum+=data;
 			}
 			return sum;
 		}
 		
 		//public static double add(double[] a) {
 			//-> 위의 가변인자가 곧 배열이기 때문에 중복되어서 오류남!
 			
 		//[ 배열과 가변인자의 차이점 ]
 		//: 배열은 입력 값 또한 배열로 넘겨줘야 처리가능
 		// ex) MyMathTest.java에서 아래와 같이 넘겨줘야함  -> 복잡 -> 가변인자가 편하고 좋다!
 				//System.out.println(MyMath.add(new double[] {1,2,3,4,5,6,7,8,9,10})); 
}