package PosDAO;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import PosVO.StateResultVO;
import PosVO.StateVO;

public class StateDAO {
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
	
	

	public ArrayList<StateResultVO> stateSearch(StateVO vo) {
		connecter();
		BufferedImage bufimg = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		ArrayList<StateResultVO> list = new ArrayList<StateResultVO>();

		String sql = "select a.sell_num, a.sell_code, b.goods_item, b.goods_price, a.sell_count, "
				+ " a.sell_total, a.sell_date, b.goods_img " + "from gs_branch_sell a join gs_admin_goods b "
				+ "on a.sell_code = b.goods_code " + "where b.goods_kind like concat('%', concat(?, '%')) "
				+ "and ? <= a.sell_date and a.sell_date <= ? order by a.sell_date";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getKindname());
			pst.setString(2, vo.getStartdate());
			pst.setString(3, vo.getEnddate());

			rst = pst.executeQuery();

			while (rst.next()) {
				StateResultVO srvo = new StateResultVO(rst.getString(1), rst.getString(2), rst.getString(3),
						rst.getInt(4), rst.getInt(5), rst.getInt(6), rst.getDate(7).toString());

				Blob blob = rst.getBlob(8);
				InputStream inputStream = blob.getBinaryStream();
				bufimg = ImageIO.read(inputStream);
				srvo.setIcon(new ImageIcon(bufimg));
				list.add(srvo);
			}
		} catch (Exception e) {

		}
		closer();
		return list;
	}

	public boolean stateDelete(String sellnum) {
		connecter();
		boolean result = false;

		String sql = "delete from gs_branch_sell where sell_num = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, sellnum);

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
