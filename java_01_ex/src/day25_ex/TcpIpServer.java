package day25_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpIpServer {

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		multiServer multi = null; // thread 객체 생성

		try {
			serverSocket = new ServerSocket(7777);
			// 7777 => port #
			// -> port 하나 열었음
			System.out.println("서버가 준비되었습니다.");
			// -> port에 문제가 있으면 이거 출력 안됨!

			while (true) {
				try {
					System.out.println("Client 요청을 기다립니다.");

					Socket socket = serverSocket.accept(); // 기다리고있다리~
					multi = new multiServer(socket);
					multi.start(); // Thread 실행 대기 큐에 넣기
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

// 여러명의 client를 받기 위한 Thread 생성
class multiServer extends Thread {

	BufferedReader br = null;
	BufferedWriter bw = null;
	Socket socket;
	String id;

	public multiServer(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			while ((id = br.readLine()) != null) {

				System.out.println("User ID " + id + "님이 로그인 하셨습니다.");
				bw.write(id + " 님 안녕하세요!\n");
				// -> readLine으로 읽어들이니까 한줄의 끝을 알리기 위해 "\n"

				bw.flush();
				// -> buffer가 언제 비워질지 모르므로 즉각 보내기 위해 flush 필수!!! ***

				String pw = br.readLine();

				System.out.println("User ID " + id + "님의 PW : " + pw);

				bw.write(id + " 님 로그인 되셨습니다.\n");
				bw.flush();

				// ******************* msg ***********************

				String msg = null;

				while ((msg = br.readLine()) != null) {
					if (msg.toUpperCase().equals("Q")) {
						break;
					}
					System.out.println("User ID " + id + " 님의 msg : " + msg);
					bw.write(id + " : " + msg + "\n");
					bw.flush();
				}
				System.out.println("User ID " + id + " 님이 로그아웃 하셨습니다.");
				System.out.println("Client 요청을 기다립니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if(br != null) socket.close();
			if(bw != null) socket.close();
			if(socket != null) socket.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}


