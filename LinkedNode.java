public class LinkedNode { // 必须是 public
    public int value;
    public LinkedNode next;
    public LinkedNode() {}
    public LinkedNode(int value) {
        this.value = value;
    }
    public static void printList(LinkedNode head) {
        while (head != null) {
            System.out.print(head.value + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}