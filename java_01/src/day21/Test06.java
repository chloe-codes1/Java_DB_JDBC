package day21;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.stream.Stream;

public class Test06 {

	public static void main(String[] args) {

		new DrawImg();

	}

}

class DrawImg extends Frame {

	Image im;

	// 생성자
	DrawImg(){
		
		super.setTitle("DrawImg");
		
		// Toolkit으로 Image의 default 값 설정
		im = Toolkit.getDefaultToolkit().getImage("c://img/grootwow.gif");
		
		//font 어떤거 있는지 보려고 fontlist 출력해보기
		String[] fontlist = Toolkit.getDefaultToolkit().getFontList();
												//->선이 그어진 이유 = 예전에는 이렇게 썼는데 이제는 이렇게 쓰지마~ 라는뜻
		Stream.of(fontlist).forEach(i->System.out.println(i));
		
		
		
		//frame size 설정
		setSize(700,700);
		
		//frame 눈에 보이게 하기
		setVisible(true);
		
		//frame X (exit) 버튼 작동하도록 하기

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				setVisible(false);
				dispose();
				System.exit(0);
				}
				});
		
		
		// [ repaint() method ]
		// **repaint method를 호출하면 색을 JAVA가 알아서 칠해줌!!*** 중요!!!
		// -> paint() 호출하고 싶을 때 repaint() 호출하면 AWT Thread에 의해 JAVA가 알아서 paint 해줌
		// -> java에서는 paint 직접 호출하지 않는다! repaint() 호출한다
		repaint();
	}
	// [ Graphics ]
	public void paint(Graphics g) {
		
		//나 이미지 그릴거야
		g.drawImage(im, 20, 20,500,400, this);
				// ->  drawImage(Image img, int x, int y,ImageObserver observer)
	}
}