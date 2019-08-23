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

public class Test01 {

	// [ AWT Package의 Frame, Button 사용 ]
	
	public static void main(String[] args) {

		// memory에 띄우기
		new UI_1();
	}
}

class UI_1 {
	// is a 관계로도 가능!

	// has a 관계
	Frame f1;

	Button red, blue, exit;
	Panel p1;

	// 생성자안에 넣기
	UI_1() {

		// frame에 title 넘기기
		f1 = new Frame("AWT UI Test");

		// panel 객체 p1 생성
		p1 = new Panel();

		// panel에 add하기
		// -> Panel은 Flow Layout!
		p1.add(red = new Button("RED"));  
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("EXIT"));

		// frame에 panel 붙이기

		// [ BorderLayout ]
		// -> 어느 위치에 붙일지 방향 설정 가능
		// EAST, WEST, NORTH, SOUTH 다 되고 그외에도 많으니 check them out!
		f1.add(p1, BorderLayout.SOUTH);

		// [ .setSize ]
		// frame의 사이즈 설정하기
		f1.setSize(300, 300);

		// [ .setVisible ]
		// frame을 눈에 보이게 하기
		f1.setVisible(true);

		// [ .addActionListener ]
		// button에 감시자 붙이기
		// -> Listener가 붙으면 다 Interface다!
//		red.addActionListener();
//		
//		// [ .addWindowLisner ]
//		// window를 감시하는 listener
//		f1.addWindowListener();

		// 방법1) 별도의 주소를 객체 생성해서 해결
//		f1.addWindowListener(new WindowEventP());
		// -> WindowListener type이 와야함!

		// 방법2) anonymous class 이용
		f1.addWindowListener(new WindowAdapter() {
			// -> WindowListener type

			@Override
			public void windowClosing(WindowEvent e) {

				f1.setVisible(false);
				f1.dispose();
				System.exit(0);

			}
		});

		red.addActionListener(new ActionListener() {
			// -> ActionListener()는 abstract method 1개라서 ActionAdapter를 쓸 필요가 없다!
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.RED);//-> panel이 빨갛게 되는거임!!
			}
		});

		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.BLUE);
			}
		});

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setVisible(false);
				System.exit(0);
			}
		});

	}

}

class WindowEventP1 extends WindowAdapter {
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