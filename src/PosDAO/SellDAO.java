package PosDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import PosVO.SellList;
import PosVO.SellVO;

public class SellDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;

	String url = "jdbc:oracle:thin:@192.168.43.84:1521:xe";
	String user = "hr";
	String password = "hr";

	ArrayList<SellList> list;

	public SellDAO() {
		list = new ArrayList<SellList>();
	}

	public ArrayList<SellList> viewSellList() {
		return list;
	}

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

	public boolean payment() {
		connecter();
		boolean result = false;
		int cnt = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String datestring = dateFormat.format(date);
		
		String sql1 = "update gs_branch_inventory set inven_count = inven_count - ? where inven_code = ?";
		String sql2 = "insert into gs_branch_sell values(?,?,?,?, (select max(sell_num)+1 from gs_branch_sell))";
		try {
			conn.setAutoCommit(false);
			for (SellList vo : list) {
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, vo.getGoodscount());
				pst.setString(2, vo.getGoodscode());
				cnt = pst.executeUpdate();
				
				pst = conn.prepareStatement(sql2);
				pst.setString(1, vo.getGoodscode());
				pst.setInt(2, vo.getGoodscount());
				pst.setInt(3, vo.getGoodsprice() * vo.getGoodscount());
				pst.setString(4, datestring);
				
				
				cnt = pst.executeUpdate();
				
				
				if(cnt >0){
					conn.commit();
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closer();
		return result;
	}

	public boolean addSellList(SellVO vo) {
		connecter();
		boolean result = false;
		String sql = "select a.inven_code, b.goods_item, b.goods_price, a.inven_count "
				+ "from gs_branch_inventory a join gs_admin_goods b "
				+ "on a.inven_code = b.goods_code where a.inven_code = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getGooodsCode());
			rst = pst.executeQuery();
			while (rst.next()) {
				if (rst.getInt(4) >= vo.getSellCount()) {
					list.add(new SellList(rst.getString(1), rst.getString(2), rst.getInt(3), vo.getSellCount()));
				}
			}
			result = true;
		} catch (Exception e) {

		}
		closer();
		return result;
	}

	public void deleteSellList(String goodscode) {
		for (SellList vo : list) {
			vo.getGoodscode().equals(goodscode);
			list.remove(vo);
			break;
		}
	}

	public void deleteAllSellList() {
		list = new ArrayList<SellList>();
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
