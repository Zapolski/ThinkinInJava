package by.zapolski.generics_gl15.linked_stack;

public class LinkedStack_task<T> {
    private class Node{
        T item;
        Node next;
        Node() {
            item = null;
            next = null;
        }
        Node(T item, Node next){
            this.item=item;
            this.next=next;
        }
        boolean end(){
            return item==null && next==null;
        }
    }

    private Node top = new Node();//сторож

    public  void push(T item){
        top = new Node(item,top);
    }

    public T pop(){
        T result = top.item;
        if (!top.end()) top = top.next;
        return result;
    }
}
