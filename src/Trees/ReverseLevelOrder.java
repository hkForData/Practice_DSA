package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class ReverseLevelOrder {
	public ArrayList<ArrayList<Integer>> reverseOrder(TreeNode A){
		Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        ArrayList<ArrayList<Integer>> mainAns = new ArrayList<ArrayList<Integer>>();
        while(q.size() > 0){
            int sz = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i < sz; i++){
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if(temp.right != null) {
                    q.add(temp.right);
                }
                if(temp.left != null) {
                    q.add(temp.left);
                }
            }
            mainAns.add(ans);
        }
        Collections.reverse(mainAns);
        return mainAns;
	}

}
