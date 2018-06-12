package model;

public class Administrator {
	private int adminId = 0;
	private String adminPwd = "";
	private String adminName = "";
	
	public Administrator() {
		super();
	}

	public Administrator(int adminId, String adminPwd, String adminName) {
		super();
		this.adminId = adminId;
		this.adminPwd = adminPwd;
		this.adminName = adminName;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}
