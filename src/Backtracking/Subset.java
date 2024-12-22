package Backtracking;

import java.util.ArrayList;

public class Subset {
	ArrayList<ArrayList<Integer>> ans;
	public ArrayList<ArrayList<Integer>> printAllSubset(ArrayList<Integer> A){
		ans = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		subset(A, temp, 0);
		return ans;
	}
	public void subset(ArrayList<Integer> A, ArrayList<Integer> temp, int index) {
		ans.add(new ArrayList<>(temp));
		for(int i = index; i<A.size(); i++) {
			temp.add(A.get(i));
			subset(A, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		Subset2 su = new Subset2();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		res = su.subset2(al);
		for(int i=0; i<res.size(); i++) {
			for(int j=0; j<res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j));
			}
			System.out.println();
		}
	}
}

/*Q2. Subset
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer.



Example Input
Input 1:

A = [1]
Input 2:

A = [1, 2, 3]


Example Output
Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]


Example Explanation
Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.*/