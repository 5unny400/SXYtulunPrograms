package Exer04;

import java.util.Scanner;

class MainR {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        if(x%4==0&&x%100!=0||x%400==0){
            System.out.println("L");
        }else{
            System.out.println("N");
        }
    }
}
