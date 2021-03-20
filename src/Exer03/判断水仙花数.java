package Exer03;

import java.util.Scanner;

/**
 * 题号14:水仙花数II
 * 请判断一个数是不是水仙花数。其中水仙花数定义各个位数立方和等于它本身的三位数
 * 数据包含一个整数n(100<=n<1000)输入0表示程序输入结束
 * 如果n是水仙花数就输出Yes否则输出No
 */
class MainS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x =scan.nextInt();
        do {
            if(x == 0) break;
            if (juge(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            x =scan.nextInt();
        }while(x != 0);
        scan.close();
    }

    private static boolean juge(int x) {
        int result = 0;
        int tmp;
        int xnum = x;

        while (x != 0) {
            tmp = x % 10;
            result = result + tmp * tmp * tmp;
            x = x / 10;
        }

        return result == xnum;
    }
}
