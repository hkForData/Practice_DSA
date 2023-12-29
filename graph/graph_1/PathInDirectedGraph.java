package graph_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class PathInDirectedGraph {
	public int solve(int A, ArrayList<ArrayList<Integer>> B) {
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
    }
	public static void main(String[] args) {
		//[[1,4],[2,1],[4,3],[4,5],[2,3],[2,4],[1,5],[5,3],[2,5],[5,1],[4,2],[3,1],[5,4],[3,4],[1,3],[4,1],[3,5],[3,2],[5,2]]
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for()
	}
}
