package com.codecool.datastructure;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    static class Node{
        //data
        int value;
        // next node in the list
        Node next;
        // previous node in the list
        Node prev;

        Node(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void displayData(){
            System.out.print(" " + value);
        }
    }
    // constructor
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // get node at index
    public int getNode(int index) {

        Node found=head;

        if(!isValidIndex(index+1)){
            throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
        }

        if (index==0) {
            found=head;
        } else if (index==size-1) {
            found=tail;
        } else if (index<size/2) {
//            current=head.next;
            for(int i=1; i<size/2; i++) {
                found=found.next;
                if(index==i)
                    return found.getValue();
            }
        } else {
            found=tail.prev;
            for(int i=size-2; i>size/2; i--) {
                found=found.prev;
                if(index==i)
                    return found.getValue();
            }
        }

        return found.getValue();
    }

    //search value, returns index
    public int search(int value) {
        Node tempNode = head;
        int currentIndex = 0;
        while(tempNode.getValue()!=value&&currentIndex<size) {
            tempNode = tempNode.next;
            currentIndex++;
        }
        return currentIndex<size ? currentIndex : -1;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertFirst(int value){
        //Create a new node
        Node newNode = new Node(value);
        // if first insertion tail should
        // also point to this node
        if(isEmpty()){
            tail = newNode;
        }else{
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }


    public void insertLast(int value){
        Node newNode = new Node(value);
        // if first insertion head should
        // also point to this node
        if(isEmpty()){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int index, int value){
        if(!isValidIndex(index)){
            throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
        }
        Node newNode = new Node(value);
        Node current = head;
        //insert at the start
        if(index == 0){
            insertFirst(value);
        }
        // insert at last
        else if(index == size){
            insertLast(value);
        }else{
            for(int j = 0; j < index && current.next != null; j++){
                current = current.next;
            }
            newNode.next = current;
            current.prev.next = newNode;
            newNode.prev = current.prev;
            current.prev = newNode;
            size++;
        }
    }

    public Node deleteFirst(){
        if(head == null){
            throw new RuntimeException("List is empty");
        }
        Node first = head;
        if(head.next == null){
            tail = null;
        }else{
            // previous of next node (new first) becomes null
            head.next.prev = null;
        }
        head = head.next;
        size--;
        return first;
    }

    public Node deleteLast(){
        if(tail == null){
            throw new RuntimeException("List is empty");
        }
        Node last = tail;
        if(head.next == null){
            head = null;
        }else{
            // next of previous node (new last) becomes null
            tail.prev.next = null;
        }
        tail = tail.prev;
        size--;
        return last;
    }

    public Node deleteAtIndex(int index){
        if(!isValidIndex(index+1)){
            throw new IndexOutOfBoundsException("Index " + index +" not valid for linked list of size " + size);
        }
        Node current = head;
        //remove at the start
        if(index == 0){
            return deleteFirst();
        }
        // remove at last
        else if(index == size-1){
            return deleteLast();
        }else{
            for(int j = 0; j < index && current.next != null; j++){
                current = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
        return current;
    }

    private boolean isValidIndex(int index){
        return index >= 0 && index <= size;
    }

    // Method for forward traversal
    public void displayForward(){
        Node current = head;
        while(current != null){
            current.displayData();
            current = current.next;
        }
        System.out.println("");
    }

    // Method to traverse and display all nodes
    public void displayBackward(){
        Node current = tail;
        while(current != null){
            current.displayData();
            current = current.prev;
        }
        System.out.println("");
    }

}
