import java.util.Scanner;

public abstract class AnestheticLand extends Country implements LandPrice {
	protected String NameOfPerson;
	protected int idOfLand;
	protected double area;
	protected double PriceOfOneMeter;
	public AnestheticLand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnestheticLand(int Nb, String na, int Id, double Ar, double pr) {
		super();
		this.NameOfPerson = na;
		this.idOfLand = Id;
		this.area = Ar;
		this.PriceOfOneMeter = pr;
		this.CountryNumber = Nb; // i am assuming that Nb refers to country number
	}
	
	public AnestheticLand(AnestheticLand L) {
		// is this a list ?
		//this.AnestheticLand= L;
		//problem is the above statement: AnestheticLand cannot be resolved or is not a field 
		this.CountryNumber = L.CountryNumber;
		this.idOfLand = L.idOfLand;
		this.area = L.area;
		this.NameOfPerson = L.NameOfPerson;
		this.PriceOfOneMeter = L.PriceOfOneMeter;
	}
	public String getNameOfPerson() {
		return NameOfPerson;
	}
	public void setNameOfPerson(String nameOfPerson) {
		NameOfPerson = nameOfPerson;
	}
	public int getIdOfLand() {
		return idOfLand;
	}
	public void setIdOfLand(int idOfLand) {
		this.idOfLand = idOfLand;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPriceOfOneMeter() {
		return PriceOfOneMeter;
	}
	public void setPriceOfOneMeter(double priceOfOneMeter) {
		PriceOfOneMeter = priceOfOneMeter;
	}
	public void Display() {
		System.out.println("NameOfPerson=" + NameOfPerson + ", idOfLand=" + idOfLand + ", area=" + area
				+ ", PriceOfOneMeter=" + PriceOfOneMeter + "]");
	}
	public void ReadAnestheticLandInformation() {
		Scanner scan = new Scanner(System.in);
		//if abstract class cannot be instantiated how do i implement the read method
		System.out.println("Please enter the number of the land: ");
		int Nb = scan.nextInt();
		//this.CountryNumber = Nb;//this line will compile. I'm assuming it means the country number ?
		System.out.println("Please enter the name of the person: ");
		String name = scan.next();
		this.NameOfPerson = name;
		System.out.println("Please enter the Id of Land:");
		int id = scan.nextInt();
		this.idOfLand = id;
		System.out.println("Please enter the area of the Land: ");
		double area = scan.nextDouble();
		this.area = area;
		System.out.println("Please enter the price of one meter: ");
		double price = scan.nextDouble();
		this.PriceOfOneMeter = price;
		//this.setArea(area);this.setIdOfLand(id);this.setNameOfPerson(name);this.setPriceOfOneMeter(price);
	}
	
}
