package com.codecool.datastructure;

public class SinglyLinkedList {

    private class Node {

        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }

    }

    private Node head;
    private int size = 0;

    public SinglyLinkedList() {
    }

    // Returns the number at 'index'.
    public int access(int index) {
        Node tempNode = head;
        int currentIndex = 0;
        while (currentIndex!=index) {
            tempNode = tempNode.getNext();
            currentIndex++;
        }
        return tempNode.getValue();
    }

    // Returns the index of 'number' if it's in the array, otherwise -1;
    public int search(int number) {
        Node tempNode = head;
        int currentIndex = 0;
        while(tempNode.getValue()!=number&&currentIndex<size) {
            tempNode = tempNode.getNext();
            currentIndex++;
        }
        return currentIndex<size ? currentIndex : -1;
    }

    // Inserts 'number' at 'index' into the array shifting elements if necessary.
    // e.g. the result of inserting 42 at index 3 into [0, 1, 2, 3, 4] is [0, 1, 2, 42, 3, 4]
    public void insert(int index, int number) {
        Node tempNode = head;
        if (index == 0) {
            this.head = new Node(number);
            head.setNext(tempNode);
        } else {
            int currentIndex=0;
            while (currentIndex+1 != index) {
                tempNode = tempNode.getNext();
                currentIndex++;

            }
            Node newLink = new Node(number);
            newLink.setNext(tempNode.getNext());
            tempNode.setNext(newLink);
        }
        size++;
    }

    // Deletes the element at 'index' from the array.
    //  e.g. the result of deleting index 2 from [0, 1, 2, 3, 4] is [0, 1, 3, 4]
    public void delete(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Node elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Node elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
