package com.app.org;

public class Mgr extends Emp {
    private double performanceBonus;
    
	public Mgr(int id, String name, String deptId, double basic, double performanceBonus) {
		super(id, name, deptId, basic);
		this.performanceBonus = performanceBonus;
	}

	@Override
    public String toString(){
        return "Mgr [id=" + id + ", name=" + name + ", deptId=" + deptId + ", basic=" + basic + ", performanceBonus=" + performanceBonus + ", NetSalary=" + this.computeNetSalary() + "]";
    }
	
	@Override
    public double computeNetSalary(){
        return basic + this.performanceBonus;
    }

    public double getPerformanceBonus(){
        return this.performanceBonus;
    }

	public void setPerformanceBonus(double performanceBonus) {
		this.performanceBonus = performanceBonus;
	}
    
}
