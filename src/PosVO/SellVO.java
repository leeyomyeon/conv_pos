package PosVO;

public class SellVO {
	private String gooodsCode;
	private int sellCount;
	public SellVO(String gooodsCode, int sellCount) {
		this.gooodsCode = gooodsCode;
		this.sellCount = sellCount;
	}
	public String getGooodsCode() {
		return gooodsCode;
	}
	public void setGooodsCode(String gooodsCode) {
		this.gooodsCode = gooodsCode;
	}
	public int getSellCount() {
		return sellCount;
	}
	public void setSellCount(int sellCount) {
		this.sellCount = sellCount;
	}
	
}
