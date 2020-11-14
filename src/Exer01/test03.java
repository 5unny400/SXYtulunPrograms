package Exer01;

import java.util.Scanner;

public class test03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();

        int result = 0;
        int num = 0;
        for(int i=1;i<=x;i++){
            num =0;
            for(int j=1;j<=i;j++){
                num = num*10+2;
            }
            result += num;
        }
        System.out.println(result);
    }
}
