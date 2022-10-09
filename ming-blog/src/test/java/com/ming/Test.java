package com.ming;

/**
 * @Author: ming
 * @Date: 2022/10/09/11:23
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 0;
        if(a++ == b)
            a++;
        b++;
        if(b == c++)
            System.out.println(d = b % c + c / b * a );
        switch(a){
            case 1 :
                b += a;
            case 2 :
                d /= c;
            case 3 :
                a %= d;
        }
        System.out.println(a + b + "" + c + d);
        System.out.println(d++);
        System.out.println(c == ++b ? a + c : b * d );
    }
}

