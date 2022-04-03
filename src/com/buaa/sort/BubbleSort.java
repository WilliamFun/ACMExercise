package com.buaa.sort;
//nlog(2n)
//比较相邻的两个元素将大的放在后面
public class BubbleSort {
    public void bubbleSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]) swap(arr,j,j+1);
            }
        }
    }

    //冒泡优化1：如果一轮比较中没有发生过交换，则立即停止排序，因为此时剩余数字一定已经有序了
    public void bubbleSort_2(int[] arr){
        boolean swapped = true;
        for (int i = 0;i<arr.length-1;i++){
            if(!swapped) break;
            swapped = false;
            for (int j = 0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    swapped = true;
                }
            }
        }
    }

    //冒泡优化2：
    public void bubbleSort_3(int[] arr){
        boolean swapped = true;
        int lastIndexOfUnsortedElement = arr.length-1;
        int lastSwappedIndex = -1;
        while (swapped){
            swapped = false;
            for (int i = 0;i<lastIndexOfUnsortedElement;i++){
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                    swapped = true;
                    lastSwappedIndex = i;
                }
            }
            lastIndexOfUnsortedElement = lastSwappedIndex;
        }
    }




    public static void main(String[] args) {
        //它的空间复杂度为 O(1)，时间复杂度为 O(n^2)，第二种、第三种冒泡排序由于经过优化，最好的情况下只需要O(n)O(n)的时间复杂度。
        BubbleSort bubbleSort=new BubbleSort();
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        bubbleSort.bubbleSort_3(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }

    }

    public void swap(int[] arr,int i,int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;

//        arr[i] = arr[i]^arr[j];
//        arr[j] = arr[i]^arr[j];
//        arr[i] = arr[i]^arr[j];

          arr[i] = arr[i]+arr[j];
          arr[j] = arr[i]-arr[j];
          arr[i] = arr[i]-arr[j];
    }

}
