package com.study.sort;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

/**
 * @program: zeno-study-sort
 * @description: 堆排序
 * @author: Zeno
 * @create: 2019-11-26 14:28
 **/
public class HeapifySort {

    public static void main(String[] args) {

        /*int max = 100000;
        int[] tree = new int[max];
        Random random = new Random(max);
        for (int i = 0;i < max;i++){
            tree[i] = random.nextInt(max);
        }

        int n = tree.length;
        long startTime = System.currentTimeMillis();
        heapSort(tree,n);
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);*/
        int tree[] = {4,10,3,5,1,2,11};
        heapSort(tree,tree.length);


    }

    /**
     *
     * @param tree
     * @param n 树的节点数
     * @param i 末尾节点
     */
    public static void heapify(int tree[],int n,int i){
        if (i >= n){
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;

        if (c1 < n && tree[c1] > tree[max]){
            max = c1;
        }

        if (c2 < n && tree[c2] > tree[max]){
            max = c2;
        }



        if (max != i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    /**
     * 构建大顶堆
     * @param tree
     * @param n
     */
    public static void buildHeap(int tree[],int n){
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;
        for (int i = parent;i >= 0; i--){
            heapify(tree,n,i);
        }
    }

    public static void heapSort(int tree[],int n){
        //构建大顶堆

        buildHeap(tree,n);
        System.out.println(Arrays.toString(tree));
        System.out.println("----------------------");
        for (int i = n - 1;i >= 0;i--){//将构建完成的大顶堆中的首个节点和末尾节点进行交换，找出最大值，砍掉末尾节点，重新堆化
            System.out.println("i:"+i);
            swap(tree,i,0);
            heapify(tree,i,0);
            System.out.println(Arrays.toString(tree));
        }
    }


    public static void swap(int[] tree,int left,int right){
        if (tree.length == 0|| tree == null){
            return;
        }
        int temp = tree[left];
        tree[left] = tree[right];
        tree[right] = temp;
    }
}
