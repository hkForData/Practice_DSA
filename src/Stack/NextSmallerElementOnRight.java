package Stack;

import java.util.Stack;

public class NextSmallerElementOnRight {
	public int[] nseOnLeft(int A[]) {
		int n = A.length;
		int ans[] = new int[n];
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i<n; i++) {
			while(st.size() > 0 && A[i] < A[st.peek()]) {
				ans[st.pop()] = A[i];
			}
			st.push(i);
		}
		while(st.size() > 0) {
			ans[st.pop()] = -1;
		}
		return ans;
	}
}
