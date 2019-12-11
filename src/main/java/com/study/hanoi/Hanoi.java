package com.study.hanoi;

/**
 * @program: zeno-study-sort
 * @description:
 * @author: Zeno
 * @create: 2019-12-11 17:07
 **/
public class Hanoi {
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }

    /**
     * A B C 代表柱子编号  n代表需要需移动个数
     * @param n
     * @param A
     * @param B
     * @param C
     */
    public static void hanoi(int n,char A,char B,char C){
        if (n == 1){
            //从A直接移动到C
            System.out.println(A + "->" + C);
        }else{
            //将n-1快看成整体将A移动到B
            hanoi(n-1,A,C,B);
            //再将最后一块移动到C
            System.out.println(A + "->" + C);
            //最后将第一步中移动到B的n-1块移动到C
            hanoi(n-1,B,A,C);
        }
    }
}
