package Exer04;

import java.util.Scanner;

/**
 * 题号38:链表的奇偶重排
 * 给定一个单链表，请设定一个函数，讲链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值
 * 时间限制(ms)	内存限制(MB)	提交量	通过量	通过率
 * 3000	64	0	0	0%
 * 标准输入:
 * {1,2,3,4,5,6}
 * 标准输出:
 * {1,3,5,2,4,6}
 */
class MainOM {
    static class Node{
        private int num;
        private Node next;

        void setNum(int num) {
            this.num = num;
        }

        int getNum() {
            return num;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

    private static class LinkList{
        private Node head;
        private Node tail;
        private int size;

        LinkList() {
            tail = head = new Node();
            size = 0;
        }

        @Override
        public String toString() {
            //输出链表
            Node p = head;
            StringBuilder s = new StringBuilder("{");

            boolean label = false;
            for(int i =1;i<=size;i++) {
                s.append(p.getNum()).append(",");
                p = p.getNext();
                label = true;
            }
            //去除末尾的‘,’
            if(label) {
                s = new StringBuilder(s.substring(0, s.length() - 1));
            }

            s.append("}");
            return s.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.next();
        n = n.replace("{", "");
        n = n.replace("}", "");
        String[] arr = n.split(",");

        //存放奇数位的数字
        LinkList linkList1 = new LinkList();
        //存放偶数位的数字
        LinkList linkList2 = new LinkList();

        for(int i =0;i<arr.length;i++){
            Node tmp = new Node();
            tmp.setNum(Integer.parseInt(arr[i]));

            //奇数位
            if(i%2==0){
                add(linkList1,tmp);
            }else{  //偶数位
                add(linkList2,tmp);
            }
        }

        linkList1.tail.setNext(linkList2.head);
        linkList1.tail = linkList2.tail;
        linkList1.size += linkList2.size;
        System.out.println(linkList1.toString());
//
//        linkList2.tail = null;
//        linkList1.tail = null;
//        linkList2.head = null;
//        linkList1.head = null;
    }

    private static void add(LinkList linkList,Node newNode){
        linkList.tail.setNext(newNode);
        linkList.tail = newNode;

        linkList.size++;
        if(linkList.size == 1) {
            linkList.head = linkList.tail;
        }
    }
}
