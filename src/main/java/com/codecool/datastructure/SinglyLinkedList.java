package com.codecool.datastructure;

public class SinglyLinkedList {

    private class Link {

        private int value;
        private Link next;

        Link(int value) {
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }

    private Link head;
    private int size = 0;

    public SinglyLinkedList() {
    }

    // Returns the number at 'index'.
    public int access(int index) {
        Link tempLink = head;
        int currentIndex = 0;
        while (currentIndex!=index) {
            tempLink = tempLink.next;
            currentIndex++;
        }
        return tempLink.getValue();
    }

    // Returns the index of 'number' if it's in the array, otherwise -1;
    public int search(int number) {
        Link tempLink = head;
        int currentIndex = 0;
        while(tempLink.getValue()!=number&&currentIndex<size) {
            tempLink = tempLink.getNext();
            currentIndex++;
        }
        return currentIndex<size ? currentIndex : -1;
    }

    // Inserts 'number' at 'index' into the array shifting elements if necessary.
    //
    // e.g. the result of inserting 42 at index 3 into [0, 1, 2, 3, 4] is [0, 1, 2, 42, 3, 4]
    public void insert(int index, int number) {
        Link tempLink = head;
        if (index == 0) {
            this.head = new Link(number);
            head.setNext(tempLink);
        } else {
            int currentIndex=0;
            while (currentIndex+1 != index) {
                tempLink = tempLink.getNext();
                currentIndex++;

            }
            Link newLink = new Link(number);
            newLink.setNext(tempLink.getNext());
            tempLink.setNext(newLink);
        }
        size++;
    }

    // Deletes the element at 'index' from the array.
    //
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
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }
}
