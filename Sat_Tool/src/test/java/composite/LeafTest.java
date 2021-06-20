package composite;

import dhbw.swe.Leaf;

import static org.junit.jupiter.api.Assertions.*;

class LeafTest {
    private final Leaf<String> leaf = new Leaf<>("Hello world");

    @org.junit.jupiter.api.Test
    void isArray() {
        assertFalse(leaf.isArray());
    }

    @org.junit.jupiter.api.Test
    void getArrayElements() {
        assertNull(leaf.getArrayElements());
    }

    @org.junit.jupiter.api.Test
    void getStructPairs() {
        assertNull(leaf.getStructPairs());
    }

    @org.junit.jupiter.api.Test
    void getValue() {
        assertEquals("Hello world", leaf.getValue());
    }

    @org.junit.jupiter.api.Test
    void isLeaf() {
        assertTrue(leaf.isLeaf());
    }

    @org.junit.jupiter.api.Test
    void isStruct() {
        assertFalse(leaf.isStruct());
    }
}