package PosVO;

public class LoginResultVO {
	private boolean admin;
	private boolean success;
	String branchName;
	
	public LoginResultVO() {
	}
	
	
	public boolean isAdmin() {
		return admin;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
	
}
