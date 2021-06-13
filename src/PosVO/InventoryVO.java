package PosVO;

import javax.swing.ImageIcon;

public class InventoryVO {
	private String goods_code;
	private String goods_name;
	private int goods_price;
	private int inven_count;
	private ImageIcon icon;
	public InventoryVO(String goods_code, String goods_name, int goods_price, int inven_count) {
		this.goods_code = goods_code;
		this.goods_name = goods_name;
		this.goods_price = goods_price;
		this.inven_count = inven_count;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public int getinven_count() {
		return inven_count;
	}
	public void setinven_count(int inven_count) {
		this.inven_count = inven_count;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	

}
