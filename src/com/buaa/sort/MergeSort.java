package com.buaa.sort;

public class MergeSort {
    public static void main(String[] args) {

    }

    public ListNode sortList(ListNode head){
        if(head==null) return head;
        return mergeSort(head);
    }

    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=mergeSort(slow.next);
        slow.next=null;
        ListNode left=mergeSort(head);
        return mergeTwoList(left,right);
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if (l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next=mergeTwoList(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoList(l1,l2.next);
            return l2;
        }
    }
}
