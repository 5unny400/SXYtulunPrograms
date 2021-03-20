package Exer03;

import java.util.Scanner;

/**
 * 题号18:子数组的最大累加和问题
 * 给定一个数组arr，返回子数组的最大累加和
 * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
 * [要求]
 * 时间复杂度为O(n)，空间复杂度为O(1)
 */
class MainC {
    public static void main(String[] args) {
        int tmp;
        int result = 0;
        int thisNum = 0;
        int i = 0;
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        Scanner input = new Scanner(line);
        while (input.hasNextInt()) {
            tmp = input.nextInt();
            thisNum += tmp;
            if (thisNum > result) {
                result = thisNum;
            }
            if (thisNum < 0) {
                if (i == 0) {
                    result = thisNum;
                }
                thisNum = 0;

            }
            i++;
        }
        System.out.print(result);
        scan.close();
        input.close();
    }
}
