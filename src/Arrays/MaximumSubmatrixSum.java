package Arrays;

public class MaximumSubmatrixSum {
	public static long maxSubMatrixSum(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		long[][] pfr = new long[n][m];
		for(int i=0; i<n; i++) {
			pfr[i][0] = A[i][0];
			for(int j=1; j<m; j++) {
				pfr[i][j] = pfr[i][j-1]+A[i][j];
			}
		}
		long pfc[][] = new long[n][m];
		for(int i=0; i<m; i++) {
			pfc[0][i] = pfr[0][i];
			for(int j=1; j<n; j++) {
				pfc[j][i] = pfc[j-1][i] + pfr[j][i];
			}
		}
		long ans = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j =0; j<m; j++) {
				int x1 = i;
				int y1 = j;
				int x2 = n-1;
				int y2 = m-1;
				long sum = 0;
				sum = pfc[x2][y2];
				if(x1>0) {
					sum = sum - pfc[x1-1][y2];
				}
				if(y1>0) {
					sum = sum - pfc[x2][y1-1];
				}
				if(x1>0 && y1>0) {
					sum = sum+pfc[x1-1][y1-1];
				}
				ans = Math.max(ans, sum);
			}
		}
		return ans;
	}

}
