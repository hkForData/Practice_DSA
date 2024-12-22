package Trees;

public class MaxPathFromRoot {
	public int maxPath(TreeNode root) {
		if(root != null) {
			return 0;
		}
		int lmax = maxPath(root.left);
		int rmax = maxPath(root.right);
		return lmax+rmax+2;
	}
}
