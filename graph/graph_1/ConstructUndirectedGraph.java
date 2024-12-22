package graph_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ConstructUndirectedGraph {
	public static int[] bfs(int n, int m, int edges[][]) {
		//graph list generate karo 0 based index k liye one based index k liye run karo equal to n tak
		// n is number of node and m is number of edges
		List<List<Integer>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		//undirected graph generation
		for(int i=0; i<m; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int ans[] = new int[n];
		Queue<Integer> que = new ArrayDeque<>();
		//one based k liye n+1 length ka visited array create karna hoga currently i m creating for 0 based
		boolean vis[] = new boolean[n];
		// add one below for 1 based
		que.add(0);
		vis[0] = true;
		int k=0;
		while(que.size()>0) {
			int rem = que.remove();
			ans[k++] = rem;
			List<Integer> nbrs= graph.get(rem);
			for(int nbr: nbrs) {
				if(!vis[nbr]) {
					que.add(nbr);
					vis[nbr] = true;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		//{{1,4}, {2,1}, {4,3}, {4, 5}, {2,3}, {2, 4}, {1, 5}, {5, 3}, {2, 5}, {5, 1}, {4, 2}, {3, 1}, {5, 4}, {3, 4}, {1, 3}, {4, 1}, {3, 5}, {3, 2}, {5, 2}};
		int arr[][] = {{0, 1}, {1,2}, {2,3}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {4,6}};
		int m = arr.length;
		int gr[] = bfs(7, m, arr);
		for(int g: gr) {
			System.out.println(g);
		}
		
	}
}
