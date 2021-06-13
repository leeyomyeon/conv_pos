package PosVO;

public class SellList {
	String goodscode;
	String goodsname;
	int goodsprice;
	int goodscount;
	public SellList(String goodscode, String goodsname, int goodsprice, int goodscount) {
		this.goodscode = goodscode;
		this.goodsname = goodsname;
		this.goodsprice = goodsprice;
		this.goodscount = goodscount;
	}
	public String getGoodscode() {
		return goodscode;
	}
	public void setGoodscode(String goodscode) {
		this.goodscode = goodscode;
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getGoodsprice() {
		return goodsprice;
	}
	public void setGoodsprice(int goodsprice) {
		this.goodsprice = goodsprice;
	}
	public int getGoodscount() {
		return goodscount;
	}
	public void setGoodscount(int goodscount) {
		this.goodscount = goodscount;
	}
	
	

}
