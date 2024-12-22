package Trees;

public class RecoverBinarySearchTree {
	int ans = -1;
    int c = 0;
    public int kthsmallest(TreeNode A, int B) {
        bthSmallest(A, B);
        return ans;
    }
    private void bthSmallest(TreeNode A, int k){
        if(A == null){
            return;
        }
        bthSmallest(A.left, k);
        c++;
        if(k == c){
            ans = A.val;
            return;
        }
        bthSmallest(A.right, k);
    }
}
