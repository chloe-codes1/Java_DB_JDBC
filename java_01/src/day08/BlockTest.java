package day08;

public class BlockTest {

	public static void main(String[] args) {

	// [ 초기화 Block ]	
		//{} : 초기화블럭
		//생성자를 실행할 때마다 실행이 되고, 생성자보다 먼저 실행됨
		
		Block b1 = new Block(); //객체생성
			//그냥 Block이라는 class가 존재하기만 해도 (밑에 만들어놨음) new로 memory에 띄울 수 있음 
			//기본 생성자는 자동으로 만들어져서 그것을 이용해서 객체 생성 한 것임!
			//but, data도 없고 기능도 없음
		
		Block b2 = new Block();
		Block b3 = new Block();
		Block b4 = new Block(1);
		
		b1.print(); // 밑에 만들어놓은 print()함수 이용하여 출력하기
		b2.print();
		b3.print();
		b4.print();
	}
	
}

class Block {
	
	int j;
	int i;
	static String name;
	
	// [ 클래스 Block ] -> static {}
	// : 클래스 전체에서 한번만 사용가능한 block이라서
	static{
		//System.out.println("static {   }"); 
		name = "~~~~";
		
	} // 위에 문장은 딱 한번만 수행되는 block
		// static이라 공유되고 있의니까 (이미 있으니까 한번만 수행 된다!)
		// static한 자원을 한번에 초기화 활 때 사용
	
	
	// [ 초기화 Block ]
	// : 인스턴스 생성 될 때마다 생성자와 함께 생성되고, 생성자보다 먼저 실행되는 block
	{
		System.out.println("{         }");
		//생성자 함수에 초기화를 위해 {} 안에 들어가는 내용 중 공통적인 내용을
		//여기에 넣으면 객체가 생성 될 때 초기화 Block이 먼지 실행 되서 코드를 줄일 수 있음!
		this.j=99;
	}
	//=> 이 {      }이 바로 생성자보다 먼저 수행되는 초기화 block
	
	
	public Block() {
		//this.j=99;
		//System.out.println("생성자");
		
	//-> 생성자 함수는 초기화 하는 과정에서 많이 사용됨!
		
	}
	public Block(int i) {
		//this.j=99;
		this.i =i;
		//System.out.println("생성자");
	}
	
	//출력을 위해 print() method 만듦
	public void print() {
		System.out.printf("i=%s, j=%s, name=%s \n", i, j , name);
	}
}
