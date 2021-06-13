package PosVO;

public class StaticVO {
	private String dateString;
	private int totalsales;
	public StaticVO(String dateString, int totalsales) {
		this.dateString = dateString;
		this.totalsales = totalsales;
	}
	public String getDateString() {
		return dateString;
	}
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}
	public int getTotalsales() {
		return totalsales;
	}
	public void setTotalsales(int totalsales) {
		this.totalsales = totalsales;
	}
	
}
