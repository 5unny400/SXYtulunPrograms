package Exer03;

import java.util.Scanner;

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
