package PosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import PosVO.*;

public class LoginDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;

	String url = "jdbc:oracle:thin:@192.168.43.84:1521:xe";
	String user = "hr";
	String password = "hr";

	void connecter() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			if (conn != null)
				System.out.println("conn success");
			else
				System.out.println("conn fail");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public LoginResultVO loginSelect(LoginVO vo) {
		connecter();
		LoginResultVO resultvo = new LoginResultVO();
		resultvo.setSuccess(false);
		if(sqlFilter(vo) == false)
			return resultvo;
		
		String sql = "select a.login_branch, b.branch_name from gs_login a join gs_admin_branch b on a.login_branch = b.branch_num where a.login_id = ? and a.login_pw =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getId());
			pst.setString(2, vo.getPw());

			rst = pst.executeQuery();
			while (rst.next()) {
				if (rst.getInt(1) == 0) {
					resultvo.setAdmin(true);
					resultvo.setSuccess(true);
				} else {
					resultvo.setAdmin(false);
					resultvo.setSuccess(true);
					resultvo.setBranchName(rst.getString(2));
				}
			}
		} catch (Exception e) {

		}
		closer();
		return resultvo;

	}
	
	boolean sqlFilter(LoginVO vo){
		String filter[] = { "<", ">", ":", "&", "|", "\\", "(", ")", "'", "\"", ";", ".", "/", "%", "_", "*", "?", "=",
				"+", "-", "{", "}" };
		for (String fil : filter) {
			if (vo.getId().contains(fil)) {
				return false;
			}
		}
		for (String fil : filter) {
			if (vo.getPw().contains(fil)) {
				return false;
			}
		}
		
		return true;
	}

	void closer() {
		try {
			if (rst != null)
				rst.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
