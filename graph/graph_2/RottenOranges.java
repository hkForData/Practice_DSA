package graph_2;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
	public static int rottenOrange(int A[][]) {
		int n = A.length;
		int m = A[0].length;
		int cnt = 0;
		Queue<Pair> que = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(A[i][j] == 2) {
					que.add(new Pair(i, j, 0));
				}
				else if(A[i][j]==1) {
					cnt++;
				}
			}
		}
		int ans = -1;
		int x[] = {-1, 0, 1, 0};
		int y[] = {0, 1, 0, -1};
		while(que.size()>0) {
			Pair rem = que.remove();
			int crow = rem.row;
			int ccol = rem.col;
			int ctime = rem.time;
			ans = ctime;
			for(int k=0; k<4; k++) {
				int xr = crow+x[k];
				int yc = ccol+y[k];
				if(xr>=0 && xr<n && yc>=0 && yc<m && A[xr][yc]==1) {
					A[xr][yc] = 2;
					que.add(new Pair(xr, yc, ctime+1));
					cnt--;
				}
			}
		}
		if(cnt!=0) {
			return -1;
		}
		return ans;
	}
	public static void main(String[] args) {
		int A[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
		System.out.println(rottenOrange(A));
	}
}

class Pair{
	int row;
	int col;
	int time;
	Pair(int row, int col, int time){
		this.row = row;
		this.col = col;
		this.time = time;
	}
}

/*Q1. Rotten Oranges
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

Each cell can have three values:

The value 0 representing an empty cell.

The value 1 representing a fresh orange.

The value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.

Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.



Problem Constraints
1 <= N, M <= 1000

0 <= A[i][j] <= 2



Input Format
The first argument given is the integer matrix A.



Output Format
Return the minimum number of minutes that must elapse until no cell has a fresh orange.

If this is impossible, return -1 instead.



Example Input
Input 1:

A = [   [2, 1, 1]
        [1, 1, 0]
        [0, 1, 1]   ]
Input 2:

 
A = [   [2, 1, 1]
        [0, 1, 1]
        [1, 0, 1]   ]


Example Output
Output 1:

 4
Output 2:

 -1


Example Explanation
Explanation 1:

Minute 0: [ [2, 1, 1]
            [1, 1, 0]
            [0, 1, 1] ]
Minute 1: [ [2, 2, 1]
            [2, 1, 0]
            [0, 1, 1] ]
Minute 2: [ [2, 2, 2]
            [2, 2, 0]
            [0, 1, 1] ]
Minute 3: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 1] ]
Minute 4: [ [2, 2, 2]
            [2, 2, 0]
            [0, 2, 2] ]
At Minute 4, all the oranges are rotten.
Explanation 2:

The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
*/