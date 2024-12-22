package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

	public ArrayList<Integer> leftView(TreeNode A){
		Queue<TreeNode> que = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		que.add(A);
		while(que.size()>0) {
			int n = que.size();
			for(int i=1; i<=n; i++) {
				TreeNode temp = que.remove();
				if(i == 1) {
					ans.add(temp.val);
				}
				if(temp.left != null) {
					que.add(temp.left);
				}
				if(temp.right != null) {
					que.add(temp.right);
				}
			}
		}
		return ans;
	}
}
