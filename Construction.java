import java.util.Scanner;

public class Construction extends AnestheticLand {
	private int numberOfLevels;
	private String typeOfSoil;
	public Construction() {
		super();
		// TODO Auto-generated constructor stub
	}
	//public Construction(AnestheticLand L) {
	//	super(L);
		// TODO Auto-generated constructor stub
	//}
	public Construction(int Nb, String na, int Id, double Ar, double pr, int nbLv, String soil) {
		super(Nb, na, Id, Ar, pr);
		// TODO Auto-generated constructor stub
		this.numberOfLevels = nbLv;
		this.typeOfSoil = soil;
	}
	public Construction(int t, String soil) {
		super();
		this.numberOfLevels = t;
		this.typeOfSoil = soil;
	}
	public int getNumberOfLevels() {
		return numberOfLevels;
	}
	public void setNumberOfLevels(int numberOfLevels) {
		this.numberOfLevels = numberOfLevels;
	}
	public String getTypeOfSoil() {
		return typeOfSoil;
	}
	public void setTypeOfSoil(String typeOfSoil) {
		this.typeOfSoil = typeOfSoil;
	}
	
	
	public void Display() {
		System.out.println("Construction [numberOfLevels=" + numberOfLevels + ", typeOfSoil=" + typeOfSoil + ", NameOfPerson="
				+ NameOfPerson + ", idOfLand=" + idOfLand + ", area=" + area + ", PriceOfOneMeter=" + PriceOfOneMeter
				+ ", CountryNumber=" + CountryNumber + "]");
	}
	
	public void ReadDetailsOfConstructionLand() {
		ReadAnestheticLandInformation();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the number of levels of the construction land: ");
		int nbLv = scan.nextInt();
		System.out.println("Please enter the type of the soil of the construction land: ");
		String soil = scan.next();
		this.typeOfSoil = soil;
		this.numberOfLevels = nbLv;
	}
	public double priceOfLand() {
		return this.area*this.PriceOfOneMeter;
	}
	
}
