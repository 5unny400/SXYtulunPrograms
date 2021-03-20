package Exer05;

import java.util.Scanner;

class MainA {
    static class Node {
        private int num;
        private Node next;
        private Node pre;

        Node getPre() {
            return pre;
        }

        void setPre(Node pre) {
            this.pre = pre;
        }


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

    private static class LinkList {
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
            StringBuilder s = new StringBuilder("");

            boolean label = false;
            for (int i = 0; i < size; i++) {
                s.append(p.getNum()).append(",");
                p = p.getNext();
                label = true;
            }
            //去除末尾的‘,’
            if (label) {
                s = new StringBuilder(s.substring(0, s.length() - 1));
            }

            return s.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        int K = scan.nextInt();

        String[] num = str.split(",");
        LinkList linkList = new LinkList();
        for (int i = 0; i < num.length; i++) {
            int tmp = Integer.parseInt(num[i]);
            //调用函数插入排序
            insert(linkList, tmp);
        }

        outPrint(linkList, K);
    }

    //插入排序
    private static void insert(LinkList linkList, int tmp) {
        //遍历指针
        Node p = linkList.head;
        //封装新节点
        Node newNode = new Node();
        newNode.setNum(tmp);


        //只有一个元素的时候直接连上
        if (linkList.size == 0) {
            linkList.tail = newNode;
            linkList.tail.setNext(null);
            linkList.head = linkList.tail;
        } else if (linkList.size == 1) {
            if(p.getNum() < tmp){
                newNode.setPre(linkList.tail);
                linkList.tail.setNext(newNode);

                linkList.tail = newNode;
            }else{
                newNode.setNext(linkList.head);
                linkList.head.setPre(newNode);

                linkList.head = newNode;
            }
        } else {
            //有两个及其以上的元素个数
            Node q = null;
            //有元素的时候需要比较
            for (int i = 0; i < linkList.size; i++) {
                q = p;
                if (p.getNum() < tmp) {
                    p = p.getNext();
                } else {
                    break;
                }
            }
            if (q == linkList.tail&&p == null) {
                //插入的数当前链表最大
                newNode.setPre(linkList.tail);
                linkList.tail.setNext(newNode);
                linkList.tail = newNode;
            } else if (q == linkList.head) {
                //插入的数当前链表最小
                newNode.setNext(linkList.head);
                linkList.head.setPre(newNode);
                linkList.head = newNode;
            } else {
                //是中间结点
                newNode.setPre(p.getPre());
                p.getPre().setNext(newNode);

                p.setPre(newNode);
                newNode.setNext(p);
            }

        }
//计数加一
        linkList.size++;
    }

    //输出前k小
    private static void outPrint(LinkList linkList, int k) {
        if (linkList == null || linkList.head == null) return;

        Node p = linkList.head;
        for (int i = 0; i < linkList.size; i++) {
            if (i + 1 == k) {
                //头结点分开
                if (p.getPre() == null) {
                    linkList.tail.setPre(null);
                    linkList.tail = p;
                    linkList.head = linkList.tail;
                    linkList.head.setNext(null);
                } else {
                    //中间结点或者尾节点
                    p.getNext().setPre(null);
                    p.setNext(null);

                    linkList.tail = p;
                }
                break;
            }
            //后移指针
            p = p.getNext();
        }
        linkList.size = k;
        System.out.println(linkList.toString());
    }
}
