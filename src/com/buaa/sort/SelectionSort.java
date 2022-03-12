package com.buaa.sort;
//n平方
//每次遍历没排好序是数组，将最大值放到最后面
public class SelectionSort {
    public int findMaxPos(int[] arr,int n){
        int max=arr[0];
        int pos=0;
        for (int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                pos=i;
            }
        }
        return pos;
    }

    void select(int arr[],int n){
        while (n>1){
            int pos=findMaxPos(arr,n);
            int temp=arr[pos];
            arr[pos]=arr[n-1];
            arr[n-1]=temp;
            n--;
        }
    }

    public static void main(String[] args) {
//        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
//        SelectionSort selectionSort=new SelectionSort();
//        selectionSort.select(arr,11);
//        for(int i:arr){
//            System.out.println(i);
//        }
        String str="liupengyu";
        System.out.println(str.substring(0,4));;
    }
}
