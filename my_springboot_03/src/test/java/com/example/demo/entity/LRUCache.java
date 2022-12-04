package com.example.demo.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-05-03 13:30
 **/
public class LRUCache {

    // 内部类
    public class CacheNode {

        CacheNode prev;
        CacheNode next;

        int key;
        int value;

        public CacheNode( int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }

        public CacheNode getPrev() {
            return prev;
        }

        public void setPrev(CacheNode prev) {
            this.prev = prev;
        }

        public CacheNode getNext() {
            return next;
        }

        public void setNext(CacheNode next) {
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CacheNode{" +
                    "prev=" + prev +
                    ", next=" + next +
                    ", key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private int capacity ;

    // 快速定位key,获取 CacheNode（or value）
    private Map<Integer,CacheNode> valNodeMap = new HashMap<>();

    //
    private CacheNode head = new CacheNode(-1,-1);

    private CacheNode tail = new CacheNode(-1,-1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // head  ,tail 互相指向
        head.next = tail;
        tail.prev = head;
    }


    // 根据key 获取节点的value
    public int getValue(int key) {
        // 没有返回 -1
        if(!valNodeMap.containsKey(key)){
            return -1;
        }
        CacheNode current = valNodeMap.get(key);
        // 因为访问了一次，所以将他放到最后，LRU 删除总是删除链表前面的 node
        moveToTail(current);
        return current.getValue() ;
    }

    // 根据key 获取节点
    public CacheNode getNode(int key) {
        // 没有返回 -1
        if(!valNodeMap.containsKey(key)){
            return null;
        }
        CacheNode current = valNodeMap.get(key);
        // 因为访问了一次，所以将他放到最后，LRU 删除总是删除链表前面的 node
        moveToTail(current);
        return current ;
    }


    public void put(int key,int value) {
        if(getValue(key) != -1){
            // 覆盖旧值
            valNodeMap.get(key).setValue(value);
            return ;
        }
        if(valNodeMap.size() == capacity){
            // 删掉 head  后的第一个 node
            valNodeMap.remove(head.getNext().getKey());

            // head  ,head  后 第一个node head.getNext() ，head  后 第二个node head.getNext().getNext()
            // head , head  后 第二个node   相互指向，这样 就相当于 把 ,head  后 第一个node 删除了
            head.setNext(head.getNext().getNext());
            head.getNext().getNext().setPrev(head);
        }
        // 可以插入
        CacheNode insert = new CacheNode(key, value);
        valNodeMap.put(key,insert);
        // insert 节点 内部的 prev 和 next 在 moveToTail 这个方法里维护
        moveToTail(insert);

    }

    // 将 currentNode  移到最末端（tail 的前一个node），同时维护 currentNode的  prev 和 next
    public void moveToTail(CacheNode currentNode){
        // tail 前一个节点 和 currentNode 互相指向

        CacheNode prev = tail.getPrev();
        prev.setNext(currentNode);
        currentNode.setPrev(prev);

        // tail 和 currentNode 互相指向
        tail.setPrev(currentNode);
        currentNode.setNext(tail);
        return ;
    }

}

