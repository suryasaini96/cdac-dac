package com.app.org;

public class Emp{
    protected int id;
    protected String name;
    protected String deptId;
    protected double basic;
    
    public Emp(int id, String name, String deptId, double basic) {
		super();
		this.id = id;
		this.name = name;
		this.deptId = deptId;
		this.basic = basic;
	}

	@Override
    public String toString(){
        return "Emp [id=" + id + ", name=" + name + ", deptId=" + deptId + ", basic=" + basic + "]";
    }

    public double computeNetSalary(){
        return basic;
    }
}