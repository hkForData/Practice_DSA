package dp;

import java.util.Arrays;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String A, String B) {
		int i = A.length();
		int j = B.length();
		//return commonSubSeqByRecc(A, i-1, B, j-1);
		int dp[][] = new int[i+1][j+1];
		for(int []arr: dp)
		{
			Arrays.fill(arr,  -1);
		}
		//return commonSubSeqByMemo(A, i-1, B, j-1, dp);
		//return commonSubSeqByMemo(A, i-1, B, j-1, dp);
		return commonSubSeqByTab(A, B);
	}
	
	public static int commonSubSeqByTab(String A, String B) {
		int dp[][] = new int[A.length()+1][B.length()+1];
		for(int []arr: dp)
		{
			Arrays.fill(arr,  0);
		}
		for(int i = A.length()-1; i>=0; i--){
            for(int j = B.length()-1; j>=0; j--){
                int ans = 0;
                if(A.charAt(i) == B.charAt(j)){
                    ans = 1 + dp[i+1][j+1];
                }
                else{
                    ans = Math.max(dp[i+1][j], dp[i][j+1]);
                }
                dp[i][j] = ans;   
            }
        }
        return dp[0][0];
	}
	
	public static int commonSubSeqByMemo(String A, int i, String B, int j, int dp[][]) {
		if(i<0 || j<0) {
			return 0;
		}
		if(dp[i][j]!=-1) {
			return dp[i][j];
		}
		int ans=0;
		if(A.charAt(i) == B.charAt(j)) {
			ans = commonSubSeqByMemo(A, i-1, B, j-1, dp)+1;
		}
		else {
			ans = Math.max(commonSubSeqByMemo(A, i-1, B, j, dp), commonSubSeqByMemo(A, i, B, j-1, dp));
		}
		dp[i][j] = ans;
		return ans;
	}
	
	public static int commonSubSeqByRecc(String A, int i, String B, int j) {
		if(i<0 || j<0) {
			return 0;
		}
		int ans=0;
		if(A.charAt(i) == B.charAt(j)) {
			ans = commonSubSeqByRecc(A, i-1, B, j-1)+1;
		}
		else {
			ans = Math.max(commonSubSeqByRecc(A, i-1, B, j), commonSubSeqByRecc(A, i, B, j-1));
		}
		return ans;
	}
	public static void main(String[] args) {
		String s1 = "abbcdgf";
		String s2 = "bbadcgf";
		System.out.println(longestCommonSubsequence(s1, s2));
	}
}
