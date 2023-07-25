package binarySearch;

public class SearchForRange {
	 private static int[] searchRange(final int[] A, int B) {
	        int l=0,h=A.length-1;
	        int res[]=new int[2];
	        res[0]=-1;
	        res[1]=-1;
	        if(l==h){
	            res[0]=l;
	            res[1]=h;
	            return res;
	        }
	        while(l<=h){
	            int m=(l+h)/2;
	            if(A[m]==B){
	                if(A[l]==B)
	                {
	                    res[0]=l;
	                }
	                else
	                {
	                    l=l+1;
	                }   
	                if(A[h]==B)
	                {
	                    res[1]=h;
	                }   
	                else 
	                {
	                    h=h-1;
	                }
	                if(A[l]==B && A[h]==B)
	                {
	                    res[0]=l;
	                    res[1]=h;
	                    return res;
	                }
	            }
	            else if(A[m]<B)l=m+1;
	            else if(A[m]>B)h=m-1;
	        }
	        return res;
	    }
	 public static void main(String[] args) {
	   	 	int A[] = {5, 7, 7, 8, 8, 10};
	   	 	int arr[] = searchRange(A, 8);
			System.out.println(arr[0]);
			System.out.println(arr[1]);
			System.out.println();
			
		}
}

/*Q3. Search for a Range
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.

Return an array of size 2, such that 
          First element = Left most index of B in A
          Second element = Right most index of B in A.
If B is not found in A, return [-1, -1].

Note : Your algorithm's runtime complexity must be in the order of O(log n).


Problem Constraints
1 <= N <= 106
1 <= A[i], B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].


Example Input
Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8
Input 2:

 A = [5, 17, 100, 111]
 B = 3


Example Output
Output 1:

 [3, 4]
Output 2:

 [-1, -1]


Example Explanation
Explanation 1:

 The first occurrence of 8 in A is at index 3.
 The last occurrence of 8 in A is at index 4.
 ans = [3, 4]
Explanation 2:

 There is no occurrence of 3 in the array.
*/