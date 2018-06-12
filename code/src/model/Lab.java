package model;

public class Lab {
	private int labId = 0;
	private String labPosition = "";
	private String labName = "";
	
	public Lab() {
		super();
	}
	public Lab(int labId, String labPostion, String labName) {
		super();
		this.labId = labId;
		this.labPosition = labPostion;
		this.labName = labName;
	}
	
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public String getLabPosition() {
		return labPosition;
	}
	public void setLabPosition(String labPosition) {
		this.labPosition = labPosition;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}

}
