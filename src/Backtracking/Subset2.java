package Backtracking;

import java.util.ArrayList;

public class Subset2 {
	ArrayList<ArrayList<Integer>> ans;
	public ArrayList<ArrayList<Integer>> subset2(ArrayList<Integer> A){
		ans = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		getUniqueSubset(A, temp, 0);
		return ans;
	}
	public void getUniqueSubset(ArrayList<Integer> A, ArrayList<Integer> temp, int index) {
		ans.add(new ArrayList<>(temp));
		for(int i=index; i<A.size(); i++) {
			if(i>index && A.get(i).equals(A.get(i-1)) ) {
				continue;
			}
			temp.add(A.get(i));
			getUniqueSubset(A, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(2);
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

/*Q1. Subsets II
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
The subsets must be sorted lexicographically.


Problem Constraints
0 <= N <= 16



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D vector denoting all the possible subsets.



Example Input
Input 1:

 A = [1, 2, 2]
Input 2:

 A = [1, 1]


Example Output
Output 1:

 [
    [],
    [1],
    [1, 2],
    [1, 2, 2],
    [2],
    [2, 2]
 ]
Output 2:

 [
    [],
    [1],
    [1, 1]
 ]


Example Explanation
Explanation 1:

All the subsets of the array [1, 2, 2] in lexicographically sorted order.
*/