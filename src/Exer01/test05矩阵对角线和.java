package Exer01;

import java.util.Scanner;

public class test05矩阵对角线和 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int row = 3,col = 3;
        int xSum = 0,ySum = 0;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                int x = scan.nextInt();
                if(i == j){
                    xSum += x;
                }
                if(j == row - i-1){
                    ySum += x;
                }
            }
        }
        scan.close();
        System.out.println(xSum + " "+ySum);

    }
}
