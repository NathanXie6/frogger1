
public class Phone {
	//attributes
	private double price;
	private String OS;
	private String model;
	
	public Phone() {
		price = 1000;
		OS 		= "templeOS";
		model = "droid";
	}
	
	public double getPrice()
	{
		System.out.println(price);
		return price;
	}
	
	public static void setPrice(double newPrice)
	{
		System.out.println(newPrice);
		return;
	}
	
	
	
}
