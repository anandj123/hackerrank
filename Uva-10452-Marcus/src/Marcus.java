public class Marcus {
	public static String[] path = {
		"JA#X",
		"JVBN",
		"XOHD",
		"DQEM",
		"T@IY"};
	public static int[][] alreadyVisited = new int[path.length][path[0].length()];
	public static void main(String[] args) {
		int startX = 0;
		int startY = 0;
		for(int j = 0; j < path.length; j++){
			for(int i = 0; i < path[0].length(); i++){
				if(path[j].charAt(i) == '@'){
					startX = i;
					startY = j;
					break;
				}
			}
		}
		for(int i = 0; i < path.length; i++){
			for(int j = 0; j < path[0].length(); j++){
				alreadyVisited[i][j] = 0;
			}
		}
		findPath(startX , startY ,"");
	}
	public static void findPath(int curX , int curY,String ans){
		
		if(path[curY].charAt(curX) == '#'){
			System.out.println(ans);
		}
		//forth
		if(curY !=0 && alreadyVisited[curY - 1][curX] != 1 && isIehova(path[curY - 1].charAt(curX))){
			alreadyVisited[curY - 1][curX] = 1;
			findPath(curX , curY - 1, ans + " forth");
			alreadyVisited[curY - 1][curX] = 0;
		}
		// left
		if(curX !=0 && alreadyVisited[curY][curX - 1] != 1 && isIehova(path[curY].charAt(curX - 1))){
			alreadyVisited[curY][curX - 1] = 1;
			findPath(curX - 1, curY, ans + " left");
			alreadyVisited[curY][curX - 1] = 0;
		}
		// right
		if(curX !=path[0].length() && alreadyVisited[curY][curX + 1] != 1 && isIehova(path[curY].charAt(curX + 1))){
			alreadyVisited[curY][curX + 1] = 1;
			findPath(curX + 1, curY, ans + " right");
			alreadyVisited[curY][curX + 1] = 0;
		}
	}
	public static boolean isIehova(char a){
		return(a == 'I'||  a == 'E'||  a == 'H'||  a == 'O'||  a == 'V'||  a == 'A' || a == '#');	
	}
}
