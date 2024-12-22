package Trees;

public class InsertKInBst {
	public void insert(TreeNode A, int k) {
		TreeNode temp = A;
		TreeNode n = new TreeNode(k);
		while(true) {
			if(temp.val > k) {
				if(temp.left == null) {
					temp.left = n;
					break;
				}
				else {
					temp = temp.left;
				}
			}
			else {
				if(temp.right == null) {
					temp.right = n;
					break;
				}
				else {
					temp = temp.right;
				}
			}
		}
	}

}
