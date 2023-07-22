package sorting;

public class MaximumUnsortedSubarray {
	 public static int[] subUnsort(int[] A) {
	        int s=0;
	        int p1=0;
	        int p2=0;
	        int n = A.length;
	        boolean flag = true;
	        int i;
	        for(i = 0; i<A.length-1; i++){
	            if(!(A[i]<=A[i+1])){
	                flag = false;
	                break;
	            }
	        }
	        if(flag){
	            int ans[] = new int[1];
	            ans[0] = -1;
	            return ans;
	        }
	        p1=i;
	        p2 = rearrange(A, p1, A.length-1);
	        int ans[] = new int[2];
	        ans[0] = p1;
	        ans[1] = p2;
	        return ans;
	    }
	    //1 2 4 3 2 5 3 6
	    //[1,1,10,10,15,10,15,10,10,15,10,15] [4,15,4,4,15,18,20]
	     public static int rearrange(int[] A, int s, int e){
	        int p1 = s+1, p2 = e;  
	        // sending A[s] to its right position
	        while(p1 <= p2){
	            if(A[p1] <= A[s]) // p1 is happy A[s]=15 s=4
	            p1++;
	            else if(A[p2] > A[s]) // p2 is happy
	            p2--;
	            else{ // both p1 and p2 are unhappy
	                break;
	            }
	        }
	        if(p2==e){
	            return p2-1;
	        }
	        else{
	            return p2;
	        }
	        
	    }
	     public static void main(String[] args) {
	    	 int A[] = {4,15,4,4,15,18,20};
			int arr[] = subUnsort(A);
			System.out.println(arr[0]);
			System.out.println(arr[1]);
		}
}
