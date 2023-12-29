package Hashing;

import java.util.HashSet;

public class CountRectangle {
	public static int countRectangle(int A[], int B[]){
		HashSet<String> hs = new HashSet<>();
		int n = A.length;
		for(int i=0; i<n; i++) {
			String s = A[i]+"_"+B[i];
			hs.add(s);
		}
		int cnt=0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				int x1 = A[i];
				int y1 = B[i];
				int x2 = A[j];
				int y2 = B[j];
				if(x1!=x2 && y1!=y2) {
					cnt++;
				}
			}
			 
		}
		return cnt/2;
	}
	public static void main(String []args) {
		int a[] = {1, 1, 2, 2, 3, 3};
		int b[] = {1, 2, 1, 2, 1, 2    };
		System.out.print(countRectangle(a, b));
	}
}
