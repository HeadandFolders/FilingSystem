import java.io.Serializable;
import java.util.Scanner;

public class Agriculture extends AnestheticLand implements Serializable{
	private String cropToBeSeeded;
	public Agriculture() {
		super();
		// TODO Auto-generated constructor stub
	}
	//public Construction(AnestheticLand L) {
	//	super(L);
		// TODO Auto-generated constructor stub
	//}
	public Agriculture(int Nb, String na, int Id, double Ar, double pr, String crop) {
		super(Nb, na, Id, Ar, pr);
		// TODO Auto-generated constructor stub
		this.cropToBeSeeded = crop;
	}
	public Agriculture(String j) {
		super();
		this.cropToBeSeeded = j;
	}
	public String getCropToBeSeeded() {
		return cropToBeSeeded;
	}
	public void setCropToBeSeeded(String cropToBeSeeded) {
		this.cropToBeSeeded = cropToBeSeeded;
	}
	
	
	public void Display() {
		System.out.println("Agriculture [cropToBeSeeded=" + cropToBeSeeded + ", NameOfPerson=" + NameOfPerson + ", idOfLand="
				+ idOfLand + ", area=" + area + ", PriceOfOneMeter=" + PriceOfOneMeter + ", CountryNumber="
				+ CountryNumber + "]");
	}
	
	public void ReadDetailsOfAgricultureLand() {
		ReadAnestheticLandInformation();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the type of the crop to be seeded: ");
		String crop = scan.next();
		this.cropToBeSeeded = crop;
		
	}
	public double priceOfLand() {
		return this.area*this.PriceOfOneMeter;
	}
	

}
