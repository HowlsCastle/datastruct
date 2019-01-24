package com.example.datastruct.stack;

public class StackBasedLink<T> {
    Node top;

    public static void main(String[] args) {
        StackBasedLink<Integer> basedLink = new StackBasedLink<>();
        basedLink.push(1);
        basedLink.push(2);
        basedLink.push(3);
        basedLink.push(4);

        basedLink.printAll();
        basedLink.pop();
        basedLink.printAll();
    }

    public void push(T data) {
        Node node = new Node(data);

        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public T pop() {
        if (top == null) return null;

        T value = (T) top.data;
        top = top.next;
        return value;
    }

    public void printAll() {
        Node p = top;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static class Node<T> {
        private T data;
        private Node next;

            public Node(T data) {
            this(data, null);
        }

            public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public T getData() {
            return this.data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }
}
