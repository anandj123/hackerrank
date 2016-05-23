import java.util.ArrayList;

public class TaroJiroDividing {

	public int getNumber(int A, int B) {
		
		ArrayList<Integer> Afac= new ArrayList<Integer>();
		Afac.add(A);
		ArrayList<Integer> Bfac= new ArrayList<Integer>();
		Bfac.add(B);
		
		for(int i = 0; i<A; i++){
			int Aval = (int) Afac.get(i);
			Afac.add(Aval/2);
			if((Aval/2)%2 == 1){
				break;
			}
		}
		
		for(int i = 0; i<B; i++){
			int Bval = (int) Bfac.get(i);
			Bfac.add(Bval/2);
			if((Bval/2)%2 == 1){
				break;
			}
		}
		int counter = 0;
		for(int i = 0; i<Afac.size(); i++){
			if (Bfac.contains(Afac.get(i))){
				counter++;
			}
		}
		return counter;
	}

}
