package queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class UniqueLetter {
	public String uniqueLetter(String A){
		HashMap<Character, Integer> hm = new HashMap<>();
        Queue<Character> que = new ArrayDeque<>();
        StringBuilder res=new StringBuilder();
        res.append(String.valueOf(A.charAt(0)));
        que.add(A.charAt(0));
        hm.put(A.charAt(0),1);
        for(int i=1;i<A.length(); i++){
            char c = A.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
            if(hm.get(A.charAt(i)) == 1){
                que.add(c);
            }
            while(que.size()>0 && hm.get(que.peek())>1){
                que.remove();
            }
            if(que.size() == 0){
                res.append("#");
            }
            else{
                res.append(que.peek());
            }
        }
        return res.toString();
	}

}

/*Q1. Unique Letter
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".

Here's a scenario:

A student says "a". It's the first letter. You write "a".
Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
A student says "c". "c" is unique. You add "c". The final is "aab#c".
Your task? Given the sequence the students call out A, determine the string on the board.



Problem Constraints
1 <= |A| <= 100000



Input Format
The only argument given is string A.



Output Format
Return a string after processing the stream of lowercase alphabets A.



Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"


Example Output
Output 1:

"aabbdd"
Output 2:

"aaabc#"


Example Explanation
Explanation 1:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"aba"    -   first non repeating character 'b'
"abad"   -   first non repeating character 'b'
"abadb"  -   first non repeating character 'd'
"abadbc" -   first non repeating character 'd'
Explanation 2:

"a"      -   first non repeating character 'a'
"ab"     -   first non repeating character 'a'
"abc"    -   first non repeating character 'a'
"abca"   -   first non repeating character 'b'
"abcab"  -   first non repeating character 'c'
"abcabc" -   no non repeating character so '#'*/