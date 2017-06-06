package com.oopsw.school;
/**
 * 학번
 * 이름
 * 출력
 * */
public class StudentVO extends PersonVO {
	private String studentNumber;

	public StudentVO(String name, String studentNumber) {
		super(name);
		setStudentNumber(studentNumber);;
	}
	
	public StudentVO(String studentNumber) {
		this("", studentNumber);
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentVO other = (StudentVO) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[studentNumber=" + studentNumber + "]";
	}
	
	@Override
	public void print(){
		System.out.println();
	}
	
	
}
