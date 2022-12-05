package Frogg;


public class Position{
	double x;
	double y;
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public String toString() {
		return "Position: ("+ x + ", " + y + ")";
	}

}