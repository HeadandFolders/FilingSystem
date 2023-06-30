import java.io.File;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProvinceJannaWithArray {
	private String name;
	private int NumberOfAnestheticLands;
	private AnestheticLand[] L;
	public ProvinceJannaWithArray(int size, String s) {
		super();
		this.NumberOfAnestheticLands = size;
		this.name = s;
		//this.L = new ArrayList<AnestheticLand>();
		this.L = new AnestheticLand[20];
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfAnestheticLands() {
		return NumberOfAnestheticLands;
	}
	public void setNumberOfAnestheticLands(int numberOfAnestheticLands) {
		NumberOfAnestheticLands = numberOfAnestheticLands;
	}
	public AnestheticLand[] getL() {
		return L;
	}
	public void setL(AnestheticLand[] l) {
		L = l;
	}
	public boolean isFull() {
		boolean flag=true;
		//can also work with just checking: NumberOfAnestheticLands < L.length
		for (int i=0; i<L.length;i++) {
			if (!(L[i] instanceof Construction) && !(L[i] instanceof Agriculture )) {
				flag=false;
			}
			
		}
		return flag;
	}
	public boolean isEmpty() {
		//return L.length==0;
		boolean flag=true;
		for (int i=0; i<L.length;i++) {
			if ((L[i] instanceof Construction) || L[i] instanceof Agriculture ) {
				flag=false;
			}
			
		}
		return flag;
	}
	public boolean AddAnestheticLand(AnestheticLand land) {
		//boolean flag = false;
		int nofregistered_lands = this.FindNumberOfAgricultureLands()+this.FindNumberOfConstructionLands();
		// can just have either one of the below conditions
		if (isFull()==false && nofregistered_lands<L.length){
			for (int i=0; i<L.length; i++) {
				if (!(L[i] instanceof Construction) && !(L[i] instanceof Agriculture)) {
					L[i]=land;
					NumberOfAnestheticLands++;
					return true;
				}
			}
		}
		return false;
	}
	public boolean DeleteAnestheticLand(int idLand) {
		for (int i=0;i<L.length;i++) {
			if (L[i].idOfLand == idLand) {
				L[i] = null;
				NumberOfAnestheticLands--;
				return true;
			}
		}
		return false;
	}
	public int searchLandById(int l) {
		for (int i=0;i<L.length;i++) {
			if (L[i].idOfLand == l) {
				return i;
			}
		}
		return -1;
	}
	public void displayAllLands() {
		for (AnestheticLand t : L) {
			if (t!=null) t.Display();
		}
	}
	public int FindNumberOfAgricultureLands() {
		int counter =0;
		for (AnestheticLand t : L) {
			if (t instanceof Agriculture) counter++;
		}
		return counter;
	}
	public int FindNumberOfConstructionLands() {
		int counter =0;
		for (AnestheticLand t : L) {
			if (t instanceof Construction) counter++;
		}
		return counter;
	}
	public boolean UpdateLandInformation(int idLand) {
		Scanner scan = new Scanner(System.in);
		int index = this.searchLandById(idLand);
		if (index !=-1) {
			if(L[index] instanceof Construction) {
				Construction c = (Construction) L[index];
				System.out.println("Please select the field you want to update: \n1)NameOfPerson \n2)Area of land \n3)Price of one meter \n4)Number of Levels \n5)Type of Soil ");
				int choice = scan.nextInt();
				switch (choice) {
					case 1:
						System.out.println("please enter the new name of person: ");
						c.setNameOfPerson(scan.next());
						return true;
						//break;
					case 2:
						System.out.println("please enter the updated area of land: ");
						c.setArea(scan.nextDouble());
						return true;
						//break;
					case 3:
						System.out.println("please enter the updated price of one meter of land: ");
						L[index].setPriceOfOneMeter(scan.nextDouble());
						return true;
						//break;
					case 4:
						System.out.println("please enter the updated nbof levels of the land: ");
						
						c.setNumberOfLevels(scan.nextInt());
						return true;
						//break;
					case 5:
						System.out.println("please enter the updated type of soil of land: ");
						c.setTypeOfSoil(scan.next());
						return true;
					//	break;
				};
			}else {
			Agriculture a = (Agriculture) L[index];
			System.out.println("Please select the field you want to update: \n1)NameOfPerson \n2)Area of land \n3)Price of one meter \n4)CropToBeSeeded ");
			int choice = scan.nextInt();
			switch (choice) {
				case 1:
					System.out.println("please enter the new name of person: ");
					a.setNameOfPerson(scan.next());
					return true;
					//break;
				case 2:
					System.out.println("please enter the updated area of land: ");
					a.setArea(scan.nextDouble());
					return true;
					//break;
				case 3:
					System.out.println("please enter the updated price of one meter of land: ");
					L[index].setPriceOfOneMeter(scan.nextDouble());
					return true;
					//break;
				case 5:
					System.out.println("please enter the updated type of crop to be seeded: ");
					a.setCropToBeSeeded(scan.next());
					return true;
			}}}
		return false;}
	public boolean MergeTwoLands (int IdOfLand1, int IdOfLand2) {
		int index1 = this.searchLandById(IdOfLand2);
		int index2 = this.searchLandById(IdOfLand1);
		
		if (index1!=-1 && index2!=-1) {
			double temparea = L[index1].getArea();
			L[index1].setArea(temparea + L[index2].getArea());
			L[index2] = null;
			return true;
			
		}
		return false;
	}
	public boolean SplitLand (int idPre, int idNew, double Percent) {
		int index1 = this.searchLandById(idPre);
		if (index1!=-1) {
			if (L[index1] instanceof Construction) {
				Construction preland = (Construction)L[index1];
				double aftersplitarea = preland.area * (Percent/100);
				Construction newLand = new Construction(preland.CountryNumber, preland.NameOfPerson, idNew, aftersplitarea, preland.PriceOfOneMeter, preland.getNumberOfLevels(),preland.getTypeOfSoil());
				newLand.Display();
				preland.setArea(preland.getArea()-preland.area*(Percent/100));
				for (int i=0;i<L.length;i++) {
					if (L[i]==null) {
						L[i]=newLand;
						return true;
					}
				}
			}else {
				Agriculture preland = (Agriculture)L[index1];
				Agriculture newLand = new Agriculture(preland.CountryNumber, preland.NameOfPerson, idNew, preland.area*(Percent/100), preland.PriceOfOneMeter,preland.getCropToBeSeeded());
				newLand.Display();
				preland.setArea(preland.getArea()-preland.area*(Percent/100));
				for (int i=0;i<L.length;i++) {
					if (L[i]==null) {
						L[i]=newLand;
						return true;
					}
				}
			}
		}
		return false;
	}
	public void storeData (String AgrFileName, String ConFileName) throws IOException {
		try {
				String filename = AgrFileName;
				String filenamecon = ConFileName;
				FileWriter myWriter = new FileWriter(filename+".txt");
		        Agriculture[] agriarray = new Agriculture[this.FindNumberOfAgricultureLands()];
		        
		        for (int i1=0;i1<L.length;i1++) {
					if (this.L[i1] instanceof Agriculture)  myWriter.write(L[i1].getIdOfLand()+"\n"); 
				}
		        myWriter.close();
		        System.out.println("Successfully wrote to the file.");
		        
		        FileWriter myWritercon = new FileWriter(filenamecon+".txt");
		        //Construction[] conarray = new Construction[this.FindNumberOfConstructionLands()];
		        for (int i1=0;i1<L.length;i1++) {
					if (this.L[i1] instanceof Construction)  myWritercon.write(L[i1].getIdOfLand()+"\n"); 
				}
		        myWritercon.close();
		        System.out.println("Successfully wrote to the file.");
		      }
		     catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	public Agriculture[] TakeAgricultureInfoFromFile(String flName){
		Agriculture[] agriarray = new Agriculture[this.FindNumberOfAgricultureLands()];
		try {
		      File myObj = new File(flName +".txt");
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        int index = this.searchLandById(Integer.parseInt(data));
		        agriarray[i] = (Agriculture) L[index];
		        agriarray[i].Display();
		        i++;
		        
		      }
		      myReader.close();
		      System.out.println("SUCCESS");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return agriarray;
	}
	public Construction[] TakeconstructioninfoFromFile(String flNam){
		Construction[] conarray = new Construction[this.FindNumberOfConstructionLands()];
		try {
		      File myObj = new File(flNam +".txt");
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		        int index = this.searchLandById(Integer.parseInt(data));
		        conarray[i] = (Construction) L[index];
		        conarray[i].Display();
		        i++;
		        
		      }
		      myReader.close();
		      System.out.println("SUCCCESS");
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return conarray;
	}
	public double PriceOfAgricultureLandById(String flName, int id) {
		// TODO Auto-generated method stub
		try {
		      File myObj = new File(flName +".txt");
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        //System.out.println(data);
		        int index = this.searchLandById(Integer.parseInt(data));
		        return (double)L[index].priceOfLand();
		        
		      }
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return -1;
	}
	public double PriceOfConstructionLandById(String flname, int id) {
		// TODO Auto-generated method stub
		try {
		      File myObj = new File(flname +".txt");
		      Scanner myReader = new Scanner(myObj);
		      int i = 0;
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        //System.out.println(data);
		        int index = this.searchLandById(Integer.parseInt(data));
		        return (double)L[index].priceOfLand();
		        
		      }
		      myReader.close();
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		return -1;
	}
	public double SecondMethodToFindPriceOfLandById(int id) {
		// TODO Auto-generated method stub
		if (this.searchLandById(id)!=-1) {
		AnestheticLand l = L[this.searchLandById(id)];
		return l.area*l.PriceOfOneMeter;
		}else {
			System.out.println("the id of land you requested is not found.");
			return -1.0;
		}
		
	}
	
}
