package Combinatorics;

import java.util.Arrays;

public class PermutationOfString {
	
	public static int rankOfString(String A) {
		int n = A.length();
		long fact[] = new long[26];
		long arr[] = new long[256];
		Arrays.fill(arr, 0);
		fact[0] = 1;
		fact[1] = 1;
		for(int i=2; i<26; i++) {
			fact[i] = i*fact[i-1];
		}
		for(int i=0; i<n; i++) {
			arr[A.charAt(i)]++;
		}
		int numberOfLetterSmaller=0;
		int output = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<256;j++) {
				if(j==A.charAt(i)) {
					break;
				}
				if(arr[j] == 1) {
					numberOfLetterSmaller++;
				}
			}
			arr[A.charAt(i)] = 0;
			output += numberOfLetterSmaller * fact[n-1-i];
		}
		return output;
	}
	
	public static void main(String[] args)
	{
		System.out.println(rankOfString("VIEW"));
	}
}
