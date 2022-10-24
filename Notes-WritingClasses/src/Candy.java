
public class Candy {
	private String brand;
	private int numPieces;
	private boolean isChocolate;
	private double size;
	private boolean isLacedWithDroogs;
	
	public Candy() {
		brand = "hershey";
		numPieces = 1;
		isChocolate = true;
		size = 5.0;
		isLacedWithDroogs = true;
	}
	public Candy(String paramBrand, int paramNumPieces,boolean paramIsChocolate, double paramSize, boolean paramIsLacedWithDroogs) {
		brand = paramBrand;
		numPieces = paramNumPieces;
		isChocolate = paramIsChocolate;
		size = paramSize;
		isLacedWithDroogs = paramIsLacedWithDroogs;
		
	}
	
	public String toString() {
		String result = "Brand: " + brand + "\n";
		result += "Number of Pieces: " + numPieces + "\n";
		result += "IsChocolate: " + isChocolate + "\n";
		result += "Size (in): " + size + "\n";
		result += "isLacedWithDroogs: " + isLacedWithDroogs + "\n";
		
		return result;
				
	}
}
