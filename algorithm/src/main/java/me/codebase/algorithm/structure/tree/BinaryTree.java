package me.codebase.algorithm.structure.tree;

import me.codebase.algorithm.structure.TreeNode;

import static me.codebase.algorithm.search.BinaryTreeBFS.bfs;
import static me.codebase.algorithm.search.BinaryTreeDFS.dfs;

/**
 * Created by chendong on 2017/9/21.
 */
public class BinaryTree {

    //构建一棵 完全二叉树
    public TreeNode[] build(int size) {
        TreeNode[] tree = new TreeNode[size];
        for (int i = 0; i < size; i++) {
            TreeNode node = new TreeNode(i);
            if (i % 2 != 0) {
                int index = (i >> 1);
                if (index >= 0 && index < size) {
                    tree[index].left = node;
                }
            } else {
                int index = (i >> 1) - 1;
                if (index >= 0 && index < size) {
                    tree[index].right = node;
                }
            }
            tree[i] = node;
        }
        return tree;
    }


    public static void main(String[] args) {
        TreeNode[] tree = new BinaryTree().build(10);
        dfs(tree[0]);
        System.out.println();
        bfs(tree[0]);
    }
}


