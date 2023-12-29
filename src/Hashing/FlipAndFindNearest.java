package Hashing;

import java.util.ArrayList;
import java.util.TreeSet;

public class FlipAndFindNearest {
	public static int[] flip(String A, int B[][]){
		TreeSet<Integer> ts = new TreeSet<>();
		int n = A.length();
		for(int i = 0; i<n; i++) {
			if(A.charAt(i) == '1') {
				ts.add(i+1);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=0; i<B.length; i++) {
			int queryType = B[i][0];
			int indexValue = B[i][1];
			if(queryType == 1) {
				if(ts.contains(indexValue)) {
					ts.remove(indexValue);
				}
				else {
					ts.add(indexValue);
				}
			}
			else {
				int nearestLeftInd = Integer.MIN_VALUE;
				int nearestRightInd = Integer.MAX_VALUE;
				if(ts.ceiling(indexValue)!=null) {
					nearestRightInd = ts.ceiling(indexValue);  
				}
				if(ts.floor(indexValue)!=null) {
					 nearestLeftInd = ts.floor(indexValue);  
				}
				if(nearestLeftInd == Integer.MIN_VALUE && nearestRightInd == Integer.MAX_VALUE) {
					ans.add(-1);
				}
				else if(nearestLeftInd != Integer.MIN_VALUE && ((indexValue - nearestLeftInd)<=(nearestRightInd-indexValue))) {
					ans.add(nearestLeftInd);
				}
				else {
					ans.add(nearestRightInd);
				}
			}
		}
		int[] result = new int[ans.size()];
        int j = 0;
        for (int i = 0; i < ans.size(); i++)
        {
            result[j++] = ans.get(i);
        }
        return result;
		
	}
	public static void main(String[] args) {
		String A = "010000100";
		int B[][] = {{2, 5},{1, 7},{2, 9}};
		int ans [] = flip(A, B);
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i]+ " ");
		}
	}

}
