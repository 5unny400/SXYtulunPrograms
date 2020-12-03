package Exer03;

import java.util.Scanner;

class MainC {
    public static void main(String[] args) {
        int tmp;
        int result = 0;
        int thisNum = 0;

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
                thisNum = 0;
            }
        }
        System.out.print(result);
        scan.close();
        input.close();
    }
}
