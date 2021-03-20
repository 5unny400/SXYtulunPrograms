package Exer05;

import java.util.Stack;
import java.util.Scanner;

class MainC {
    private char[] arr = {
            'a', 'b', 'c', 'd', 'e',
            'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y',
            'z'
    };
    private char[] array;

    private int kindNum;

    public MainC(String str) {
        str = str.substring(1,str.length()-1);
        this.array = str.toCharArray();
        kindNum = 0;
    }

    public void getResult(int index, Stack stack) throws ClassCastException {
        if (index < 0) {
            //出栈的顺序，输出栈内整型值对应的字符
            int i = stack.size();
            while (i > 0) {
                i--;
                System.out.print(arr[(int) stack.get(i)]);
            }
            kindNum++;

            System.out.println();
        } else {

            int x = Integer.parseInt(String.valueOf(array[index]));
            if (index == array.length - 1) {
                //第一个字符直接入栈,整型栈
                stack.push(x);
                //递归
                getResult(index - 1, stack);
            } else {
                String tmp = array[index] + String.valueOf(stack.peek());
                int y = (Integer.parseInt(tmp));
                if (y > 9 && y < 26) {
                    //结合了一个字符，就要出栈顶数字
                    stack.pop();
                    //入新结合数值
                    stack.push(y);
                    //递归
                    getResult(index - 1, stack);
                    //出结合的数值
                    stack.pop();
                    //入原来的各位数值
                    stack.push(Integer.parseInt(String.valueOf(array[index + 1])));
                }
                //递归，仅仅单个数值
                stack.push(x);
                getResult(index - 1, stack);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入一段数字密文：");
        String str = scan.nextLine();
        MainC translate = new MainC(str);

        System.out.println("可能结果如下：");

        Stack stack = new Stack();
        translate.getResult(translate.array.length - 1, stack);
        System.out.println(translate.kindNum);
    }


}
