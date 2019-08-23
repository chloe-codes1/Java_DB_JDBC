package day10;

public class Point {

	
	// [ 좌표값 ]
		
		int x;
		int y;
		
		//기본 생성자
		public Point() {
			super();
			
		}
		
		//parameter 2개인 생성자
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}



		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		
		public void print() {
			
			System.out.printf("j");
			
		}
		

}
