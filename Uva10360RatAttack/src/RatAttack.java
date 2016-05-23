public class RatAttack{
	public static void main(String[] args){
		int[][] input = {{1}, {3}, {3}, {12, 11, 10}, {14, 15, 20}, {20, 14, 12}};
		int maxDead = 0;
		int bestR = 0;
		int bestC = 0;
		int radius = input[1][0];
		int[][] city = new int[1025][1025];
		
		// fill in city
		for(int colonies = input.length - (input.length - 3); colonies <input.length; colonies ++ ){
			city [input[colonies][0]][input[colonies][1]] = input[colonies][2];
		}
		
		for(int colonies = input.length - (input.length - 3); colonies <input.length; colonies ++ ){
			for(int r= input[colonies][0] - radius; r<input[colonies][0] + radius + 1; r++){
				for(int c = input[colonies][1] - radius; c< input[colonies][1] + radius + 1; c++){
					int bombEffect = city[r + 1][c - 1] + city[r + 1][c] + city[r + 1][c + 1] + city[r][c-1] +  city[r][c] + city[r][c+1] + city[r-1][c-1] + city[r-1][c] + city[r-1][c+1];
					if(bombEffect > maxDead){
						maxDead = bombEffect;
						bestR = r;
						bestC = c;
					}
					else{
						;
					}
				}
			}
			
		}
		System.out.println(bestR + " " + bestC + " " + maxDead);	
	}
}