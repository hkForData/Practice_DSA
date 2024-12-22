package graph_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class PathInDirectedGraph {
	/*public static int solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=A; i++){
            graph.add(new ArrayList<>());
        }
        for(ArrayList<Integer> edges: B){
            int from  = edges.get(0);
            int to = edges.get(1);
            graph.get(from).add(to);
        }
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Boolean> visited = new ArrayList<>();
        que.add(1);
        visited.add(true);
        while(!que.isEmpty()){
            int node = que.poll();
            if(node == A){
                return 1;
            }
            for(int neighbor: graph.get(node)){
                if(!visited.get(neighbor)){
                    que.add(neighbor);
                    visited.add(neighbor, false);
                }
            }
        }
        return 0;       
    }*/
	public static int bfs(int N, int M, int [][]edges ) {
		//construct the directed graph
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			//add below line for undirected graph
			//graph.get(v).add(u);
		}
		Queue<Integer> que = new ArrayDeque<>();
		boolean visited[] = new boolean[N+1];
		que.add(1);
		visited[1] = true;
		while(que.size()>0) {
			//remove from que and process
			int rem = que.remove();
			//get all the neighbors and process them
			List<Integer> neighbors = graph.get(rem);
			for(int v: neighbors) {
				if(!visited[v]) {
					que.add(v);
					visited[v] = true;
				}
			}
		}
		if(!visited[N-1]) {
			return 0;
		}
		else {
			return 1;
		}
	}
	public static void main(String[] args) {
		//{{1,4}, {2,1}, {4,3}, {4, 5}, {2,3}, {2, 4}, {1, 5}, {5, 3}, {2, 5}, {5, 1}, {4, 2}, {3, 1}, {5, 4}, {3, 4}, {1, 3}, {4, 1}, {3, 5}, {3, 2}, {5, 2}};
		int arr[][] = {{1,2},{2,3},{4,3}};
		int m = arr.length;
		System.out.println(bfs(4, m, arr));
	}
}
/*Q1. Path in Directed Graph
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints except Complete Solution is Penalty free now
Use Hint
Problem Description
Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.

NOTE:

There are no self-loops in the graph.
There are no multiple edges between two nodes.
The graph may or may not be connected.
Nodes are numbered from 1 to A.
Your solution will run on multiple test cases. If you are using global variables make sure to clear them.


Problem Constraints
2 <= A <= 105

1 <= M <= min(200000,A*(A-1))

1 <= B[i][0], B[i][1] <= A



Input Format
The first argument given is an integer A representing the number of nodes in the graph.

The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].



Output Format
Return 1 if path exists between node 1 to node A else return 0.



Example Input
Input 1:

 A = 5
 B = [  [1, 2] 
        [4, 1] 
        [2, 4] 
        [3, 4] 
        [5, 2] 
        [1, 3] ]
Input 2:

 A = 5
 B = [  [1, 2]
        [2, 3] 
        [3, 4] 
        [4, 5] ]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 The given doens't contain any path from node 1 to node 5 so we will return 0.
Explanation 2:

 Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.*/