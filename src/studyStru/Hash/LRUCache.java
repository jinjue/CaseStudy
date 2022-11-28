package studyStru.Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 */
public class LRUCache {

    //一个双向链表
    class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;
        public DLinkNode(){}
        public DLinkNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer,DLinkNode> cache = new HashMap<Integer,DLinkNode>() ;
    private int size;
    private int capacity;
    static DLinkNode head,tail;


    /**
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    /**
     * 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * @param key
     * @return
     */
    public int get(int key) {
        DLinkNode node = cache.get(key);
        if(node == null)
            return -1;
        moveNode(node);
        return node.value;
    }

    /**
     * 如果关键字 key 已经存在，则变更其数据值 value ；
     * 如果不存在，则向缓存中插入该组 key-value 。
     * 如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        DLinkNode elem = cache.get(key);
        if(elem == null){
            DLinkNode node = new DLinkNode(key,value);
            if(size > capacity){
                DLinkNode dLinkNode = removeNode();
                cache.remove(dLinkNode.key);
            }
            cache.put(key,node);
            addNode(node);
            size++;
        }
        else {
            elem.value = value;
            moveNode(elem);
        }
    }

    private void moveNode(DLinkNode node){
        remove(node);
        addNode(node);
    }

    private void addNode(DLinkNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

    }

    private void remove(DLinkNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private DLinkNode removeNode(){
        DLinkNode node = tail.pre;
        remove(node);
        size --;
        return node;
    }


}
