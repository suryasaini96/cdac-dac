package com.app.org;

public class Worker extends Emp {
    private double hoursWorked;
    private double hourlyRate;
    
    public Worker(int id, String name, String deptId, double basic, double hoursWorked, double hourlyRate) {
		super(id, name, deptId, basic);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
    public String toString(){
        return "Worker [id=" + id + ", name=" + name + ", deptId=" + deptId + ", basic=" + basic + ", hoursWorked=" + hoursWorked + ", hourlyRate=" + hourlyRate + ", NetSalary=" + this.computeNetSalary() + "]";
    }

	@Override
    public double computeNetSalary(){
        return basic + this.hoursWorked*this.hourlyRate;
    }

    public double getHourlyRate(){
        return this.hourlyRate;
    }

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
}
