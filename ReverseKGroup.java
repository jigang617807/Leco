
import java.util.Scanner;
public class ReverseKGroup {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num-->0){
            int n = sc.nextInt();
            // 3. 构建链表
            LinkedNode dummy = new LinkedNode(0);
            LinkedNode tail = dummy;
            //尾插入法创建链表
            for(int i =0;i<n;i++){
                tail.next = new LinkedNode(sc.nextInt());
                tail = tail.next;
            }
            int k = sc.nextInt();
            System.out.println("反转前：");
            LinkedNode.printList(dummy.next);
            LinkedNode newHead = RKGroup(dummy.next, k);
            System.out.println("反转后：");
            LinkedNode.printList(newHead);
        }
        sc.close();
    }
    private static LinkedNode RKGroup(LinkedNode head,int k){
        LinkedNode dummy = new LinkedNode(0);
        dummy.next = head;
        LinkedNode cur = head;
        int len = 0;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        cur = head;
        int group = len/k;
        //k个一组反转
        LinkedNode pre = dummy;
        for(int i = 0;i<group;i++){
            for(int j=0;j<k-1;j++){
                LinkedNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
   
}
