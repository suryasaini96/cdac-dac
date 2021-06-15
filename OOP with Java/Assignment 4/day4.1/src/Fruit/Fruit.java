package Fruit;

public class Fruit {
	
	protected String name;
	protected String taste;
	
	protected Fruit(String name, String taste){
		this.name = name;
		this.taste = taste;
	}

	protected String taste() {
		return this.taste;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", taste=" + taste + "]";
	}
}
