package com.xyy.ssm.pojo;

public class City {
    private Integer cityid;

    private Integer provinceid;

    private String name;

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public Integer getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "City [cityid=" + cityid + ", provinceid=" + provinceid + ", name=" + name + "]";
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(Integer cityid, Integer provinceid, String name) {
		super();
		this.cityid = cityid;
		this.provinceid = provinceid;
		this.name = name;
	}
    
    
}