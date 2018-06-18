package model;

import java.sql.Timestamp;
import java.util.Date;

public class Record {
	private int recordId = 0;
	private int studentId = 0;
	private int labId = 0;
	private int computerPosition = 0;
	private Date startTime=null;
	private Date endTime=null;
	private String studentName;
	private String labName;
	private double duration;
	
	public Record() {
		super();
	}

	public Record(int recordId, int studentId, int labId, int computerPosition, Timestamp startTime,
			Timestamp endTime, String studentName, String labName) {
		super();
		this.recordId = recordId;
		this.studentId = studentId;
		this.labId = labId;
		this.computerPosition = computerPosition;
		this.startTime = startTime;
		this.endTime = endTime;
		this.studentName = studentName;
		this.labName = labName;
	}
	
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
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

}
