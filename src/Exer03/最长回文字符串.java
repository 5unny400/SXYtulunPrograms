package Exer03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题号17:最长回文字符串
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
class MainL {
    private char[] chars;

    private int result = 0;
    private int resultb = 0;

    private MainL(char[] chars) {
        this.chars = chars;
    }

    private void function(int i, int label) {
        char tmpa = chars[i - label];
        char tmpb = chars[i];
        int j = i;
        while (j < chars.length - 1 && tmpa == tmpb) {
            resultb++;
            tmpb = chars[j++];
            if (i - resultb - label + 1 > -1) {
                tmpa = chars[i - resultb - label + 1];
            } else {
                break;
            }
        }
        if (tmpa != tmpb) {
            resultb--;
        }
        if (label == 1) {
            if (2 * resultb > result) {
                result = 2 * resultb;
            }
        } else if (label == 2) {
            if (2 * resultb + 1 > result) {
                result = 2 * resultb + 1;
            }
        }
        resultb = 0;
    }

    //查找最长回文序列，输出其长度
    private void process() {
        for (int i = 0; i < chars.length; i++) {
            if (i - 1 > -1 && chars[i] == chars[i - 1]) {

                function(i, 1);

            } else if (i - 2 > -1 && chars[i] == chars[i - 2]) {
                function(i, 2);
            }

        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();

        int n = scanner.nextInt();

        char[] chars;
        chars = str.toCharArray();
        char[] tmp = new char[n];
        for(int i =0;i<n;i++){
            tmp[i] = chars[i+1];
        }

        MainL mainL = new MainL(tmp);
//        System.out.println(Arrays.toString(tmp));
        mainL.process();

    }
}
