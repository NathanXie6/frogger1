/* What is a class in java?
 * 	blueprint for creating objects * 
 *  */
public class Dog { //<------------ class header syntax is always public class NameOfClass
	//attributes -> instance variables (properties)
	private int tailLength;
	private String breed;
	private String color;
	private int age;
	private String name;
	
	//when somethign is static, it becomes
	//a property of the class, not a specific object
	//you don't need an object to use it
	public static int population = 0;
	
	//constructor - default constructor
	//is the one without parameters
	public Dog() {
		//contructor assigns values to the
		//instance variables
		tailLength = 3; //miles
		breed = "Different";
		color = "green";
		age = 214;
		name = "Spot";
		population++;
	}

	private Dog(String newName) {
		this(); //call the default constructor
		this.name = newName; //set the new name
	}
	
	//GETTERS - allow outsiders to get info from the object
	// it's a method public returnType getPropertyName(){ }
	public String getName() {
		return this.name;
	}
	
	public static int feetToMeters(int feet) {
		return (int) (feet/3.281);
	}
	
	
	
	
}
