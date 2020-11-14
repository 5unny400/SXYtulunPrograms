package Exer01;

import java.util.Scanner;

public class Test09最长公共子序列 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        scan.close();

        char[] s = maxPublicStr(str1,str2);
        if( s == null){
            System.out.println(-1);
        }else{
            System.out.println(s);
        }
    }

    private static char[] maxPublicStr(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        char[] same = new char[0];

        //动态规划




        return same;
    }


}
