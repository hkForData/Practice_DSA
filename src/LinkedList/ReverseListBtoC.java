package LinkedList;

public class ReverseListBtoC {
	ListNode reverseListBtoC(ListNode A, int B, int C) {
		/*B--;
		C--;
		ListNode temp, curr, prev;
		temp = A;
		prev = null;
		for(int i=0; i<B; i++) {
			prev = temp;
			temp = temp.next;
		}
		if(prev != null) {
			prev.next = reverseList(temp, B-C+1);
		}
		else {
			A = reverseList(temp, B-C+1);
		}
		return A;
	}
	private ListNode reverseList(ListNode node, int count) {
		ListNode temp, curr, prev;
		curr = node;
		prev = null;
		while(curr != null && count>0) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
			count--;
		}
		node = prev;
		return node;*/
		
		//Create a dummy node to mark the head of the list
	       ListNode dummy = new ListNode(0);
	       dummy.next = A;
	       //make marker for currNode and for the node before reversing
	       ListNode leftPre = dummy;
	       ListNode currNode = A;
	       for(int i=0; i<B-1; i++){
	           leftPre = leftPre.next;//1
	           currNode = currNode.next;//2
	       }
	       //make marker to node where we start reversing
	       ListNode subListHead = currNode;//2
	       ListNode preNode = null;
	       for(int i=0; i<=C-B; i++){//null<-2 <-3 <-4
	           ListNode temp = currNode.next;//5
	           currNode.next = preNode;
	           preNode = currNode;//4
	           currNode = temp;//5
	       }
	       //1->4->3->2->5
	       //join the lists
	       leftPre.next = preNode;
	       subListHead.next = currNode;
	       return dummy.next;
	}
}
/*Q4. Reverse Link List II
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Reverse a linked list A from position B to C.

NOTE: Do it in-place and in one-pass.



Problem Constraints
1 <= |A| <= 106

1 <= B <= C <= |A|



Input Format
The first argument contains a pointer to the head of the given linked list, A.

The second arugment contains an integer, B.

The third argument contains an integer C.



Output Format
Return a pointer to the head of the modified linked list.



Example Input
Input 1:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 2
 C = 4

Input 2:

 A = 1 -> 2 -> 3 -> 4 -> 5
 B = 1
 C = 5


Example Output
Output 1:

 1 -> 4 -> 3 -> 2 -> 5
Output 2:

 5 -> 4 -> 3 -> 2 -> 1


Example Explanation
Explanation 1:

 In the first example, we want to reverse the highlighted part of the given linked list : 1 -> 2 -> 3 -> 4 -> 5 
 Thus, the output is 1 -> 4 -> 3 -> 2 -> 5 
Explanation 2:

 In the second example, we want to reverse the highlighted part of the given linked list : 1 -> 4 -> 3 -> 2 -> 5  
 Thus, the output is 5 -> 4 -> 3 -> 2 -> 1 */