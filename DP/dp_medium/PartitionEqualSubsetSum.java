package dp_medium;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int target=0;
        for(int i=0; i<nums.length; i++){
           target += nums[i];
        }
        int index = 0;
        if(target%2!=0){
            return false;
        }
        //return canPartitionByRecc(nums, index, target/2);
        int n = nums.length;
        int dp[][] = new int[n][(target/2)+1];
        for(int arr[]: dp){
            Arrays.fill(arr, -1);
        }
        //int res = canPartitionByMemo(nums, index, target/2, dp);
        //int res = canPartitionByTabulation(nums, target/2);
        /*int res = canPartitionByTabulationSO(nums, target/2);
        if(res==1){
            return true;
        }
        else{
            return false;
        }*/
        return canPartitionByTabulationSO(nums, target/2);
    }
    private boolean canPartitionByRecc(int nums[], int index, int target){
        int n = nums.length;
        if(index>=n){
            return false;
        }
        if(target < 0){
            return false;
        }
        if(target == 0){
            return true;
        }
        boolean include = canPartitionByRecc(nums, index+1, target-nums[index]);
        boolean exclude = canPartitionByRecc(nums, index+1, target);
        return (include || exclude );
    }
    private int canPartitionByMemo(int nums[], int index, int target, int dp[][]){
        int n = nums.length;
        if(index>=n){
            return 0;
        }
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int include = canPartitionByMemo(nums, index+1, target-nums[index], dp);
        int exclude = canPartitionByMemo(nums, index+1, target, dp);
        if(include == 1 || exclude == 1){
            dp[index][target] = 1;
        }
        else{
            dp[index][target] = 0;
        }
        return dp[index][target];
    }
    private int canPartitionByTabulation(int nums[], int target){
        int n = nums.length;
        int dp[][] = new int[n+1][target+1];
        for(int arr[]: dp){
            Arrays.fill(arr, 0);
        }
        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }
        for(int i = n-1; i>=0; i--){
            for(int t = 1; t<=target; t++){
                int include = 0;
                if(t-nums[i]>=0){
                    include = dp[i+1][t-nums[i]];
                }
                int exclude = dp[i+1][t];
                if(include == 1 || exclude == 1){
                    dp[i][t] = 1;
                }
                else{
                    dp[i][t] = 0;
                }
            }
        }
        for(int i=0; i<=n; i++) {
        	for(int j=0; j<=target; j++) {
        		System.out.println(dp[i][j]);
        	}
        }
      return dp[0][target];
    }

    //Solution using space optimized approach
    private static boolean canPartitionByTabulationSO(int nums[], int target){
        int n = nums.length;
        boolean curr[] = new boolean[target+1];
        boolean next[] = new boolean[target+1];
        curr[0] = true;
        next[0] = true;
        for(int i = n-1; i>=0; i--){
            for(int t = 1; t<=target; t++){
                boolean include = false;
                if(t-nums[i]>=0){
                    include = next[t-nums[i]];
                }
                boolean exclude = next[t];
                curr[t] = (include || exclude);
            }
            next =  curr;
        }
        for(int i=0; i<=target; i++) {
        	System.out.println(next[i]);
        }
        return next[target];
    }
    public static void main(String args[]) {
    	int nums[] = {1,2,5};
    	//System.out.println(canPartition(nums));
    }
}