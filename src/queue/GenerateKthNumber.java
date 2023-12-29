package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class GenerateKthNumber {
	public int[] generateKthNumber(int A){
		Queue<String> que = new ArrayDeque<>();
		int ans[] = new int[A];
		que.add("1");
		que.add("2");
		que.add("3");
		if(A==1) {
			ans[0] = 1;
			return ans;
		}
		int j=0;
		for(int i=0; i<A-1; i++) {
			String x = que.poll();
			ans[j++] = Integer.parseInt(x);
			que.add(x + "1");
			que.add(x + "2");
			que.add(x + "3");
			
		}
		ans[j++] = Integer.parseInt(que.remove());
		return ans;
	}

}
