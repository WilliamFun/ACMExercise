package com.buaa.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums={1,5,6,2,3,4,8,9,2,1,0,6,158};
        //mergeSort2(nums,0, nums.length-1);
        int[] result = new int[nums.length];
        mergeSort(nums,0,nums.length-1,result);
        for(int i:nums){
            System.out.print(i+" ");
        }
    }
    /*
    拆分数组的过程中，会将数组拆分 logn 次，每层执行的比较次数都约等于 n 次，所以时间复杂度是 O(nlogn)
    空间复杂度是 O(n)，主要占用空间的就是我们在排序前创建的长度为 n 的 result 数组
    归并排序是一种稳定的排序算法
     */

    public static int[] mergeSort(int[] arr,int start,int end){
        //只有一个数，认为有序
        if(start==end) return new int[]{arr[start]};
        int mid = (end+start)>>1;
        int[] left = mergeSort(arr,start,mid);
        int[] right = mergeSort(arr,mid+1,end);
        return merge(left,right);
    }

    private static int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length+arr2.length];
        int index1 = 0,index2 = 0;
        //选取小的加入新数组
        while (index1<arr1.length&&index2< arr2.length){
            if(arr1[index1]<=arr2[index2]){
                result[index1+index2] = arr1[index1++];
            }else {
                result[index1+index2] = arr2[index2++];
            }
        }
        //将剩余数字补到结果数组之后
        while (index1<arr1.length) result[index1+index2] = arr1[index1++];
        while (index2< arr2.length) result[index1+index2] = arr2[index2++];

        return result;

    }

    //减少递归新建对象
    private static void mergeSort(int[] arr, int start, int end, int[] result){
        if(start==end) return;
        int mid = (start+end)>>1;
        mergeSort(arr,start,mid,result);
        mergeSort(arr,mid+1,end,result);
        merge(arr, start, end, result);
    }

    private static void merge(int[] arr, int start, int end, int[] result){
        int end1 = (start+end)>>1;
        int start2 = end1+1;
        int index1 = start,index2 = start2;
        while (index1<=end1&&index2<=end){
            if(arr[index1]<=arr[index2]){//保证稳定性，如果这里的比较条件写成了arr[index1] < arr[index2]，则归并排序将变得不稳定
                result[index1+index2-start2] = arr[index1++];
            }else{
                result[index1+index2-start2] = arr[index2++];
            }
        }
        while (index1<=end1){
            result[index1+index2-start2] = arr[index1++];
        }
        while (index2<=end){
            result[index1+index2-start2] = arr[index2++];
        }

        while (start<=end){
            arr[start] = result[start];
            start++;
        }

    }


    //原地归并（插入排序）
    public static void mergeSort2(int[] arr,int start,int end){
        //只有一个数，认为有序
        if(start==end) return;
        int mid = (end+start)>>1;
        mergeSort2(arr,start,mid);
        mergeSort2(arr,mid+1,end);
        merge(arr,start,end);
    }

    private static void merge(int[] arr, int start,int end){
        int end1 = (start+end)>>1;
        int start2 = end1+1;
        int index1 = start,index2 = start2;
        //原地移动数组
        while (index1<=end1&&index2<=end){
            if(arr[index1]<=arr[index2]){
                index1++;
            }else {
                int value = arr[index2];
                int index = index2;
                while (index>index1){
                    arr[index] = arr[index-1];
                    index--;
                }
                //index == index1
                arr[index] = value;
                index1++;
                index2++;
                //起到剩余数字补到结果数组的作用
                end1++;
            }
        }
    }





}
