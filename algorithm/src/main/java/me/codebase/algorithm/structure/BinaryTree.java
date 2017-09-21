package me.codebase.algorithm.structure;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by chendong on 2017/9/21.
 */
public class BinaryTree {

    class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }

    //构建一棵 完全二叉树
    private Node[] build(int size) {
        Node[] tree = new Node[size];
        for (int i = 0; i < size; i++) {
            Node node = new Node(i);
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


    //Breadth-First-Search
    public static void bfs(Node node) {
        if (node != null) {
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node tmp = queue.poll();
                System.out.print(tmp.value);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }

                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
    }

    //Depth-First-Search
    public static void dfs(Node node) {
        if (node != null) {
            // 递归  DLR  前中后
            System.out.print(node.value);
            dfs(node.left);
            dfs(node.right);
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

    public static void main(String[] args) {
        Node[] tree = new BinaryTree().build(10);
        dfs(tree[0]);
        System.out.println();
        bfs(tree[0]);
    }
}


