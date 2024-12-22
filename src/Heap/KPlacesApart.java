package Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {
	public static ArrayList<Integer> kplacesApart(ArrayList<Integer> A, int B){
		PriorityQueue<Integer> minHip = new PriorityQueue<>();
		for(int i=0; i<B; i++) {
			minHip.add(A.get(i));
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=B; i<A.size(); i++) {
			al.add(minHip.poll());
			minHip.add(A.get(i));
		}
		return al;
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(6);
		al.add(40);
		al.add(2);
		al.add(3);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans = kplacesApart(al, 2);
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}
