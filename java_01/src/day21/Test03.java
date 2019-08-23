package day21;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Test03 {

	// [ AWT Package의 Frame, Button 사용 ]
	
	public static void main(String[] args) {

		// memory에 띄우기
		new UI_3();

	}

}

class UI_3 extends Frame implements ActionListener {
	// is a 관계로도 가능!

	// has a 관계
	Frame f1;

	Button red, blue, exit;
	Panel p1;

	// 생성자안에 넣기
	UI_3() {

		super("AWT UI Test");

		// panel 객체 p1 생성
		p1 = new Panel();

		// panel에 add하기
		// -> Panel은 Flow Layout!
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("종료"));
				// -> Eclipse로 보면 한글 에러 나는 것 처럼 보이지만 DOS창으로 실행시키면 문제없이 동작함!
				// -> Eclipse는 개발자 도구니까 Test용이고 진짜 사용자가 보는 화면을 확인하려면 DOS창으로 실행시키기~

		// frame에 panel 붙이기
		add(p1, BorderLayout.SOUTH);
		// -> this.add 인데 this 생략됨

		// [ .setSize ]
		// frame의 사이즈 설정하기
		setSize(300, 300);

		// [ .setVisible ]
		// frame을 눈에 보이게 하기
		setVisible(true);

		// 감시자 붙이기
		red.addActionListener(this);
		blue.addActionListener(this);
		exit.addActionListener(this);
		// -> add___Listener(___Event type이 와야함!);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				setVisible(false);
				dispose();
				System.exit(0);
			}
		});

	}

	// [ Call back method ]
	// : 내가 호출하는게 아니고 System에 의해 호출되는 method
	// -> 대부분의 Call back method의 return type은 void임
	// -> parameter는 알아서 정해져있음

	// actionPerformed가 수행되고 나면, 다시 감시자 (Listener)로 돌아감!
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "RED":
		// -> Button 명칭과 동일해야 함!
			p1.setBackground(Color.RED);
			break;
			
		case "BLUE":
			p1.setBackground(Color.BLUE);
			break;
			
		case "종료":
			System.exit(0);
		}
	}
}

class WindowEventP3 extends WindowAdapter {
	// ( 처음에 WindowListener implements 했었음)
	// -> WindowListener 가 갖고있는 abstract method 엄청 많음..
	// -> 다 override 해야함! 하는일이 없어도 override는 해야함
	// -> 나는 하나의 method만 필요한데 불필요한 코드들을 써야함
	// => 그래서 WindowListener를 implements 한 WindowAdaptor를 extends 하면 됨!

	@Override
	public void windowClosing(WindowEvent e) {
// -> UI_1의 f1객체를 쓰기 위해 WindowEvenP를 UI_1의 inner class로 만들었음!
//    => 나중에 다시 innerClass 밖으로 뺐음...

		// System.exit(0)이 시간이 좀 걸릴 수 있어서 미리 frame을 눈에 안보이게 만들기
//	f1.setVisible(false);
//	
//	f1.dispose();

		System.exit(0);
		// -> 시간이 좀 걸릴 수 있음
	}
}