package day25;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TcpIpServer {

	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		List<BufferedWriter> clients = new ArrayList<BufferedWriter>();
		// -> BufferedWriter들을 관리하는 clients 객체 만들기
		
		try {
			serverSocket = new ServerSocket(7777);
			// 7777 => port #number
			// -> port 하나 열었음
			System.out.println("서버가 준비되었습니다.");
			// -> port에 문제가 있으면 이거 출력 안됨!

		} catch (Exception e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				System.out.println("Client 요청을 기다립니다.");

				Socket socket = serverSocket.accept(); // 기다리고있다리~
				
				//accept가 수행되는 순간 Thread 만들어서 동작시키기
				
			   new ServerThread(socket, clients).start();
				// -> socket = 나, clients = 모든 client들이 공유할 clients
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
}

class ServerThread extends Thread{

	BufferedReader br = null;
	BufferedWriter bw = null;
	Socket socket = null;
	String id = null;
	
	List<BufferedWriter> clients = null;
	// -> Thread에서도 이 type을 알아야 공유 가능
	
	public ServerThread(Socket socket, List<BufferedWriter> clients) {
		super();
		this.socket = socket;
		this.clients = clients;
		// -> 이제 Thread들은 clients를 공유 할 수 있음!

		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			clients.add(bw);
			
			id = br.readLine();

			String pw = br.readLine();

			System.out.println("User ID " + id + "님의 PW : " + pw);

			bw.write("User ID " + id + "님 로그인 되셨습니다.\n");
			bw.flush();
			
			broadCast(" 님이 로그인 하셨습니다.");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	@Override
	public void run() {

		String msg = null;
		try {
			while ((msg = br.readLine()) != null) {
				
				System.out.println(id + " 님의 msg : " + msg);
				broadCast(msg);
				// -> 밑에 broadCast() method를 만들어서 한줄로 해결
				
				if(msg.toUpperCase().equals("Q")) {
					broadCast(" 님이 로그아웃 하셨습니다.");
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
			if(br != null) br.close();
			if(bw != null) {
				clients.remove(bw);
				bw.close();
			}
			if(socket != null) socket.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	// msg를 모든 client들에게 보내는 method
	private synchronized void broadCast(String msg){
		// -> 여러명의 client의 msg 순서가 엉킬 수 있으므로 synchronized 처리 함!
		// -> broadCast() method는 외부에서 쓸 필요가 없으므로 private 처리 함!
		clients.forEach(bw -> {
			try {
			bw.write(id + ": " + msg + "\n");
			bw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
	}
}
