
public class Spider {
	
	//properties / attributes
	//make them private
	// add 4 attributes
	private int numEyes;
	private boolean hasWeb;
	private int numLegs;
	private String color;
	private String name;
	
	
	
	//add a default constructor
	public Spider() {
		numEyes = 10;
		hasWeb = true;
		numLegs = 8;
		color = "black";
		name = "American House Spider";
	}
	
	public Spider(String name) {
		this(); //calls default constructor
		name = this.name;
		
	}
	
	public Spider(boolean hasWeb, String color, String name, int numLegs, int numEyes) {

		hasWeb = this.hasWeb;
		color = this.color;
		name = this.name;
		numLegs = this.numLegs;
		numEyes = this.numEyes;
	}
	
	
	//add a toString
	public String toString() {
		String result = name + "\n";
		result += "Number of Eyes: " + numEyes + "\n";
		result += "Has a Web? : " + hasWeb + "\n";
		result += "Number of Legs: " + numLegs + "\n";
		result += "Color: " + color;
		return result;
	}
	
}
