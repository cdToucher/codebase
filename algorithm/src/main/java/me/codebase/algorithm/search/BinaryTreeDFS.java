package me.codebase.algorithm.search;

import me.codebase.algorithm.structure.TreeNode;

/**
 * Created by chendong on 2017/10/9.
 */
public class BinaryTreeDFS {

    //Depth-First-Search
    public static void dfs(TreeNode root) {
        if (root != null) {
            // 递归  DLR  前中后
            System.out.print(root.value);
            dfs(root.left);
            dfs(root.right);
        }
        /*
        Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()){
			TreeNode tmp = s.pop();
			System.out.print(tmp.val+" ");
			if(tmp.right!=null){
				s.push(tmp.right);
			}

			if(tmp.left!=null){
				s.push(tmp.left);
			}
		}
         */
    }

}


