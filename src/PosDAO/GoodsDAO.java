package PosDAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import PosVO.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class GoodsDAO {
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

	//모든정보를 뽑고싶으면 kindname = "" 으로 설정
	public ArrayList<GoodsVO> goodsSelect(String kindname) {
		connecter();
		BufferedImage bufimg = null;
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();

		String sql1 = "select * from gs_admin_goods where goods_kind like concat('%', concat(?, '%')) order by goods_code";
		try {

			pst = conn.prepareStatement(sql1);
			pst.setString(1, kindname);
			rst = pst.executeQuery();

			while (rst.next()) {
				GoodsVO vo =new GoodsVO(
						rst.getString(1), 
						rst.getString(2), 
						rst.getString(3), 
						rst.getInt(4), 
						rst.getInt(5)); 
				
				Blob blob = rst.getBlob(6);
				InputStream inputStream = blob.getBinaryStream();
				bufimg = ImageIO.read(inputStream);
				vo.setIcon(new ImageIcon(bufimg));
				list.add(vo);
			}
		} catch (Exception e) {

		}

		closer();
		return list;
	}
	
	public boolean goodsDelete(String goodscode) {
		connecter();
		boolean result = false;
		String sql = "delete from gs_admin_goods where goods_code = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, goodscode);
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			}

		} catch (Exception e) {
		}

		closer();
		return result;
	}

	public boolean goodsInsert(InsertGoodsVO gvo) {
		connecter();
		boolean result = false;
		
		String sql1 = "insert into gs_admin_goods values(?,?,?,?,?,?)";
		try {

			pst = conn.prepareStatement(sql1);
			pst.setString(1, gvo.getGoodsCode());
			pst.setString(2, gvo.getGoodsName());
			pst.setString(3, gvo.getGoodsKind());
			pst.setInt(4, gvo.getGoodsPrice());
			pst.setInt(5, gvo.getGoodsPackageNum());
			
			File f = new File(gvo.getImagepath());
			if(!f.exists()) {
				System.out.println("file not exist");
			}
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(f);
			while(true) {
				int x = fis.read();
				if(x == -1) break;
				bos.write(x);
			}
			fis.close();
			bos.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			pst.setBinaryStream(6, bis, bos.size());
			
			int cnt = pst.executeUpdate();

			if (cnt > 0) {
				result = true;
			}
			
		} catch (Exception e) {
			
		}

		closer();
		return result;
	}

	public boolean goodsUpdate(InsertGoodsVO gvo) {
		connecter();
		boolean result = false;
		String sql = "update gs_admin_goods set goods_item = ?, goods_kind = ?, goods_price = ?, goods_package = ?, goods_img = ? where goods_code = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(6, gvo.getGoodsCode());
			
			pst.setString(1, gvo.getGoodsName());
			pst.setString(2, gvo.getGoodsKind());
			pst.setInt(3, gvo.getGoodsPrice());
			pst.setInt(4, gvo.getGoodsPackageNum());
			
			File f = new File(gvo.getImagepath());
			if(!f.exists()) {
				System.out.println("file not exist");
			}
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			FileInputStream fis = new FileInputStream(f);
			while(true) {
				int x = fis.read();
				if(x == -1) break;
				bos.write(x);
			}
			fis.close();
			bos.close();
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			pst.setBinaryStream(5, bis, bos.size());
			
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
