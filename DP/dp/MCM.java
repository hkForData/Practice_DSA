package dp;

import java.util.Arrays;

public class MCM {
	 public static int getMinByTabulation(int A[]){
	        int n = A.length;
	        int dp[][] = new int[n+1][n+1];
	        /*for(int []row: dp){
	            Arrays.fill(row, -1);
	        }*/
	        for(int gap=2; gap<n; gap++){
	            for(int left=1; left<(n-gap+1); left++){
	                int right  = left+gap-1;
	                dp[left][right] = Integer.MAX_VALUE;
	                for(int i=left; i<right; i++){
	                    int yourAns = dp[left][i]+dp[i+1][right]+(A[left-1]*A[i]*A[right]);
	                    if(yourAns<dp[left][right]) {
	                    	dp[left][right] = yourAns;
	                    }
	                    
	                }
	            }
	        }
	        return dp[1][n-1];
	        //return dp;
	    }
	 public static int mcm(int A[]){
		 int n = A.length;
	        int dp[][] = new int[n-1][n-1];
	        for(int g=0; g<dp.length; g++) {
	        	for(int i=0, j=g; j<dp.length; i++, j++) {
	        		if(g == 0) {
	        			dp[i][j] = 0;
	        		}
	        		else if(g == 1) {
	        			dp[i][j] = A[i] * A[j] * A[j+1];
	        		}
	        		else {
	        			int min = Integer.MAX_VALUE;
	        			for(int k=i; k<j; k++) {
	        				// dp array k andar i, k left half hoga and k+1, j right half hoga.
	        				// A array k andar i*k+1 left half hoga and k+1, j+1 right half hoga.
	        				int lc = dp[i][k];//left half
	        				int rc = dp[k+1][j];//right half
	        				int mc = A[i] * A[k+1] * A[j+1];//multiplication cost from both side left half and right half
	        				int tc = lc + rc + mc;
	        				if(tc<min) {
	        					min = tc;
	        				}
	        			}
	        			dp[i][j] = min;
	        		}
	        	}
	        }
	        return dp[0][dp.length-1];
	 }
	 public static void main(String[] args) {
		 int arr[] = {45, 17, 34, 27, 12, 22};
		 System.out.print(mcm(arr));
		 /*int ans[][] = getMinByTabulation(arr);
		 for(int i=0; i<ans.length; i++) {
			 for(int j=0; j<ans[0].length; j++) {
				 System.out.print(ans[i][j]+" ");
			 }
			 System.out.println();
		 }*/
	}
}
