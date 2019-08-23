package day19_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test03_map2 {

	// Test02 copy 한 것!

	public static void main(String[] args) {

		// [ MAP 구조 ]

		Map<String, String> map = new HashMap<String, String>();

		// ID PW
		map.put("java01", "1234");
		map.put("java02", "1234");
		map.put("admin", "admin");

		// 테스트용으로 여러개의 계정 한번에 만들기
		for (int i = 0; i < 30; i++) {
			map.put("test" + i, "abc" + (int) (Math.random() * 3));
			// PW는 Math.random으로 random하게 생성

		}
		int count = 3;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("*** 로그인 처리 ***");
			System.out.println("ID/PW 형식으로 입력해 주세요");
			String data = sc.nextLine();
			// split써서 ID PW 구분하기
			String[] info = data.split("/");

			String id = info[0];
			String pw = info[1];

			// ID가 없는 ID일 경우
			if (map.containsKey(id)) {

				// 사용자가 입력한 id의 진짜 pw와 사용자가 입력한 pw비교
				if (map.get(id).equals(pw)) {
					System.out.println("로그인 성공!");
					System.out.println("이제부터 서비스 이용 가능합니다.");
					sc.close();
					sc = null;
					break;
				} else if (!(map.get(id).equals(pw))) {

					System.out.println("PW 불일치\n다시 로그인하세요.");
					count--;
				}

				if (count < 1) {
					System.out.println("비밀번호를 3회 잘못 입력하셨습니다.\n회원님의 이메일로 인증 메일을 발송 하였습니다.");
					break;
				}

			} else {

				System.out.println("입력하신 ID가 존재하지 않습니다.");
				System.out.println("회원 가입 후 이용하세요!!!!!");
			}
		}

	}

}
