import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] v = new int[n][m];
		int[][] cumX = new int[n][m];
		int[][] cumY = new int[n][m];
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				v[i][j] = in.nextInt();
				if(i == 0)
					cumX[i][j] = v[i][j];
				else
					cumX[i][j] = v[i][j] + cumX[i-1][j];
				if(j == 0)
					cumY[i][j] = v[i][j];
				else
					cumY[i][j] = v[i][j] + cumY[i][j-1];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i == 0){
					dp[i][j] = cumY[i][j];
					continue;
				}
				if(j == 0){
					dp[i][j] = cumX[i][j];
					continue;
				}
				dp[i][j] = v[i][j] + cumX[i-1][j] + cumY[i][j-1] + dp[i-1][j-1];
					
			}
		}
		int q = in.nextInt();
		
		while (--q >= 0) 
			System.out.println(dp[in.nextInt()-1][in.nextInt()-1]);
		
		in.close();
	}
	
	
}