package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.JDBC_util;

 // [ Connection() 랑 자원반납 close() util로 


public class Test03 {

	public static void main(String[] args) {
		
		//args로 입력 받은 값이 없을 경우 대비하여 default로 deptno 10으로 설정하고 조건문 만들었음~!
		int deptno=10;
		if(args.length!=0) {
			
		deptno = Integer.parseInt(args[0]);
		}
		String sql =  "select * from emp where deptno = " + deptno; 

		
		System.out.println("************** JDBC TEST **************");
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;  //select 구문의 결과값을 받을 객체
		int result = 0; //DML의 결과값을 받을 객체
		
		try {
			//connect하기 위해 JDBC_util에서 getConnection() method 호출
			con = JDBC_util.getConnection();
			st = con.createStatement();
			
			rs = st.executeQuery(sql); //실행해
			
			while(rs.next()) {
				System.out.print(rs.getInt("empno") + "\t");
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("job") + "\t");
				System.out.print(rs.getString("mgr") + "\t");
				System.out.print(rs.getDate("hiredate") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getString("comm") + "\n");
			}
		
		} catch (Exception e1) {
			System.out.println(e1.getMessage());
		} finally {
			
		//자원 반납위해 JDBC_util의 close() method 호출
			JDBC_util.close(con, st, rs);
			
		}
		System.out.println("***************** END *****************");
	}
}
