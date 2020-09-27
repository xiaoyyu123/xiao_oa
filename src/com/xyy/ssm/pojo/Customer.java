package com.xyy.ssm.pojo;

import java.util.Date;

public class Customer {
    private Long custId;

    private String custName;

    private String custSource;

    private String custLevel;

    private String custLinkman;

    private String custPhone;

    private String custMobile;

    private Date custBirthday;

    private String picFilepath;

    private String custAddress;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource == null ? null : custSource.trim();
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel == null ? null : custLevel.trim();
    }

    public String getCustLinkman() {
        return custLinkman;
    }

    public void setCustLinkman(String custLinkman) {
        this.custLinkman = custLinkman == null ? null : custLinkman.trim();
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone == null ? null : custPhone.trim();
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile == null ? null : custMobile.trim();
    }

    public Date getCustBirthday() {
        return custBirthday;
    }

    public void setCustBirthday(Date custBirthday) {
        this.custBirthday = custBirthday;
    }

    public String getPicFilepath() {
        return picFilepath;
    }

    public void setPicFilepath(String picFilepath) {
        this.picFilepath = picFilepath == null ? null : picFilepath.trim();
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress == null ? null : custAddress.trim();
    }

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Long custId, String custName, String custSource, String custLevel, String custLinkman,
			String custPhone, String custMobile, Date custBirthday, String picFilepath, String custAddress) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custSource = custSource;
		this.custLevel = custLevel;
		this.custLinkman = custLinkman;
		this.custPhone = custPhone;
		this.custMobile = custMobile;
		this.custBirthday = custBirthday;
		this.picFilepath = picFilepath;
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", custSource=" + custSource + ", custLevel="
				+ custLevel + ", custLinkman=" + custLinkman + ", custPhone=" + custPhone + ", custMobile=" + custMobile
				+ ", custBirthday=" + custBirthday + ", picFilepath=" + picFilepath + ", custAddress=" + custAddress
				+ "]";
	}
    
    
}