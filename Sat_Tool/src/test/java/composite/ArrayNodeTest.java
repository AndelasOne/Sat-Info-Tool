package composite;

import dhbw.swe.AbstractNode;
import dhbw.swe.ArrayNode;
import dhbw.swe.Leaf;
import dhbw.swe.StructNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayNodeTest {
    private final ArrayNode<Integer> arrayNode = new ArrayNode<>();

    @BeforeEach
    void setUp() {
        arrayNode.addElement(new Leaf<>(5));
        StructNode<Integer> structNode =new StructNode<>();
        structNode.addPair("key", new Leaf<>(10));
        arrayNode.addElement(structNode);
    }

    @Test
    void addElement() {
        int size = arrayNode.getSize();
        arrayNode.addElement(new Leaf<>(42));
        assertEquals(size+1, arrayNode.getSize());
    }

    @Test
    void getSize() {
        assertEquals(2, arrayNode.getSize());
    }

    @Test
    void getArrayElements() {
        List<AbstractNode<Integer>> list = arrayNode.getArrayElements();
        assertNotNull(list);
        assertEquals(list.size(), arrayNode.getSize());
    }

    @Test
    void getStructPairs() {
        assertNull(arrayNode.getStructPairs());
    }

    @Test
    void getValue() {
        assertNull(arrayNode.getValue());
    }

    @Test
    void isArray() {
        assertTrue(arrayNode.isArray());
    }

    @Test
    void isLeaf() {
        assertFalse(arrayNode.isLeaf());
    }

    @Test
    void isStruct() {
        assertFalse(arrayNode.isStruct());
    }
}