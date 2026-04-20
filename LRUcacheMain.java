import java.util.*;
class LRUCache{
    class Dlinknode{
        int key;
        int value;
        Dlinknode prev;
        Dlinknode next;
        public Dlinknode(){}
        public Dlinknode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private Map<Integer,Dlinknode>mp = new HashMap<Integer,Dlinknode>();
    private Dlinknode head;
    private Dlinknode tail;
    private int size;
    private int capacity;

    public LRUCache(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new Dlinknode();
        tail = new Dlinknode();
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        Dlinknode node = mp.get(key);
        if(node!=null){
            moveToHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        Dlinknode node = mp.get(key);
        if(node!=null){
            node.value = value;
            moveToHead(node);
        }else{
            //不存在
            Dlinknode newNode = new Dlinknode(key,value);
            mp.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                Dlinknode tail = removeTail();
                mp.remove(tail.key);
                size--;
            }
            
        }
    }


    private void addToHead(Dlinknode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    private void removeNode(Dlinknode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private Dlinknode removeTail(){
        Dlinknode tail = this.tail.prev;
        removeNode(tail);
        return tail;
    }
    private void moveToHead(Dlinknode node){
        removeNode(node);
        addToHead(node);
    }


}


public class LRUcacheMain {
    public static void main(String[]args){
        
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 3
        System.out.println(cache.get(3));       // returns -1 (not found)
        System.out.println(cache.get(4));       // returns 4
        
    }
}
