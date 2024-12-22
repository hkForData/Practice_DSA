package graph_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
	public int[] shortestPath(int A, int[][] B, int C) {
		//step 1 generate the nbrs list
		ArrayList<ArrayList<Pair>> graph = generateAddjecencyList(B, A);
		int dist[] = new int[A];
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<DPair> pq = new PriorityQueue<>();
		pq.add(new DPair(C, 0));
		while(pq.size()>0) {
			DPair rem = pq.remove();
			int vtx = rem.u;
			int wsf = rem.w;
			if(dist[vtx] != Integer.MAX_VALUE) {
				continue;
			}
			dist[vtx] = wsf;
			ArrayList<Pair>nbrs = graph.get(vtx);
			for(Pair nbr: nbrs) {
				if(dist[nbr.vt] != Integer.MAX_VALUE) {
					continue;
				}
				pq.add(new DPair(nbr.vt, wsf+nbr.wt));
			}
		}
		return dist;
	}
	private static ArrayList<ArrayList<Pair>> generateAddjecencyList(int B[][], int n) {
		ArrayList<ArrayList<Pair>> al = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0; i<B.length; i++) {
			int u = B[i][0];
			int v = B[i][1];
			int w = B[i][2];
			addEdge(al, u, v, w);
		}
		return al;
	}
	private static void addEdge(ArrayList<ArrayList<Pair>> graph, int u, int v, int w) {
		graph.get(u).add(new Pair(v, w));
		graph.get(v).add(new Pair(u, w));
	}
}

class Pair{
	public int vt;
	public int wt;
	Pair(int vt, int wt){
		this.vt = vt;
		this.wt = wt;
	}
}
class DPair{
	public int u;
	public int w;
	DPair(int u, int w){
		this.u = u;
		this.w = w;
	}
}
