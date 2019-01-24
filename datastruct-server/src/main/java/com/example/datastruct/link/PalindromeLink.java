package com.example.datastruct.link;

public class PalindromeLink<T> {

    private Node head = null;

    /**
     * 反转
     * @param list
     * @return
     */

    public Node reverse(Node list) {
        if (list == null || list.next == null) {
            return list;
        }

        Node pre = null;
        Node cur = list.next;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;

        return cur;
    }

    /**
     *
     * @param list
     * @return
     */
    public boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }

        Node fast = list.next;
        Node slow = list;
        while(fast !=null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 合并有序数组
     * @param la
     * @param lb
     * @return
     */

    public Node mergeSortList(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        Node head;
        Node p = la;
        Node q = lb;

        if (compare(p, q)) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        Node cur = head;
        while (q !=null && p!=null) {
            if (compare(p, q)) {
                cur.next = p;
                p = p.next;
            } else {
                cur.next = q;
                q = q.next;
            }
        }

        if (p != null) {
            cur.next = p;
        }
        if (q != null) {
            cur.next = q;
        }

        return head;
    }

    //模拟比较两个对象的大小
    private boolean compare(Node a, Node b) {
        if (Integer.valueOf(a.element.toString()) < Integer.valueOf(b.element.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast.next != null && i< k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node pre = null;
        Node slow = list;
        while(fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }

        if (pre == null) {
            return list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    // 求中间结点
    public Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public Node findByValue(T value) {
        Node cur = head;
        while(cur != null && !cur.element.equals(value)) {
            cur = cur.next;
        }

        return cur;
    }

    public Node findByIndex(int index) {

        Node cur = head;
        int pos = 0;
        while (cur!=null && pos<index) {
            cur = cur.next;
        }

        return cur;
    }

    public void insertHead(T value) {
        Node node = new Node(value);
        insertToHead(node);
    }

    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head.next;
            head = node;
        }
    }

    public void insertTail(T value) {
        Node node = new Node(value);
        insertToTail(node);
    }

    public void insertToTail(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while(cur.next !=null) {
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }
    }

    public void insertBefore(Node node, T value) {

        Node tmp = new Node(value);
        insertBefore(node, tmp);
    }

    public void insertBefore(Node p, Node q) {
        if (head == p) {
            insertToHead(q);
            return;
        }
        Node cur = head;
        while(cur!=null && cur.next != p) {
            cur = cur.next;
        }

        if (cur == null) {
            return;
        }

        q.next = cur.next;
        cur.next = q;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;
        Node q = null;
        while (p != null && !p.element.equals(value)) {
            q = p;
            p = p.next;
        }

        if (p == null) return;

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.element + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Node revertLink(Node p) {
        Node pre = null;
        Node next = null;
        Node cur = head;

        if (head == null || head.next == null) {
            return head;
        }
        while (cur !=p) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        cur.next = pre;

        return cur;
    }

    public boolean compareLink(Node left, Node right) {
        Node p = left;
        Node q = right;
        while(p!=null && q!=null) {
            if (q.element.equals(p.element)) {
                p = p.next;
                q = q.next;
            } else {
                break;
            }
        }

        if (q !=null || p != null) {
            return false;
        }

        return true;
    }

    public boolean palindrome() {
        if (head == null) {
            return false;
        } else {
            Node p = head;
            Node q = head;

            if (p.next == null) {
                return true;
            }
            while(q.next != null && q.next.next!=null) {
                p = p.next;
                q = q.next.next;
            }


            Node rightLink = null;
            Node leftLink = null;
            //链表个数为奇数个
            if (q.next == null) {
                rightLink = p.next;
                leftLink = revertLink(p).next;
            } else {
                rightLink = p.next;
                leftLink = revertLink(p);
            }

            //TODO 判断
            return compareLink(leftLink, rightLink);
        }
    }

    public static void main(String[]args){

        PalindromeLink link = new PalindromeLink();
        System.out.println("hello");
//        int data[] = {1};
        int data[] = {1,2};
//        int data[] = {1,2,3,1};
//        int data[] = {1,2,5};
//        int data[] = {1,2,2,1};
//         int data[] = {1,2,5,2,1};
//        int data[] = {1,2,5,3,1};

        for(int i =0; i < data.length; i++){
            //link.insertToHead(data[i]);
            link.insertTail(data[i]);
        }
        // link.printAll();
        // Node p = link.inverseLinkList_head(link.head);
        // while(p != null){
        //     System.out.println("aa"+p.data);
        //     p = p.next;
        // }

        System.out.println("打印原始:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("回文");
        }else{
            System.out.println("不是回文");
        }
    }


    public class Node<T> {
        T element;
        Node next;

        public Node() {
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
        }

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }
    }
}
