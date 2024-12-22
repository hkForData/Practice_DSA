package Trees;

public class SmallestSubtreewthDpstNode {
	int maxDepth = 0;
	TreeNode result = null;
	public TreeNode smallestSubtree(TreeNode A) {
		deepestNode(A, 0);
		return result;
	}
	public int deepestNode(TreeNode A, int depth) {
		if(A == null) {
			return depth;
		}
		int left = deepestNode(A.left, depth+1);
		int right = deepestNode(A.right, depth+1);
		if(left == right) {
			maxDepth = Math.max(left, right);
			if(maxDepth == left) {
				result = A;
			}
		}
		return Math.max(left, right);//3
	}
}

/*Q8. Smallest Subtree with all the Deepest Nodes
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description

Given a binary tree with root node pointer A . The depth of each node is the shortest distance to the root. A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes of the entire tree lies in its subtree.

NOTE: All nodes values are uniques in the tree.



Problem Constraints

1 <= Total number of nodes <= 100000
0 <= Nodes values <= 10



Input Format

The only arguments given are root pointer A.



Output Format

Return the node with the largest depth such that it contains all the deepest nodes of the entire tree lies in its subtree.



Example Input

       1
      / \
     2   3
    / \  \
   6   4  5
      / \
     12  13 


Example Output

      4
     / \
    12  13


Example Explanation

Considering depth of root node as 0.
Maximum depth is 3.
Node with value 12 has depth 3.
Node with value 13 has depth 3.
Smallest subtree which contains 12 and 13 is (4,12,13).*/