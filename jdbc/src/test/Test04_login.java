package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import util.JDBC_util;

public class Test04_login {

	public static void main(String[] args) {
	
		System.out.println("*** 로그인 처리 ***");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		// 나이거 sqlplus admin/1234 계정에 로그인처리 만들어놔서 JDBC_util 가서 file이름 DBinfo2.txt로 바꿔야 실행 된다!
		
		String sql = "select*from users where id='user5' and password ='1234'";
		
		try {
			con = JDBC_util.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()) {
				System.out.println(rs.getString("id") + "님 로그인 되었습니다.");
				System.out.printf("%s / %s",rs.getString("id"), rs.getString("name"));
			}else {
				System.out.println("로그인 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBC_util.close(con, st, rs);
			
		}
		
		
	
		
	}

}
