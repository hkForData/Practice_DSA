package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfMinAndMax {
	public int sumOfMinAndMax(int A[], int B) {
		int n = A.length;
        long sum = 0;
        long mod = 1000000007;
        Deque<Integer> dq1 = new ArrayDeque<>(); // dq1 is to get the max in each subarray.
        Deque<Integer> dq2 = new ArrayDeque<>(); // dq2 is to get the min in each subarray.
        for (int i = 0; i < B; i++) {
            while (dq1.size () > 0 && dq1.getLast() < A[i]) {
                dq1.removeLast();
            }
            dq1.addLast(A[i]);
            while (dq2.size() > 0 && dq2.getLast() > A[i]) {
                dq2.removeLast();
            }
            dq2.addLast(A[i]);
        }
        sum += dq1.getFirst() + dq2.getFirst();
        int s = 1;
        int e = B;
        while (e < n) {
            if (A[s - 1] == dq1.getFirst()) {
                dq1.removeFirst();
            }
            if (A[s - 1] == dq2.getFirst()) {
                dq2.removeFirst();
            }
            while (dq1.size() > 0 && dq1.getLast() < A[e]) {
                dq1.removeLast();
            }
            dq1.addLast(A[e]);
            while (dq2.size() > 0 && dq2.getLast() > A[e]) {
                dq2.removeLast();
            }
            dq2.addLast(A[e]);
            sum += dq1.getFirst() + dq2.getFirst();
            s++;
            e++;
        }
        // The elements in the array can be negative and the final sum could be negative too.
        // Since we need to the modulo operation, the remainder cannot be negative. So, we do the below step.
        long ans = ((sum % mod) + mod) % mod;
        return (int)ans;
	}

}


/*public class Solution {
    public int solve(int[] A, int B) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int mod = 1000000007;
        long sum=0;
        for(int i=0; i<B; i++){
            while(maxDeque.size()>0 && maxDeque.getLast()<A[i]){
                maxDeque.removeLast();
            }
            while(minDeque.size()>0 && minDeque.getLast()>A[i]){
                minDeque.removeLast();
            }
            maxDeque.addLast(A[i]);
            minDeque.addLast(A[i]);
        }
        sum += maxDeque.getFirst()+minDeque.getFirst();
        for(int i=B; i<A.length; i++){
            if(maxDeque.getFirst() == A[i-B]){
                maxDeque.removeFirst();
            }
            if(minDeque.getFirst() == A[i-B]){
                minDeque.removeFirst();
            }
            while(maxDeque.size() > 0 && maxDeque.getLast()<A[i]){
                maxDeque.removeLast();
            }
            maxDeque.addLast(A[i]);
            while(minDeque.size() > 0 && minDeque.getLast()>A[i]){
                minDeque.removeLast();
            }
            minDeque.addLast(A[i]);
            
            sum = sum + maxDeque.getFirst()+minDeque.getFirst();
        }
        long ans = ((sum%mod) + mod)%mod;
        return (int)ans;
    }
}

*/
