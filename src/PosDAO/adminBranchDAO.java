package PosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import PosVO.*;

public class adminBranchDAO {
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

	public ArrayList<BranchInfoVO> branchSelect(String branchname) {
		connecter();
		ArrayList<BranchInfoVO> list = new ArrayList<BranchInfoVO>();

		String sql = "select * from gs_admin_branch where branch_name like concat('%', concat(?, '%'))";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, branchname);
			rst = pst.executeQuery();

			while (rst.next()) {
				if(rst.getInt(1) == 0)
					continue;
				list.add(new BranchInfoVO(rst.getInt(1), rst.getString(2), rst.getString(3)));
			}

		} catch (Exception e) {

		}

		closer();
		return list;
	}

	public boolean branchDelete(int branchnum) {
		connecter();
		boolean result = false;
		String sql1 = "delete from gs_login where login_branch = ?";
		String sql2 = "delete from gs_admin_branch where branch_num = ?";
		try {
			conn.setAutoCommit(false);
			pst = conn.prepareStatement(sql1);
			pst.setInt(1, branchnum);
			int cnt = pst.executeUpdate();
			
			pst = conn.prepareStatement(sql2);
			pst.setInt(1, branchnum);
			cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
				conn.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		closer();
		return result;
	}

	public boolean branchInsert(BranchAccountVO avo) {
		connecter();
		boolean result = false;
		String sql1 = "insert into gs_admin_branch values((select max(branch_num)+1 from gs_admin_branch),?, ?)";
		String sql2 = "insert into gs_login values(?,?,(select max(branch_num) from gs_admin_branch))";
		try {
			conn.setAutoCommit(false);

			pst = conn.prepareStatement(sql1);
			pst.setString(1, avo.getBranchName());
			pst.setString(2, avo.getBranchAddr());
			int cnt = pst.executeUpdate();

			if (cnt <= 0) {
				conn.rollback();
				closer();
				return false;
			}

			pst = conn.prepareStatement(sql2);
			pst.setString(1, avo.getId());
			pst.setString(2, avo.getPw());

			cnt = pst.executeUpdate();

			if (cnt > 0) {
				conn.commit();
				result = true;
			}
			
		} catch (Exception e) {
			
		}

		closer();
		return result;
	}

	public boolean branchUpdate(BranchInfoVO ivo) {
		connecter();
		boolean result = false;
		String sql = "update gs_admin_branch set branch_name = ?, branch_addr = ? where branch_num = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, ivo.getBranchName());
			pst.setString(2, ivo.getBranchAddr());
			pst.setInt(3, ivo.getBranchNum());
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			}
		} catch (Exception e) {

		}
		closer();
		return result;
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
