package Exer01;

import java.util.Scanner;

class Test02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.close();

        int i =0;
        //将每一位存到数组里
        int arr[] = new int[16];
        while(num != 0){
            int x = num%10;
            arr[i++] = x;
            num = num/10;
        }
        //是不是回文数的标签
        boolean label = false;
        for(int x = 0;x<i/2;x++){
            if(arr[x] == arr[i-x-1]){
                label = true;
                continue;
            }else{
                label = false;
                break;
            }
        }
        System.out.print(label);


    }
}
