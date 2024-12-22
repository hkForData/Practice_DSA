package graph_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopoLogicalSort {
	public int[] topologicalSort(int A, int B[][]) {
		//step 1 generate the nbrs list
		ArrayList<ArrayList<Integer>> graph = generateAddjecencyList(B, A);
		//step 2 generate the indegree array
		int indegree[] = generateIndegree(graph, A);
		//step 3 fill the que which has indegree 0
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i=1; i<=A; i++) {
			if(indegree[i] == 0) {
				que.add(i);
			}
		}
		int ans[] = new int[A];
		int k=0;
		while(que.size()>0) {
			int rem = que.remove();
			ans[k++] = rem;
			ArrayList<Integer> nbrs = graph.get(rem);
			for(int nbr: nbrs) {
				indegree[nbr]--;
				if(indegree[nbr] == 0) {
					que.add(nbr);
				}
			}
		}
		if(k == A) {
			return ans;
		}
		return new int[0];
	}
	private static ArrayList<ArrayList<Integer>> generateAddjecencyList(int B[][], int n) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<Integer>());
		}
		for(int i=0; i<B.length; i++) {
			int u = B[i][0];
			int v = B[i][1];
			al.get(u).add(v);
		}
		return al;
	}
	private static int [] generateIndegree(ArrayList<ArrayList<Integer>> graph, int n) {
		int indegree[] = new int [n+1];
		for(int i=0; i<graph.size(); i++) {
			ArrayList<Integer> nbrs = graph.get(i);
			for(int nbr: nbrs) {
				indegree[nbr]++;
			}
		}
		return indegree;
	}
}
/*Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.

NOTE:

There are no self-loops in the graph.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 104

1 <= M <= min(100000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.



Example Input
Input 1:

 A = 6
 B = [  [6, 3] 
        [6, 1] 
        [5, 1] 
        [5, 2] 
        [3, 4] 
        [4, 2] ]
Input 2:

 A = 3
 B = [  [1, 2]
        [2, 3] 
        [3, 1] ]


Example Output
Output 1:

 [5, 6, 1, 3, 4, 2]
Output 2:

 []


Example Explanation
Explanation 1:

 The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
Explanation 2:

 The given graph contain cycle so topological ordering not possible we will return empty array.*/
