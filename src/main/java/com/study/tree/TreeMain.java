package com.study.tree;

/**
 * @program: zeno-study-sort
 * @description:
 * @author: Zeno
 * @create: 2019-11-28 14:41
 **/
public class TreeMain {

    public static void main(String[] args) {
        int[] arr = {7,9,1,2,4};
        TreeNode tree = buildBST(arr);
        //inTraverseBTree(tree);
        System.out.println("Max Value:"+findMaxOrMinInBST(tree,-1));
        System.out.println("Min Value:"+findMaxOrMinInBST(tree,1));
        System.out.println("the height of tree:"+getBSTHeight(tree));
    }

    /**
     * 二叉搜索树的先序遍历依次为从小到大输出
     */
    public static void demo2() {
        int[] arr = {7,9,1,2,4,5,6,3,8};
        inTraverseBTree(buildBST(arr));
    }

    public static void demo1() {
        TreeNode tree1 = new TreeNode();
        TreeNode tree2 = new TreeNode();
        TreeNode tree3 = new TreeNode();
        TreeNode tree4 = new TreeNode();
        TreeNode tree5 = new TreeNode();
        tree1.setValue(10);
        tree2.setValue(9);
        tree3.setValue(20);
        tree4.setValue(15);
        tree5.setValue(35);

        tree1.setRightNode(tree3);
        tree1.setLeftNode(tree2);

        tree3.setLeftNode(tree4);
        tree3.setRightNode(tree5);

        System.out.println("----------先序遍历-----------");
        preTraverseBTree(tree1);
        System.out.println("----------中序遍历-----------");
        inTraverseBTree(tree1);
        System.out.println("----------后序遍历-----------");
        postTraverseBTree(tree1);
    }

    /**
     * 先序遍历（根左右）
     * @param treeNode
     */
    public static void preTraverseBTree(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        if (treeNode.getValue() != null){
            System.out.println(treeNode.getValue());
        }
        preTraverseBTree(treeNode.getLeftNode());
        preTraverseBTree(treeNode.getRightNode());
    }

    /**
     * 中序遍历（左根右）
     * @param treeNode
     */
    public static void inTraverseBTree(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        inTraverseBTree(treeNode.getLeftNode());
        if (treeNode.getValue() != null){
            System.out.println(treeNode.getValue());
        }
        inTraverseBTree(treeNode.getRightNode());
    }

    /**
     * 后序遍历（左右根）
     * @param treeNode
     */
    public static void postTraverseBTree(TreeNode treeNode){
        if (treeNode == null){
            return;
        }
        postTraverseBTree(treeNode.getLeftNode());
        postTraverseBTree(treeNode.getRightNode());
        if (treeNode.getValue() != null){
            System.out.println(treeNode.getValue());
        }
    }


    /**
     * 创建二叉搜索树（右 > 根 > 左）
     * @param value
     * @param tree
     */
    public static void createBST(int value,TreeNode tree){

        //根节点为空，将数据直接添加到根节点
        if (tree.getValue() == null){
            tree.setValue(value);
            return;
        }
        //将小于根节点的数据放在左子树，将大于根节点的数据放在右子树
        if (tree.getValue() < value){
            //构建右子树
            if (tree.getRightNode()== null){
                //将大于根的值放入到根的右孩子树
                TreeNode rightNode = new TreeNode();
                rightNode.setValue(value);
                tree.setRightNode(rightNode);
                return;
            }else{
                createBST(value,tree.getRightNode());
            }
        }else {
            //构建左子树
            if (tree.getLeftNode() == null){
                TreeNode leftNode = new TreeNode();
                leftNode.setValue(value);
                tree.setLeftNode(leftNode);
                return;
            }else{
                createBST(value,tree.getLeftNode());
            }
        }
    }

    /**
     * 构建二叉树
     * @param arr
     * @return
     */
    public static TreeNode buildBST(int[] arr){
        TreeNode tree = new TreeNode();
        for (int i = 0; i < arr.length; i++){
            createBST(arr[i],tree);
        }
        return tree;
    }

    /**
     * 求二叉搜索树中最大值（最小值） 此例中只做正数测试 type为1就最大值，为-1求最小值
     * @param tree
     * @param type
     * @return
     */
    public static int findMaxOrMinInBST(TreeNode tree,int type){
        //判断是否只有一个节点
        if (tree.getValue() == null){
            return -1;
        }else{
            if (tree.getLeftNode() == null && tree.getRightNode() == null){
               return tree.getValue();
            }
        }

        //BST中最左边子树，存放最小值
        if (type == -1) {
            while (tree.getLeftNode() != null) {
                tree = tree.getLeftNode();
            }
            return tree.getValue();
        }

        //BST中最右边子树，存放最大值
        if (type == 1){
            while (tree.getRightNode() != null) {
                tree = tree.getRightNode();
            }
            return tree.getValue();
        }
        return -1;
    }

    /**
     * 求BST高度
     * @param tree
     * @return
     */
    public static int getBSTHeight(TreeNode tree){
        if (tree == null || tree.getValue() == null){
            return 0;
        }else {
            if (tree.getRightNode() == null && tree.getLeftNode() == null){
                return 1;
            }
        }
        //左子树高度
        int leftHeight = getBSTHeight(tree.getLeftNode());
        //右子树高度
        int rightHeight = getBSTHeight(tree.getRightNode());

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

}


