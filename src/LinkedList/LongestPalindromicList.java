package LinkedList;

public class LongestPalindromicList {
	public int longestPalindromLength(ListNode A){
		ListNode prev = null;
		ListNode curr = A;
		int max = 0;
		while(curr != null) {
			ListNode forw = curr.next;
			int count = countNodes(prev, forw);
			max = Math.max(max,  (2*count) + 1);
			curr.next = prev;
			prev = curr;
			curr = forw;
		}
		return max;
	}
	public int countNodes(ListNode prev, ListNode forw) {
		ListNode x  = prev;
		ListNode y = forw;
		int c = 0;
		while(x != null && y != null) {
			if(x.val == y.val) {
				c = c+1;
			}
			else {
				break;
			}
			x = x.next;
			y = y.next;
		}
		return c;
	}
}

//Solution 2
/*public class Solution {
    public int len = 0; // even
    public int length = 1;
    public void reverseLinkedList(ListNode A){
        ListNode prev = null;
        ListNode curr = A;
    //null<-2 <-3
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            checkPalindrome(prev, curr,0); // check even palindrome
            checkPalindrome(prev.next, curr,1); // check odd palindrome
        }
    }

public void checkPalindrome(ListNode first , ListNode second, int count){
        while(first != null && second != null){
            if(first.val != second.val){
                break;
        }
        count+=2;
        length = Math.max(length ,count);
        first = first.next;
        second = second.next;
        }
    }
        public int solve(ListNode A) {
        reverseLinkedList(A);
        return length;
    }
}*/

/*Q2. Longest Palindromic List
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a linked list of integers. Find and return the length of the longest palindrome list that exists in that linked list.

A palindrome list is a list that reads the same backward and forward.

Expected memory complexity : O(1)



Problem Constraints
1 <= length of the linked list <= 2000

1 <= Node value <= 100



Input Format
The only argument given is head pointer of the linked list.



Output Format
Return the length of the longest palindrome list.



Example Input
Input 1:

 2 -> 3 -> 3 -> 3
Input 2:

 2 -> 1 -> 2 -> 1 ->  2 -> 2 -> 1 -> 3 -> 2 -> 2


Example Output
Output 1:

 3
Output 2:

 5


Example Explanation
Explanation 1:

 3 -> 3 -> 3 is largest palindromic sublist
Explanation 2:

 2 -> 1 -> 2 -> 1 -> 2 is largest palindromic sublist.*/
