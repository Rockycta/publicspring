package com.ffw.form;

import com.ffw.formatter.Email;

public class DoctorForm {
	private String doctorName;
	private String qualification;
	@Email
	private EmailAddress emailAddress;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public EmailAddress getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(EmailAddress emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "DoctorForm [doctorName=" + doctorName + ", qualification=" + qualification + ", emailAddress="
				+ emailAddress + "]";
	}

}
