package Backtracking;

import java.util.ArrayList;

public class LetterPhone {
	String letters[] = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	public ArrayList<String> letterCombination(String A){
		ArrayList<String> ans = new ArrayList<>();
		StringBuilder temp = new StringBuilder();
		generateCombination(A, ans, temp, 0);
		return ans;
	}
	public void generateCombination(String A, ArrayList<String>ans, StringBuilder temp, int index) {
		
		if(index == A.length()) {
			ans.add(temp.toString());
			temp = new StringBuilder();
			return;
		}
		int num = (int)(A.charAt(index)-'0');
		for(int i=0; i<letters[num].length(); i++) {
			temp.append(letters[num].charAt(i));
			generateCombination(A, ans, temp, index+1);
			temp.deleteCharAt(temp.length()-1);
		}
	}
	public static void main(String[] args) {
		String A = "23";
		LetterPhone lt = new LetterPhone();
		ArrayList<String> al = new ArrayList<>();
		al = lt.letterCombination(A);
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
	}
}
