package graph_2;

import java.util.ArrayList;

public class CycleInUndirectedGraph {
	public int cycleInGraph(int A, int B[][]) {
		ArrayList<ArrayList<Integer>> adList = new ArrayList<>();
        int N = B.length;
        for (int i = 0; i <= N; i++) {
            adList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < N; i++) {
            int u = B[i][0];
            int v = B[i][1];
            adList.get(u).add(v);
            adList.get(v).add(u);
        }
        boolean visited[] = new boolean[N + 1];
		return 0;
	}

}
