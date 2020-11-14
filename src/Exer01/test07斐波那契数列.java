package Exer01;

import java.util.Scanner;

public class test07斐波那契数列 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        System.out.println(function(x));
    }

    private static int function(int x) {
        int result = 0;
        if(x == 0){
            result = 0;
        }else if(x == 1){
            result = 1;
        }else{
            result = function(x -1)+function(x-2);
        }
        return result;

    }
}
