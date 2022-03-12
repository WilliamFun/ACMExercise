package com.buaa.sort;

public class HeapSort {
    void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    void heapify(int[] tree,int n,int i){//让父节点大于子节点，对第i个节点操作
        if(i>=n) return;
        int c1=2*i+1;//i是父节点，c1  c2是子节点
        int c2=2*i+2;
        int max=i;
        if(c1<n&&tree[c1]>tree[max]){
            max=c1;
        }
        if(c2<n&&tree[c2]>tree[max]){
            max=c2;
        }//找到最大值
        if(max!=i){
            swap(tree,max,i);
            heapify(tree,n,max);
        }
    }

    void build_heap(int[] tree,int n){
        int last_node=n-1;
        int parent=(last_node-1)/2;
        for(int i=parent;i>=0;i--){
            heapify(tree,n,i);
        }
    }

    void heap_sort(int[] tree,int n){//根节点是最大值
        build_heap(tree,n);
        for(int i=n-1;i>=0;i--){
            swap(tree,i,0);
            heapify(tree,i,0);
        }
    }
    public static void main(String[] args) {
        HeapSort heapSort=new HeapSort();
        int[] tree={2,5,3,1,10,4};
        heapSort.heap_sort(tree,tree.length);
        for(int i:tree){
            System.out.println(i);
        }
    }
}
