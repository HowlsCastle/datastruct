package com.example.datastruct.link;

import java.util.Random;
import java.util.Scanner;

public class Link<T> {

    private final static int DEFAULT_CAPACITY = 10;

    private LinkNode<T> head;

    private int capacity;

    private int length;

    public Link() {
        this.head = new LinkNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public Link(int capacity) {
        this.head = new LinkNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public void add(T value) {
        LinkNode node = findPreNode(value);
        if (node == null) {
            if (this.length == this.capacity) {
                deleteNodeEnd();
            }
            insertStart(value);
        } else {
            deletePreNoe(node);
            insertStart(value);
        }
    }

    public void deleteElement(T value) {
        LinkNode cur = head;
        while(cur.getNext() != null) {
            if (cur.getNext().getElement().equals(value)) {
                LinkNode tmp = cur.getNext();
                cur.setNext(cur.getNext().getNext());
                tmp = null;
                length--;
            }
        }
    }

    public void deletePreNoe(LinkNode pre) {
        LinkNode tmp = pre.getNext();
        pre.setNext(pre.getNext().getNext());
        tmp = null;
        length--;
    }

    public void insertStart(T value) {
        LinkNode node = new LinkNode(value);
        node.setNext(head.getNext());
        head.setNext(node);
        length++;
    }

    public void deleteNodeEnd() {
        LinkNode cur = head;
        if (cur.getNext() == null) {
            return ;
        }

        while(cur.getNext().getNext() != null) {
            cur = cur.getNext();
        }
        LinkNode tmp = cur.getNext();

        cur.setNext(null);
        tmp = null;
        length--;
    }

    public LinkNode findPreNode(T data) {
        LinkNode node = head;
        while (node.getNext() != null) {
            if (node.getNext().getElement().equals(data)) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll() {
        LinkNode node = head.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class LinkNode<T> {
        T element;
        LinkNode next;

        public LinkNode() {
            this.next = null;
        }

        public LinkNode(T element) {
            this.element = element;
        }

        public LinkNode(T element, LinkNode next) {
            this.element = element;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T value) {
            element = value;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode linkNode) {
            this.next = linkNode;
        }
    }


    public static void main(String[] args) {
        Link list = new Link();
        Random random = new Random();
        int i = 0;
        while (i < 15) {
            list.add(i);
            i++;
        }
        list.add(1);
        list.add(2);
        list.printAll();

    }
}
