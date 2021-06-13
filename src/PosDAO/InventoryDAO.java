package PosDAO;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import PosVO.GoodsVO;
import PosVO.InventoryVO;
import PosVO.gknameVO;

public class InventoryDAO {
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

	// 모든정보를 뽑고싶으면 kindname = "" 으로 설정
	public ArrayList<InventoryVO> inventorySelect(gknameVO vo) {
		connecter();
		BufferedImage bufimg = null;
		ArrayList<InventoryVO> list = new ArrayList<InventoryVO>();

		String sql = 
				"select b.inven_code, a.goods_item, a.goods_price, "
				+ "b.inven_count, a.goods_img "
				+ "from gs_admin_goods a join gs_branch_inventory b "
				+ "on a.goods_code = b.inven_code "
				+ "where a.goods_item like concat('%', concat(?, '%')) "
				+ "and a.goods_kind like concat('%', concat(?, '%'))";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, vo.getGoods_name());
			pst.setString(2, vo.getGoods_kind());
			rst = pst.executeQuery();

			while (rst.next()) {
				InventoryVO ivo = new InventoryVO(
						rst.getString(1), 
						rst.getString(2), 
						rst.getInt(3), 
						rst.getInt(4));
				Blob blob = rst.getBlob(5);
				InputStream inputStream = blob.getBinaryStream();
				bufimg = ImageIO.read(inputStream);
				ivo.setIcon(new ImageIcon(bufimg));
				list.add(ivo);
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
