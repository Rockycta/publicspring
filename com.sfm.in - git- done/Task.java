package com.sfm.in.beans;

import java.util.Calendar;

public class Task {

	private String taskNo;
	private String taskName;
	private Calendar calender;

	public String getTaskNo() {
		return taskNo;
	}

	public String getTaskName() {
		return taskName;
	}

	public Calendar getCalender() {
		return calender;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public void setCalender(Calendar calender) {
		this.calender = calender;
	}

	@Override
	public String toString() {
		return "Task [taskNo=" + taskNo + ", taskName=" + taskName + ", calender=" + calender.getTime() + "]";
	}

	
}
