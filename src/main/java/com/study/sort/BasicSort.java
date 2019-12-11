package com.study.sort;

import java.util.*;

/**
基本排序
*/
public class BasicSort{


	public static void main(String[] args){

        int max = 10;
        Random random = new Random(max);
        int[] arr1 = new int[max];
        int[] arr2 = new int[max];
        for (int i = 0;i < max;i++){
            arr1[i] = random.nextInt(max);
            arr2[i] = arr1[i];
        }
        /*long start1 = System.currentTimeMillis();
        bubbleSort(arr1);
		//.out.println("be sort By bubbleSort:" + Arrays.toString(bubbleSort(arr)));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);*/

		/*int[] selectSort = new int[]{4,2,1,5,6,7,10,9,8,89,98,45,33,56};
		System.out.println("be sort By selectSort:" + Arrays.toString(selectSort(selectSort)));*/


        long start2 = System.currentTimeMillis();
		quickSort(arr2,0,arr2.length -1);
        long end2 = System.currentTimeMillis();
		System.out.println("be sort By quickSort:" + Arrays.toString(arr2));

        System.out.println(end2 - start2);

        /*long start1 = System.currentTimeMillis();
		System.out.println("be sort By heapfy:" + Arrays.toString(headfySort(arr2)));
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start2);*/

        long start1 = System.currentTimeMillis();
        headfySort2(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println("be sort By heapfy:" + Arrays.toString(arr1));
        System.out.println(end1 - start1);
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

		int falg = partitionDemo1(sort,left,right);
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
    public static int[] headfySort1(int[] arr){
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
        int leftNode = 2 * parent + 1;
        int rightNode = 2 * parent + 2;
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




    public static void headfySort2(int []arr){
        //1.构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }

    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * @param arr
     * @param i
     * @param length
     */
    public static void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] > temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
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