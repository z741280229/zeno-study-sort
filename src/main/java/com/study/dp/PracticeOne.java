package com.study.dp;

/**
 * @program: zeno-study-sort
 * @description: 在一组数据中，找出一组数据相加和最大的值，前提每个数不能相邻
 * @author: Zeno
 * @create: 2019-12-14 14:15
 **/
public class PracticeOne {

    public static void main(String[] args) {
        int arr[] = {1,2,4,1,7,8,3};
        System.out.println(revOpt(arr,arr.length - 1));
        System.out.println(dpOpt(arr));
    }


    /**
     * 非递归方法
     * @param arr
     * @return
     */
    public static int dpOpt(int arr[]){
        if (arr.length == 1){
            return arr[0];
        }
        if (arr.length == 2){
            return max(arr[0],arr[1]);
        }
        for (int i = 2;i < arr.length; i++){
            arr[i] = max(arr[ i - 2 ]+arr[ i ],arr[ i - 1 ]);
        }
        return arr[arr.length - 1];
    }

    /**
     *递归方法会产生很多重叠子问题
     * @param arr
     * @param i
     */
    public static int revOpt(int arr[],int i){
        if (i == 0){
            return arr[0];
        }
        if (i == 1){
            return max(arr[0],arr[1]);
        }
        int notSelect = revOpt(arr,i -1);
        int selected = revOpt(arr,i -2) + arr[i];
        return max(notSelect,selected);
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static int max(int a,int b){
        return a > b ? a : b;
    }
}
