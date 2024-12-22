package Arrays;

import java.util.ArrayList;

public class MergeInterval {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals, Interval newInterval){
		int s = newInterval.start;
		int e = newInterval.end;
		int n = intervals.size();
		ArrayList<Interval> ans = new ArrayList<>();
		for(int i=0; i<n; i++) {
			if(intervals.get(i).end<s) {
				ans.add(intervals.get(i));
			}
			else if(e<intervals.get(i).start) {
				for(int j=i; j<n; j++) {
					ans.add(intervals.get(j));
				}
			}
			else {
				s = Math.min(s, intervals.get(i).start);
				e = Math.min(e, intervals.get(i).end);
			}
		}
		ans.add(newInterval);
		return ans;	
	}
}



  //Definition for an interval.
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
