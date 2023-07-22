package Advance_DSA_1;

public class RainWaterTrapped {
	public static int trap(final int[] A) {
        int n = A.length;
        int Pmax[] = new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max, A[i]);
            Pmax[i] = max;
        }
        int Smax[] = new int[n];
        max=0;
        for(int i=n-1;i>=0;i--){
            max = Math.max(max, A[i]);
            Smax[i] = max;
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            int lb = Pmax[i-1];
            int rb = Smax[i+1];
            int yb = Math.min(lb,rb);
            int water = yb-A[i];
            if(water>0){
                ans = ans+water;
            }
        }
        return ans;
    }
	public static void main(String[] args)
	{
		int arr[]= {0, 1, 0, 2};
		System.out.println(trap(arr));
		
	}
}
