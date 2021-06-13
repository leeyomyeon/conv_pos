package PosVO;

public class StateVO {
	private String kindname;
	private String startdate;
	private String enddate;
	public StateVO(String kindname, String startdate, String enddate) {
		this.kindname = kindname;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
}
