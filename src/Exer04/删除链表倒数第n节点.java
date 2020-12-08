package Exer04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题号19:删除链表的倒数第n个节点
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 * 例如，
 * 给出的链表为:1->2->3->4->5, n= 2.
 * 删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是有效的
 * 请给出请给出时间复杂度为 O(n)的算法
 * 标准输入:
 * {1, 2}
 * <p>
 * 2
 * <p>
 * 标准输出:
 * {2}
 */
class MainDelete {
    static class Node {
        private int x;
        private Node next;

        public int getX() {
            return x;
        }

        Node getNext() {
            return next;
        }

        public void setX(int x) {
            this.x = x;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }

    static class LinkList {
        Node head;
        static int size;

        public LinkList() {
            head = new Node();
        }

        @Override
        public String toString() {
            //输出链表
            Node p = head;
            StringBuilder s = new StringBuilder("{");

            boolean label = false;
            while (p != null && p.getNext() != null) {
                s.append(p.getX()).append(",");
                p = p.getNext();
                label = true;
            }
            //如果有加入数据，去除末尾的‘,’
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
        //倒数第m个节点
        int m = scan.nextInt();
//        System.out.println(Arrays.toString(arr));
        //元素个数
        LinkList.size = arr.length;

        LinkList linkList = new LinkList();

        Node tmp = linkList.head;
        int j = 0;
        while (j < arr.length) {
            tmp.setX(Integer.parseInt(arr[j]));

            tmp.setNext(new Node());
            tmp = tmp.getNext();

            j++;
        }

        int size = LinkList.size;
        //遍历指针
        Node p = linkList.head;
        //指针q指向前一个节点
        Node q = null;
        for (int i = 1; i <= size; i++) {
            if (i == size - m + 1) {
                //删除节点
                //如果是头结点，q为null
                if (q == null) {
                    linkList.head = p.getNext();
                    break;
                }
                //如果是尾节点
                //如果是中间结点，q指向当前结点p的next
                q.setNext(p.getNext());
                break;
            }
            //后移指针
            q = p;
            p = p.getNext();
        }
        //利用重写后的方法，输出链表
        System.out.println(linkList.toString());
    }

}
