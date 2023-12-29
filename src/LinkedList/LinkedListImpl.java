package LinkedList;

public class LinkedListImpl {
	public static Node h = null;
	public static int length = 0;

	    public static void insert_node(int position, int value) {
	        // @params position, integer
	        // @params value, integer
	        if(position > length + 1) {
	            return;
	        }
	        if(position == 1) {
	            Node n = new Node(value);
	            n.link = h;
	            h = n;
	        } else {
	            Node t = h;
	            for(int i = 2; i <= position - 1; i++) {
	                t = t.link;
	            }
	            Node n = new Node(value);
	            n.link = t.link;
	            t.link = n;
	        }
	        length++; // Since we are inserting one node hence incrementing length by 1.
	    }

	    public static void delete_node(int position) {
	        // @params position, integer
	        if(position > length) {
	            return;
	        }
	        if(position == 1) {
	            h = h.link;
	        } else {
	            Node t = h;
	            for(int i = 2; i <= position - 1; i++) {
	                t = t.link;
	            }
	            t.link = t.link.link;
	        }
	        length--;
	    }

	    public static void print_ll() {
	        // Output each element followed by a space
	    if(length == 0) {
	        return;
	    }
	    Node t = h;
	    while(t.link != null) {
	        System.out.print(t.val + " ");
	        t = t.link;
	    }
	    System.out.print(t.val);
	}
}
class Node {
    int val;
    Node link;
    public Node(int a) {
        val = a;
        link = null;
    }
}
