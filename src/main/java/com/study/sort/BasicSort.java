package com.study.sort;

import java.util.*;

/**
基本排序
*/
public class BasicSort{


	public static void main(String[] args){
		/*int[] bubbleSort = new int[]{3,2,1,5,6,7,10,9,8};
		System.out.println("be sort By bubbleSort:" + Arrays.toString(bubbleSort(bubbleSort)));

		int[] selectSort = new int[]{4,2,1,5,6,7,10,9,8,89,98,45,33,56};
		System.out.println("be sort By selectSort:" + Arrays.toString(selectSort(selectSort)));*/

		/*int[] qs= new int[]{6,1,2,7,9,3,4,5,10,8};
		quickSort(qs,0,qs.length -1);
		System.out.println("be sort By quickSort:" + Arrays.toString(qs));*/

		int[] tree = new int[]{6,1,2,7,9,3,4,5,10,8,6,8,0};
		System.out.println("be sort By heapfy:" + Arrays.toString(headfySort(tree)));
	}


    /**
     * 冒泡排序
     * @param sort
     * @return
     */
	public static int[] bubbleSort(int[] sort){
		if (sort.length == 0 || sort == null) {
			System.out.println("invalid data");
			return sort;
		}
		int temp = sort[0];
		for (int i = sort.length; i > 0 ; i-- ) {
				for (int j = 0 ; j < i - 1 ; j++) {  
					if (sort[j] > sort[j+1]) {
						temp = sort[j];
						sort[j] = sort[j+1];
						sort[j+1] = temp;
					}
				}
			}	

	    return sort;
	}

    /**
     * 选择排序
     * @param sort
     * @return
     */
	public static int[] selectSort(int[] sort){

		if (sort.length == 0 || sort == null) {
			System.out.println("invalid data");
			return sort;
		}

		int temp = sort[0];
		for(int i = 0;i < sort.length;i++){
			for(int j = i+1; j < sort.length;j++){
				if (sort[j] < sort[i]) {
					temp = sort[j];
					sort[j] = sort[i];
					sort[i] = temp;
				}
			}
		}
		return sort;
	}

    /**
     * 快速排序
     * @param sort
     * @param left
     * @param right
     */
	public static void quickSort(int[] sort,int left,int right){

		if (sort.length == 0 || sort == null) {
			System.out.println("invalid data");
		}

		if (left > right) {
			return;
		}

		int falg = partitionDemo2(sort,left,right);
		quickSort(sort,left,falg -1);
		quickSort(sort,falg + 1,right);
	}

	public static int partitionDemo3(int[] arr,int left,int right){
		int basicInt = arr[left];
		int remarkLeft = left;
		int temp = arr[left];
		while(right > left){
			if (arr[right] <= basicInt && right > left) {
				if (arr[left] >= basicInt && left < right) {
					temp = arr[right];
					arr[right] = arr[left];
					arr[left] = temp;
					right--;
				}

				left++;
			}

			if (arr[right] > basicInt) {
				right--;
			}

			if (right == left) {
				int flag = arr[0];
				flag = arr[remarkLeft];
				arr[remarkLeft] = arr[right];
				arr[right] = flag;
				System.out.println(Arrays.toString(arr));
			}
		}
		return left;
	}

    public static int partitionDemo1(int[] arr,int left,int right){
        int remarkLeft = left;
        //temp is basic number
        int temp = arr[left];
        int swap = arr[left];
        while(left < right){
            while(arr[right] >= temp && right > left){
                right--;
            }
            //存在问题，如果出现arr[left]一开始就等于temp，就不进行下一步探测
            while(arr[left] <= temp && right > left){
                left++;
            }
            if (left < right) {
                swap = arr[left];
                arr[left] = arr[right];
                arr[right] = swap;
            }
        }
        arr[remarkLeft] = arr[right];
        arr[right] = temp;
        return right;
    }

    public static int partitionDemo2(int[] arr,int left,int right){
        int i = left, j = right;
        int tmp = arr[left];
        while (i < j) {
            while (i < j && arr[j] > tmp){
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                i++;
            }
            while (i < j && arr[i] < tmp) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = tmp;
        return i;
    }

    /**
     * 堆排序
     * @param arr
     */
    public static int[] headfySort(int[] arr){
	    for (int i = arr.length - 1;i >= 0;i--){

	        heapfyArr(arr,i,(i-1)/2);
	        swap(arr,0,i);
        }
	    return arr;
    }

    /**
     * 对数组进行堆化
     * @param tree
     */
    public static void heapfyArr(int[] tree,int length,int parent){
        if (parent < 0){
            return;
        }
        //开始比较父节点与子节点的大小，并做交换,leftNode：父节点下的左节点下标，rightNode：父节点下的右节点下标
        int leftNode = 2 * parent + 1; //1
        int rightNode = 2 * parent + 2; //2
        //2,10,9,5,7,8
        while (parent >= 0){
            //父节点与左孩子节点比较
            if (leftNode <= length && tree[leftNode] > tree[parent]  ){
                swap(tree,leftNode,parent);
                heapfyArr(tree,length,leftNode);
            }
            //父节点与右孩子节点比较
            if (rightNode <= length && tree[rightNode] > tree[parent]){
                swap(tree,rightNode,parent);
                heapfyArr(tree,length,rightNode);
            }
            parent--;
            heapfyArr(tree,length,parent);
        }
    }

    /**
     * 数组交换
     * @param tree
     * @param left
     * @param right
     */
    public static void swap(int[] tree,int left,int right){
        if (tree.length == 0|| tree == null){
            return;
        }
        int temp = tree[left];
        tree[left] = tree[right];
        tree[right] = temp;
    }





}