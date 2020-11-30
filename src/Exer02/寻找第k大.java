package Exer02;

import java.util.Arrays;
import java.util.Scanner;

class MAIN {
    Scanner scanner;
    private int N;
    private int K;
    //存储数组
    private int arr[];

    private MAIN(){
        scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = scanner.nextInt();
        }
    }

    private void print(){
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String args[]){
        MAIN main = new MAIN();

main.print();
    }
}
