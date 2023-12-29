package Trees;

import java.util.ArrayList;

public class PostOrder {
	// post means traverse to left right and then add value to ArrayList
	public ArrayList<Integer> postOrder(TreeNode A){
		ArrayList<Integer> ans = new ArrayList<>();
		traverse(A, ans);
		return ans;
	}
	public void traverse(TreeNode A, ArrayList<Integer> al) {
		if(A == null) {
			return;
		}
		traverse(A.left, al);
		traverse(A.right, al);
		al.add(A.val);
	}
}
