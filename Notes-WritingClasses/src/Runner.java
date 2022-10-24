
public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//by-default: a default constructor
		// is provided if non are in the class!
//		Ghost casper = new Ghost("Boo", 0.2, 6.3, true);
		
		Spider spidey1 = new Spider(true, "brown", "Tarantula", 7, 10);
		
		//dot operator allows access to all PUBLIC methods and properties
		System.out.println(spidey1);
		
		Candy candy1 = new Candy("Hershey", 2, true, 2.0, false);
		System.out.println(candy1);
	}

}

//only 1 public class can exist in a java files
//and it should match the file name
//Halloween


//Unit 2: class- template for creating objects
class Ghost{
	//Properties - Attributes
	//private - always try to hide properties
	private String name;
	private double opacity;
	private double height;
	private boolean isScary;
	
	public Ghost() {
		name = "Boo";
		opacity = 0.0;
		height = 5.0;
		isScary = false;
	}
	
	public Ghost(String name, double opacity, double height, boolean isScary) {
		name = this.name;
		opacity = this.opacity;
		height = this.height;
		isScary = this.isScary;
	}
	
	//the toString method allows printing of this object
	//it's called everything this object is passed to print or println
	
	public String toString() {
		
		return name + ", " + opacity + ", " + height + ", " + isScary;
	}
		
}