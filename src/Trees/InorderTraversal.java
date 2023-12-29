package Trees;

import java.util.ArrayList;

public class InorderTraversal {
	public int[] inorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		inorder(A, ans);
		int arr[] = new int[ans.size()];
		int i=0;
		for(int a: ans) {
			arr[i++] = a;
		}
		return arr;
	}
	public void inorder(TreeNode A, ArrayList al) {
		if(A == null) {
			return;
		}
		inorder(A.left, al);
		al.add(A.val);
		inorder(A.right, al);
	}
}

/*Q4. Inorder Traversal
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a binary tree, return the inorder traversal of its nodes' values.



Problem Constraints
1 <= number of nodes <= 105



Input Format
First and only argument is root node of the binary tree, A.



Output Format
Return an integer array denoting the inorder traversal of the given binary tree.



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

 [1, 3, 2]
Output 2:

 [6, 1, 3, 2]


Example Explanation
Explanation 1:

 The Inorder Traversal of the given tree is [1, 3, 2].
Explanation 2:

 The Inorder Traversal of the given tree is [6, 1, 3, 2].*/