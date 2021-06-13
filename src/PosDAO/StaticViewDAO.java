package PosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import PosVO.StaticVO;

public class StaticViewDAO {
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

	public ArrayList<StaticVO> stateSearch() {
		connecter();

		ArrayList<StaticVO> list = new ArrayList<StaticVO>();

		String sql = "select * from (select to_char(sell_date, 'yyyy-mm') recentdate, "
				+ "sum(sell_total) from gs_branch_sell "
				+ "group by to_char(sell_date, 'yyyy-mm')) "
				+ "where rownum <= 3  order by recentdate";
		try {
			pst = conn.prepareStatement(sql);
			rst = pst.executeQuery();

			while (rst.next()) {
				list.add(new StaticVO(rst.getString(1), rst.getInt(2)));
			}
		} catch (Exception e) {

		}
		closer();
		return list;
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
