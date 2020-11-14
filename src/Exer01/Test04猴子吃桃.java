package Exer01;

import java.util.Scanner;

public class Test04猴子吃桃 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        scan.close();

        int total = 1;
        for(int i =0;i<x-1;i++){
            total = (total +1)*2;
        }
        System.out.println(total);

    }
}
