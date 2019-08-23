package day21_ex;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookApp_UI_answer {

	public static void main(String[] args) {

		new Gui();

	}
}

class Gui extends JFrame {

	private static final String Dialog = null;
	private static final String SansSerif = null;

	static int count = 0;
	BookMgr_answer_List mgr;
	JButton instruction, intro, add, list, delete, search, exit, save, load;
	TextField title, price, isbn;
	TextArea output;

	Gui() {

		super("BoopApp for Administrator");

		mgr = new BookMgr_answer_List();

		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(1, 7));
		p1.add(add = new JButton("ADD"));
		p1.add(list = new JButton("List"));
		p1.add(delete = new JButton("Delete"));
		p1.add(search = new JButton("Search"));
		p1.add(save = new JButton("Save"));
		p1.add(load = new JButton("Load"));
		p1.add(exit = new JButton("Exit"));
		p1.setBackground(Color.gray);
		add(p1, BorderLayout.SOUTH);

		Panel p2 = new Panel();

		// [ GridLayout (행,열) ]
//		p2.setLayout(new GridLayout(3, 2));

		Panel panel = new Panel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(intro = new JButton("하단의 버튼을 눌러 Search, Add, Delete, Print, Save, Load 작업을 하세요."));
		add("North", panel);

		p2.add(new JLabel("    ISBN    "));
		p2.add(isbn = new TextField(10));
		p2.add(new JLabel("    Title   "));
		p2.add(title = new TextField(10));
		p2.add(new JLabel("    Price   "));
		p2.add(price = new TextField(10));
		p2.setBackground(Color.LIGHT_GRAY);

	
		
		panel.add("North", p2);
		
		Panel pan = new Panel();
		pan.add(instruction = new JButton("Need Help?"));
		panel.add(pan);
		
		Panel p3 = new Panel();
		p3.setLayout(new GridLayout(2, 1));
		ImageIcon icon = new ImageIcon("e://work//workspace_0708//java_02_ex//src//day21_ex/chubbyCat.jpg");
		Image img = icon.getImage();
		Image modifiedImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon modifiedIcon = new ImageIcon(modifiedImg);
		JLabel imageLabel = new JLabel(modifiedIcon);
		p3.add(imageLabel);

		// gif 넣으려고 수정 했던 것
//		Image test = Toolkit.getDefaultToolkit().getImage("c://img/grootwow.gif");
//		ImageIcon test1 = new ImageIcon(test);
//		JLabel test2 = new JLabel(test1);
//		p3.add(test2);

		p3.add(output = new TextArea(15, 40));
		
			
		output.setFont(new Font(SansSerif, 4, 15));

		add(p3, BorderLayout.CENTER);

		// [ pack() ]
		// -> 니가 알아서 모든 component 알맞게 들어갈 수 있게 Frame 크기 설정해줘
//		pack();

		setSize(600, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		intro.addActionListener(e -> {
			output.setText("");
		output.append("하단의 버튼을 누르세요!\n");
		
		});

		instruction.addActionListener(e -> {
		output.setText("         ===== All About Book App ===== \n\n1. To Add Book  ->  Input title & price + ADD Button \n");
		output.append("\n2. To Print Book List   ->   Click the List Button \n");
		output.append("\n3. To Delete Book   ->   Input ISBN + Delete Button Click \n");
		output.append("\n4. To Search Book   ->   Input title + Search Button Click \n");
		output.append("\n5. To Save the List  ->  Click the Save Button \n");
		output.append("\n6. To Load from the Saved File  ->  Click the Load Button \n");
		output.append("\n7. To Exit  ->  Click the Exit Button");
		});
		
		
		exit.addActionListener(e -> System.exit(0));

		// list 버튼을 클릭하면, 이 method를 수행하겠다
		list.addActionListener(e -> {
			output.setText(" [ Book List ] \n");
			mgr.BookList().forEach(i -> output.append(i + "\n"));
		});

		add.addActionListener(e -> {
			int p = 0;

			try {
				p = Integer.parseInt(price.getText());
				price.setText("");
			} catch (NumberFormatException e1) {
				output.setText(" [ Book 등록 실패  ] \n");
				output.append("가격에 문자가 포함되면 안됩니다!\n");
				output.append(e1.getMessage());
				return;
			} catch (Exception e4) {
				output.setText(" [ Book 등록 실패  ] \n");
				output.append("삭제할 책의 title과 price를 입력하세요!\n");
				return;

			}
			
			
			boolean b = mgr.addBook(new Book(++count, title.getText(), p));
			if (b) {
				output.setText("등록 성공\nList Button을 누르면 목록을 볼 수 있습니다.\n");
				title.setText("");
			} else {
				System.out.println("등록 실패");
			}
		});

		delete.addActionListener(e -> {

			try {
				output.setText(" [ 입력한 책을 삭제합니다. ] \n");

				boolean b = mgr.deleteBook(Integer.parseInt(isbn.getText()));
				if (b) {
					output.append("삭제 성공!\n");
					output.append("List Button을 누르면 삭제 결과를 볼 수 있습니다.\n");
				} else {
					System.out.println("삭제 실패");
				}
			} catch (Exception e2) {
				output.setText(" [ Book 삭제 실패  ] \n");
				output.append("삭제할 책의 ISBN number를 입력하세요!\n");
				return;
			}

			isbn.setText("");

		});

		search.addActionListener(e -> {

			try {
				output.setText(" [ " + title.getText() + " 도서를 검색합니다. ] \n");
				output.append("검색 결과: \n");
				mgr.searchTitleBook(title.getText()).forEach(i -> output.append(i + "\n"));
				title.setText("");

			} catch (Exception e3) {
				output.setText(" [ Book 검색 실패  ] \n");
				output.append("삭제할 책의 title을 입력하세요!\n");
				return;

			}
		});

		save.addActionListener(e -> {

			mgr.saveBook();
			output.setText(" [ Book List가 저장 되었습니다. ] ");
			
		});
	
		load.addActionListener(e -> {
		
				output.setText(" [ 저장된 Book List 입니다. ] \n");
				mgr.loadBook().forEach(i -> output.append(i + "\n"));
				
				
	});
		

	}
}

class DrawPanel extends Panel {
	public void paint(Graphics g) {

		// 나 이미지 그릴거야
		Image img = Toolkit.getDefaultToolkit().getImage("c://img/chubbyCat/jpg");
		g.drawImage(img, 20, 20, 200, 200, this);
	}

}
