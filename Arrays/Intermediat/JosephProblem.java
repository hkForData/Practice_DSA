package Intermediat;

public class JosephProblem {
	private static int findAlivePerson(int A){
		/*int i = 1;
        while(i <= A){
            i = i * 2;
        }
        int t = A-(i/2);
        return (2*t)+1;*/
         for (int i = 30; i >= 0; i--) {
           
            if ((A ^ (1 << i)) < A) {
                A ^= (1 << i);
                A <<= 1;
                A |= 1;
                break;
            }
           }
        return A;
	}
	public static void main(String[] args) {
		System.out.println(findAlivePerson(4));
	}
}
/*Q4. Josephus Problem - 2
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
There are A people standing in a circle. Person 1 kills their immediate clockwise neighbour and pass the knife to the next person standing in circle. This process continues till there is only 1 person remaining. Find the last person standing in the circle.



Problem Constraints
1 <= A <= 105


Input Format
First argument A is an integer.


Output Format
Return an integer.


Example Input
Input 1:
A = 4
Input 2:
A = 5


Example Output
Output 1:
1
Output 2:
3


Example Explanation
For Input 1:
Firstly, the person at position 2 is killed, then the person at position 4 is killed,
then the person at position 3 is killed. So the person at position 1 survives. 
For Input 2:
 
Firstly, the person at position 2 is killed, then the person at position 4 is killed, 
then the person at position 1 is killed. Finally, the person at position 5 is killed. 
So the person at position 3 survives. */