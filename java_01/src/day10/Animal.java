package day10;

public class Animal {

	//[ protected ]
	//-> 상속 받는 자식 class까지 접근 가능한 access modifier

	protected String kind = "동물의 종류";
	//" " 입력하여 default 초기화
	
	// 생성자 = member변수의 초기화 담당
	
	// [기본 생성자]
	// =상속을 고려하여 기본 생성자 만들기
		//-> 없으면 에러가 많아진다
		//-> 만약 이걸 지우면 부모의 기본생성자가 사라지므로 자식 class인 Dog에서 에러가 남!
	public Animal() {
		super();
	}
	
	public Animal(String kind) {
		super();
		this.kind = kind;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void breath() {
		System.out.printf("%s : 폐로 숨쉰다~!%n", kind);
		
	}
	
	public void print() {
		System.out.printf("[ Animal Kind : %s",kind);
		
	}
}
