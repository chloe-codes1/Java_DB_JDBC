package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.JDBC_util;

/*		
		문제 개요 : show() 메소드는 매개변수로 부서번호(DEPARTMENT_ID) 정보를 입력 받아서 해당
		부서에 해당하는 사원의 평균 급여정보를 출력하는 메서드이다. 
		특정 부서에 해당하는 직원정보를 출력하는 show () 메소드를 구현하시오. 
*/
public class Prob {

	// SCOTT/TIGER
	
	private static void show(int DEPARTMENT_ID) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		String sql = "select round(avg(sal)) \"평균 급여\" from emp where deptno = ?";

		
		try {
			con = JDBC_util.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, DEPARTMENT_ID);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString("평균 급여"));
			}else {
				System.out.println("부서 조회 실패");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_util.close(con, ps, rs);
		}
		
		
	}

	public static void main(String[] args) {
		show(10);
		System.out.println("============================");
		show(50);
	}

	/*
	 * <<주의사항>> 1. main() 메서드는 수정하지 않고 실행해야 하며, show() 메소드의 시그니쳐도 변경할 수 없습니다.
	 * 
	 * 2. PreparedStatement를 사용해야 합니다. PreparedStatement를 사용하지 않은 경우는 실행 결과가 동일하다
	 * 하더라도 부분점수로 처리합니다.
	 * 
	 * 3. 출력 결과가 <<실행결과>>와 다른 경우 오답으로 처리됩니다.
	 * 
	 * 4. 컴파일 오류나 Exception 발생 시, 모두 오답으로 처리됩니다.
	 */

}
