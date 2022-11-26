package com.lu.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lupeng
 * @Date 2022/9/27
 */
public class Tree_01_构建 {
    // 节点类
    static class TreeNode {
        // 节点值
        int val;

        // 左节点
        TreeNode left;

        // 右节点
        TreeNode right;

        // 节点的构造函数(默认左右节点都为null)
        public TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
        /**
         * 根据数组构建二叉树
         * @param arr 树的数组表示
         * @return 构建成功后树的根节点
         */
        public TreeNode constructBinaryTree(final int[] arr) {
            List<TreeNode> treeNodeList = arr.length > 0 ? new ArrayList<>(arr.length) : null; //储存所有节点
            TreeNode root = null;
            for (int i = 0; i < arr.length; i++) {
                TreeNode node = null;
                if (arr[i] != -1){ // 用 -1 表示null
                    node = new TreeNode(arr[i]);
                }
                treeNodeList.add(node);
                if (i == 0){
                    root = node;
                }
            }
            for (int i = 0; i * 2 < arr.length; i++) {
                TreeNode node = treeNodeList.get(i);
                if (node != null){
                    node.left = treeNodeList.get(i * 2 + 1);
                    //判断数据是否越界
                    if (i * 2 + 2 < arr.length){
                        node.right = treeNodeList.get(2 * i +2);
                    }
                }
            }
            return root;
        }
    }
}
