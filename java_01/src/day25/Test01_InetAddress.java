package day25;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01_InetAddress {

	public static void main(String[] args) {

		InetAddress ip = null;

		// [ IP 할당 받기 ]
		// -> 내 system의 IP주소 가져오기

		try {
			ip = InetAddress.getLocalHost();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		System.out.println("getHostName => " + ip.getHostName());
		System.out.println("getHostAddress => " + ip.getHostAddress());
		System.out.println("getByName => " + ip.toString());

		System.out.println("---------------------------");

		// 도메인의 IP주소 할당 받기
		// -> 도메인의 IP주소 알려줭
		// -> Naver는 당연히! IP주소 한개면 안되니까 그들이 알아서 분배해서 줌 -> 그래서 실행하면 IP 바뀜~
		try {
			ip = InetAddress.getByName("www.naver.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		System.out.println("getHostName => " + ip.getHostName());
		System.out.println("getHostAddress => " + ip.getHostAddress());
		System.out.println("getByName => " + ip.toString());

		System.out.println("---------------------------");
		
		
		// [ InetAddress.getAllbyName ]
		//하나의 도메인명에 여러 IP 주소가 mapping 되었을 때 모든 IP주소를 얻을 수 있게 해줌!
		InetAddress[] inet = null;
		try {
			inet = InetAddress.getAllByName("www.naver.com");

				for(int i= 0 ; i<inet.length ; i++) {
					System.out.println(inet[i]);
				}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
