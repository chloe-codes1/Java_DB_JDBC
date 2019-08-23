package day08;

public class Test02 {

	public static void main(String[] args) {

		Student[] students = {
				new Student("홍길동", 2019001, 90, 99, 71),
				new Student("김길동", 2019021, 89, 99, 61),
				new Student("최길동", 2019031, 90, 59, 71),
				new Student("박길동", 2019041, 40, 90, 71),
				new Student("고길동", 2019051, 100, 99, -70)
		};
		
		//s.setGradeProcess(); -> setGradeProcess는 이제 private하고, getGrade()함수 안에서 처리하므로 이 문장은 에러를 일으킴
		
		
		for(Student data: students) {
			//학점별로 뽑아서 관리하려고 if 문 씀
			//if(data.getGrade()== 'B') 
				//data.getGrade()의 return type은 char라서 .equals() 못 씀
			data.print();
		}
	}
	}

class Student {
	
	private String name;
	private int number;
	private int kor;
	private int eng;
	private int math;
	private char grade;
	//위에 있는 정보들이 모여있어야 정보가 됨 -> class로 만들어야한다!
	// -> 이 정보들이 모여서 Student class라는 하나의 data 가 됨
	
	
	//기본 생성자 -1
	public Student() {} 
	
	//다른 parameter 5개짜리 생성자 -2
		//이 생성자 함수를 만듬으로써 객체가 생성될 때 필요한 초기값 설정을 한번에 할 수 있음
	
	public Student(String name, int number, int kor, int eng, int math){ 
		
		this.name = name;
		this.number = number;
		
		//this.kor = kor;  // -> 원래 이렇게 짰다가, private처리해서 Setters Getters 생성함
		setKor(kor);   // setKor에 있는 if문으로 유효하지 않은 점수를 걸러주는 생성자 함수를 만든 것!!!
		
		//this.eng = eng;
		setEng(eng);
		
		//this.math = math;
		setMath(math);
		
		//setGradeProcess(); -> getGrade method 안에서 setGradeProcess() 함수를 호출해서 이 문장 필요 없어짐
	}
	
	//또 다른 parameter 1개짜리 생성자 -3
	public Student(String data) {} 
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		//점수가 유효한지 확인해주는 ScoreCheck() method 사용
		if(!(this.ScoreCheck(kor))) return;
		
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if(!(this.ScoreCheck(eng))) return;
		
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		
		if(!(this.ScoreCheck(math))) return;
	
		this.math = math;
	}
	
	public char getGrade() {
		this.setGradeProcess(); //private한 setGradeProcess를 내부에서 처리해서 여기서 호출하여 값을 얻어내고 getGrade() 
		return grade;
	}

	private void setGradeProcess() {
		//Student class 내의  member variable들을 private 처리해서 이 Student class 안에서만 쓸 수 있게 함
		//내부에서 해결 하겠다는 뜻
		
		double avg = (kor+eng+math)/3;
		
		//삼항연산자로 등급 구하기
		this.grade = avg>=90 && avg<=100 ? 'A' : (avg>=80 && avg<90 ? 'B' : (avg>=70 && avg<80 ? 'C': (avg>=60 && avg<70 ? 'D' : 'F'))); 
	}
	
	//정보 출력해야 하니까 출력문 만들기
	public void print() { 
		System.out.printf("%s, %f.2, %c %n", name, (kor+eng+math)/3.,this.getGrade());

		//getGrade() method를 통해 grade를 얻어오므로 ~~
	}
	
	
	//점수 체크용 함수
	
	private boolean ScoreCheck(int score) {
		
		boolean flag =true; //초기값으로 true 값을 넣음
							
		if(!(score>=0 && score<=100)){
			System.out.printf("%s => 점수가 유효하지 않습니다.%n", score);
				flag = false; // 조건에 맞지 않을 때만 false로 바뀌도록 설정함
		} 
			return flag;
			
	}
}
