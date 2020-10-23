package com.codecool.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DoublyLinkedListTest {

    @Test
    void testInsert() {

        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtIndex(0, 123);
        dll.insertAtIndex(1, 465);
        dll.insertAtIndex(2, 45);
        dll.insertAtIndex(0, 11);


        assertEquals(123, dll.getNode(1));
        assertEquals(465, dll.getNode(2));
        assertEquals(45, dll.getNode(3));
        assertEquals(11, dll.getNode(0));

    }

    @Test
    void deleteTest() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtIndex(0, 11);
        dll.insertAtIndex(1, 412);
        dll.insertAtIndex(2, 453);
        dll.insertAtIndex(3, 111);

        dll.deleteAtIndex(2);
        dll.deleteFirst();

        assertEquals(412, dll.getNode(0));
        assertEquals(111, dll.getNode(1));
    }

    @Test
    void searchTest() {
        DoublyLinkedList dll = new DoublyLinkedList();

        dll.insertAtIndex(0, 1);
        dll.insertAtIndex(1, 2);
        dll.insertAtIndex(2, 3);

        assertEquals(2, dll.search(3));
    }
}
