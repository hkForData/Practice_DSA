package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomViewOfTree {
	public ArrayList<Integer> bottomView(TreeNode A){
		Queue<Pair> que = new LinkedList<>();
		HashMap<Integer, Integer> hm = new HashMap<>();
		que.add(new Pair(A, 0));
		while(que.size()>0) {
			Pair rem = que.poll();
			hm.put(rem.verticalLevel, rem.node.val);
			if(rem.node.left != null) {
				que.add(new Pair(rem.node.left, rem.verticalLevel-1));
			}
			if(rem.node.right != null) {
				que.add(new Pair(rem.node.right, rem.verticalLevel+1));
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		for(Map.Entry<Integer, Integer> p: hm.entrySet()) {
			al.add(p.getValue());
		}
		return al;
	}

}
