package LinkedList;
/*3 -> 2 -> 4 -> 5 -> 6
			^         |
			|         |    
			- - - - - -*/
public class RemoveLoopFromList {
	public ListNode removeLoopFromList(ListNode A) {
		//Check if cycle is present or not using slow and fast pointer
        ListNode slow = A;
        ListNode fast = A;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        //Reset slow pointer to head and move slow pointer and fast pointer 
        //simultaneously with one step at meeting of these pointer set null;
        slow = A;
        ListNode temp = null;
        while(slow != fast){
            temp = fast;
            slow = slow.next;
            fast = fast.next;
        }
        if(slow.next == slow){
            slow.next = null;
        }
        else{
            temp.next = null;
        }
        return A;
	}
}

/*Q1. Remove Loop from Linked List
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
You are given a linked list that contains a loop.
You need to find the node, which creates a loop and break it by making the node point to NULL.



Problem Constraints
1 <= number of nodes <= 1000



Input Format
The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
The second line of the input contains an integer which denotes the position of node where cycle starts.



Output Format
return the head of the updated linked list.



Example Input
Input 1:

 
1 -> 2
^    |
| - - 
Input 2:

3 -> 2 -> 4 -> 5 -> 6
          ^         |
          |         |    
          - - - - - -


Example Output
Output 1:

 1 -> 2 -> NULL
Output 2:

 3 -> 2 -> 4 -> 5 -> 6 -> NULL


Example Explanation
Explanation 1:

 Chain of 1->2 is broken.
Explanation 2:

 Chain of 4->6 is broken.
*/