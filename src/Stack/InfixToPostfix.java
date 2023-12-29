package Stack;

import java.util.Stack;

public class InfixToPostfix {
	/* 01 If operand add it to postfix string 
	 * 02 If ( add it to stack 
	 * 03 If ) pop until you get the opening bracket on 
	 * 04 If op has some priority Resolve the one which has come first
	 * 05 If op > st.peeks Insert it in stack 
	 * 06 It op < st.peeks Pop the peek element*/
	public String infixToPostFix(String A) {
		StringBuilder sb = new StringBuilder();
        int n = A.length();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<n; i++){
            char ch = A.charAt(i);
            //if character is operand add to string
            if(ch>='a' && ch<='z'){
                sb.append(ch);
            }
            //if character is '(' add to stack
            else if(ch == '('){
                st.push(ch);
            }
            //if character is ')' add to string until '(' and stack size till greater than zero
            else if(ch == ')'){
               while(st.size()>0 && st.peek()!='('){
                   sb.append(st.pop());
               }
               st.pop();
            }
            else{
              //if operator has the same priority resolve the one which has came first
              //If operator > st.peek() insert it into stack.
              //If operator < st.peek() pop the peek element
              if(st.size()==0){
                  st.push(ch);
              }
              else{
                  while(st.size()>0 && prec(st.peek()) >= prec(ch)){
                      sb.append(st.pop());
                  }
                  st.push(ch);
              }
            }
        }
        while(st.size()>0){
            sb.append(st.pop());
        }
        return sb.toString();

    }
    //method to check the precedence of character in stack and current character
    public int prec(char a){
        if(a == '^'){
            return 3;
        }
        else if(a == '/' || a == '*'){
            return 2;
        }
        else if(a == '('){
            return 0;
        }
        return 1;
	}

}
/*Q4. Infix to Postfix
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given string A denoting an infix expression. Convert the infix expression into a postfix expression.

String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.

Find and return the postfix expression of A.

NOTE:

^ has the highest precedence.
/ and * have equal precedence but greater than + and -.
+ and - have equal precedence and lowest precedence among given operators.


Problem Constraints
1 <= length of the string <= 500000



Input Format
The only argument given is string A.



Output Format
Return a string denoting the postfix conversion of A.



Example Input
Input 1:

 A = "x^y/(a*z)+b"
Input 2:

 A = "a+b*(c^d-e)^(f+g*h)-i"


Example Output
Output 1:

 "xy^az*/ //b+"
/* Output 2:

 "abcd^e-fgh*+^*+i-"


Example Explanation
Explanation 1:

 Ouput dentotes the postfix expression of the given input.*/

