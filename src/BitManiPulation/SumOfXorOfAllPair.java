package BitManiPulation;

public class SumOfXorOfAllPair {

	private static int sumOfXorOfAllPair(int A[]) {
		long ans=0;
        int n=A.length;
        long modNum = 1000000007;
        for(int i=0;i<32;i++){
            long subCount=0, count=0;
            for(int j=0;j<n;j++){
                if(checkBit(A[j], i)==1){
                    subCount++;
                }
            }
            count = (subCount*(n-subCount));
            ans=(ans+ ((count*(1<<i)))%modNum)%modNum;
        }
        return (int)ans;
	}
	private static int checkBit(int x, int y) {
		if((x & (1<<y))!=0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 3};
		System.out.println(sumOfXorOfAllPair(arr));
	}
}
/*Q3. Sum of Xor of all Pairs
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder after the dividing the answer by 109+7.



Problem Constraints
1 <= N <= 105

1 <= A[i] < 109



Input Format
Only argument A is an array of integers



Output Format
Return an integer denoting the sum of xor of all pairs of number in the array.



Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [3, 4, 2]


Example Output
Output 1:
6
Output 2:
14


Example Explanation
For Input 1:
Pair    Xor
{1, 2}  3
{1, 3}  2
{2, 3}  1
Sum of xor of all pairs = 3 + 2 + 1 = 6.
For Input 2:
Pair    Xor
{3, 4}  7
{3, 2}  1
{4, 2}  6
Sum of xor of all pairs = 7 + 1 + 6 = 14.*/