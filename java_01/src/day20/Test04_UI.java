package day20;

import java.awt.Button;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.awt.Panel;

public class Test04_UI {

	public static void main(String[] args) {
		new UI();
		
	}
}

class UI{
	
	Frame f;
	Button ok, exit;

	//기본 생성자
	UI(){
		f = new Frame();
		
		ok = new Button("OK");
		exit = new Button("Exit");
		
		//Panel 만들기
		Panel p1 = new Panel();
		p1.add(ok);
		p1.add(exit);
		
		//Panel읇 Frame에 붙이기
		f.add(p1);
		
		//Frame의 크기 정해주기
		f.setSize(500,500);
		
		//눈에 보이게 하기
		f.setVisible(true);
	}
	
}