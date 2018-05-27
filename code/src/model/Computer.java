package model;

public class Computer {
	private int computerId = 0;
	private int computerPosition = 0;
	private int labId = 0;
	private String computerIp = "";
	public int getComputerId() {
		return computerId;
	}
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public int getComputerPosition() {
		return computerPosition;
	}
	public void setComputerPosition(int computerPosition) {
		this.computerPosition = computerPosition;
	}
	public String getComputerIp() {
		return computerIp;
	}
	public void setComputerIp(String computerIp) {
		this.computerIp = computerIp;
	}

}
