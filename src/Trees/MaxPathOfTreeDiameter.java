package Trees;

public class MaxPathOfTreeDiameter {
	public int maxPath(TreeNode root) {
		int diameter[] = new int[1];
		getMaxPath(root, diameter);
		return diameter[0];
	}
	private int getMaxPath(TreeNode A, int []diameter) {
		if(A == null) {
			return 0;
		}
		int lh = getMaxPath(A.left, diameter);
		int rh = getMaxPath(A.right, diameter);
		diameter[0] = Math.max(diameter[0], lh+rh);
		return 1 + Math.max(lh, rh);
	}
}
