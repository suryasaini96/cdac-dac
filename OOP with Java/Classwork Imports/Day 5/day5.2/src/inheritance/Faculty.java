package inheritance;

//Faculty -- firstName,lastName,yrs of experience , sme
public class Faculty extends Person {
	private int yrsOfExperience;
	private String sme;
	public Faculty(String firstName,String lastName,int yrs,String sme)
	{
		super(firstName,lastName);
		System.out.println("in faculty constr");
		yrsOfExperience=yrs;
		this.sme=sme;
	}
	//override toString , inherited from Person , to ret COMPLETE details of the faculty
	@Override
	public String toString()
	{
		return "Faculty "+super.toString()+" training for "+yrsOfExperience+" in domain "+sme;
	}
	//additional func
	public void teach()
	{
		//lastName teaching in sme
		System.out.println(getLastName()+" teaching courses in "+sme);
	}
}
