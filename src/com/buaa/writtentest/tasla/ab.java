package com.buaa.writtentest.tasla;

public class ab {

    public static void main(String[] args) {
        int[] blocks = new int[]{1,1};
        System.out.println(solution2(blocks));
    }
    public static boolean solution(String S) {
        // write your code in Java SE 8
        int flag = 0;
        for (int i = 0;i<S.length();i++){
            if(flag==0&&S.charAt(i)=='a'){
                continue;
            }
            if(flag==0&&S.charAt(i)=='b'){
                flag=1;
            }
            if(flag==1&&S.charAt(i)=='a'){
                return false;
            }
        }
        return true;
    }

    public static int solution2(int[] blocks) {
        // write your code in Java SE 8
        int l = 0;
        int r = blocks.length-1;
        int ans = 0;
        while(r-l+1>ans){
            int cur = l+1;
            int pre = blocks[l];
            int same = cur;
            while (cur<r){
                if(pre<blocks[cur]&&blocks[cur]>blocks[cur+1]) break;
                if(blocks[cur]!=blocks[cur+1]) pre = blocks[cur];
                if(blocks[cur]==blocks[cur+1]&&blocks[cur-1]!=blocks[cur]) same = cur;
                cur++;
            }
            if(cur-l+1>ans){
                ans = cur-l+1;
            }
            if(same-l<=r-cur){
                l = same;
            }else {
                r = cur;
            }
        }
        return ans;
    }
}
