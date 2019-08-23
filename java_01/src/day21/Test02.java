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

public class Test02 {

	// [ AWT Package의 Frame, Button 사용 ]
	
	public static void main(String[] args) {

		// memory에 띄우기
		new UI_2();

	}

}

class UI_2 extends Frame{
	// is a 관계!
	// -> 이제 내가 Frame이니까 ex) f1.setSize 이렇게 할 필요 없음! 그냥 setSize!
	
	// has a 관계로도 가능 (Test01에서 이렇게 함)
//	Frame f1;

	Button red, blue, exit;
	Panel p1;

	// 생성자안에 넣기
	UI_2() {

		// 내가 Frame이니까 new 할 필요 없이 super() 로 생성!
		// -> why? 내부모는 Frame이니까 super()로 Frame에 title 생성해주는 생성자를 호출해서 title 만들기!
		super("AWT UI Test");

		// panel 객체 p1 생성
		p1 = new Panel();

		// panel에 add하기
		// -> Panel은 Flow Layout!
		p1.add(red = new Button("RED"));
		p1.add(blue = new Button("BLUE"));
		p1.add(exit = new Button("EXIT"));

		// frame에 panel 붙이기

		add(p1, BorderLayout.SOUTH);

		// [ .setSize ]
		// frame의 사이즈 설정하기
		setSize(300, 300);

		// [ .setVisible ]
		// frame을 눈에 보이게 하기
		setVisible(true);


		// 방법2) anonymous class 이용
		addWindowListener(new WindowAdapter() {
			// -> WindowListener type

			@Override
			public void windowClosing(WindowEvent e) {

				setVisible(false);
				dispose();
				System.exit(0);

			}
		});

		red.addActionListener(new ActionListener() {
			// -> ActionListener()는 abstract method 1개라서 ActionAdapter를 쓸 필요가 없다!
			@Override
			public void actionPerformed(ActionEvent e) {
				p1.setBackground(Color.RED);
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

class WindowEventP2 extends WindowAdapter {
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