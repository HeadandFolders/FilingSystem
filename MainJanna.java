import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainJanna {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProvinceJannaWithArray a = new ProvinceJannaWithArray(20, "Akkar");
		AnestheticLand l1 = new Construction(961, "EmiratiSheikh", 1110, 1300, 10000, 2, "solidred");
		AnestheticLand l2 = new Construction(961, "Lenen", 1111, 4000, 9000, 3, "sturdybrown");
		AnestheticLand l3 = new Agriculture(961, "MonacoMillionaire", 1112, 3000, 10000, "amazingfertile");
		//AnestheticLand l4 = new Agriculture(961, "Gilfoil", 1113,1000,100, "babushka soil");
		AnestheticLand[] arr = new AnestheticLand[a.getNumberOfAnestheticLands()];
		a.setL(arr);
		
		arr[0]=l1;
		arr[1]=l2;
		arr[2]=l3;
		
		
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
		
		System.out.println("What action would you like to perform? \n1) for search land by id  \n2) for addition of land \n3) for deletion of land  \n4) for updating land info \n5) for merging two lands \n6) for splitting 2 lands \n7)storeData \n8)TakeAgricultureLandinfo \n9)TakeConstructionLandinfo \n10)for finding price of a land by id and filename \n11)for finding price of land by id and filename \n12)for finding price of land by id (2nd method) \n-1 to exit ");
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
						//a.AddAnestheticLand(land);
						if (a.AddAnestheticLand(land)) System.out.println("successfully added land.");;
						break;

					case 'a':
						Agriculture landa = new Agriculture();
						landa.ReadDetailsOfAgricultureLand();
						if (a.AddAnestheticLand(landa)) System.out.println("successfully added land");
						break;
						
				}
				break;
			case 3:
				System.out.println("please enter the id of land you want to delete: ");
				int delete_id = scan.nextInt();
				a.DeleteAnestheticLand(delete_id);
				//System.out.println(a.getNumberOfAnestheticLands());
				break;
				
			case 4:
				System.out.println("Please enter the id of the land whose info you wish to update: ");
				int search_id1 = scan.nextInt();
				if(a.UpdateLandInformation(search_id1)) System.out.println("Successfully updated!");
				break;
			case 5:
				System.out.println("Enter the id of the first land (to be merged upon)");
				int m1 = scan.nextInt();
				System.out.println("Enter the id of the second land (that will be merged and deleted)");
				int m2 = scan.nextInt();
				if (a.MergeTwoLands(m1, m2)) { System.out.println("Successfully merged!");}else {System.out.println("Something went wrong");}
				break;
			case 6:
				System.out.println("Please enter the pre id:");
				int idPre = scan.nextInt();
				System.out.println("Please enter the new id:");
				int idNew = scan.nextInt();
				System.out.println("Please enter the percentage of the new land with respect to the old one: ");
				double Percent = scan.nextDouble();
				if(a.SplitLand(idPre, idNew, Percent)) {
					System.out.print("Successfully split!");
				}else {
					System.out.println("Something went wrong.");
				}
				break;
				
				
			case 7:
				System.out.println("Please enter the name of the file you want to create containing agriculture lands");
				String AgrFileName = scan.next();
				System.out.println("Please enter the name of file that will contain construction lands: ");
				String ConFileName = scan.next();
				
				a.storeData(AgrFileName, ConFileName);
				
				break;
				
				
			case 8:
				System.out.println("Enter file name: ");
				String flName = scan.next();
				
				a.TakeAgricultureInfoFromFile(flName);
				//Agriculture[] agriarray = new Agriculture[a.FindNumberOfAgricultureLands()];
				
				break;
			case 9:
				System.out.println("Enter file name: ");
				String flNam = scan.next();
				
				a.TakeconstructioninfoFromFile(flNam);
				//Agriculture[] agriarray = new Agriculture[a.FindNumberOfAgricultureLands()];
				
				break;
			case 10:
				System.out.println("Please provide agriculture land file name: ");
				String fname = scan.next();
				System.out.println("Please provide the id of land you wish to know the price for: ");
				int id = scan.nextInt();
				System.out.println("The price of land you inquired about is " +a.PriceOfAgricultureLandById(fname, id));
				break;
				
			case 11:
				System.out.println("Please provide construction land file name: ");
				String fname1 = scan.next();
				System.out.println("Please provide the id of land you wish to know the price for: ");
				int id1 = scan.nextInt();
				System.out.println("The price of the land you inquired about is " + a.PriceOfAgricultureLandById(fname1, id1));
				break;
				
			case 12:
				System.out.println("Please enter the id of the land you want to get the price of: ");
				int id11 = scan.nextInt();
				if (a.SecondMethodToFindPriceOfLandById(id11)!=-1) System.out.println("The price of land you inquired about is: "+a.SecondMethodToFindPriceOfLandById(id11));
				break;
			
		}
		}
		System.out.println("Thank you for using this program (●'◡'●)");
		System.out.println("Lands in the province: \n-------------------------------------");
		a.displayAllLands();
		System.out.println("-------------------------------------");
		System.out.println("Number of agriculture lands: "+ a.FindNumberOfAgricultureLands() + "\nNumber of construction lands: "+ a.FindNumberOfConstructionLands()+ "\nNumber of lands in the province: "+ (a.FindNumberOfAgricultureLands()+a.FindNumberOfConstructionLands()));
	
	}

}
