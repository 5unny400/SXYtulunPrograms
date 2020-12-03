package Exer03;


import java.util.Scanner;

class Main {
    private Scanner scanner;

    private Main() {
        scanner = new Scanner(System.in);

    }

    private void print() {
        int x = scanner.nextInt();
        while (x != 0) {

            if (juge(x)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            x = scanner.nextInt();
        }
        System.out.println();
    }

    private boolean juge(int x) {
        if (x < 100 || x >= 1000) {
            return false;
        }

        int result = 0;
        int tmp = 0;
        int xnum = x;
        while (x != 0) {
            tmp = x % 10;
            result = result + tmp * tmp * tmp;
            x = x / 10;
        }
        return result == xnum;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.print();
    }
}
