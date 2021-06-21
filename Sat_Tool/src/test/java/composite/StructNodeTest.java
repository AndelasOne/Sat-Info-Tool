package composite;

import dhbw.swe.AbstractNode;
import dhbw.swe.Leaf;
import dhbw.swe.StructNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StructNodeTest {
    private final StructNode<Integer> structNode = new StructNode<>();

    @BeforeEach
    void setUp() {
        structNode.addPair("test", new Leaf<>(5));
    }

    @Test
    void addPair() {
        final int size = structNode.getStructPairs().size();
        final int leafVal = 10;
        final String sameKey = "test";
        assertNotEquals(leafVal, structNode.getStructPairs().get(sameKey).getValue());
        structNode.addPair(sameKey, new Leaf<>(leafVal));
        assertEquals(size, structNode.getStructPairs().size());
        assertEquals(leafVal, structNode.getStructPairs().get(sameKey).getValue());
        final String newKey = "newKey";
        structNode.addPair(newKey, new Leaf<>(leafVal));
        assertEquals(size+1, structNode.getStructPairs().size());
        assertEquals(leafVal, structNode.getStructPairs().get(newKey).getValue());
    }

    @Test
    void isArray() {
        assertFalse(structNode.isArray());
    }

    @Test
    void getArrayElements() {
        assertNull(structNode.getArrayElements());
    }

    @Test
    void getStructPairs() {
        Map<String, AbstractNode<Integer>> map = structNode.getStructPairs();
        assertEquals(map.size(), 1);
    }

    @Test
    void getValue() {
        assertNull(structNode.getValue());
    }

    @Test
    void isLeaf() {
        assertFalse(structNode.isLeaf());
    }

    @Test
    void isStruct() {
        assertTrue(structNode.isStruct());
    }
}