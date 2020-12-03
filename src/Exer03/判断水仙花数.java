package Exer03;

import java.util.Scanner;

class MainS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        while ((x = scan.nextInt())!= 0) {
            if (juge(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        scan.close();
    }

    public static boolean juge(int x) {
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
