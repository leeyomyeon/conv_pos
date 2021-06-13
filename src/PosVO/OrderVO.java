package PosVO;

import javax.swing.ImageIcon;

public class OrderVO {
	private String goodsCode;
	private String goodsName;
	private int goodsPrice;
	private int goodsPackageNum;
	private int goodsPackageSelectNum;
	private ImageIcon icon;
	
	public OrderVO(String goodsCode, String goodsName,  int goodsPrice, int goodsPackageNum, int goodsPackageSelectNum) {
		super();
		this.goodsCode = goodsCode;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsPackageNum = goodsPackageNum;
		this.goodsPackageSelectNum = goodsPackageSelectNum;
	}
	public String getGoodsCode() {
		return goodsCode;
	}
	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsPackageNum() {
		return goodsPackageNum;
	}
	public void setGoodsPackageNum(int goodsPackageNum) {
		this.goodsPackageNum = goodsPackageNum;
	}
	public int getGoodsPackageSelectNum() {
		return goodsPackageSelectNum;
	}
	public void setGoodsPackageSelectNum(int goodsPackageSelectNum) {
		this.goodsPackageSelectNum = goodsPackageSelectNum;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
}
