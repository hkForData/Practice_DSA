package Trees;

public class SymmetricBinaryTree {
	public int isSymmetric(TreeNode A){
		return check(A.left, A.right);
	}
	public int check(TreeNode lh, TreeNode rh) {
		if(lh == null && rh == null) {
			return 1;
		}
		if(lh == null || rh == null) {
			return 0;
		}
		if(lh.val != rh.val) {
			return 0;
		}
		return check(lh.left, rh.right) & check(lh.right, rh.left);
	}
}

/*Q6. Symmetric Binary Tree
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is the root node of the binary tree.



Output Format
Return 0 / 1 ( 0 for false, 1 for true ).



Example Input
Input 1:

    1
   / \
  2   2
 / \ / \
3  4 4  3
Input 2:

    1
   / \
  2   2
   \   \
   3    3


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 The above binary tree is symmetric. 
Explanation 2:

The above binary tree is not symmetric.*/
