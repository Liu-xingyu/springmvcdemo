package algorithm;

/**
 * 链表反转
 */
public class LinkReverse {

    public static void main(String[] args) {
        System.out.println("输出初始化的链表：");
        printLinkNode(initLink());
        System.out.println();
        System.out.println("输出反转后的链表：");
        printLinkNode(linkNodeReverse(initLink()));
        System.out.println();
        System.out.println("递归输出反转后的链表：");
        printLinkNode(reverseRescusion(initLink()));
    }

    static class Node {
        Node next;  // 下一个节点，和C语言指针类似
        Object data;    // 节点存储数据

        public Node(Object data) {
            this.data = data;
        }
    }

    // 初始化一个链表
    public static Node initLink() {
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        Node node4 = new Node("D");
        Node node5 = new Node("E");
        Node node6 = new Node("F");
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;
        return node1;
    }

    // 输出node链表
    public static void printLinkNode(Node node) {
        while (node.next != null) {
            System.out.print(node.data + "->");
            // 必须要链接到下一个节点
            node = node.next;
        }
        System.out.print(node.data);
    }

    // 反转链表（非递归方式）
    public static Node linkNodeReverse(Node headNode) {
        Node preNode = null;
        while (headNode != null) {
            Node tempNode = headNode;
            headNode = headNode.next;
            tempNode.next = preNode;
            preNode = tempNode;
        }
        return preNode;
    }

    // 递归方式实现链表反转  递归实现有些问题
    public static Node reverseRescusion(Node headNode) {
        Node preNode;
        if (headNode == null || headNode.next == null) {
            preNode = headNode;
        } else {
            Node tempNode = reverseRescusion(headNode.next);
            headNode.next.next = headNode;
            headNode.next = null;
            preNode = tempNode;
        }
        return preNode;
    }

}
