package com.buaa.writtentest.huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int ans = 0;
            if(n<=14){
                //判断题终止
                ans = cacul(10,n/2);
            }else if(n<=52){
                //单选题终止
                if((n-16)%4==0){
                    //错两个判断题的情况
                    ans += cacul(10,2);
                }
                if((n-18)%4==0){
                    //错1个判断题
                    int nums = (n-18)/4;
                    if(nums<8){
                        ans+=10;
                    }else{
                        ans+=cacul(10,2);
                    }
                }
                if((n-20)%4==0){
                    //错3个单选
                    int num = (n-20)/4;
                    if(num<7){
                        ans += 1;
                    }else{
                        ans += cacul(10,3);
                    }
                }
            }else {
                //多选题终止
                if(n==100){
                    System.out.println(1);
                    continue;
                }
                if((n-52)%8==0){
                    //2个单选
                    int n1 = (n-52)/8;
                    if(n1<4||n1==5){
                        ans += cacul(10,2);
                    }else{
                        ans+=cacul(10,2)*5;
                    }
                }
                if((n-56)%8==0){
                    //2判断+1单选
                    int n2 = (n-56)/8;
                    if(n2<4||n2==5){
                        ans += cacul(10,2)+10;
                    }else{
                        ans+=(cacul(10,2)+10)*5;
                    }
                }
                if((n-54)%8==0){
                    int n3 = (n-54)/8;
                    if(n3<4||n3==5){
                        ans += 100;
                    }else{
                        ans+=500;
                    }
                }
                if((n-58)%8==0){
                    int n4 = (n-58)/8;
                    if(n4<4||n4==5){
                        ans += 10;
                    }else{
                        ans += 50;
                    }
                }
                if((n-60)%8==0){
                    //前面没错
                    int n5 = (n-60)/8;
                    if(n5<2||n5==5){
                        ans += 1;
                    }else{
                        ans += cacul(5,n5);
                    }
                }

            }

            System.out.println(ans);
        }



    }

    public static int cacul(int m,int n){
        int up = 1;
        for(int i = 1;i<=m;i++){
            up *= i;
        }
        int nn = 1;
        for(int i = 1;i<=n;i++){
            nn *= i;
        }
        int x = 1;
        for(int i = 1;i<=m-n;i++){
            x *= i;
        }
        return up/(nn*x);

    }
}
