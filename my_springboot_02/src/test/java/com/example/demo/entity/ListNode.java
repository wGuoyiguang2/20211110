package com.example.demo.entity;

/**
 * @program: springboot_01
 * @description:
 * @author: guoyiguang
 * @create: 2021-05-03 11:42
 **/
public class ListNode {


    private  Integer data;
    private  ListNode next;

    public ListNode() {

    }

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
