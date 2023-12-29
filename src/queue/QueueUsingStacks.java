package queue;

import java.util.Stack;

public class QueueUsingStacks {
	public static Stack<Integer> st1;
	public static Stack<Integer> st2;
	QueueUsingStacks(){
		st1 = new Stack<>();
		st2 = new Stack<>();
	}
	//Enqueque efficient implementation 
	//push() O(1), pop() O(n)
	/* add()
	 1: Push x in St1
	 remove()
	 1: move n-1 element st1 to st2
	 2: remove st1 top element and store in variable to return
	 3: move all element from st2 to st1
	 4: return stored variable
	 * */
	public static void push(int A) {
		st1.push(A);
	}
	public static int pop() {
		while(st1.size()>1) {
			st2.push(st1.pop());
		}
		int ans = st1.pop();
		while(st2.size()>0) {
			st1.push(st2.pop());
		}
		return ans;
	}
	public static int peek() {
		while(st1.size()>1) {
			st2.push(st1.pop());
		}
		int ans = st1.peek();
		while(st2.size()>0) {
			st1.push(st2.pop());
		}
		return ans;
	}
	public static boolean empty() {
		if(st1.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//Dequeue efficient implementation 
	//push() O(n), pop() O(1)
	/*
	 * 
	 add()
	 1: move all element st1 to st2
	 2: add x to st1
	 3: move all element from st2 to st1
	 remove()
	 Step1: pop top element in St1
	 */
	
	static void push1(int X) {
        while(st1.size()!=0){
            st2.push(st1.pop());
        }
        st1.push(X);
        while(st2.size() != 0){
            st1.push(st2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    static int pop1() {
       if(st1.size() == 0){
           return -1;
       }
       return st1.pop();
    }
    
    /** Get the front element of the queue. */
    static int peek1() {
       if(st1.size() == 0){
           return -1;
       }
       return st1.peek();
    }
    
    /** Returns whether the queue is empty. */
    static boolean empty1() {
        if(st1.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
}

/*Q1. Queue Using Stacks
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description

Implement a First In First Out (FIFO) queue using stacks only.

The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the UserQueue class:

void push(int X) : Pushes element X to the back of the queue.
int pop() : Removes the element from the front of the queue and returns it.
int peek() : Returns the element at the front of the queue.
boolean empty() : Returns true if the queue is empty, false otherwise.
NOTES:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.


Problem Constraints

1 <= X <= 109

At most 1000 calls will be made to push, pop, peek, and empty function.

All the calls to pop and peek are valid. i.e. pop and peek are called only when the queue is non-empty.



Example Input

Input 1:

 1) UserQueue()
 2) push(20)
 3) empty()
 4) peek()
 5) pop()
 6) empty()
 7) push(30)
 8) peek()
 9) push(40)
 10) peek()
Input 2:

 1) UserQueue()
 2) push(10)
 3) push(20)
 4) push(30)
 5) pop()
 6) pop()


Example Output

Output 1:

 false
 20
 20
 true
 30
 30 
Output 2:

 10
 20


Example Explanation

Explanation 1:

 Queue => 20
 Queue => -
 Queue => 30
 Queue => 30, 40 
Explanation 2:

 Queue => 10
 Queue => 10, 20
 Queue => 10, 20, 30
 Queue => 20, 30
 Queue => 30*/
