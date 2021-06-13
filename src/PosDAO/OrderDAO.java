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
import PosVO.InventoryVO;
import PosVO.OrderVO;

public class OrderDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rst;

	String url = "jdbc:oracle:thin:@192.168.43.84:1521:xe";
	String user = "hr";
	String password = "hr";

	ArrayList<OrderVO> orderlist;

	public OrderDAO() {
		orderlist = new ArrayList<OrderVO>();
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

	public void inputOrderList(OrderVO vo) {
		for(OrderVO listvo: orderlist) {
			if(listvo.getGoodsCode().equals(vo.getGoodsCode())){
				listvo.setGoodsPackageSelectNum(vo.getGoodsPackageSelectNum());
			}
		}
		orderlist.add(vo);
	}
	
	public void clearalllist(){
		orderlist.clear();
	}
	
	public ArrayList<OrderVO> viewOrderList(){
		return orderlist;
	}

	public ArrayList<OrderVO> goodsSelect(String kindname) {
		connecter();
		BufferedImage bufimg = null;
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();

		String sql = "select a.goods_code, "
				+ "a.goods_item, "
				+ "a.goods_price,a.goods_package, "
				+ "a.goods_img "
				+ "from gs_admin_goods a join gs_branch_inventory b  "
				+ "on a.goods_code = b.inven_code   "
				+ "where a.goods_kind like concat('%', concat(?, '%'))  "
				+ "order by goods_code";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, kindname);
			rst = pst.executeQuery();

			while (rst.next()) {
				OrderVO ivo = new OrderVO(
						rst.getString(1), 
						rst.getString(2), 
						rst.getInt(3),
						rst.getInt(4),
						0);
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

	public boolean inventoryInsert() {
		connecter();
		boolean result = false;

		String sql = "select 1 from gs_branch_inventory where inven_code = ?";
		String sqlinsert = "insert into gs_branch_inventory values(?,?)";
		String sqlupdate = "update gs_branch_inventory set inven_count = inven_count + ? where inven_code = ?";
		try {
			for (OrderVO vo : orderlist) {
				pst = conn.prepareStatement(sql);
				pst.setString(1, vo.getGoodsCode());
				int cnt = pst.executeUpdate();
				
				if(cnt > 0) {
					pst = conn.prepareStatement(sqlupdate);
					pst.setInt(1, vo.getGoodsPackageSelectNum());
					pst.setString(2, vo.getGoodsCode());
					cnt = pst.executeUpdate();
					if (cnt > 0) {
						result = true;
					}
				}
				else {
					pst = conn.prepareStatement(sqlinsert);
					pst.setString(1, vo.getGoodsCode());
					pst.setInt(2, vo.getGoodsPackageSelectNum());
					cnt = pst.executeUpdate();
					if (cnt > 0) {
						result = true;
					}
				}
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
