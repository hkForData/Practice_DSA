package dp;

public class LongestPalindromicSubsequence {
	
	public static int longestPalindromicSubsequence(String A) {
		StringBuilder sb = new StringBuilder(A);
		String B = sb.reverse().toString();
		int i = A.length();
		int j = B.length();
		return LongestCommonSubsequence.commonSubSeqByRecc(A, i-1, B, j-1);
	}
	public static void main(String[] args) {
		String s1 = "bebeeed";
		System.out.println(longestPalindromicSubsequence(s1));
	}
}
