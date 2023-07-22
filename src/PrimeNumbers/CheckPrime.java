package PrimeNumbers;

import java.util.Arrays;

public class CheckPrime {
	public static int isPrime(int A) {
		boolean temp[] = new boolean[A+1];
		Arrays.fill(temp, false);
		for(int i=2; i*i<=A; i++) {
			for(int j=i*i; j<=A; j+=i) {
				if(!temp[j]) {
					temp[j] = true;
				}
			}
		}
		if(!temp[A]) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		
		System.out.println(isPrime(6));
	}
}
