package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfTree {
	public ArrayList topView(TreeNode A) {
		Queue<Pair> que = new LinkedList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		que.add(new Pair(A, 0));
		while(que.size( )> 0) {
			Pair rem = que.remove();
			if(hm.containsKey(rem.verticalLevel) == false) {
				hm.put(rem.verticalLevel, rem.node.val);
			}
			if(rem.node.left != null) {
				que.add(new Pair(rem.node.left, rem.verticalLevel-1));
			}
			if(rem.node.right != null) {
				que.add(new Pair(rem.node.left, rem.verticalLevel+1));
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(Map.Entry<Integer, Integer> p: hm.entrySet()) {
			ans.add(p.getValue());
		}
		return ans;
	}
}
