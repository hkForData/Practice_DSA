package Stack;

import java.util.Stack;

public class BalancedParanthesis {
	public int balanceParenthesis(String A) {
		Stack<Character> st = new Stack<>();
		for(int i=0; i<A.length(); i++) {
			if(A.charAt(i)==')' || A.charAt(i) == '}' || A.charAt(i) == ']') {
				if(st.isEmpty()) {
					return 0;
				}
				if(A.charAt(i)==')' && st.peek()!='(') {
					return 0;
				}
				else if(A.charAt(i)=='}' && st.peek()!='{') {
					return 0;
				}
				else if(A.charAt(i)==']' && st.peek()!='[') {
					return 0;
				}
				else {
					st.pop();
				}
			}
			else {
				st.push(A.charAt(i));
			}
		}
		if(st.isEmpty()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
/*Q2. Balanced Paranthesis
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.

Refer to the examples for more clarity.



Problem Constraints
1 <= |A| <= 100



Input Format
The first and the only argument of input contains the string A having the parenthesis sequence.



Output Format
Return 0 if the parenthesis sequence is not balanced.

Return 1 if the parenthesis sequence is balanced.



Example Input
Input 1:

 A = {([])}
Input 2:

 A = (){
Input 3:

 A = ()[] 


Example Output
Output 1:

 1 
Output 2:

 0 
Output 3:

 1 


Example Explanation
You can clearly see that the first and third case contain valid paranthesis.

In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.*/
