package Trees;

public class ValidBinarySearchTree {
	public int isValidBst(TreeNode A) {
		TreeNode temp = A;
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		return isBst(temp, min, max);
	}
	public int isBst(TreeNode temp, int min, int max) {
		if(temp == null) {
			return 1;
		}
		if(temp.val<min || temp.val> max) {
			return 0;
		}
		int left = isBst(temp.left, min, temp.val-1);
		if(left == 0) {
			return 0;
		}
		int right = isBst(temp.right, temp.val+1, max);
		if(right == 0) {
			return 0;
		}
		return 1;
	}
}

/*Q2. Valid Binary Search Tree
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.



Problem Constraints
1 <= Number of nodes in binary tree <= 105

0 <= node values <= 232-1



Input Format
First and only argument is head of the binary tree A.



Output Format
Return 0 if false and 1 if true.



Example Input
Input 1:

 
   1
  /  \
 2    3
Input 2:

 
  2
 / \
1   3


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 2 is not less than 1 but is in left subtree of 1.
Explanation 2:

Satisfies all conditions.*/