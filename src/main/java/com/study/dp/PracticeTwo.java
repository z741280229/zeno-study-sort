package com.study.dp;

/**
 * @program: zeno-study-sort
 * @description:在给出的一组数据中，可以找出一组数据，它们相加得到一个指定数据，可以返回为true，否则false。
 * @author: Zeno
 * @create: 2019-12-14 16:18
 **/
public class PracticeTwo {

    public static void main(String[] args) {
        int arr[] = {3,34,4,12,5,2};
    }


    /**
     * 递归方法
     * @param arr
     * @param i
     * @param sum
     * @return
     */
    public static boolean recSubSet(int arr[],int i,int sum){
        /*if (sum == 0){
            return true;
        }*/
        // 与sum == 0 效果相同，但是使用sum == arr[i] 少递归一次
        if (sum == arr[i]){
            return true;
        }
        if (i == 0){
            return sum == arr[0];
        }
        //当sum小于第i数时，两者相减出现负数，说明不必将此数算入，所以直接执行recSubSet(arr,i - 1,sum)
        if (sum < arr[i]){
            //return false;
            return  recSubSet(arr,i - 1,sum);
        }

        return recSubSet(arr,i - 1,sum - arr[i]) || recSubSet(arr,i - 1,sum);
    }
}
