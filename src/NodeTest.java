import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {

    @Test
    public void getData() {
        Integer expected = 12;
        Node<Integer> node = new Node(expected);
        assertEquals(expected, node.getData());
    }

    @Test
    public void getNext() {
        Node<Integer> node = new Node(12);
        Node<Integer> prevNode = new Node(23, node);
        assertEquals(node, prevNode.getNext());
    }

    @Test
    public void setData() {
        Node<Integer> node = new Node(1);
        Integer changedValue = 8;
        node.setData(changedValue);
        assertEquals(changedValue, node.getData());
    }

    @Test
    public void setNext() {
        Node<Integer> node = new Node(12);
        Node<Integer> prevNode = new Node(23);
        prevNode.setNext(node);
        assertEquals(node, prevNode.getNext());
    }
}