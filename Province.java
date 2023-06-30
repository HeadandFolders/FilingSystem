import java.util.ArrayList;

public class Province extends AnestheticLand{
	private String name;
	private int NumberOfAnestheticLands;
	private ArrayList<AnestheticLand> L;
	public Province(int size, String s) {
		super();
		this.NumberOfAnestheticLands = size;
		this.name = s;
		this.L = new ArrayList<AnestheticLand>();
	//	this.L = new AnestheticLand[size];
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
	public ArrayList<AnestheticLand> getL() {
		return L;
	}
	public void setL(ArrayList<AnestheticLand> l) {
		L = l;
	}
	public boolean isFull() {
		//with array list this method will always return true..?
		boolean flag=true;
		for (int i=0; i<L.size();i++) {
			if (!(L.get(i) instanceof Construction) && !(L.get(i) instanceof Agriculture )) {
				flag=false;
			}
			
		}
		return flag;
	}
	public boolean isEmpty() {
		//return L.length==0;
		boolean flag=true;
		for (int i=0; i<L.size();i++) {
			if ((L.get(i) instanceof Construction) || L.get(i) instanceof Agriculture ) {
				flag=false;
			}
			
		}
		return flag;
	}
	public boolean AddAnestheticLand(AnestheticLand land) {
		//boolean flag = false;
		//if (isFull()==false){
		//	for (int i=0; i<L.length; i++) {
		//		if (!(L[i] instanceof Construction) && !(L[i] instanceof Agriculture) && (L[i]!=null )) {
		//			L[i]=land;
		//			flag= true;
		//		}
		//	}
		//}
		//else {
		//	flag= false;
		//}
		//return flag;
	//}
		L.add(land);
		NumberOfAnestheticLands++;
		return true;
	}
	public boolean DeleteAnestheticLand(int idLand) {
		//if L.contains()
		for (AnestheticLand t : L) {
	        if (t.idOfLand == idLand) {
	            L.remove(t);
	            NumberOfAnestheticLands--;
	            return true;
	        }
	    }
		return false;
	}
	public int searchLandById(int l) {
		for (int i=0; i<L.size();i++) {
			if (L.get(i).idOfLand == l) {
				return i;
			}
		}
		return -1;
	}
	public void displayAllLands() {
		for (AnestheticLand t : L) {
			t.Display();
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
	@Override
	public double priceOfLand() {
		// TODO Auto-generated method stub
		return 0;
	}
}
