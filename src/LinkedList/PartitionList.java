package LinkedList;

public class PartitionList {
	public ListNode partition(ListNode A, int B) {
		ListNode beforeStart = null;
		ListNode beforeEnd = null;
		ListNode afterStart = null;
		ListNode afterEnd = null;
		while(A != null) {
			ListNode nxt = A.next;
			A.next = null;
			if(A.val < B) {
				if(beforeStart == null) {
					beforeStart = A;
					beforeEnd = beforeStart;
				}
				else {
					beforeEnd.next = A;
					beforeEnd = A;
				}
			}
			else {
					if(afterStart == null) {
						afterStart = A;
						afterEnd = afterStart;
					}
					else {
						afterEnd.next = A;
						afterEnd = A;
					}
			}
			A = nxt;
		}
		if(beforeStart == null) {
			return afterStart;
		}
		beforeEnd.next = afterStart;
		return beforeStart;
	}
}
/*Q2. Partition List
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.

You should preserve the original relative order of the nodes in each of the two partitions.



Problem Constraints
1 <= |A| <= 106

1 <= A[i], B <= 109



Input Format
The first argument of input contains a pointer to the head to the given linked list.

The second argument of input contains an integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

A = [1, 4, 3, 2, 5, 2]
B = 3
Input 2:

A = [1, 2, 3, 1, 3]
B = 2


Example Output
Output 1:

[1, 2, 2, 4, 3, 5]
Output 2:

[1, 1, 2, 3, 3]


Example Explanation
Explanation 1:

 [1, 2, 2] are less than B wheread [4, 3, 5] are greater than or equal to B.
Explanation 2:

 [1, 1] are less than B wheread [2, 3, 3] are greater than or equal to B.*/