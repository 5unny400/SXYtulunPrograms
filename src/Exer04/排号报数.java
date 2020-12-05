package Exer04;

import java.util.Scanner;

class MainS {
    static class Node{
        private int no;
        private Node next;
        private Node pre;

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public int getNo() {
            return no;
        }

        public Node getNext() {
            return next;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    static class LinkList{
        private Node head;
        private Node tail;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        LinkList list = new LinkList();
        Node head = new Node();
        //双向循环链表，起初头尾相同
        list.head = head;
        list.tail = head;
        Node p = list.head;
        for(int i =1;i<=x;i++){

            if(i == 1){
                p.setNo(i);

            }else {
                Node tmp = new Node();
                tmp.setNo(i);
                p.setNext(tmp);
                tmp.setPre(p);
                tmp.setNext(list.head);
                list.tail = tmp;
                p = p.getNext();
            }
        }

        int y=0;
        Node q = list.head;
        while(q!=q.getNext()){
            y++;
            if(y==3){
                Node t = q.getPre();
                q.getPre().setNext(q.getNext());
                q.getNext().setPre(q.getPre());
                q = t.getNext();
                y=0;
            }else {
                q = q.getNext();
            }
        }
        System.out.println(q.getNo());
    }
}
