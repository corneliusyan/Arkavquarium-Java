import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {

    public LinkedList<Integer> generatePopulatedLinkedList() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        return list;
    }

    @Test
    public void add() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertEquals(0, list.getSize());
        list.add(23);
        assertEquals(1, list.getSize());
    }

    @Test
    public void remove() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(23);
        assertEquals(1, list.getSize());
        list.remove(23);
        assertEquals(0, list.getSize());
    }

    @Test
    public void find() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(8);
        list.add(9);
        list.add(10);
        int idx = list.find(9);
        assertEquals(1, idx);
    }

    @Test
    public void getHead() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(8);
        assertNotNull(list.getHead());
        assertEquals((Integer)(8), list.getHead().getData());
    }

    @Test
    public void get() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(8);
        list.add(9);
        list.add(10);
        Integer result = list.get(2);
        assertEquals((Integer)(10), result);
    }

    @Test
    public void isEmpty() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue(list.isEmpty());
        list.add(8);
        assertFalse(list.isEmpty());
    }

    @Test
    public void getSize() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(8);
        list.add(9);
        list.add(10);
        assertEquals(3, list.getSize());
    }
}