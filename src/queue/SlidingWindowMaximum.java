package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] slidingWindowMax(int A[], int B) {
		int n = A.length;
		Deque<Integer> dq = new ArrayDeque<>();
		int len = n-B+1;
		int ans[] = new int[len];
		for(int i=0; i<B; i++) {
			while(dq.size()>0 && dq.getLast()< A[i]) {
				dq.removeLast();
			}
			dq.addLast(A[i]);
		}
		int j = 0;
		ans[j++] = dq.getFirst();
		for(int i =0; i<n; i++) {
			while(dq.size()>0 && dq.getLast() < A[i]) {
				dq.removeLast();
			}
			dq.addLast(A[i]);
			ans[j++] = dq.getFirst();
		}
		return ans; 
	}

}
