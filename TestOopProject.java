import java.util.ArrayList;
import java.util.Scanner;

public class TestOopProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Province a = new Province(3, "Akkar");
		AnestheticLand l1 = new Construction(961, "EmiratiSheikh", 1110, 1300, 10000, 2, "solidred");
		AnestheticLand l2 = new Construction(961, "Lenen", 1111, 4000, 9000, 3, "sturdybrown");
		AnestheticLand l3 = new Agriculture(961, "MonacoMillionaire", 1112, 3000, 10000, "amazingfertile");
		ArrayList<AnestheticLand> arr = new ArrayList<AnestheticLand>();
		arr.add(l1);
		arr.add(l2);
		arr.add(l3);
		
		a.setL(arr);
		if (a.isEmpty()) {
			System.out.println("the array of lands is empty.");
			
		}else {
			System.out.println("the array of lands is not empty");
		}
		if (a.isFull()) {
			System.out.println("the array of lands is full.");
			
		}else {
			System.out.println("the array of lands is not full");
		}
		Scanner scan = new Scanner(System.in);
		int action = 0;
		while (action!=-1) {
		
		System.out.println("What action would you like to perform? 1 for search land by id / 2 for addition of land / 3 for deletion of land / -1 to exit ");
		action = scan.nextInt();
		switch (action) {
			case 1:
				System.out.println("please type id of land you would like to search for: ");
				int search_id = scan.nextInt();
				System.out.println("index of the land you searched for: "+ a.searchLandById(search_id));
				break;
			case 2:
				System.out.println("Would you like to add ('c') construction land or an ('a') agricultural land?");
				char typeofland = scan.next().charAt(0);
				switch (typeofland) {
					case 'c':
						Construction land = new Construction();
						land.ReadDetailsOfConstructionLand();
						a.AddAnestheticLand(land);
						break;

					case 'a':
						Agriculture landa = new Agriculture();
						landa.ReadDetailsOfAgricultureLand();
						a.AddAnestheticLand(landa);
						break;
						
				}
				break;
			case 3:
				System.out.println("please enter the id of land you want to delete: ");
				int delete_id = scan.nextInt();
				a.DeleteAnestheticLand(delete_id);
				//System.out.println(a.getNumberOfAnestheticLands());
				break;
			
		}
		}
		System.out.println("Thank you for using this program (●'◡'●)");
		System.out.println("Lands in the province: \n-------------------------------------");
		a.displayAllLands();
		System.out.println("-------------------------------------");
		System.out.println("Number of agriculture lands: "+ a.FindNumberOfAgricultureLands() + "\nNumber of construction lands: "+ a.FindNumberOfConstructionLands() + "\nNumber of registered lands: "+(a.FindNumberOfAgricultureLands()+a.FindNumberOfConstructionLands()));
	}

}
