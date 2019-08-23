package day25_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TcpIpClient {

	public static void main(String[] args) {

		// server의 ip 주소를 알아야 연결 가능함
		String serverIp = "127.0.0.1";
		// -> 나를 지칭하는 IP (Local IP) 나야나~ 나야나~
//		String serverIp = "192.168.0.135";
		// -> 강사님 IP

//		String serverIp = "192.168.0.134";

		BufferedReader br = null;
		BufferedWriter bw = null;

		Socket socket = null;
		try {
			System.out.println(serverIp + " 연결 시도 할게요...");
			socket = new Socket(serverIp, 7777);
			// -> socket은 어떤 server와 연결되었는지에 대한 정보 갖게 됨!
			// -> 한번 socket을 만들고 죽음
			// -> server와 연결하려면 InputStream & OutputStream 필요!! -> buffered 로 readLine하는게
			// 편하므로 buffered로 감싸야함
			System.out.println("서버와 연결 되었습니다.");

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// -> byte단위로 읽는것을 char단위로 읽으려고 InputStreamReader 사용

			String id = JOptionPane.showInputDialog("아이디를 입력하세요");
			bw.write(id + "\n");
			bw.flush();

			System.out.println(br.readLine());
			// -> server로부터 한줄씩 읽어들이기

			String pw = JOptionPane.showInputDialog("비밀번호를 입력하세요");

			bw.write(pw + "\n");
			bw.flush();

			System.out.println(br.readLine());

			// ********************* msg **********************

			while (true) {
				String msg = JOptionPane.showInputDialog("메세지를 입력하세요. \n종료를 원하시면 Q/q를 입력하세요.");
				if (msg.toUpperCase().equals("Q")) {
					System.out.println("종료합니다.");
					break;
				} else {
					bw.write(msg + "\n");
					bw.flush();
					System.out.println(br.readLine());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				socket = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
