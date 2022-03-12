package com.buaa.sort;
//nlog(2n)
//比较相邻的两个元素将大的放在后面
public class BubbleSort {
    public void bubble(int[] arr,int n){//将最大的排到最后
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }
    }
    public void bubbleSort(int[] arr,int n){
        for(int i=n;i>=1;i--){
            bubble(arr,i);
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort=new BubbleSort();
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        bubbleSort.bubbleSort(arr,11);
        for(int i:arr){
            System.out.println(i);
        }

    }

}
