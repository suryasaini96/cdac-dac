package inheritance;

/*
 * eg : Organize following in suitable class hierarchy(under "inheritance" package) : tight encapsulation
Person -- firstName,lastName


 */
public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
	//	super();
		System.out.println("in person's constr");
		this.firstName = firstName;
		this.lastName = lastName;
	}
//	public Person() {
//		// TODO Auto-generated constructor stub
//	}
	//override the inherited method from Object class
	//Object class Method : public String toString() : WHAT (specs) : SAME => method declaration
	//HOW : implementation details => method def (body)
	public String toString()
	{
		return firstName+" "+lastName;
	}
	

}
