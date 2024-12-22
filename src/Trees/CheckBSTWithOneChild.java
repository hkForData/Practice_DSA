package Trees;

public class CheckBSTWithOneChild {
	public String CheckBstWithOneChilde(int []A) {
		int l = Integer.MIN_VALUE;
		int r = Integer.MAX_VALUE;
		int root = A[0];
		for(int i=1; i<A.length; i++) {
			if(A[i]<root) {
				r = root;
			}
			else {
				l = root;
			}
			if(A[i]<l || A[i]>r) {
				return "NO";
			}
			root = A[i];
		}
		return "YES";
	}

}
