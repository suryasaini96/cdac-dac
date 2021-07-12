package params_passing;
class Emp
{
	private int id;
	private String name;
	private double sal;
	Emp(int i,String s,double sa)
	{
		id=i;
		name=s;
		sal=sa;
	}
	void setSal(double sal)
	{
		this.sal=sal;
	}
	double getSal()
	{
		return sal;
	}
}
