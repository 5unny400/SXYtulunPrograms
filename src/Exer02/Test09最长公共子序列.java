package Exer02;

import java.util.Scanner;

class Main {
    char result[] ;
    static int size;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        scan.close();

        Main main = new Main();

        main.maxPublicStr(str1, str2);
    }

    private void maxPublicStr(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        String str = "";
        int arr[][] = new int[str2.length()][str1.length()];

        //变成矩阵
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (chars1[j] == chars2[i]) {
                    arr[i][j] = 1;
                }
            }
        }

        //输出显示矩阵
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(Arrays.toString(arr[i]));
//        }

        //寻找最长公共子序列


        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                char[] temp = new char[20];
                int t = 0;
                while (row < arr.length && col < arr[i].length) {
                    //如果等于0，从下一个开始遍历

                    //更新最长公共子序列
                    if (arr[row][col] == 0) {
                        if (result == null || t > size) {
                            size = t;
                            result = temp;
                        }
                        //row 和col重新赋值
                        row = i;
                        col = j;
                        break;
                    } else {
                        temp[t++] = chars2[row];
                        //row 和col重新赋值
                        row++;
                        col++;
                    }
                }
                //更新最长公共子序列
                if (result == null || t > size) {
                    size = t;
                    result = temp;
                }
            }
        }


        print(result);
    }

    public void print(char[] arr){
        int i =0;
        while( i < size ){
            System.out.print(arr[i++]);
        }
    }

}
