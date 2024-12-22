package Greedy;

import java.util.Arrays;

public class ActivitySelection {
	public int selectActivity(int A[], int B[]) {
		int n = A.length;
		StartAndEnd se[] = new StartAndEnd[n];
		for(int i=0; i<n; i++) {
			se[i] = new StartAndEnd(A[i], B[i]);
		}
		Arrays.sort(se, (a,b)->Integer.compare(a.end, b.end));
		int ans = 1;
		int endTime = se[0].end;
		for(int i=1; i<n; i++) {
			if(se[i].start>=endTime) {
				ans++;
				endTime = se[i].end;
			}
		}
		return ans;
	}

}

class StartAndEnd{
	int start;
	int end;
	public StartAndEnd(int start, int end) {
		this.start = start;
		this.end = end;
	}
}