package Intermediat;

public class LengthOfLongest1 {
	
	public static int lengthOfLogest1(String A) {
		int n = A.length();
		int cntOfOne = 0;
		for(int i=0; i<n; i++) {
			if(A.charAt(i) == '1') {
				cntOfOne++;
			}
		}
		if(cntOfOne == n) {
			return n;
		}
		if(cntOfOne == 0) {
			return 0;
		}
		int myc=0;
		int ans=0;
		for(int i=0; i<n; i++) {
			if(A.charAt(i)=='0') {
				int l=0;
				for(int j = i-1; j>=0; j--) {
					if(A.charAt(j)=='1') {
						l++;
					}
					else {
						break;
					}
				}
				int r=0;
				for(int j = i+1; j<n; j++) {
					if(A.charAt(j)=='1') {
						r++;
					}
					else {
						break;
					}
				}
				if(cntOfOne>l+r) {
					myc = l+r+1;
				}
				else {
					myc = l+r;
				}
				if(myc>ans) {
					ans = myc;
				}
			}		
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "111011101";
		System.out.println(lengthOfLogest1(A));
	}

}
/*Q2. Length of longest consecutive ones
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.


Input Format

The only argument given is string A.
Output Format

Return the length of the longest consecutive 1’s that can be achieved.
Constraints

1 <= length of string <= 1000000
A contains only characters 0 and 1.
For Example

Input 1:
    A = "111000"
Output 1:
    3

Input 2:
    A = "111011101"
Output 2:
    7
*/