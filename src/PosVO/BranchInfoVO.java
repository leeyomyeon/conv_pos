package PosVO;

public class BranchInfoVO {
	private int branchNum;
	private String branchName;
	private String branchAddr;
	
	public BranchInfoVO(int branchNum, String branchName, String branchAddr) {
		this.branchNum = branchNum;
		this.branchName = branchName;
		this.branchAddr = branchAddr;
	}
	public int getBranchNum() {
		return branchNum;
	}
	public String getBranchName() {
		return branchName;
	}
	public String getBranchAddr() {
		return branchAddr;
	}
	public void setBranchNum(int branchNum) {
		this.branchNum = branchNum;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public void setBranchAddr(String branchAddr) {
		this.branchAddr = branchAddr;
	}
	
}
