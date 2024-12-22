package dp;

public class MaximumSumValue {
	public int maximumSum(int A[], int B, int C, int D){
		int n = A.length;
		int dp [][] = new int [n+1][3];
		for(int i=0; i<=n; i++) {
			dp[i][0] = dp[i][1]=dp[i][2] = Integer.MAX_VALUE;
		}
		for(int i=1; i<=n; i++) {
			// Maximum value of A[i]*B
			dp[i][0] = Math.max(dp[i-1][0], A[i-1]*B);
			// Maximum value of A[i]*B + A[j]*C
			dp[i][1] = Math.max(dp[i-1][0], dp[i][0] + A[i-1]*C);
			// Maximum value of A[i]*B + A[j]*C + A[k]*D
			dp[i][2] = Math.max(dp[i-1][0], dp[i][1] + A[i-1]*D);
		}
		return dp[n][2];
	}
}
