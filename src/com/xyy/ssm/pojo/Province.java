package com.xyy.ssm.pojo;

public class Province {
    private Integer provinceid;

    private String name;

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

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Province(Integer provinceid, String name) {
		super();
		this.provinceid = provinceid;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Province [provinceid=" + provinceid + ", name=" + name + "]";
	}
    
    
}