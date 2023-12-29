package LinkedList;

public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1->1->2->3->3
	}
	public ListNode removeDuplicate(ListNode A) {
		ListNode temp = A;
		while(temp.next != null) {
			if(temp.val == temp.next.val) {
				temp.next = temp.next.next;
			}
			else {
				temp = temp.next;
			}
		}
		return A;
	}

}
/*Q2. Remove Duplicates from Sorted List
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a sorted linked list, delete all duplicates such that each element appears only once.



Problem Constraints
0 <= length of linked list <= 106



Input Format
First argument is the head pointer of the linked list.



Output Format
Return the head pointer of the linked list after removing all duplicates.



Example Input
Input 1:

 1->1->2
Input 2:

 1->1->2->3->3


Example Output
Output 1:

 1->2
Output 2:

 1->2->3


Example Explanation
Explanation 1:

 Each element appear only once in 1->2.*/