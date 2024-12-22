package Trees;

public class CountNode {
	public int greateAncestor(TreeNode A) {
		return greaterAncestor(A, 0);
	}
	public int greaterAncestor(TreeNode child, int parent) {
		int count = 0;
		if(child  == null) {
			return 0;
		}
		if(child.val > parent) {
			parent = child.val;
			count++;
		}
		int left = greaterAncestor(child.left, Math.max(child.val, parent));
		int right = greaterAncestor(child.right, Math.max(child.val, parent));
		return count+ left+ right;
	}
}
