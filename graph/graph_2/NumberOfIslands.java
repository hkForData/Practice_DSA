package graph_2;

public class NumberOfIslands {
	public static int numberOfIsland(int A[][]) {
		int n = A.length;
		int m = A[0].length;
		int cnt = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] == 1) {
					dfs(A, i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	private static void dfs(int A[][], int n, int m) {
		if(n<0 || n>=A.length || m<0 || m>=A[0].length || A[n][m]==0) {
			return;
		}
		A[n][m] = 0;
		int x[] = {-1, -1, -1, 0, +1, +1, +1, 0};
		int y[] = {-1, 0, +1, +1, +1, 0, -1, -1};
		for(int k = 0; k<8; k++) {
			dfs(A, n+x[k], m+y[k]);
		}
	}
	public static void main(String[] args) {
		int A[][] = {{0, 1, 0}, {0, 0, 1}, {1, 0, 0}};
		System.out.println(numberOfIsland(A));
	}
}
