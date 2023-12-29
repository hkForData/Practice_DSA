package BitManiPulation;

public class SingleNumber2 {
	
	public static int singleInteger2(int A[]) {
		int n = A.length;
		int ans=0;
		for(int i=0; i<32; i++) {
			int count=0;
			for(int j=0; j<n; j++) {
				if(checkBit(A[j], i)==1) {
					count++;
				}
			}
			if(count%3==1) {
				ans = ans + (1<<i);
			}
		}
		return ans;
	}
	public static int checkBit(int x, int y) {
		if((x & (1<<y))!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
		System.out.println(singleInteger2(arr));
	}

}
