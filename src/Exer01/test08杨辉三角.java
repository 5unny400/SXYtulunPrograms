package Exer01;

import java.util.Scanner;

public class test08杨辉三角 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        outPut(functionYang(x));
    }

    private static int[][] functionYang(int x) {
        int arr[][] = new int[x][x];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        return arr;
    }

    public static void outPut(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
