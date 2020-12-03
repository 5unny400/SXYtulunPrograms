package Exer02;

import java.util.Scanner;

class MAIN {
    Scanner scanner;
    private int N;
    private int K;
    //存储数组
    private int arr[];

    private MAIN() {
        scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
    }

    private void print() {
//        System.out.println(Arrays.toString(arr));
        System.out.println(arr[getKMax()]);
        //关闭输入
        scanner.close();
    }
    private static int partition(int low, int high, int[] arr) {
        int mark = arr[low];
        while (low < high) {
            //从后往前找比基准数据小的元素
            while (arr[high] >= mark && low < high) {
                high--;     //high可能会越界
            }
            if (low == high) {
                break;
            }
            if(arr[high]<mark){
                arr[low] = arr[high];
            }
            //从后往前找比基准数据小的元素
            while (arr[low] <= mark && low < high) {
                low++;
            }
            if (low == high) {
                break;
            }
            if(arr[low]>mark) {
                arr[high] = arr[low];
            }
        }
        arr[low] = mark;
        return low;
    }

    private int getKMax(){
        int low = 0;
        int high = arr.length-1;
        int mid = partition(low,high,arr);
        K = arr.length - K;
        while(K != mid){
            if(K > mid){
                mid = partition(mid+1,high,arr);
                low = mid+1;
            }else{
                mid = partition(low,mid-1,arr);
                high = mid-1;
            }
        }

        return mid;
    }
    public static void main(String args[]) {
        MAIN main = new MAIN();

        main.print();
    }
}
