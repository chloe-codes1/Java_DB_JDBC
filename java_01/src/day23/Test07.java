package day23;

import java.io.RandomAccessFile;

public class Test07 {

	public static void main(String[] args) throws Exception{
							// -> main method에 throws Exception 하면 try -catch 할 곳이 없어짐 => 근데 웬만하면 하디망
		
		RandomAccessFile raf = new RandomAccessFile("rand.dat", "rw");
												// -> rw mode : Read & Write 다 되는 mode!
		//Random -> 내가 원하는 위치에 직접 접근이 가능하다!
		
		// [ RandonAccessFile ]
		// : 입출력이 모두 가능
		//   입의 접근이 가능
		//   실행 시킬 때마다 추가되고 바뀜!
		
		String msg = "Hello, RandomAccessFile ...";
		String result = null;
			// -> rand.dat file로부터 data 읽어올 때 result 받으려구 만듬
		
		// [ .writeBytes ]
		raf.writeBytes(msg);
		
		// [ .seek ]
		//커서를 옮길 수 있음!
		raf.seek(0); // => 0번위치 (맨앞)로 당겨옴!
		while(true) {
			result = raf.readLine();
			if(result==null) break;
			// -> null이 아닐 때 까지 계속 한줄씩 읽어라~
			System.out.println(result);
		}
		System.out.println("==================");
		raf.seek(raf.length()); // => raf의 맨 뒤 위치로 커서를 옮김!
		
		msg = "\nWe are... currently texting...this...file...";
		raf.writeBytes(msg);
		raf.seek(7);
		 // -> 7번째 위치인 Random부터 읽음!
		while(true) {
			result = raf.readLine();
			if(result==null) break;
			// -> null이 아닐 때 까지 계속 한줄씩 읽어라~
			System.out.println(result);
		}
		System.out.println("=================");
		raf.close();
		raf = null;
		
		
		
	}

}
