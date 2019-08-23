package day09;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Test02_String {

	public static void main(String[] args) {
		String msg = "Java Programming/20000";
		
		// /기준으로 데이터 뽑아오려고 /가 있는 위치정보를 먼저 뽑아오고 1더해서 / 뒤의 위치 알기
		System.out.println(msg.indexOf("/")+1);
		
	// [ .substring() ]	-> 추출하는 것
		
		// 0의 위치부터 slash 전 위치까지 뽑기
		String d1 = msg.substring(0, msg.indexOf("/"));
		
		// slash +1 위치부터 뽑기
		String d2 = msg.substring(msg.indexOf("/")+1);
		
		System.out.println(d1);
		System.out.println(d2);
		
		
	// [ .indexOf, .lastIndexOf() ]	
		//이 url의 맨뒤에 있는 정보 뽑기
		String url = "http://127.0.0.1:8080/web1/list.do";
		
		//slash가 많아서 뒤에 slash위치를 알고싶은건데 맨 앞에 위치를 추출함
		System.out.println(url.indexOf('/'));
		
		//그래서 .lastIndexOf를 써서 맨 마지막 slash 뽑아냄!
		System.out.println(url.lastIndexOf('/'));
		
		
		//그 결과 원했던 맨 마지막 slash 뒤의 정보 뽑아냄!!
		System.out.println(url.substring(url.lastIndexOf('/')));
		
		
	// [ .contains() ]	
		System.out.println("contains");
		System.out.println(url.contains("web1"));
		
		
		
// [ split으로 나누기 ]
		
		String data = "2019001_홍길동/90/70/100";
		
		System.out.println(data);
		
	// [ .replace(a,b) ]	
		System.out.println(data.replace('_','/'));
		
		
		//하지만 replace 한다고 data 자체가 바뀌지 않음 ! -> 이때만 이렇게 출력한다
		//why? String은 immutable한 객체이기 때문!!!
		System.out.println(data);
		
		//이렇게 data에 넣어야만 바뀜
		data = data.replace('_','/');
		String[] sdata =data.split("/");
		
		// _는 쪼개지 못하는 걸 알 수 있음 -> 다른 방법 필요하다!
		System.out.println(Arrays.toString(sdata));
		
		
		System.out.println("========================");
	
		
// [StringTokenizer]	
		
		
		data = "2019001_홍길동/90/70/100";
		
	
		StringTokenizer st1 = new StringTokenizer(data);
		
		//구분자 넣지 않으면 기본 구분자인 white space, new line, tab기준으로 구분됨
		
		System.out.println("StringTokenizer 구분자 넣지 않았을 때");
		
	// [ .countTokens() ]	
			//-> 몇개로쪼개졌는지 궁금해	
		System.out.println(st1.countTokens());
		
		while(st1.hasMoreElements()){
			System.out.print(st1.nextToken()+" , ");
		}
		
		System.out.println();
		
		System.out.println("========================");
		
		
	//StringTokenizer는 밑에처럼 내가 원하는 구분자를 다 넣어서 구분할 수 있음
		StringTokenizer st2 = new StringTokenizer(data,"/_");
		
		
		System.out.println("StringTokenizer 구분자 넣었을 때");
		System.out.println(st2.countTokens());
	
		while(st2.hasMoreElements()){
			System.out.print(st2.nextToken()+" , ");
		}
		
		
	}

}
