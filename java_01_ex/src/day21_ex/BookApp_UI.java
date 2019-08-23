package day21_ex;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookApp_UI {

	public static void main(String[] args) {

		new UI();
	}
}

class UI extends JFrame implements ActionListener {

	static int count =0;
	BookMgr book;
	
	JFrame f1, f2, f3;
	JButton intro, search, add, delete, quit, list, enter;
	Panel p1, p2, p3, p4, p5, p6, p7, p8, p9,panel;
	TextField introduction, searchTitle, insertTitle, insertPrice, deleteISBN;
	TextArea output;


	UI() {

		super("BookApp for Administrator");
		book = new BookMgr();
		
		p1 = new Panel();
		p1.add(intro = new JButton("아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요."));
		add(p1, BorderLayout.PAGE_START);

		add(output = new TextArea(10, 10));
		output.setVisible(true);
		output.setFont(new Font(null, 2, 24));
		
		
		
		p2 = new Panel();
		
		GridLayout grid = new GridLayout(1, 5);
		p2.setLayout(grid);
		p2.add(search = new JButton("Search by Title"));
		p2.add(add = new JButton("Add Book"));
		p2.add(delete = new JButton("Delete Book"));
		p2.add(list = new JButton("Print Book List"));
		p2.add(quit = new JButton("Quit"));
		add(p2, BorderLayout.SOUTH);

		intro.addActionListener(this);
		search.addActionListener(this);
		add.addActionListener(this);
		delete.addActionListener(this);
		list.addActionListener(this);
		quit.addActionListener(this);
		
		// search
		p3 = new Panel();
		p3.add(new JLabel("검색할 책 title 입력"));
		p3.add(searchTitle = new TextField(20));
		f1 = new JFrame();
		f1.setVisible(false);
		f1.add(p3, BorderLayout.NORTH);

		// Search
		searchTitle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				output.append("검색 결과: " + book.searchTitleBook(searchTitle.getText()) +"\n");
				searchTitle.setText("");

			}
		});

		// insert
		f2 = new JFrame();
		f2.setVisible(false);

		panel = new Panel();
		GridLayout layout = new GridLayout(2, 1);
		panel.setLayout(layout);
		
		
		
		p7 = new Panel();
		
		GridLayout layout1 = new GridLayout(2,1);
		p7.setLayout(layout1);
		p7.add(new JLabel("등록할 책 title 입력"));
		p7.add(insertTitle = new TextField(20));

		p7.add(new JLabel("등록할 책 price 입력"));
		p7.add(insertPrice = new TextField(20));
		panel.add(p7);
		
		
		p4 = new Panel();
		p4.add(enter = new JButton("ENTER"));
		panel.add(p4);
		
		f2.add(panel, BorderLayout.NORTH);
		
		
		enter.addActionListener(e -> {
			int p=0 ;
			try {
				p = Integer.parseInt(insertPrice.getText());
					insertPrice.setText("");
				} catch (NumberFormatException e1) {
					output.setText(" [ Book 등록 실패  ] \n");
					output.append("가격에 문자가 포함되면 안됩니다!\n");
					output.append(e1.getMessage());
					return;
				} catch(Exception e4) {
					output.setText(" [ Book 등록 실패  ] \n");
					output.append("삭제할 책의 title과 price를 입력하세요!\n");
					return;
					
				}
				 book.addBook(++count, new Book(count, insertTitle.getText(), p));
				 insertTitle.setText("");
		});
			
		
		
		
		// insert
		
//		insertTitle.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//			
////				book.addBook(Integer.toString(count), new Book (count,insertTitle.getText(), insertPrice.getText()));
//				insertTitle.setText("");
//				
//				output.append("제목 추가 완료~~\n");
//				
//			}
//		});
		
		
//		insertPrice.addActionListener(e -> {
//			int p = 0;
//			
//			try {
//			p= Integer.parseInt(insertPrice.getText());
//				insertPrice.setText("");
//			} catch (NumberFormatException e1) {
//				output.setText(" [ Book 등록 실패  ] \n");
//				output.append("가격에 문자가 포함되면 안됩니다!\n");
//				output.append(e1.getMessage());
//				return;
//			} catch(Exception e4) {
//				output.setText(" [ Book 등록 실패  ] \n");
//				output.append("삭제할 책의 title과 price를 입력하세요!\n");
//				return;
//			}
//			count++;
//			book.addBook(count, new Book(count, insertTitle.getText(),p));
//			output.append("가격 추가 완료~~\n");
//	
//		});
		

		// delete
		f3 = new JFrame();
		f3.setVisible(false);

		p8 = new Panel();
		p8.add(new JLabel("삭제할 책 ISBN 입력"));
		p8.add(deleteISBN = new TextField(20));
		f3.add(p8, BorderLayout.NORTH);


		deleteISBN.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
				output.setText(" [ 입력한 책을 삭제합니다. ] \n");
				
				boolean b = book.deleteBook((Integer.parseInt(deleteISBN.getText())));
				if(b) {
				output.append(deleteISBN.getText() +"도서 삭제 완료\n");
				deleteISBN.setText("");
				}else {
					System.out.println("삭제 실패");
				}
				} catch(Exception e1) {
					output.setText(" [ Book 삭제 실패 ] \n");
					output.append("삭제할 책의 ISBN number를 입력하세요!\n");
					return;
				}
				
				deleteISBN.setText("");
				
				}
		});


		pack();
//		setSize(700, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "아래의 버튼을 눌러 Search, Add, Delete, Print 작업을 하세요.":
			output.append("아래의 버튼을 누르세요!\n");
			break;
		
		
		case "Search by Title":

			f1.setVisible(true);
			f1.setSize(300, 80);
			break;

		case "Add Book":

			f2.setVisible(true);
			f2.setSize(380, 120);
			break;

		case "Delete Book":
			
			f3.setVisible(true);
			f3.setSize(350, 80);
			
			break;

		case "Print Book List":
			output.setText("**** Book List ****\n");
			output.append(book.printBookList()+"\n");
			break;
			
		case "Quit":
			
		quit.setVisible(false);
		dispose();
		System.exit(0);
		
		}

	}

}
