package graph_2;

import java.util.ArrayList;

public class FirstDepthFirstSearch {
	public static int srcToDestination(int A[], int B, int C){
		ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        int N = A.length;
        for (int i = 0; i <= N; i++) {
            adList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            adList.get(A[i]).add(i + 1);
        }
        boolean visited[] = new boolean[N + 1];
        dfs(adList, C, visited);
        return visited[B] ? 1 : 0;
    }
    private static void dfs(ArrayList<ArrayList<Integer>> adList, int source, boolean visited[]) {
        visited[source] = true;
        ArrayList<Integer> list = adList.get(source);
        for (int node : list) {
            if (!visited[node]) {
                visited[node] = true; 
                dfs(adList, node, visited);
            }
        }
	}
	public static void main(String[] args) {
		int a[] = {1,1,2,3,4,3,4,1};
		int b = 7;
		int c = 7;
		System.out.println(srcToDestination(a, b, c));
	}
}

/*Q2. First Depth First Search
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.

Given 2 towns find whether you can reach the first town from the second without repeating any edge.

B C : query to find whether B is reachable from C.

Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).

There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.

NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.



Problem Constraints
1 <= N <= 100000



Input Format
First argument is vector A

Second argument is integer B

Third argument is integer C



Output Format
Return 1 if reachable, 0 otherwise.



Example Input
Input 1:

 A = [1, 1, 2]
 B = 1
 C = 2
Input 2:

 A = [1, 1, 2]
 B = 2
 C = 1


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
Explanation 2:

 Tree is 1--> 2--> 3 and hence 2 is reachable from 1.*/