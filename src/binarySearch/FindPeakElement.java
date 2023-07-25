package binarySearch;

public class FindPeakElement {
	 public static int findPeakElement(int[] A) {
	        int n = A.length;
	        if(n == 1){
	            return A[0];
	        }
	        if(A[0]>=A[1]){
	            return A[0];
	        }
	        if(A[n-1]>=A[n-2]){
	            return A[n-1];
	        }
	        int l=1;
	        int h=n-2;
	        while(l<=h){
	            int mid = (l+h)/2;
	            if(A[mid]>=A[mid-1] && A[mid]>=A[mid+1]){
	                return A[mid];
	            }
	            else if(A[mid]<A[mid-1]){
	                //move to the left
	                h=mid-1;
	            }
	            else{
	                l=mid+1;
	            }
	        }
	        return 0;
	    }
	 public static void main(String[] args) {
	   	 	int A[] = {1, 3, 5, 2};
			System.out.println(findPeakElement(A));
			
		}
}

/*Q2. Find a peak element
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an array of integers A, find and return the peak element in it.
An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

NOTE:

It is guaranteed that the array contains only a single peak element.
Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the peak element.



Example Input
Input 1:

A = [1, 2, 3, 4, 5]
Input 2:

A = [5, 17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 100


Example Explanation
Explanation 1:

 5 is the peak.
Explanation 2:

 100 is the peak.*/