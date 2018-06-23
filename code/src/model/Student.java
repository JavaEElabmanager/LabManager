package model;

public class Student {
	private int studentId = 0;
	private String studentName = "";
	private boolean isUsing = false;
	
	public Student() {
		super();
	}
	public Student(int studentId, String studentName, boolean using) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.isUsing = using;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public boolean getisUsing() {
		return isUsing;
	}
	public void setisUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
}
