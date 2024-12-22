package Trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {
	public ArrayList<Integer> inorder(TreeNode root){
		TreeNode curr = root;
		ArrayList<Integer> ans = new ArrayList<>();
		while(curr != null) {
			if(curr.left == null) {
				ans.add(curr.val);
				curr = curr.right;
			}
			else {
				TreeNode currp1 = curr.left;
				while(currp1.right != null && currp1.right != curr) {
					currp1 = currp1.right;
				}
				if(currp1.right == null) {
					currp1.right = curr;
					curr = curr.left;
				}
				else {//currp1.right == curr
					currp1.right = null;
					ans.add(curr.val);
					curr = curr.right;
				}
			}
		}
		return ans;
	}

}
