package PrimeNumbers;

import java.util.Arrays;

public class CountOfDivisor {
	public static int[] countFactor (int A[]) {
		/*int[] ans = new int[A.length];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
		}

		int[] temp = new int[max + 1];
		for (int i = 1; i < temp.length; i++) {
			for (int j = i; j < temp.length; j += i) {
				temp[j] += 1;
			}
		}

		for (int i = 0; i < A.length; i++) {
			ans[i] = temp[A[i]];
		}

		return ans;*/
		int[] ans = new int[A.length];
		int n = A.length;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			max = Math.max(max, A[i]);
		}
		int[] temp = new int[max + 1];
		Arrays.fill(temp, 2);
		for(int i=2; i<=max; i++) {
			for(int j=2*i; j<=max; j+=i) {
				temp[j]+=1;
			}
		}
		for(int i=0;i<n; i++) {
			if(A[i]==1) {
				ans[i] = 1;
			}
			else {
				ans[i] = temp[A[i]];
			}
		}
		return ans;
	}
	public static void main(String[] args)
	{
		int arr[]= {8, 1, 10, 7};
		int ans[] = countFactor(arr);
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
