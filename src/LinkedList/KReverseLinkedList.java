package LinkedList;

public class KReverseLinkedList {
	//1->2->3->4->5->6
	public ListNode reverseList(ListNode A, int B) {
		ListNode curr, prev, p1, p2;
		int flag = 0;
		p1 = curr=A;
		p2 = prev = null;
		while(curr != null) {
			for(int i=0; i<B; i++) {
				//Storing next node addrees
				ListNode temp = curr.next;
				//Breaking the connection from next node and point to prev node
				curr.next = prev;
				//Moving prev pointer to next node
				prev = curr;
				//Moving curr pointer to next node
				curr = temp;
			}
			//if it is the first sublist mark prev as head
			//2->1->3->4->5->6
			//2 is prev and 1 is curr. 2 pehla hai to hame head banana hoga isse
			if(flag==0){
                A = prev;
                flag = 1;     
            }
			//else link the sublist to previous sublist and update the pointer
			else {
				p1.next = prev;
				p1 = p2;
			}
			prev = null;
			p2 = curr;
		}
		return A;
	}
}

/*Q3. K reverse linked list
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.



Problem Constraints
1 <= |A| <= 103

B always divides A



Input Format
The first argument of input contains a pointer to the head of the linked list.

The second arugment of input contains the integer, B.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5, 6]
 B = 2
Input 2:

 A = [1, 2, 3, 4, 5, 6]
 B = 3


Example Output
Output 1:

 [2, 1, 4, 3, 6, 5]
Output 2:

 [3, 2, 1, 6, 5, 4]


Example Explanation
Explanation 1:

 For the first example, the list can be reversed in groups of 2.
    [[1, 2], [3, 4], [5, 6]]
 After reversing the K-linked list
    [[2, 1], [4, 3], [6, 5]]
Explanation 2:

 For the second example, the list can be reversed in groups of 3.
    [[1, 2, 3], [4, 5, 6]]
 After reversing the K-linked list
    [[3, 2, 1], [6, 5, 4]]*/