package com.ffw.form;

public class EmailAddress {
	private String id;
	private String domainName;

	public EmailAddress() {
	}

	public EmailAddress(String id, String domainName) {
		this.id = id;
		this.domainName = domainName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	@Override
	public String toString() {
		return "EmailAddress [id=" + id + ", domainName=" + domainName + "]";
	}

}
