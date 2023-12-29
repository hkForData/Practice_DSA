package LinkedList;

public class RemoveNthNodeFromListEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A = 1->2->3->4->5
			//	B = 2
	}
	public ListNode removeNthNodeFromEnd(ListNode A, int B) {
		ListNode temp = A;
		int length = 0;
		while(temp.next != null) {
			temp = temp.next;
			length++;
		}
		if(length == 1) {
			A = null;
			return A;
		}
		int pos = length-B;
		if(pos <= 0) {
			temp = temp.next;
			return temp;
		}
		temp = A;
		for(int i=1; i<pos; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		return A;
	}

}
/*Q1. Remove Nth Node from List End
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a linked list A, remove the B-th node from the end of the list and return its head. For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of the list, remove the first node of the list. NOTE: Try doing it using constant additional space.


Problem Constraints
1 <= |A| <= 106


Input Format
The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.


Output Format
Return the head of the linked list after deleting the B-th element from the end.


Example Input
Input 1:
A = 1->2->3->4->5
B = 2
Input 2:
A = 1
B = 1


Example Output
Output 1:
1->2->3->5
Output 2:
  


Example Explanation
Explanation 1:
In the first example, 4 is the second last element.
Explanation 2:
In the second example, 1 is the first and the last element.*/
