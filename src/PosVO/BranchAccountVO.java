package PosVO;

public class BranchAccountVO {
	private String id;
	private String pw;
	private String branchName;
	private String branchAddr;
	
	public BranchAccountVO(String id, String pw, String branchName, String branchAddr) {
		this.id = id;
		this.pw = pw;
		this.branchName = branchName;
		this.branchAddr = branchAddr;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getBranchName() {
		return branchName;
	}
	public String getBranchAddr() {
		return branchAddr;
	}
	
	
}
