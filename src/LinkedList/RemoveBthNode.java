package LinkedList;

public class RemoveBthNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//A = 1 -> 2 -> 3
		//l		B = 1
	}
	private ListNode removeBthNode(ListNode A, int B) {
		if(B == 0) {
			A = A.next;
			return A;
		}
		ListNode temp = A;
		int cnt = 0;
		while(A.next!=null) {
			if(cnt == B-1) {
				temp.next = temp.next.next;
				break;
			}
			temp = temp.next;
			cnt++;
		}
		return temp;
	}

}
/*
 * class ListNode { public int val; public ListNode next; ListNode(int x) { val
 * = x; next = null; } }
 */