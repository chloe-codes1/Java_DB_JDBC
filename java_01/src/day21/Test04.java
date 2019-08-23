package day21;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;


// [ Swing의 JFrame, JButton 쓰기 ]

public class Test04 {

	public static void main(String[] args) {
		// memory에 띄우기
		new UI_4();
	}
}

class UI_4 extends JFrame implements ActionListener {
				//J 붙이면 Swing에 있는 JFrame이 됨
	
	
	//J붙여서 Swing에 있는 JButton쓰기
	JButton red, blue, exit;
	Panel p1;

	// 생성자안에 넣기
	UI_4() {

		super("AWT UI Test");

		// panel 객체 p1 생성
		p1 = new Panel();

		// panel에 add하기
		// -> Panel은 Flow Layout!
		p1.add(red = new JButton("RED"));
		p1.add(blue = new JButton("BLUE"));
		p1.add(exit = new JButton("종료"));
							// -> 한글도 문제없이 처리됨

		// frame에 panel 붙이기

		// [ BorderLayout ]
		// -> 어느 위치에 붙일지 방향 설정 가능
		// EAST, WEST, NORTH, SOUTH 다 되고 그외에도 많으니 check them out!
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

//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//
//				setVisible(false);
//				dispose();
//				System.exit(0);
//			}
//		});
		// -> 여길 주석처리 하면 닫히지 않음! (눈에는 안보이는데 application은 종료가 안됨)
		// -> 그래서 JFrame은 아래의 코드를 지원함
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// -> JFrame 종료시켜주는 코드! 간단! 이걸 쓰자 JFrame 일 때~
		
		
		
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

class WindowEventP4 extends WindowAdapter {
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