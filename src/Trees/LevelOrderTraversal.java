package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A){
		Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        ArrayList<ArrayList<Integer>> mainAns = new ArrayList<ArrayList<Integer>>();
        while(q.size() > 0){
            int sz = q.size();
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i=0; i < sz; i++){
                TreeNode temp = q.poll();
                ans.add(temp.val);
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
            mainAns.add(ans);
        }
        return mainAns;
	}

}
