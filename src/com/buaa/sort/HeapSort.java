package com.buaa.sort;

public class HeapSort {
    /*
    完全二叉树有如下性质：
    对于完全二叉树中的第 i 个数，它的左子节点下标：left = 2i + 1
    对于完全二叉树中的第 i 个数，它的右子节点下标：right = left + 1
    对于有 n 个元素的完全二叉树(n≥2)(n≥2)，它的最后一个非叶子结点的下标：n/2 - 1

    堆排序是不稳定的排序算法

    根据数学运算可以推导出初始化建堆的时间复杂度为O(n)
    重建堆的时间复杂度为 O(nlogn)
    所以堆排序总的时间复杂度为 O(nlogn)。

    堆排序的空间复杂度为 O(1)，只需要常数级的临时变量

     */

    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    void maxHeapify(int[] arr, int i, int heapSize){
        int l = 2*i+1;
        int r = l+1;
        int largest = i;
        if(l<heapSize&&arr[l]>arr[largest]){
            largest = l;
        }
        if(r<heapSize&&arr[r]>arr[largest]){
            largest = r;
        }
        if(largest!=i){
            //交换
            swap(arr,i,largest);
            //递归调用
            maxHeapify(arr,largest,heapSize);
        }

    }

    void buildMaxHeap(int[] arr){
        //从最后一个非叶子节点开始调整大顶堆
        for (int i = arr.length/2-1;i>=0;i--){
            maxHeapify(arr,i,arr.length);
        }
    }

    void heap_sort(int[] arr){
        buildMaxHeap(arr);
        //建好大顶堆
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("");
        for (int i = arr.length-1;i>0;i--){
            //当前大顶堆的根换到最后
            swap(arr,0,i);
            //剩下的继续维护大顶堆
            maxHeapify(arr,0,i);
        }

    }
    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] arr={2,5,3,1,10,4};
        heapSort.heap_sort(arr);
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}
