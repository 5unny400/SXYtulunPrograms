package Exer04;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题号19:删除链表的倒数第n个节点
 * 给定一个链表，删除链表的倒数第n个节点并返回链表的头指针
 *
 * 例如，
 *  给出的链表为:1->2->3->4->5, n= 2.
 *  删除了链表的倒数第n个节点之后,链表变为1->2->3->5.
 * 备注：
 * 题目保证n一定是有效的
 * 请给出请给出时间复杂度为 O(n)的算法
 *
 *
 *
 * 时间限制(ms)	内存限制(MB)	提交量	通过量	通过率
 * 3000	64	0	0	0%
 * 标准输入:
 * {1, 2}
 *
 * 2
 *
 * 标准输出:
 * {2}
 */
class MainDelete {
    static class Node{
        private int x;
        private Node next;
        public int getX() {
            return x;
        }

        public Node getNext() {
            return next;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    static class LinkList{
        Node head;
        static int size;

        @Override
        public String toString() {
            //输出链表
            Node p = head;
            String s ="{";
            while(p!=null&&p.getNext()!=null){
                s += p.getX()+",";
                p = p.getNext();
            }
            s = s.substring(0,s.length()-1);
            s += "}";


            return s;
        }
    }

    public static void main(String args[]){
        LinkList linkList = new LinkList();
        linkList.head = new Node();
        Scanner scan = new Scanner(System.in);


        String n = scan.next();
        n = n.replace("{","");
        n = n.replace("}","");
        String arr[] = n.split(",");
        System.out.println(Arrays.toString(arr));
        LinkList.size = arr.length;

        Node tmp = linkList.head;
        int j =0;
        while(j < arr.length){

            tmp.setX(Integer.parseInt(arr[j]));
            Node node = new Node();
            tmp.setNext(node);
            tmp = tmp.getNext();
            j++;
        }

        //倒数第m个节点

        int m = scan.nextInt();

        Node p = linkList.head;
        int size = LinkList.size;
        Node q = null;
        for(int i =1;i<=size;i++){
            if(i == size-m+1){
                //删除节点
                //如果是头结点
                if(q == null){
                    linkList.head = p.getNext();
                    break;
                }
                //如果是尾节点
                //如果是中间结点
                q.setNext(p.getNext());
                break;
            }
            //后移指针
            q = p;
            p = p.getNext();

        }

        //输出链表
        System.out.println(linkList.toString());
    }

}
