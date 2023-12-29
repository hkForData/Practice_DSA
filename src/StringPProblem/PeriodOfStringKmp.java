package StringPProblem;

public class PeriodOfStringKmp {
	public int solve(String A) {
		int n= A.length();
        int[] lps = new int[n];
        createLps(A, lps);
        return n-lps[n-1];
    }
    void createLps(String A, int[] lps){
        int i=1, j=0;
        while(i<A.length()){
            if(A.charAt(i)==A.charAt(j)){
                lps[i]=j+1;
                i++;
                j++;
            }
            else{
                if(j>0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
    }
    
}
