import java.util.ArrayList;

public class Jugs {
	
	public static int[] in = {3,5,4};
	
	public static ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		alreadyUsed.add(0);
		fillJugs( 0 , 0 , "");
	}
	public static void fillJugs(int jugA, int jugB, String ans){
		
		if(jugA == in[2] || jugB == in[2]){
			ans = ans + " success";
			System.out.println(ans);
			System.exit(1);
		}
		
		// fill A
		if( !beenThere(in[0] , jugB )&&jugA != in[0]){
			ans += " fill A";
			System.out.println(ans);
			fillJugs(in[0], jugB, ans);
			ans = ans.replace(" fill A" , "");
		}
		
		//fill B
		if(!beenThere(jugA, in[1]) && jugB != in[1]){
			ans += " fill B";
			System.out.println(ans);
			fillJugs(jugA, in[1], ans);
			ans = ans.replace(" fill B" , "");	
		}
		
		//empty A
		if(!beenThere(0, jugB) && jugA != 0){
			ans += " empty A";
			System.out.println(ans);
			fillJugs(0, jugB, ans);
			ans = ans.replace(" empty A", "");
		}
		
		//empty B
		if(!beenThere(jugA , 0) && jugB != 0){
			ans += " empty B";
			System.out.println(ans);
			fillJugs(jugA, 0, ans);
			ans = ans.replace(" empty B", "");
		}
		
		//pour A B
		ans += " pour A B";
		if(jugA > 0 && !beenThere(0 , jugA + jugB) && jugA + jugB <= in[1]){
			System.out.println(ans);
			fillJugs(0 , jugA + jugB, ans );
		}
		if(jugA > 0 && !beenThere(jugA - (in[1] - jugB), in[1])){
			System.out.println(ans);
			fillJugs(jugA - (in[1] - jugB), in[1] , ans);
		}
		ans = ans.replace(" pour A B", "");
		
		//pour B A
		ans += " pour B A";
		if( jugB > 0 && !beenThere(jugA + jugB , 0 ) && jugA + jugB <= in[0]){
			System.out.println(ans);
			fillJugs(jugA + jugB , 0 , ans );
		}
		if(jugB > 0 && !beenThere(in[0] ,jugB - (in[0] - jugA))){
			System.out.println(ans);
			fillJugs(in[0] ,jugB - (in[0] - jugA),  ans);
		}
		ans = ans.replace(" pour B A", "");
		return;
	}
	
	public static boolean beenThere(int jugA , int jugB){
		int i = 10 * jugA + jugB;
		if(alreadyUsed.contains(i)){
			return true;
		}
		else{
			alreadyUsed.add(i);
			return false;
		}
	}

}
