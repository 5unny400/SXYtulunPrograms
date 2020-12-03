package Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 * <p>
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 * 标准输入:
 * "abc1234321ab"
 * <p>
 * <p>
 * 12
 */
class Main {
    private char[] chars;

    private char tmpa;
    private char tmpb;
    private int result = 0;
    private int resultb = 0;
    private int j;

    private Main(char[] chars) {
        this.chars = chars;
    }

    private void function(int i, int label) {
        tmpa = chars[i - label];
        tmpb = chars[i];
        j = i;
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
        Main mainL = new Main(chars);
        mainL.process();

    }
}
