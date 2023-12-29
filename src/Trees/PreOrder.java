package Trees;

import java.util.ArrayList;

public class PreOrder {
	public ArrayList<Integer> preOrder(TreeNode A){
		ArrayList<Integer> ans = new ArrayList<>();
		traverse(A, ans);
		return ans;
	}
	public void traverse(TreeNode A, ArrayList<Integer> al) {
		if(A == null) {
			return;
		}
		al.add(A.val);
		traverse(A.left, al);
		traverse(A.right, al);
	}
}

/*Q5. Preorder Traversal
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a binary tree, return the preorder traversal of its nodes values.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the preorder traversal of the given binary tree.



Example Input
Input 1:

   1
    \
     2
    /
   3
Input 2:

   1
  / \
 6   2
    /
   3


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 6, 2, 3]


Example Explanation
Explanation 1:

 The Preoder Traversal of the given tree is [1, 2, 3].
Explanation 2:

 The Preoder Traversal of the given tree is [1, 6, 2, 3].*/