package Stack;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] A) {
		//first smaller index from left
        int left[] = firstSmallidxLeft(A);
        int right[] = firstSmallIdxRight(A);
        int n = A.length;
        if(n==1) return A[0];
        int area = 0;
        for(int i=0; i<n; i++){ 
            int p1 = -1;
            int p2 = n;
            if(left[i]!=-1){
                p1 = left[i];
            }
            if(right[i]!=-1){
                p2 = right[i];
            }
            int ht = A[i];
            area = Math.max(area, ht*(p2-p1-1));
        }
        return area;
    }
    public int[] firstSmallidxLeft(int arr[]){
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(st.size() > 0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size() > 0){
                ans[i] = st.peek();
            }
            else if(st.size() == 0){
                ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
    }
     public int[] firstSmallIdxRight(int arr[]){
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(st.size()>0 && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.size()>0){
                ans[i] = st.peek();
            }
           else if(st.size()==0){
                ans[i] = -1;
            }
            st.push(i);
        }
        return ans;
	}
}
//0 1 2 3 4 5 6 7 8 9 10
//2 1 3 5 4 3 4 3 7 2 5

/*Q3. Largest Rectangle in Histogram
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000



Input Format
The only argument given is the integer array A.



Output Format
Return the area of the largest rectangle in the histogram.



Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.*/