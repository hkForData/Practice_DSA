package Trees;

public class SumOfBinaryTreeNode {
	public int sumOfBinaryTree(TreeNode A) {
		return sum(A, 0);
	}
	public int sum(TreeNode A, int sum){
		if(A == null) {
			return 0;
		}
		int l = sum(A.left, sum);
		int r = sum(A.right, sum);
		return r+l+A.val;
	}
}

/*Q3. Sum of nodes of a Binary Tree
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given the root of a binary tree A. Return the sum of all the nodes of the binary tree.


Problem Constraints
1 <= Number of nodes in A <= 104

1 <= value of each node <= 104



Input Format
First argument is the root of binary tree A.



Output Format
Return an integer denoting the sum of all the nodes



Example Input
Input 1:

 A =   2                 
      / \                           
     1   4            
    /                           
   5


Input 2:

A =   3
      / \
      6  1
      \   \
       2   7


Example Output
Output 1:

12
Output 2:

19


Example Explanation
Explanation 1:

The sum of all the nodes is 12
Explanation 2:

The sum of all the nodes is 19*/