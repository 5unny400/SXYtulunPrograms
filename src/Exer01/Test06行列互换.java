package Exer01;

import java.util.Scanner;

public class Test06行列互换 {
    public static void main(String[] args) {

        int arr[][] = inPut();
        exchangRowCol(arr);
        outPut(arr);
    }

    public static int[][] inPut(){
        Scanner scan = new Scanner(System.in);

        int row = 3,col = 3;

        int arr[][] = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                arr [i][j] = scan.nextInt();
            }
        }
        scan.close();
        return arr;
    }

    public static void exchangRowCol(int [][] arr){
        for(int i = 0;i<arr.length;i++) {
            for (int j = i; j < arr[i].length; j++){
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
        }
    }

    public static void outPut(int[][] arr){
        for(int i = 0;i<arr.length;i++) {
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
