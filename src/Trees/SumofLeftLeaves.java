package Trees;

public class SumofLeftLeaves {
	public int sumOfLeftLeave(TreeNode A){
		boolean b = false;
		int sum = sum(A, b);
		return sum;
	}
	public int sum(TreeNode A, boolean b) {
		if(A == null) {
			return 0;
		}
		if(A.left != null && A.right != null && b) {
			return A.val;
		}
		return sum(A.left, true) + sum(A.right, false);
	}

}

/*Q2. Sum of Left Leaves
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description

Given a binary tree, find and return the sum of node value of all left leaves in it.



Problem Constraints

1 <= number of nodes <= 5 * 105

1 <= node value <= 105



Input Format

First and only argument is a pointer to the root node of the Binary Tree, A.



Output Format

Return an integer denoting the sum of node value of all left leaves in it.



Example Input

Input 1:

    3
   / \
  9  20
    /  \
   15   7
Input 2:

   1
  / \
 6   2
    /
   3


Example Output

Output 1:

 24
Output 2:

 9


Example Explanation

Explanation 1:

 Left leaf node in the given tree are 9 and 15. Return 24 (9 + 15).
Explanation 2:

 Left leaf node in the given tree are 6 and 3. Return 9 (6 + 3).*/