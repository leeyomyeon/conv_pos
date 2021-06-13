package PosVO;

import javax.swing.ImageIcon;

public class StateResultVO {
	private String sellnum;
	private String goodscode;
	private String goodsname;
	private int sellprice;
	private int sellcount;
	private int selltotal;
	private String date;
	private ImageIcon icon;
	public StateResultVO(String sellnum, String goodscode, String goodsname, int sellprice, int sellcount, int selltotal, String date) {
		this.sellnum = sellnum;
		this.goodscode = goodscode;
		this.goodsname = goodsname;
		this.sellprice = sellprice;
		this.sellcount = sellcount;
		this.selltotal = selltotal;
		this.date = date;
	}
	public String getsellnum() {
		return sellnum;
	}
	public void setsellnum(String sellnum) {
		this.sellnum = sellnum;
	}
	public String getgoodscode() {
		return goodscode;
	}
	public void setgoodscode(String goodscode) {
		this.goodscode = goodscode;
	}
	public String getgoodsname() {
		return goodsname;
	}
	public void setgoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getSellprice() {
		return sellprice;
	}
	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}
	public int getSellcount() {
		return sellcount;
	}
	public void setSellcount(int sellcount) {
		this.sellcount = sellcount;
	}
	public int getSelltotal() {
		return selltotal;
	}
	public void setSelltotal(int selltotal) {
		this.selltotal = selltotal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
