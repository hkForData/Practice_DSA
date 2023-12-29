package dp_medium;

import java.util.Arrays;

/*322. Coin Change
Medium
17.1K
385
Companies
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104*/
public class CoinChange {
	public static void main(String args[]) {
		int coins[] = {1,2,5};
		int amount = 11;
		//int res = coinChange(coins, amount);
		int dp[] = new int[amount+1];
		Arrays.fill(dp, -1);
		int res = coinChangeTopDownDp(coins, amount, dp);
		System.out.println(res);
	}
	//Coin change using reccursion
	private static int coinChange(int []coins, int amount) {
		int ans = recCoinChange(coins, amount);
		if(ans == Integer.MAX_VALUE) {
			return -1;
		}
		else {
			return ans;
		}
	}
	private static int recCoinChange(int []coins, int amount) {
		if(amount == 0) {
			return 0;
		}
		if(amount<0) {
			return Integer.MAX_VALUE;
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++) {
			int res = recCoinChange(coins, amount-coins[i]);
			if(res!=Integer.MAX_VALUE) {
				min = Math.min(min,  res+1);
			}
		}
		return min;
	}
	
	//Coin change using dp
	private static int coinChangeTopDownDp(int coins[], int amount, int dp[]){
		if(amount == 0) {
			return 0;
		}
		if(amount<0) {
			return Integer.MAX_VALUE;
		}
		if(dp[amount]!=-1) {
			return dp[amount];
		}
		int min = Integer.MAX_VALUE;
		for(int i=0; i<coins.length; i++) {
			int res = coinChangeTopDownDp(coins, amount-coins[i], dp);
			if(res != Integer.MAX_VALUE) {
				min = Math.min(min, res+1);
			}
		}
		dp[amount] = min;
		return dp[amount];
	}
}
