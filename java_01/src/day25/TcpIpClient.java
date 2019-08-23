package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

public class TcpIpClient {

	public static void main(String[] args) {

		// [ server의 ip 주소를 알아야 연결 가능함 ]

		String serverIp = "127.0.0.1";
		// -> 나를 지청하는 IP (Local IP) 나야나~ 나야나~
//		String serverIp = "192.168.0.135";
		// -> 강사님 IP
//		String serverIp = "192.168.0.134";
		// -> 내자리 IP

		BufferedReader br = null;
		BufferedWriter bw = null;
		
		Socket socket = null;
		
		try {
			System.out.println(serverIp + " 연결 시도 할게요...");
			socket = new Socket(serverIp, 7777);

			System.out.println("서버와 연결 되었습니다.");

			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// -> byte단위로 읽는것을 char단위로 읽으려고 InputStreamReader 사용

			new clientThread(br).start();
			// -> 읽는 작업을 할 준비 완료!
			
			String id = JOptionPane.showInputDialog("아이디를 입력하세요");
			bw.write(id + "\n");
			bw.flush();
			
			
			String pw = JOptionPane.showInputDialog("비밀번호를 입력하세요");
			
			bw.write(pw + "\n");
			bw.flush();


			while (true) {
				String msg = JOptionPane.showInputDialog("메세지를 입력하세요. \n종료를 원하시면 Q/q를 입력하세요.");
				if (msg.toUpperCase().equals("Q")) {
					System.out.println("종료합니다.");
					bw.write(msg + "\n");
					break;
				} else {
					bw.write(msg + "\n");
					bw.flush();

				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				socket=null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
class clientThread extends Thread{
	// Server에서 보내는 것 읽기만 하는 Thread
	
	BufferedReader br = null;
	
	public clientThread(BufferedReader br) {
		this.br = br;
	}



	@Override
	public void run() {
		String msg = null;
		
		try {
			while((msg = br.readLine()) !=null) {
			System.out.println(msg);
			}
		} catch (Exception e) {

		}
	}
}
