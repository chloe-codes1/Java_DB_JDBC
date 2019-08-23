package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JDBC_util;

public class Test05_login {

	public static void main(String[] args) {
	
		System.out.println("*** 로그인 처리 ***");
		
		Connection con = null;
		Statement st = null;  // -> SQL구문의 '?' 처리 못함
		
		// [ PreparedStatement ]
		// : SQL구문의 '?' 처리할 수 있는 관리 객체
		PreparedStatement ps = null; 
		ResultSet rs = null;
		
		// 나이거 sqlplus admin/1234 계정에 로그인처리 만들어놔서 JDBC_util 가서 file이름 DBinfo2.txt로 바꿔야 실행 된다!
//		String id = "user5";
//		String pw = "1234";
		String id = JOptionPane.showInputDialog("ID를 입력하세요");
		String pw = JOptionPane.showInputDialog("PW를 입력하세요");
		
//		String sql = "select*from users where id ='" + id +"' and password ='" + pw +"'"; //변수 binding
		// -> 이 sql 문장은 보안상 매우 위험!!!!!!!!!!!!! SQL injection의 대상이 된다!!!!!
		
		//그래서 이렇게 쓴다! 이건 보안상 안전한 SQL 구문
		String sql = "select*from users where id = ? and password = ?"; //변수 binding
		//-> 물음표가 있는 SQL구문은 Statement가 처리하지 못함!
		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql); // -> 실행전에 SQL 구문 넣고 pre-compile 하게 함
			//첫번째 ?에 id 넣어줘
			ps.setString(1, id);
			//두번째 ?에 pw 넣어줘
			ps.setString(2, pw);
			
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("id") + "님 로그인 되었습니다.");
				System.out.printf("%s / %s",rs.getString("id"), rs.getString("name"));
			}else {
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_util.close(con, ps, rs);
			
		}
	}
}
