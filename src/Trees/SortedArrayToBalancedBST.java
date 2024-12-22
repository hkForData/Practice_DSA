package Trees;

public class SortedArrayToBalancedBST {
	public TreeNode sortedArrayToBSt(int A[]) {
		return construct(A, 0, A.length-1);
	}
	public TreeNode construct(int []A, int l, int r) {
		if(l>r) {
			return null;
		}
		int mid = (l+r)/2;
		TreeNode root = new TreeNode(mid);
		root.left = construct(A, l, mid-1);
		root.right = construct(A, mid+1, r);
		return root;
	}
}
