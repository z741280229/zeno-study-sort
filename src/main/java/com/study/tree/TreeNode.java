package com.study.tree;

/**
 * @program: zeno-study-sort
 * @description:
 * @author: Zeno
 * @create: 2019-11-28 14:39
 **/
public class TreeNode {

    //树值
    private Integer value;
    //右节点
    private TreeNode rightNode;
    //左节点
    private TreeNode leftNode;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }
}
