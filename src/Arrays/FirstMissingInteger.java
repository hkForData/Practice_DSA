package Arrays;

public class FirstMissingInteger {
	public int firstMissingPositive(int[] A) {
        int n = A.length;
        int i =0;
        while(i<n){
            //jab invalid value ho ya value apne correct position pe ho
            if(A[i]<1 || A[i]>n || i == A[i]-1){
                i++;
            }
            else{
                int idx = A[i]-1;
                //jab do value equal ho jae tab ye condition chalegi
                if(A[idx] == A[i]){
                    i++;
                }
                else{
                    swap(A, i, idx);
                }
            }
        }
        for(int j=0; j<n; j++){
            if(A[j]-1 != j){
                return j+1;
            }
        }
        return n+1;
    }
    public void swap(int A[], int i, int idx){
        int rem = A[i];
        A[i] = A[idx];
        A[idx] = rem;
    }

}
