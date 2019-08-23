package day17_collection;

public class Test02_generic2 {

	public static void main(String[] args) {
		
		// [ Generic ]
		
		Book2 b1 = new Book2 ("java",900); 
					// <Object, Object>
					// -> Object는 down-casting 해야함
		System.out.println(b1);
		
		//System.out.println(b1.getTitle().charAt()); -> 에러남!
			//-> Object는 charAt() method를 가지고 있지 않아서 casting이 필요함!
		if(b1.getTitle()instanceof String) System.out.println(((String)(b1.getTitle())).charAt(0));
		if(b1.getPrice()instanceof Integer) System.out.println((Integer)(b1.getPrice()));
		
		Book2<String, Integer> b2 = new Book2 ("SQL", 4000);
		System.out.println(b2);
	
		// [ 와일드 카드 <?> ]
		// : <?> 는 Object를 의미한다!
		Book2<?, Integer> b3 = new Book2 ("Spring", 4000);
		//System.out.println(b3.getTitle().charAt()); -> b3.getTitle() 은 Object라서 charAt() 안됨!
		
		// [ ? extends ]
		Book2<String, ? extends Number> b4 = new Book2 ("Spring", 4000);
		           // ? extends Number -> Number를 상속받은 자식만 가능 (Number 포함)
		System.out.println(b4.getPrice()); // ? => Number Type이 되었음!
		
		// [ ? super ]
		Book2<String, ? super Number> b5 = new Book2 ("Spring", 4000);
				   // ? super Number -> Number의 부모만 가능 (Number 포함)
		System.out.println(b5.getPrice()); // ? => Object type 되었음 (Number 포함!)
	}
}
