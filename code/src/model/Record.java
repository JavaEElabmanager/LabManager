package model;

import java.util.Date;

public class Record {
	private int recordId = 0;
	private int studentId = 0;
	private int labId = 0;
	private int computerPosition = 0;
	private Date startTime=null;
	private Date endTime=null;
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
