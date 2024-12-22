package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class SpecialMedian {
	
	public static int solve(ArrayList<Integer> A) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i=A.size()-1;i>=0;i--){
            temp.add(A.get(i));
        }
        if(checkMedian(A) || checkMedian(temp)){
            return 1;
        }
        return 0;
    }

    static boolean checkMedian(ArrayList<Integer> A){
        //Max heap(For max heap we just need to reverse PriorityQueue using collections.reverseOrder())
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        //Min heap
        PriorityQueue<Integer> right = new PriorityQueue<>();
       return false;
    }
	
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(2);
		al.add(4);
		al.add(3);
		int ans = solve(al);
		System.out.println(ans);
	}

}
