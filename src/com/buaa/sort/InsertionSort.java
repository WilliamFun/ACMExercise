package com.buaa.sort;
//将未排序的数字插入到排好序的数组中
public class InsertionSort {
    void insert(int[] arr,int n){
        int key=arr[n];
        int i=n;
        while (arr[i-1]>key){
            arr[i]=arr[i-1];
            i--;
            if(i==0) break;
        }
        arr[i]=key;
    }

    void insertSort(int[] arr,int n){
//        for(int i=1;i<n;i++){
//            insert(arr,i);
//        }
        for(int i=1;i<n;i++){
            int key=arr[i];
            int insertPos=i;
            while(arr[insertPos-1]>key){
                arr[insertPos]=arr[insertPos-1];
                insertPos--;
                if(insertPos==0) break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr={1,5,8,9,4,6,7,2,15,16,2};
        InsertionSort selectionSort=new InsertionSort();
        selectionSort.insertSort(arr,11);
        for(int i:arr){
            System.out.println(i);
        }
    }
}
