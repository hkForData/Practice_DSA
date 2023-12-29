package Stack;

import java.util.Stack;

public class LongestValidParanthesis {
	public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int len = 0;
        st.push(-1);
        for(int i=0; i<s.length(); i++){
            Character ch = s.charAt(i);
            if(ch =='('){
                st.push(i);
            }
            else{
                st.pop();
                if(!st.isEmpty()){
                    len = Math.max(len, i-st.peek());
                }
                else{
                    st.push(i);
                }
            }
        }
        return len;
    }
}
