package com.buaa.sort;

public class SelectionSort {

    //选择排序：双重循环遍历数组，每经过一轮比较，找到最小元素的下标，将其交换至首位
    public void selectionSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            int minindex = i;
            for (int j = i+1;j<arr.length;j++){
                if(arr[j]<arr[minindex]) minindex = j;
            }
            swap(arr,i,minindex);
        }
    }
    /*
    冒泡排序和选择排序有什么异同？
    相同点：
    都是两层循环，时间复杂度都为 O(n^2);
    都只使用有限个变量，空间复杂度 O(1)O(1)。
    不同点：
    冒泡排序在比较过程中就不断交换；而选择排序增加了一个变量保存最小值 / 最大值的下标，遍历完成后才交换，减少了交换次数。
    事实上，冒泡排序和选择排序还有一个非常重要的不同点，那就是：
    冒泡排序法是稳定的，选择排序法是不稳定的。

    而选择排序中，最小值和首位交换的过程可能会破坏稳定性。
    比如数列：[2, 2, 1]，在选择排序中第一次进行交换时，原数列中的两个 2 的相对顺序就被改变了，因此，我们说选择排序是不稳定的。

     */

    //二元选择排序：每轮选择时记录最小值和最大值，可以把数组需要遍历的范围缩小一倍
    public void selectionSort2(int[] arr){
        for (int i = 0;i<arr.length/2;i++){
            int minindex = i;
            int maxindex = i;
            for (int j = i+1;j<arr.length-i;j++){
                if(arr[j]>arr[maxindex]) maxindex = j;
                if(arr[j]<arr[minindex]) minindex = j;
            }
            if(minindex==maxindex) break;
            swap(arr,minindex,i);
            if(maxindex==i) maxindex = minindex;
            swap(arr,maxindex,arr.length-1-i);
        }
    }



    public void swap(int[] arr,int i,int j){
        if(i==j) return;
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

    public static void main(String[] args) {
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        SelectionSort selectionSort=new SelectionSort();
        selectionSort.selectionSort2(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
