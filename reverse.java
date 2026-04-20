
public class reverse{
    public static void main(String []args){
        // 构造测试链表: 1 -> 2 -> 3 -> 4 -> 5
        LinkedNode head = new LinkedNode(1);
        head.next = new LinkedNode(2);
        head.next.next = new LinkedNode(3);
        head.next.next.next = new LinkedNode(4);
        head.next.next.next.next = new LinkedNode(5);

        System.out.println("反转前：");
        LinkedNode.printList(head);

        // 调用反转方法，必须接收返回值
        LinkedNode newHead = reverseLink(head);

        System.out.println("反转后：");
        LinkedNode.printList(newHead);
    }
    private static LinkedNode reverseLink(LinkedNode head){
        if(head==null||head.next==null) return head;
        LinkedNode dummy = new LinkedNode(0);
        dummy.next = head;
        LinkedNode cur = head;
        while(cur.next!=null){
            LinkedNode next = cur.next;
            cur.next = next.next;
            next.next = dummy.next;
            dummy.next = next;
        }
        return dummy.next;
    }
    // 辅助打印方法
    
}