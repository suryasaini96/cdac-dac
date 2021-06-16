package inheritance;

/*
 * eg : Organize following in suitable class hierarchy(under "inheritance" package) : tight encapsulation
Person -- firstName,lastName


 */
public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		super();
		System.out.println("in person's constr");
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Person() {

		this("aa", "bb");// Person p=new Person();21 --->13-->Object's def constr
	}

	// override the inherited method from Object class
	// Object class Method : public String toString() : WHAT (specs) : SAME =>
	// method declaration
	// HOW : implementation details => method def (body)
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	//getter for firstName

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	

}
