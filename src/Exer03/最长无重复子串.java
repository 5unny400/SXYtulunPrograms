package Exer03;

import java.util.Arrays;
import java.util.Scanner;

class Main2 {
    private int N;
    private char arr[];
    private static int resultLength;

    private Main2(int N, char arr[]) {
        this.N = N;
        this.arr = arr;
//        System.out.println(Arrays.toString(arr));
    }

    private void find() {
        int tmp = arr.length;
        for (int i = 0; i < tmp; i++) {
//            表示该字符与前边的字符重复
            resultLength++;

            for (int j = i; j < tmp; j++) {
                if (arr[i] == arr[j] && i != j) {
                    move(j);
                    tmp--;
                }
            }
        }

        System.out.println(resultLength);
    }

    private void move(int j) {
        for (int i = j; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            arr[i] = str.charAt(0);
        }

        Main2 main2 = new Main2(n,arr);
        main2.find();
    }
}
