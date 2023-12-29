package LinkedList;

public class PalindromeList {
	public int isPalinDrom(ListNode A) {
		ListNode mid = middleNode(A);
		ListNode nhead = mid.next;
		mid.next = null;
		ListNode secondHalf = reverseSecondHalf(nhead);
		ListNode t1 = A;
		ListNode t2 = secondHalf;
		while(t1 != null && t2 != null) {
			if(t1.val != t2.val) {
				return 0;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		return 1;
	}
	public static ListNode middleNode(ListNode A) {
		ListNode s = A;
		ListNode f = A;
		if(A == null || A.next == null) {
			return A;
		}
		while(f.next!=null && f.next.next!=null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}
	public static ListNode reverseSecondHalf(ListNode nhead) {
		ListNode curr = nhead;
		ListNode prev = null;
		while(curr.next != null) {
			ListNode forw= curr.next;
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		return prev;
		
	}

}
/*Q1. Palindrome List
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.



Problem Constraints
1 <= |A| <= 105



Input Format
The first and the only argument of input contains a pointer to the head of the given linked list.



Output Format
Return 0, if the linked list is not a palindrome.

Return 1, if the linked list is a palindrome.



Example Input
Input 1:

A = [1, 2, 2, 1]
Input 2:

A = [1, 3, 2]


Example Output
Output 1:

 1 
Output 2:

 0 


Example Explanation
Explanation 1:

 The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
Explanation 2:

 The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].*/